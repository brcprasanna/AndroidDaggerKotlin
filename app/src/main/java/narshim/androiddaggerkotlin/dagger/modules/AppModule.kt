package narshim.androiddaggerkotlin.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun getApplication(): Application {
        return application
    }

}
