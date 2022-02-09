package com.campusknot.newsapiclient.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.AssertionError

class NewsAPIServiceTest {
    private lateinit var service:NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
        //We don't require to start webserver because when we are invoking server's function it
        //will be automatically started
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sendRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=415e5827df584c8d93996cbd1c6e9796")
        }
    }

    @Test
    fun getTopHeadlines_receiveResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val articleList = responseBody!!.articles
            assertThat(articleList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receiveResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val articleList = responseBody!!.articles
            val article = articleList[0]
            assertThat(article.author).isEqualTo("Emily Giambalvo, Des Bieler")
            assertThat(article.url).isEqualTo("https://www.washingtonpost.com/sports/olympics/2022/02/03/winter-olympics-results-figure-skating/")
            assertThat(article.publishedAt).isEqualTo("2022-02-04T04:39:35Z")
        }
    }
}