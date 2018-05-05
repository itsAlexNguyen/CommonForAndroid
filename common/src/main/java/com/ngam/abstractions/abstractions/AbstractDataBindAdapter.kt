package com.ngam.abstractions.abstractions

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class AbstractDataBindAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    protected var listItems : ArrayList<AbstractDataBinder<*>> = ArrayList()

    // Creates ViewHolder given unique ViewType
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getDataBinder<AbstractDataBinder<RecyclerView.ViewHolder>>(viewType)!!.createViewHolder(parent)
    }

    // Binds ViewHolder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        (listItems as ArrayList<AbstractDataBinder<RecyclerView.ViewHolder>>)[position]
                .bindViewHolder(holder)
    }

    // Gets Unique ID of item.
    override fun getItemViewType(position: Int): Int {
        return listItems[position].getViewType()
    }

    // Gets ItemCount
    override fun getItemCount(): Int {
        return listItems.size
    }

    // Gets Binder from views in list
    private fun <T: AbstractDataBinder<RecyclerView.ViewHolder>> getDataBinder(viewType: Int): T? {
        for (binder in listItems) {
            if (binder.getViewType() == viewType) {
                @Suppress("UNCHECKED_CAST")
                return binder as T
            }
        }
        return null
    }

    /**
     * This reloads the RecyclerView.
     */
    open fun reload() {
        buildRows()
        notifyDataSetChanged()
    }

    /**
     * Adds item to end of RecyclerView.
     */
    open fun add(item: AbstractDataBinder<*>) {
        listItems.add(item)
        notifyItemChanged(listItems.size)
    }

    /**
     * This fills listitems with populated binders.
     */
    abstract fun buildRows()
}