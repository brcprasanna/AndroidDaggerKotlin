package narshim.androiddaggerkotlin

import dagger.Component
import narshim.androiddaggerkotlin.dagger.modules.AppModule
import narshim.androiddaggerkotlin.dagger.modules.PresenterModule
import javax.inject.Singleton

//this is an interface, !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface MyAwesomeComponent {
    fun inject(repository: PresenterRepository?)
}