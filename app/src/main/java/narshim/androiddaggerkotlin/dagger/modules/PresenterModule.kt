package narshim.androiddaggerkotlin.dagger.modules

import dagger.Module
import dagger.Provides
import narshim.androiddaggerkotlin.home.HomePresenter
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun homePresenter(): HomePresenter {
        return HomePresenter()
    }

}
