package com.example.funfacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class FactAdapter(context: Context, facts: List<FactModel>  ) : ArrayAdapter<FactModel>(context,0,facts) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)

        if(view == null){
            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        }

        val logo = view?.findViewById<ImageView>(R.id.logo)
        val name = view?.findViewById<TextView>( R.id.name)

        fact?.logo?.let {
            logo?.setImageResource(fact.logo)
        }

        name?.text = fact?.name

        view?.setOnClickListener{
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA, fact?.logo)
            intent.putExtra(NAME_EXTRA, fact?.name)
            intent.putExtra(FACT_EXTRA, fact?.detail)

            parent.context.startActivity(intent)
        }
        return view!!
    }

    companion object{
        val LOGO_EXTRA = "logo_extra"
        val NAME_EXTRA = "name_extra"
        val FACT_EXTRA = "fact_extra"
    }
}