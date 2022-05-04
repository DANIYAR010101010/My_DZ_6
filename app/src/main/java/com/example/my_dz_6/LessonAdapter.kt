package com.example.my_dz_6

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.my_dz_6.databinding.ItemLessonBinding

class LessonAdapter(private val data : ArrayList<modelka>) :
    RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {

        return LessonViewHolder(
            ItemLessonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {

        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size



   inner class LessonViewHolder(private val binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root) {
     @RequiresApi(Build.VERSION_CODES.M)
     fun bind (lesson : modelka){
         if (lesson.color!=null){
             binding.mainLayout.setBackgroundColor(itemView.context.getColor(lesson.color!!))
         }
         binding.textView.text = lesson.lesson
         Glide.with(binding.image).load(lesson.image).into(binding.image)

     }
    }
}