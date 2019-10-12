package narshim.androiddaggerkotlin.dagger

import dagger.Component
import narshim.androiddaggerkotlin.dagger.modules.AppModule
import javax.inject.Singleton

class MyAwesomeComponent {
    @Singleton
    @Component(modules = [
    AppModule::class
    ])

    interface MyAwesomeComponent {

    }


}