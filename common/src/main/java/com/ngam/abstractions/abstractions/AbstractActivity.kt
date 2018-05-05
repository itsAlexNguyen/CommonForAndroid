package com.ngam.abstractions.abstractions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.ngam.abstractions.R

abstract class AbstractActivity<Presenter: AbstractPresenter, Adapter: AbstractDataBindAdapter>:
        AppCompatActivity() {
    /**
     * Properties class for AbstractActivity containing fields required to inflate page.
     */
    data class ActivityProperties<out Presenter: AbstractPresenter,
            out Adapter: AbstractDataBindAdapter> (
            val presenter: Presenter, // Mandatory
            val adapter: Adapter, // Mandatory
            val pageTitle: String, // Mandatory
            val shouldBuildRows: Boolean? = true) // Optional

    // DataSource
    protected lateinit var dataSource: ActivityProperties<Presenter, Adapter>
    // Presenter and Adapter
    protected lateinit var presenter: Presenter
    protected lateinit var adapter: Adapter

    // Views
    protected lateinit var listView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get DataSource and set vars.
        dataSource = setProperties()
        presenter = dataSource.presenter
        adapter = dataSource.adapter
        if (dataSource.shouldBuildRows == true) {
            adapter.buildRows()
        }

        title = dataSource.pageTitle
        setContentView(getLayoutId())

        // RecyclerView Setup
        listView = findViewById(getRecyclerViewId())
        listView.layoutManager = LinearLayoutManager(this)
        listView.itemAnimator = DefaultItemAnimator()
        listView.adapter = adapter

        presenter.onViewReady()

        // [HACK]: Prevents EditTexts from automatically stealing focus on initial load.
        listView.requestFocus()
    }

    /**
     * This returns layout id of abstract activity.
     * It can be overriden as needed to provide different layouts if required.
     */
    open fun getLayoutId(): Int {
        return R.layout.abstract_recycler_view_activity;
    }

    /**
     * This returns id of RecyclerView.
     * It can be overriden as needed if a different layout is being used.
     */
    open fun getRecyclerViewId(): Int {
        return R.id.abstractListView
    }

    /**
     * This notifies RecyclerView to reload itself.
     */
    fun reload() {
        runOnUiThread {
            adapter.reload()
        }
    }

    /**
     * This sets the adapter and presenter with implemented versions of themselves.
     */
    protected abstract fun setProperties(): AbstractActivity.ActivityProperties<Presenter, Adapter>
}