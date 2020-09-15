package com.example.gadsproj.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsproj.DataClass.Hour
import com.example.gadsproj.R
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class HourAdapter(private val hours: List<Hour>?) : RecyclerView.Adapter<HourViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_layout_hour, parent, false)
        return HourViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hours!!.size

    }

    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {
        return holder.bind(hours?.get(position))
    }
}

class HourViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    private val photo: ImageView = itemView.findViewById(R.id.hour_image_view)
    private val name: TextView? = itemView.findViewById(R.id.hour_name)
    private val hour_text: TextView? = itemView.findViewById(R.id.hour_rating)

    fun bind(each_hour: Hour?) {
        //Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
        Picasso.get().load(each_hour?.badgeUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .placeholder(R.drawable.skilliqqtrimmed)
            .error(R.drawable.skilliqqtrimmed)
            .resize(200, 200)
            .centerCrop().into(photo);
        val h_text: String = "${each_hour?.hours} learning hours, ${each_hour?.country}."
        name?.text = each_hour?.name
        hour_text?.text = h_text
    }

}
