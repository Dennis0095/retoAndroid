package com.comercio.retoandroid.commons.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comercio.core.request_result.RequestResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

typealias DoTask<T> = suspend CoroutineScope.() -> RequestResult<T>
typealias SuccessResult<T> = (success: T) -> Unit
typealias ErrorResult = ((Exception) -> Unit)?
typealias Finally = (() -> Unit)?

fun <T> ViewModel.launchOnIO(
    doTask: DoTask<T>,
    result: SuccessResult<T>,
    error: ErrorResult = null,
    finally: Finally = null
): Job {
    return viewModelScope.launch {
        try {
            withContext(Dispatchers.IO) {
                doTask()
            }.also {
                when (it) {
                    is RequestResult.Success -> result(it.value)
                    is RequestResult.Error -> error?.invoke(it.exception)
                }
            }
        } catch (ex: Exception) {
            error?.invoke(ex)
        } finally {
            finally?.invoke()
        }
    }
}