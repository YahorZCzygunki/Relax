package egor.android.core.network

interface HttpClient {

    fun makeRequest(isError: Boolean): String
}

class DemoHttpClient : HttpClient {
    override fun makeRequest(isError: Boolean): String {
        println("Make request")
        return if (isError) "Error" else "Success"
    }
}