package com.ngam.abstractions.samplePage.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ngam.abstractions.R
import com.ngam.abstractions.abstractions.AbstractActivity
import com.ngam.abstractions.abstractions.AbstractClassProperties
import com.ngam.abstractions.abstractions.AbstractFragment
import com.ngam.abstractions.samplePage.adapter.SampleAdapter
import com.ngam.abstractions.samplePage.contracts.SampleView
import com.ngam.abstractions.samplePage.fragment.SampleFragment
import com.ngam.abstractions.samplePage.presenter.SamplePresenter

class SampleActivity: AbstractActivity<SamplePresenter, SampleAdapter>(), SampleView {
    override fun setProperties(): AbstractClassProperties<SamplePresenter, SampleAdapter> {
        presenter = SamplePresenter(this)
        adapter = SampleAdapter(presenter)
        return AbstractClassProperties(presenter, adapter, "Sample Title")
    }
}

// To launch Fragment:
//class SampleActivity: AppCompatActivity(), SampleView {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val sampleFragment: SampleFragment = SampleFragment()
//        supportFragmentManager.beginTransaction()
//                .add(sampleFragment, "Sample Fragment")
//                .commit()
//    }
//}