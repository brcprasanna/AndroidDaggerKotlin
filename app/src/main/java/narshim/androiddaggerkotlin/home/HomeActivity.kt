package narshim.androiddaggerkotlin.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import narshim.androiddaggerkotlin.MyApplication
import narshim.androiddaggerkotlin.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var presenter = MyApplication[this].presenters().get(HomePresenter::class)

        presenter.printMessage("Presenter called")

    }
}
