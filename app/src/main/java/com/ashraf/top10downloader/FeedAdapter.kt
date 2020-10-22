package com.ashraf.top10downloader

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FeedAdapter(context: Context,private val ressource: Int,private val applications: ArrayList<Feed>): ArrayAdapter<Feed>(context, ressource, applications) {

    private val TAG = "FeedAdapater"
    private val inflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return applications.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(ressource,parent,false)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvActor: TextView = view.findViewById(R.id.tvActor)
        val tvSummary: TextView = view.findViewById(R.id.tvSummary)

        val currentApp = applications[position]
        tvName.text = currentApp.name
        tvActor.text = currentApp.artist
        tvSummary.text = currentApp.summary

        return view
    }
}