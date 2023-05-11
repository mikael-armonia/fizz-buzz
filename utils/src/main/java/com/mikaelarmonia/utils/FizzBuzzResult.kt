package com.mikaelarmonia.utils

sealed class FizzBuzzResult<S, F> {

    class Success<S, F>(val result: S) : FizzBuzzResult<S, F>()
    class Failure<S, F>(val error: F) : FizzBuzzResult<S, F>()

    fun isSuccess() = this is Success

    fun onSuccess(action: (S) -> Unit) {
        if (this is Success) {
            action(result)
        }
    }

    fun onFailure(action: (F) -> Unit) {
        if (this is Failure) {
            action(error)
        }
    }
}
