package com.ngam.abstractions.samplePage.presenter

import android.widget.CompoundButton
import com.ngam.abstractions.abstractions.AbstractPresenter
import com.ngam.abstractions.samplePage.contracts.SampleView

class SamplePresenter(val view: SampleView): AbstractPresenter() {
    val sampleData1: String = "This is some sample data in the presenter"
    var sampleData2: Boolean = true // Initially checked.
    val sampleData3: String = "This is more sample data"
    var sampleData4: Boolean = false // Not initially checked.

    fun createCheckChangeListener(): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { _, _ ->
            view.makeToast("Changed check!")
        }
    }
}