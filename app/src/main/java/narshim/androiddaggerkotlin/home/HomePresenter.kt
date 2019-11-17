package narshim.androiddaggerkotlin.home

import android.util.Log

class HomePresenter : BasePresenter<Any?> {
    fun printMessage(message: String) {
        Log.i("Prasanna", message);
    }
}