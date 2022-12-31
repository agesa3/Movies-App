package com.beatrice.moviesapp.core.network.util

import logcat.logcat
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApi(
    block: suspend () -> Response<T>
): Result<T?> {
    return try {
        val response = block()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            Result.success(response.body())
        } else {
            logcat("Network_request"){"failed with code ${response.code()} message ${response.message()}"}
            val e = Exception(response.message())
            Result.failure(e)
        }
    } catch (e: HttpException) {
        logcat("Network_request"){"failed with HTTP exception $e"}
        Result.failure(e)
    } catch (e: Throwable) {
        logcat("Network_request"){"failed with a general exception $e"}
        Result.failure(e)
    }
}