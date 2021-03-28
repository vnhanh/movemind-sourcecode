package player.wellnesssolutions.com.network

import player.wellnesssolutions.com.network.services.*

/**
 * This class defines ApiServices generated from interfaces by Retrofit framework.
 * ApiServices allow app to communicate to server side through methods like GET, POST, PUT, DELETE that defined before in interfaces
 *
 * Extra: package "datasource": it contains repositories as well as local and remote datasources.
 */
open class ApiUtil {
    companion object {
        // determine servers's addresses here

//        private const val BASE_SERVER = "http://10.1.0.249"
        //UAT server
        //private const val BASE_SERVER = "http://movemind.me"
//        private const val BASE_SERVER = "https://player.wellnesssolutions.com.au"
        private const val BASE_SERVER = "https://uat.wellnesssolutions.com.au"

        fun getLoginService(): LoginService {
            return RetrofitClient.getClient(BASE_SERVER).create(LoginService::class.java)
        }

        fun getTimeTableService(): TimeTableService {
            return RetrofitClient.getClient(BASE_SERVER).create(TimeTableService::class.java)
        }

        fun getBrandService(): BrandService = RetrofitClient.getClient(BASE_SERVER).create(BrandService::class.java)

        fun getDurationService(): DurationService = RetrofitClient.getClient(BASE_SERVER).create(DurationService::class.java)

        fun getLevelService(): LevelService = RetrofitClient.getClient(BASE_SERVER).create(LevelService::class.java)

        fun getGymCollectionService(): CollectionService = RetrofitClient.getClient(BASE_SERVER).create(CollectionService::class.java)

        fun getInstructorService(): InstructorService = RetrofitClient.getClient(BASE_SERVER).create(InstructorService::class.java)

        fun getSearchPreviewService(): SearchPreviewService = RetrofitClient.getClient(BASE_SERVER).create(SearchPreviewService::class.java)

        fun getSearchResultService(): SearchResultService = RetrofitClient.getClient(BASE_SERVER).create(SearchResultService::class.java)

        fun getHelpMeChooseService(): HelpMeChooseService = RetrofitClient.getClient(BASE_SERVER).create(HelpMeChooseService::class.java)

        fun getNowPlayingService(): NowPlayingService = RetrofitClient.getClient(BASE_SERVER).create(NowPlayingService::class.java)

        fun getNoClassSearchService(): NoClassSearchService = RetrofitClient.getClient(BASE_SERVER).create(NoClassSearchService::class.java)

        fun getHomeService(): HomeService = RetrofitClient.getClient(BASE_SERVER).create(HomeService::class.java)

        fun getFCMService() : FireBaseCloudMessenger = RetrofitClient.getClient(BASE_SERVER).create(FireBaseCloudMessenger::class.java)

        fun getDownloadService() : DownloadService = RetrofitClient.getClient(BASE_SERVER).create(DownloadService::class.java)
    }
}