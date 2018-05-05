package com.ngam.abstractions.samplePage.adapter

import com.ngam.abstractions.abstractions.AbstractDataBindAdapter
import com.ngam.abstractions.samplePage.binder.SampleBinder
import com.ngam.abstractions.samplePage.presenter.SamplePresenter

class SampleAdapter(private val presenter: SamplePresenter): AbstractDataBindAdapter() {
    override fun buildRows() {
        add(SampleBinder(presenter.sampleData1, presenter.createCheckChangeListener(),
                presenter.sampleData2))

        add(SampleBinder(presenter.sampleData3, presenter.createCheckChangeListener(),
                presenter.sampleData4))
    }
}