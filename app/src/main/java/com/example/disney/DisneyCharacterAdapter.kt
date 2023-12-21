package com.example.disney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class DisneyCharacterAdapter(private val disneyCharacters: List<DisneyCharacter>) :
    RecyclerView.Adapter<DisneyCharacterAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.disneyCharacterName)
            imageView = view.findViewById(R.id.disneyCharacterImage)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_view_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val character = disneyCharacters[position]

        // Load image using Glide
        Glide.with(viewHolder.imageView.context)
            .load(character.imageUrl) // Replace with the actual URL property in your MyDataModel
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(viewHolder.imageView)

        viewHolder.textView.text = disneyCharacters[position].name

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = disneyCharacters.size

}
