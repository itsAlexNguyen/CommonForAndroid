package com.ngam.abstractions.samplePage.binder

import android.view.ViewGroup
import android.widget.CompoundButton
import com.ngam.abstractions.abstractions.AbstractDataBinder
import com.ngam.abstractions.samplePage.viewholder.SampleViewHolder

class SampleBinder(val sampleToggleText: String,
                   val sampleListener: CompoundButton.OnCheckedChangeListener,
                   val isChecked: Boolean): AbstractDataBinder<SampleViewHolder>() {

    // Create ViewHolder given parent ViewGroup
    override fun createViewHolder(parent: ViewGroup): SampleViewHolder {
        return SampleViewHolder(getView(SampleViewHolder.getLayoutId(), parent))
    }

    // Binder method to bind data to view as needed.
    override fun bindViewHolder(viewHolder: SampleViewHolder) {
        viewHolder.sampleTextView.text = sampleToggleText
        viewHolder.sampleToggleSwitch.setOnCheckedChangeListener(sampleListener)
        viewHolder.sampleToggleSwitch.isChecked = isChecked
    }
}