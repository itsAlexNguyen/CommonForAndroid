package com.ngam.abstractions.abstractions

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import com.ngam.abstractions.R

/**
 * This extends AbstractRecyclerViewActivity and leads to a screen with a bottom menu
 */
abstract class AbstractMenuActivity<Presenter: AbstractPresenter, Adapter: AbstractDataBindAdapter>
    :  AbstractActivity<Presenter, Adapter>() {
    // NOTE: Due to a limitation in Kotlin, Data Classes cannot be subclassed. This is why if
    // additional data needs to be added for this class, it must be added in the data class for
    // AbstractActivity. While there are workarounds, none of them are clean, all very hacky.
    // Thus for now if an extra parameter is to be added, it is to be done in properties of parent

    protected lateinit var menuBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuBar = findViewById(getBottomBarLayoutId())
        menuBar.menu.clear()
        menuBar.menu.add(Menu.NONE, 1, Menu.NONE, "Home").setIcon(R.drawable.home_icon)
        menuBar.menu.add(Menu.NONE, 1, Menu.NONE, "WOW").setIcon(R.drawable.home_icon)
        menuBar.menu.add(Menu.NONE, 1, Menu.NONE, "LEL").setIcon(R.drawable.home_icon)
    }

    override fun getLayoutId(): Int {
        return R.layout.abstract_recycler_view_bottom_bar_activity
    }

    /**
     * This returns bottom bar layout Id, needed if custom layout is used with different id.
     */
    fun getBottomBarLayoutId(): Int {
        return R.id.bottomNavBar
    }
}