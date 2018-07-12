package com.ngam.abstractions.abstractions

data class AbstractClassProperties<out Presenter: AbstractPresenter,
        out Adapter: AbstractDataBindAdapter> (
        val presenter: Presenter, // Mandatory
        val adapter: Adapter, // Mandatory
        val pageTitle: String, // Mandatory
        val shouldBuildRows: Boolean? = true) // Optional