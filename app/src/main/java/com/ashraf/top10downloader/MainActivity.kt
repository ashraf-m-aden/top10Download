package com.ashraf.top10downloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        GlobalScope.launch { // launch a new coroutine in background and continue
           val result = dataDownload("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")
               //http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml
            Log.d(TAG, result)

        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "OnCreate called")
        Log.d(TAG, "OnCreate done")


    }
    suspend fun dataDownload(url:String):String{
        val url = url
        Log.d(TAG, "dataDownload started")
        val rssFeed = downloadXML(url)
        if (rssFeed.isEmpty()){
            Log.d(TAG, "les données n'ont pas pu etre telechargés")
        }
        return rssFeed
    }

    suspend fun downloadXML(urlPath: String):String{
        return URL(urlPath).readText()
    }
//    suspend fun downloadXML(urlPath: String?):String{
//        val xmlResult = StringBuilder()
//        try {
//            val url = URL(urlPath)
//            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
//            val response = connection.responseCode
//            Log.d(TAG, "downloadXML Le code de reponse est $response")
//
////            val reader = BufferedReader(InputStreamReader(connection.inputStream))
////            val inputBuffer = CharArray(500)
////            var charRead = 0
////            while (charRead >= 0) {
////                charRead = reader.read(inputBuffer)
////                if (charRead > 0) {
////                    xmlResult.append((String(inputBuffer, 0, charRead)))
////                }
////            }
////            reader.close()
//
//            connection.inputStream.buffered().reader().use {xmlResult.append(it.readText())
//            }
//            Log.d(TAG, "Received ${xmlResult.length} bytes")
//            return xmlResult.toString()
//
////        } catch (e:MalformedURLException){
////            Log.d(TAG, "downloadXML url mal formé")
////        }
////        catch (e:IOException){
////            Log.d(TAG, "downloadXML io exception")
////        }
////        catch (e:Exception){
////            Log.d(TAG, "downloadXML problem inconnu, ${e.message}")
////        }
//        } catch (e: Exception){
//            val errorMessage:String = when (e){
//                is MalformedURLException->"downloadXML url mal formé ${e.message}"
//                is IOException->"downloadXML io exception ${e.message}"
//                is SecurityException->{e.printStackTrace()
//                    "downloadXML security exception. Need permission? ${e.message}"}
//                else -> "Unknow error ${e.message}"
//            }
//            Log.d(TAG, errorMessage)
//
//        }
//        return "" // if it get there there is a problem return an empty string
//    }

}