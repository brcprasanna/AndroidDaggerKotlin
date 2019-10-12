package narshim.androiddaggerkotlin.dagger.modules

import android.app.Application
import dagger.Module

@Module
open class AppModule(private val application: Application) {
    fun getApplication(): Application {
        return application
    }


}
