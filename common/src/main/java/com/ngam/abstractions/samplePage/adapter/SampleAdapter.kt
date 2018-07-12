package com.ngam.abstractions.samplePage.adapter

import com.ngam.abstractions.abstractions.AbstractDataBindAdapter
import com.ngam.abstractions.samplePage.presenter.SamplePresenter

class SampleAdapter(private val presenter: SamplePresenter): AbstractDataBindAdapter() {
    override fun buildRows() {
    }
}