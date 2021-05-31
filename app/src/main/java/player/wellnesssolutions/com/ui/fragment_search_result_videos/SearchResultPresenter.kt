package player.wellnesssolutions.com.ui.fragment_search_result_videos

import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.videos.SearchResultApi
import player.wellnesssolutions.com.network.datasource.videos.SearchVideosRequestOptions
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SearchPreviewMapper
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment.Companion.mVideosToPlay
import player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultConstant
import player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultDataMapper
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener
import player.wellnesssolutions.database.manager.DownloadDBManager

class SearchResultPresenter() : BaseResponseObserver<ArrayList<MMVideo>>(), ISearchResultContract.Presenter {

    private var mView: ISearchResultContract.View? = null
    private var mSearchResultApi = SearchResultApi()

    // flag
    private var mSearchType = SearchResultConstant.TYPE_SEARCH_BY

    // search videos from Search Screens
    private var mLoadedData: ArrayList<MMVideo>? = null

    private var mLatestVideosForPlay = ArrayList<MMVideo>()

    // search videos by Help Me Choose answers
    private var brandId = -1
    private var mAnswers: ArrayList<MMHelpMeChooseAnswer>? = null

    // search videos by instructor
    private var mInstructor: MMInstructor? = null

    private var mChosenOptions: SPSearchedOption? = null

    // if @mIsDisplayedResponseData == false -> loadedData has not been displayed on and ...
    private var mIsDisplayedResponseData = false

    private var mItemListeners = mutableListOf<ISearchResultItemListener>()

    // flag select video seri
    private var mIsTraversingAllVideos = false

    private fun resetData() {
        mInstructor = null
        brandId = -1
        mAnswers = null
        mChosenOptions = null

        mLoadedData = null
        //if(mVideosToPlay.size > 0) mVideosToPlay = ArrayList()
        if (mLatestVideosForPlay.size > 0) mLatestVideosForPlay = ArrayList()
    }

    override fun inputData(chosenOptions: SPSearchedOption?) {
        resetData()

        this.mSearchType = SearchResultConstant.TYPE_SEARCH_BY
        this.mChosenOptions = chosenOptions
    }

    override fun inputData(answers: ArrayList<MMHelpMeChooseAnswer>, brandId: Int) {
        resetData()

        this.mSearchType = SearchResultConstant.TYPE_HELP_ME_CHOOSE
        this.mAnswers = answers
        this.brandId = brandId
    }

    override fun inputData(instructor: MMInstructor) {
        resetData()

        this.mSearchType = SearchResultConstant.TYPE_GET_VIDEOS_BY_INSTRUCTOR
        this.mInstructor = instructor
    }

    override fun onAttach(view: ISearchResultContract.View) {
        this.mView = view
        loadData(view)
        checkSelectedVideo()
    }

    override fun loadData(view: ISearchResultContract.View) {
        // no request data
        if (mChosenOptions == null && mInstructor == null && mAnswers == null) {
            onRequestFailed(message = view.getViewContext()?.getString(R.string.error_no_data_for_request))
            return
        }

        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), view.getFragment())
                    ?: return

            // handle in case loading data completed but exited app then resume app
            if (!mIsDisplayedResponseData && mLoadedData != null) {
                showDataOnUI(mLoadedData!!)
            } else if (mLoadedData == null) {
                view.showLoadingProgress()
                showUIBeforeLoadData(view)

                loadData(headerData.token, headerData.deviceId)
            }
        }
    }

    override fun onReshowUI(view: ISearchResultContract.View) {
        this.mView = view
        displayUI(view)
        checkSelectedVideo()
    }

    private fun displayUI(view: ISearchResultContract.View) {
        val data: ArrayList<MMVideo>? = mLoadedData
        if (data != null) {
            showDataOnUI(data)
        } else {
            loadData(view)
        }
    }

    private fun showUIBeforeLoadData(view: ISearchResultContract.View) {
        when (mSearchType) {
            SearchResultConstant.TYPE_SEARCH_BY -> {
                view.showUIBeforeLoadResultData(mChosenOptions)
            }

            SearchResultConstant.TYPE_HELP_ME_CHOOSE -> view.showUIBeforeLoadResultData()

            SearchResultConstant.TYPE_GET_VIDEOS_BY_INSTRUCTOR -> {
                val instructor = mInstructor
                if (instructor != null)
                    view.showUIBeforeLoadResultData(instructor)
            }
        }
    }

    private fun loadData(token: String, deviceId: String) {
        when (mSearchType) {
            SearchResultConstant.TYPE_SEARCH_BY -> loadDataByChosenSearchedOptions(token, deviceId)

            SearchResultConstant.TYPE_HELP_ME_CHOOSE -> loadDataByHelpMeChooseAnswers(token, deviceId)

            SearchResultConstant.TYPE_GET_VIDEOS_BY_INSTRUCTOR -> loadDataByInstructor(token, deviceId)

            else -> {
                mView?.showMessage(R.string.cant_load_videos_cause_wrong_data, R.color.red)
                mView?.hideLoadingProgress()
            }
        }
    }

    private fun loadDataByChosenSearchedOptions(token: String, deviceId: String) {
        val searchByData = mChosenOptions
        if (searchByData == null)
            onRequestFailed(mView?.getViewContext()?.getString(R.string.cant_load_videos_cause_no_search_data))
        else {
            loadDataBySearchBy(searchByData, token, deviceId)
        }
    }

    private fun loadDataByHelpMeChooseAnswers(token: String, deviceId: String) {
        val answers: ArrayList<MMHelpMeChooseAnswer>? = mAnswers
        if (answers == null) {
            onRequestFailed(mView?.getViewContext()?.getString(R.string.cant_load_videos_cause_no_answers_data))
            return
        }
        loadDataByHelpMeChooseAnswers(answers, token, deviceId)
    }

    private fun loadDataByInstructor(token: String, deviceId: String) {
        val instructor = mInstructor
        if (instructor?.id == null) {
            val msg = mView?.getViewContext()?.getString(R.string.cant_load_videos_cause_no_data)
                    ?: SearchResultFragment.MSG_CANT_LOAD_VIDEOS_BECAUSE_NO_INSTRUCTOR_ID
            onRequestFailed(msg)
            return
        }
        loadDataByInstructor(instructor.id!!, token, deviceId)
    }

    private fun loadDataByInstructor(instructorId: Int, token: String, deviceId: String) {
        mSearchResultApi.getSearchResultOnInstructor(token, deviceId, instructorId)
                .subscribe(this)
    }

    private fun loadDataByHelpMeChooseAnswers(helpMeChooseAnswer: ArrayList<MMHelpMeChooseAnswer>, token: String, deviceId: String) {
        val answerRequest = SearchResultDataMapper.mapHelpMeChooseAnswersToArrayInt(helpMeChooseAnswer)
        mSearchResultApi.getSearchResultOnHelpMeChooseAnswers(token, deviceId, brandId, answerRequest)
                .subscribe(this)
    }

    private fun loadDataBySearchBy(searchData: SPSearchedOption, token: String, deviceId: String) {
        val searchByData: SearchedOption? = mChosenOptions?.searchByData
        val searchById = searchByData?.id
        val brandId = searchData.brand?.id

        val searchBy: String = getSearchByRequestKey(searchByData?.typeOptionId)

        if (brandId == null || searchByData?.typeOptionId == null || searchBy.isEmpty() || searchById == null) {
            onRequestFailed(mView?.getViewContext()?.getString(R.string.cant_load_videos_cause_no_data))
            return
        }

        val options: SearchVideosRequestOptions = SearchPreviewMapper.getOptionsMapForRequestApi(searchData)

        mSearchResultApi.getSearchResultOnSearchBy(token, deviceId, brandId, searchBy, searchById, options)
                .subscribe(this)
    }

    private fun getSearchByRequestKey(typeOptionId: Int?): String =
            when (typeOptionId) {
                Constant.SEARCH_DURATION -> "duration"
                Constant.SEARCH_LEVEL -> "level"
                Constant.SEARCH_COLLECTION -> "collection"
                Constant.SEARCH_PRESENTER -> "instructor"
                else -> ""
            }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
        super.onResponseSuccess(data)
        if (data?.data == null) return

        // TODO: handle video is null
//        data.data.add(MMVideo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null))
        onReceiveDataSuccess(data.data)
    }

    private fun onReceiveDataSuccess(responseData: ArrayList<MMVideo>) {
        when (mSearchType) {
            SearchResultConstant.TYPE_SEARCH_BY -> {
                mLoadedData = responseData
                showDataOnUI(responseData)
            }

            SearchResultConstant.TYPE_HELP_ME_CHOOSE -> {
                val answers = mAnswers
                if (answers != null) {
                    mLoadedData = responseData
                    showDataOnUI(responseData)
                }
            }

            SearchResultConstant.TYPE_GET_VIDEOS_BY_INSTRUCTOR -> {
                mLoadedData = responseData
                showDataOnUI(responseData)
            }
        }
        checkSelectedVideo()
    }

    private fun showDataOnUI(showData: ArrayList<MMVideo>) {
        mView?.also { view ->
            view.displaySearchReuslt(showData)
            mIsDisplayedResponseData = true
            view.hideLoadingProgress()
        }
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        onRequestFailed(message)
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        onRequestFailed(message)
    }

    private fun onRequestFailed(message: String?) {
//        val msg = mView?.getViewContext()?.getString(R.string.request_failed)?: Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
    }

    override fun onComplete() {
        super.onComplete()
        mView?.hideLoadingProgress()
    }

    override fun getVideos(): ArrayList<MMVideo> = mLoadedData ?: ArrayList()

    override fun getVideosFromRange(begin: Int, range: Int): ArrayList<MMVideo> {
        mLoadedData?.also { videos ->
            val endIndex = Math.min(videos.size - 1, begin + range - 1)
            val list = ArrayList<MMVideo>()

            for (i: Int in begin..endIndex) {
                list.add(videos[i])
            }
            return list
        }
        return ArrayList()
    }

    override fun onPlaySearchedVideos() {
//        Log.d("LOG", this.javaClass.simpleName + " onPlaySearchedVideos()")
        val data: ArrayList<MMVideo> = mVideosToPlay

        when (data.size == 0) {
            true -> {
                mView?.getViewContext()?.also { context ->
                    MessageUtils.showToast(context = context, messageRes = R.string.please_select_videos_to_play, colorRes = R.color.white, isLongTime = false)?.show()
                }
            }

            false -> {
                mLatestVideosForPlay.addAll(mVideosToPlay)
                mView?.openPlayingVideosScreen(data)
            }
        }
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment)
                it.onExpired(error)
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment)
                it.onExpiredUnAuth(error)
        }
    }

    override fun selectVideoToPlay(video: MMVideo?, isSelected: Boolean) {
        if (video == null) return

        when (isSelected) {
            true -> if (!mVideosToPlay.contains(video)) mVideosToPlay.add(video)
            false -> {
                for (i in 0 until mVideosToPlay.size) {
                    if (mVideosToPlay[i].id == video.id) {
                        mVideosToPlay.removeAt(i)
                        break
                    }
                }
            }
        }

        // if traver all videos or select all videos, unselected all videos will return
        if (mIsTraversingAllVideos) return

        checkSelectedVideo()

        when (isAllVideosSelected()) {
            true -> mView?.onAllVideosSelected()
            false -> mView?.onNoAllVideosSelected()
        }
    }

    override fun addItemListener(listener: ISearchResultItemListener) {
        mItemListeners.add(listener)
    }

    override fun isVideoSelected(video: MMVideo?): Boolean = mVideosToPlay.contains(video)

    override fun hasSelectedVideos(): Boolean = mVideosToPlay.size > 0

    override fun isAllVideosSelected(): Boolean {
        return if (mLoadedData != null) {
            mVideosToPlay.size == mLoadedData?.size ?: 0
        } else {
            false
        }
    }

    override fun selectAllVideos() {
        mIsTraversingAllVideos = true

        // notify all now available video items of fragments in viewpager
        for (listener: ISearchResultItemListener in mItemListeners) {
            listener.selectVideo()
        }

        // add all remain videos
        mVideosToPlay.clear()
        mLoadedData?.also { videos ->
            for (video: MMVideo in videos) {
                if (!mVideosToPlay.contains(video)) mVideosToPlay.add(video)
            }
        }

        checkSelectedVideo()

        mView?.onAllVideosSelected()

        mIsTraversingAllVideos = false
    }

    override fun unselectAllVideos() {
        mIsTraversingAllVideos = true

        for (listener: ISearchResultItemListener in mItemListeners) {
            listener.unselectVideo()
        }

        // remove all remain videos
        mVideosToPlay.clear()

        mView?.onNoVideoSelected()
        mIsTraversingAllVideos = false
    }

    override fun checkSelectedVideo() {
        var isAnyVideoNotDownloaded = false

        for (ele: MMVideo in mVideosToPlay) {
            val id: Int? = ele.id
            if (!DownloadDBManager.getInstance().findData(id)) {
                isAnyVideoNotDownloaded = true
                break
            }
        }

        when (hasSelectedVideos()) {
            true -> mView?.onAnyVideoSelected(isAnyVideoNotDownloaded)
            false -> mView?.onNoVideoSelected()
        }
        when (isAllVideosSelected()) {
            true -> mView?.onAllVideosSelected()
            false -> mView?.onNoAllVideosSelected()
        }
    }

    override fun onShowPlayingVideoDialog(data: MMVideo) {
        mView?.onShowPlayingVideoDialog(data)
    }

    override fun onDetach() {
        this.mView = null
        mItemListeners.clear()
    }

    override fun onDestroy() {
        disposable.clear()
        mItemListeners.clear()

        mInstructor = null
        mLoadedData?.clear()

        mAnswers?.clear()

        mChosenOptions?.clear()
    }
}