package com.abdurashidov.movieapp.models

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.abdurashidov.movieapp.models.Movie
import androidx.recyclerview.widget.RecyclerView
import com.abdurashidov.movieapp.R
import com.abdurashidov.movieapp.databinding.RvItemBinding
import com.abdurashidov.movieapp.ui.MovieInfo

class RvAdapter(val list:ArrayList<Movie>, val context: Context, val rvAction: RvAction):RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val rvItem:RvItemBinding): RecyclerView.ViewHolder(rvItem.root){
        fun onBind(movie:Movie, position: Int){

            val animation=AnimationUtils.loadAnimation(context, R.anim.rv_anim)
            rvItem.root.startAnimation(animation)

            rvItem.name.text=movie.name
            rvItem.root.setOnClickListener {
                rvAction.click(movie, position)
            }

            rvItem.edit.setOnClickListener {
                rvAction.edtClick(movie, position)
            }

            rvItem.delete.setOnClickListener {
                list.remove(movie)
                this@RvAdapter.notifyItemRemoved(position)
                MySharedPrefarance.init(context)
                MySharedPrefarance.obektString=list
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface RvAction{
        fun click(movie: Movie, position: Int)
        fun edtClick(movie: Movie, position: Int)
    }

}
