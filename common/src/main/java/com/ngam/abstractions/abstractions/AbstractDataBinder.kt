package com.ngam.abstractions.abstractions

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractDataBinder <T: RecyclerView.ViewHolder> {
    /**
     * Returns inflated view.
     */
    protected fun getView(@LayoutRes layoutId: Int, parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    }

    /**
     * Returns type of view.
     */
    fun getViewType(): Int {
        return this.javaClass.simpleName!!.hashCode()
    }

    /**
     * Creates View Holder
     */
    abstract fun createViewHolder(parent: ViewGroup): T

    /**
     * Binds View Holder.
     */
    abstract fun bindViewHolder(viewHolder: T)
}