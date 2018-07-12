package com.ngam.abstractions.abstractions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngam.abstractions.R

abstract class AbstractFragment<Presenter: AbstractPresenter, Adapter: AbstractDataBindAdapter>: Fragment() {
    // DataSource
    protected lateinit var dataSource: AbstractClassProperties<Presenter, Adapter>
    // Presenter and Adapter
    protected lateinit var presenter: Presenter
    protected lateinit var adapter: Adapter

    // Views
    protected lateinit var listView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val parentView: View = inflater.inflate(getLayoutId(), container, false)

        // Get DataSource and set vars.
        dataSource = setProperties()
        presenter = dataSource.presenter
        adapter = dataSource.adapter
        if (dataSource.shouldBuildRows == true) {
            adapter.buildRows()
        }

        activity?.title = dataSource.pageTitle

        // RecyclerView Setup
        listView = parentView.findViewById(getRecyclerViewId())
        listView.layoutManager = LinearLayoutManager(activity)
        listView.itemAnimator = DefaultItemAnimator()
        listView.adapter = adapter

        presenter.onViewReady()

        // [HACK]: Prevents EditTexts from automatically stealing focus on initial load.
        listView.requestFocus()
        return view
    }

    /**
     * This returns layout id of abstract activity.
     * It can be overriden as needed to provide different layouts if required.
     */
    open fun getLayoutId(): Int {
        return R.layout.abstract_recycler_view_activity
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
        activity?.runOnUiThread {
            adapter.reload()
        }
    }

    /**
     * This sets the adapter and presenter with implemented versions of themselves.
     */
    protected abstract fun setProperties(): AbstractClassProperties<Presenter, Adapter>
}