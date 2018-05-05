package com.ngam.abstractions.samplePage.viewholder

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Switch
import android.widget.TextView

import com.ngam.common.R

/**
 * This is a sample ViewHolder for the Sample UI element.
 */
class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var sampleTextView: TextView
    var sampleToggleSwitch: Switch
    init {
        sampleTextView = itemView.findViewById(R.id.sampleTextView)
        sampleToggleSwitch = itemView.findViewById(R.id.sampleToggleSwitchView)
    }

    companion object {
        /**
         * Function to return layout Id of sample UI element.
         */
        @LayoutRes
        fun getLayoutId(): Int {
            return R.layout.sample_view_layout
        }
    }

}