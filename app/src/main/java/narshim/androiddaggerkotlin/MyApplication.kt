package narshim.androiddaggerkotlin

import android.app.Application
import narshim.androiddaggerkotlin.dagger.modules.AppModule

class MyApplication : Application() {

    private lateinit var component: MyAwesomeComponent
    private lateinit var presenterRepository: PresenterRepository

    fun component(): MyAwesomeComponent {
        if (component == null) {
            //component = D.builder().appModule(AppModule(this)).build();
            component = DaggerMyAwesomeComponent.builder().appModule(AppModule(this)).build()
        }
        return component
    }

    fun presenter(): PresenterRepository {
        if (presenterRepository == null) {
            presenterRepository = PresenterRepository()
            component().inject(presenterRepository)
        }
        return presenterRepository;
    }


}