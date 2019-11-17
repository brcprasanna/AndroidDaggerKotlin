package narshim.androiddaggerkotlin

import android.app.Application
import android.content.Context
import narshim.androiddaggerkotlin.dagger.modules.AppModule

class MyApplication : Application() {

    private lateinit var component: MyAwesomeComponent
    private lateinit var presenterRepository: PresenterRepository

    fun component(): MyAwesomeComponent {
        if (component == null) {
            component = DaggerMyAwesomeComponent.builder().appModule(AppModule(this)).build()
        }
        return component
    }

    fun presenters(): PresenterRepository {
        if (presenterRepository == null) {
            presenterRepository = PresenterRepository()
            component().inject(presenterRepository)
        }
        return presenterRepository;
    }

    companion object {
        operator fun get(context: Context): MyApplication {
            return context.applicationContext as MyApplication
        }
    }

}