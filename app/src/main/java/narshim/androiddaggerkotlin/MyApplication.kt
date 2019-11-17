package narshim.androiddaggerkotlin

import android.app.Application
import android.content.Context
import narshim.androiddaggerkotlin.dagger.modules.AppModule

class MyApplication : Application() {

    private var component: MyAwesomeComponent? = null
    private var presenterRepository: PresenterRepository? = null

    override fun onCreate() {
        super.onCreate()
        component()
    }

    fun component(): MyAwesomeComponent? {
        if (component == null) {
            component = DaggerMyAwesomeComponent.builder().appModule(AppModule(this)).build()
        }
        return this!!.component
    }

    fun presenters(): PresenterRepository {
        if (presenterRepository == null) {
            presenterRepository = PresenterRepository()
            component()?.inject(presenterRepository)
        }
        return presenterRepository as PresenterRepository;
    }

    companion object {
        operator fun get(context: Context): MyApplication {
            return context.applicationContext as MyApplication
        }
    }

}