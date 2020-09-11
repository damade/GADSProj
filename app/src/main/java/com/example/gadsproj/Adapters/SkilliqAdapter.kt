package com.example.gadsproj.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsproj.DataClass.Hour
import com.example.gadsproj.DataClass.SkillIq
import com.example.gadsproj.R
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class SkilliqAdapter(val skills: List<SkillIq>): RecyclerView.Adapter<SkilliqViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkilliqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout_hour, parent, false)
        return SkilliqViewHolder(view)
    }

    override fun getItemCount(): Int {
        return skills.size
    }

    override fun onBindViewHolder(holder: SkilliqViewHolder, position: Int) {
        return holder.bind(skills[position])
    }
}

class SkilliqViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo: ImageView = itemView.findViewById(R.id.skill_image_view)
    private val name: TextView = itemView.findViewById(R.id.skill_name)
    private val hour_text: TextView = itemView.findViewById(R.id.skill_rating)

    fun bind(each_skill: SkillIq) {
        //Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
        Picasso.get().load(each_skill.badgeUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .placeholder(R.drawable.toplearner)
            .error(R.drawable.toplearner)
            .resize(200, 200)
            .centerCrop().into(photo);
        val h_text = "${each_skill.score} skill IQ Score, ${each_skill.country}."
        name.text = each_skill.name
        hour_text.text = h_text
    }

}