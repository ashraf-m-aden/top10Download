package com.ashraf.top10downloader

class Feed {
    var name = ""
    var artist = ""
    var releaseDate = ""
    var summary = ""
    var imageUrl = ""
    override fun toString(): String {
        return """
                name=$name
                artist=$artist
                releaseDate=$releaseDate
              summary = $summary
                imageUrl=$imageUrl
            """.trimIndent()
    }


}