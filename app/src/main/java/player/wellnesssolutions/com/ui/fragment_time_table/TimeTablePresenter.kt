package player.wellnesssolutions.com.ui.fragment_time_table

import androidx.core.content.ContextCompat
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.time_table.TimeTableApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.response.Session
import player.wellnesssolutions.com.network.models.response.SessionVideo
import player.wellnesssolutions.com.network.models.response.TimeTableResponse

class TimeTablePresenter : ITimeTableContract.Presenter, BaseResponseObserver<TimeTableResponse>() {
    private var mView: ITimeTableContract.View? = null
    private var mTimeTableApi = TimeTableApi()
    private var mResponse: TimeTableResponse? = null
    private var mIsLoading = false
    private var mIsRendered = false

    private val NO_SCHEDULE = "There is no schedule for this device"
    private val NOT_PUBLISH = "The schedule has not been published"

    override fun onAttach(view: ITimeTableContract.View) {
        this.mView = view

        onGetTimetable()
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onStop() {
        mIsRendered = false
    }

    override fun onDestroy() {
        mResponse = null
        disposable.clear()
    }

    override fun onGetSessionVideo(typeDay: String, typeSession: String): ArrayList<SessionVideo>? {
        return when (typeDay) {
            getString(R.string.today) -> {
                with(mResponse?.today) {
                    when (typeSession.trim()) {
                        getString(R.string.morning) -> this?.morning
                        getString(R.string.afternoon) -> this?.afternoon
                        getString(R.string.evening) -> this?.evening
                        else -> null
                    }
                }

            }
            getString(R.string.tomorrow) -> {
                with(mResponse?.tomorrow) {
                    when (typeSession.trim()) {
                        getString(R.string.morning) -> this?.morning
                        getString(R.string.afternoon) -> this?.afternoon
                        getString(R.string.evening) -> this?.evening
                        else -> null
                    }
                }
            }
            else -> null
        }
    }

    private fun getString(id: Int): String {
        return mView?.getViewContext()?.getString(id) ?: ""
    }

    override fun onGetTimetable() {
        val view: ITimeTableContract.View = mView ?: return

        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), view.getFragment())
            if (headerData == null || mIsLoading || mIsRendered) return

            if (mResponse != null) {
                displayUI()
            } else {
                mIsRendered = false
                mView?.showLoadingProgress()
                mTimeTableApi.getTimeTable(headerData.token, headerData.deviceId)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this)
            }
        }
    }

    override fun onResponseSuccess(data: ResponseValue<TimeTableResponse>?) {
        super.onResponseSuccess(data)
        mView?.hideLoadingProgress()

        mResponse = data?.data

        checkIfNoSchedulerForToday(data)

        displayUI()
    }

    private fun displayUI() {
        if (mIsRendered) return
        mView?.setupUI(mResponse?.today?.morning)
        mIsRendered = true
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        onRequestFailed(message)
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        onRequestFailed(message)
    }

    private fun onRequestFailed(message: String?) {
        mView?.getViewContext()?.also { context ->

            when (message != null && (message.contains(NO_SCHEDULE) || message.contains(NOT_PUBLISH))) {
                true -> {
                    mView?.showDialog(message)
                }
                false -> {
                    val msg = context.getString(player.wellnesssolutions.com.R.string.request_failed)
                    mView?.showDialog(msg, ContextCompat.getColor(context, R.color.red))
                    mView?.onRequestFailed()
                }
            }
        }
    }

    override fun onComplete() {
        mIsLoading = false
        mView?.hideLoadingProgress()
    }

    private fun checkIfNoSchedulerForToday(data: ResponseValue<TimeTableResponse>?) {
        val today: Session? = data?.data?.today
        val morning = today?.morning
        val isMorningEmpty = morning == null || morning.size == 0
        val afternoon = today?.afternoon
        val isAfternoonEmpty = afternoon == null || afternoon.size == 0
        val evening = today?.evening
        val isEveningEmpty = evening == null || evening.size == 0

        if (today == null || (isMorningEmpty && isAfternoonEmpty && isEveningEmpty)) {
            val msg = mView?.getViewContext()?.getString(player.wellnesssolutions.com.R.string.no_scheduler_for_today)
                    ?: Constant.MSG_NO_SCHEDULE_TODAY
            mView?.showDialog(msg)
        }
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment)
                it.onExpiredUnAuth(error)
        }
    }

}