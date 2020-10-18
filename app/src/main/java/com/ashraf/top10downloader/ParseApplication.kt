package com.ashraf.top10downloader

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

class ParseApplication {
    private val TAG = "ParseApplication"
    val applications = ArrayList<Feed>()

    fun parse(xmlData:String):Boolean{
        Log.d(TAG,"parse called with $xmlData")
        var status = true
        var inEntry = false
        var textValue =""

        try {
            val factory=XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp=factory.newPullParser()
            xpp.setInput(xmlData.reader())
            var eventType = xpp.eventType
            var currentRecord = Feed()
            while (eventType != XmlPullParser.END_DOCUMENT){

            }
        }
        catch (e:Exception){
            e.printStackTrace()
            status = false
        }
        return status
    }
}