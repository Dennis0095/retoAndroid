package com.comercio.data.core

import okhttp3.*
import okio.Buffer
import timber.log.Timber
import java.nio.charset.Charset

class OkHttpLogger: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logRequest(request)

        val response = chain.proceed(request)
        logResponse(response)

        return response
    }

    private fun logRequest(request: Request) {
        val requestBody = request.body()
        val hasRequestBody = requestBody != null

        val logMessage = StringBuilder()
        logMessage.append("Request: ")
            .append(request.method())
            .append(" ")
            .append(request.url())
            .appendLine()

        if (hasRequestBody) {
            val requestBodyString = requestBodyToString(requestBody!!)
            logMessage.append("Body: ").append(requestBodyString).appendLine()
        }
        Timber.tag("OkHttp").d(logMessage.toString())


    }

    private fun logResponse(response: Response) {
        val responseBody = response.body()
        val hasResponseBody = responseBody != null

        val logMessage = StringBuilder()
        logMessage.append("Response: ")
            .append(response.code())
            .append(" ")
            .append(response.message())
            .appendLine()

        if (hasResponseBody) {
            val responseBodyString = responseBodyToString(responseBody!!)
            logMessage.append("Body: ").append(responseBodyString).appendLine()
        }

        Timber.tag("OkHttp").d(logMessage.toString())


    }

    private fun requestBodyToString(requestBody: RequestBody): String {
        val buffer = Buffer()
        requestBody.writeTo(buffer)
        val charset: Charset = requestBody.contentType()?.charset(Charset.forName("UTF-8")) ?: Charset.forName("UTF-8")
        return buffer.readString(charset)
    }

    private fun responseBodyToString(responseBody: ResponseBody): String {
        val source = responseBody.source()
        source.request(Long.MAX_VALUE)
        val buffer = source.buffer

        val charset: Charset = responseBody.contentType()?.charset(Charset.forName("UTF-8")) ?: Charset.forName("UTF-8")
        return buffer.clone().readString(charset)
    }
}