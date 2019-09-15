package ru.touchin.pic_loaders_benchmark.activities

import android.os.Bundle
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.pic_loaders_benchmark.viewcontrollers.ChooserViewController
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.EmptyState

class StartupActivity : NavigationActivity() {

    override val fragmentContainerViewId: Int
        get() = R.id.fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity)
        navigation.setInitialViewController(ChooserViewController::class.java, EmptyState)
    }

}
