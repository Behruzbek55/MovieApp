package com.abdurashidov.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.movieapp.R
import com.abdurashidov.movieapp.databinding.ActivityEditMovieBinding
import com.abdurashidov.movieapp.models.MovieList
import com.abdurashidov.movieapp.models.MySharedPrefarance

class EditMovie : AppCompatActivity() {

    private lateinit var binding: ActivityEditMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEditMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        binding.apply {
            var position=intent.getIntExtra("position", 0)
            MySharedPrefarance.init(this@EditMovie)
            MovieList.movieList=MySharedPrefarance.obektString
            name.setText(MovieList.movieList[position].name)
            authors.setText(MovieList.movieList[position].authors)
            about.setText(MovieList.movieList[position].about)
            date.setText(MovieList.movieList[position].date)


        }
    }
}