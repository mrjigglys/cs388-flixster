package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster.R.id

class MovieRecyclerViewAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
    ) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder
    {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_fragment, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)
    {
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movieTitle) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movieDescription) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(id.movieImage) as ImageView
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int)
    {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description

        // Add "https://image.tmdb.org/t/p/w500/" to front of movie image url
        movie.movieImageUrl = "https://image.tmdb.org/t/p/w500/" + movie.movieImageUrl
        Glide.with(holder.mView)
            .load(movie.movieImageUrl)
            .centerInside()
            .into(holder.mMovieImage)

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}