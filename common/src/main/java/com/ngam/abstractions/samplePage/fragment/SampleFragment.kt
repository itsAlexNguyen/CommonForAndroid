package com.ngam.abstractions.samplePage.fragment

import com.ngam.abstractions.abstractions.AbstractClassProperties
import com.ngam.abstractions.abstractions.AbstractFragment
import com.ngam.abstractions.samplePage.adapter.SampleAdapter
import com.ngam.abstractions.samplePage.contracts.SampleView
import com.ngam.abstractions.samplePage.presenter.SamplePresenter

class SampleFragment: AbstractFragment<SamplePresenter, SampleAdapter>(), SampleView {
    override fun setProperties(): AbstractClassProperties<SamplePresenter, SampleAdapter> {
        val presenter: SamplePresenter = SamplePresenter(this)
        val adapter: SampleAdapter = SampleAdapter(presenter)
        return AbstractClassProperties(presenter, adapter, "Wow")
    }
}