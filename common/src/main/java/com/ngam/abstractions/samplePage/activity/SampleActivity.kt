package com.ngam.abstractions.samplePage.activity

import android.widget.Toast
import com.ngam.abstractions.abstractions.AbstractActivity
import com.ngam.abstractions.samplePage.adapter.SampleAdapter
import com.ngam.abstractions.samplePage.contracts.SampleView
import com.ngam.abstractions.samplePage.presenter.SamplePresenter

class SampleActivity: AbstractActivity<SamplePresenter, SampleAdapter>(), SampleView {
    override fun setProperties(): ActivityProperties<SamplePresenter, SampleAdapter> {
        presenter = SamplePresenter(this)
        adapter = SampleAdapter(presenter)
        return ActivityProperties(presenter, adapter, "Sample Title")
    }

    override fun makeToast(toastString: String) {
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show()
    }
}