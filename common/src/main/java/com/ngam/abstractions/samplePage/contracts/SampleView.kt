package com.ngam.abstractions.samplePage.contracts

interface SampleView {
    /**
     * Notifies View to make Toast with provided String.
     */
    fun makeToast(toastString: String)
}