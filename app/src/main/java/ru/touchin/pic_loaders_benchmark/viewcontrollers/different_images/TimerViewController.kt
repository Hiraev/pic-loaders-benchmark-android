package ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images

import android.os.Parcelable
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController
import kotlin.concurrent.fixedRateTimer

abstract class TimerViewController<TActivity : FragmentActivity, TState : Parcelable>(
        creationContext: CreationContext,
        @LayoutRes id: Int
) : ViewController<TActivity, TState>(
        creationContext,
        id
) {

    abstract val textView: TextView

    abstract val numOfPictures: Int

    private val startTime = System.currentTimeMillis()

    private val timer = fixedRateTimer(period = 100L) {
        val current = (System.currentTimeMillis() - startTime)
        val seconds = (current / 1000).toString()
        val milliseconds = ((current % 1000) / 10).toString()
        textView.text = "${seconds.padStart(2, '0')}:${milliseconds.padEnd(2, '0')}"
    }

    private var counter = 0

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    fun onResourceLoaded() {
        synchronized(counter) {
            counter++
            if (counter == numOfPictures) {
                timer.cancel()
            }
        }
    }

}
