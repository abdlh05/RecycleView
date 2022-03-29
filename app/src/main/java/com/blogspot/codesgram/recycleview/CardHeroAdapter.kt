package com.blogspot.codesgram.recycleview

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardHeroAdapter (private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardHeroAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btnFav: ImageButton = itemView.findViewById(R.id.btn_fav)
        var btnShare: ImageButton = itemView.findViewById(R.id.btn_share)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item_hero, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardHeroAdapter.CardViewHolder, position: Int){
        val (name, from, photo) = listHero[position]
            Glide.with(holder.itemView.context)
                .load(photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)


            holder.tvName.text = name
            holder.tvFrom.text = from

            holder.btnFav.setOnClickListener(View.OnClickListener {
                Toast.makeText(holder.itemView.context,"Favorite " + listHero.get(holder.absoluteAdapterPosition).name,Toast.LENGTH_SHORT).show()
                holder.btnFav.setImageResource(R.drawable.ic_favorite_done)

//                val resource = holder.btnFav.getTag()
//                if (resource == R.drawable.ic_favorite){
//                    holder.btnFav.setImageResource(R.drawable.ic_favorite_done)
//                }else if (resource == R.drawable.ic_favorite_done){
//                    holder.btnFav.setImageResource(R.drawable.ic_favorite)
//                }
            })

            holder.btnShare.setOnClickListener(View.OnClickListener {
                Toast.makeText(holder.itemView.context,"Kamu Pilih " + listHero.get(holder.absoluteAdapterPosition).name,Toast.LENGTH_SHORT).show()
            })
        }

    override fun getItemCount(): Int {
        return listHero.size
    }
}