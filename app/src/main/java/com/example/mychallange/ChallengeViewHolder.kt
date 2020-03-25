package com.example.mychallange

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.json_item.view.*

class ChallengeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private val textName = itemView.text_view_name
    private val textId = itemView.text_view_id
    private val textStatus = itemView.text_view_status
    private val textDescription = itemView.text_view_description
    private val imageStar = itemView.image_star


    fun bind(establishment: Establishment){
        textName.text = establishment.name
        textId.text = if(establishment.id.isNullOrEmpty()) "Id não identificado" else establishment.id
        textDescription.text = if (establishment.description.isNullOrEmpty()) "Descrição vazia" else establishment.description

        when {
            establishment.status.isNullOrEmpty() -> establishment.status = "Status vazio"
            establishment.status == "Reativação" -> {
                imageStar.visibility = View.VISIBLE
                textStatus.text = establishment.status
            }
            else -> {
                textStatus.text = establishment.status
            }
        }


    }
}