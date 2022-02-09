package com.campusknot.newsapiclient.data.model


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String, // ok
    @SerializedName("totalResults")
    val totalResults: Int // 38
)

data class Article(
    @SerializedName("author")
    val author: String, // Reuters
    @SerializedName("content")
    val content: String, // By Tommy WilkesLONDON (Reuters) - Stocks staged a modest rebound on Monday as traders put aside concerns about inflation and the crisis in Ukraine to dip back in, but global equities are still head… [+3897 chars]
    @SerializedName("description")
    val description: String, // Stocks rebound but head for worst January since 2016
    @SerializedName("publishedAt")
    val publishedAt: String, // 2022-01-31T09:46:00Z
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String, // Stocks rebound but head for worst January since 2016 By Reuters - Investing.com
    @SerializedName("url")
    val url: String, // https://www.investing.com/news/stock-market-news/asia-shares-in-cautious-mood-oil-keeps-climbing-2752813
    @SerializedName("urlToImage")
    val urlToImage: String // https://i-invdn-com.investing.com/news/LYNXNPEBAI13Z_L.jpg
)

data class Source(
    @SerializedName("id")
    val id: Any, // null
    @SerializedName("name")
    val name: String // Investing.com
)