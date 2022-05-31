package com.example.coursespotifyapiproject.ui.playlists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coursespotifyapiproject.R
import com.example.coursespotifyapiproject.data.model.Playlist

class PlaylistsAdapter(
    private val playlists: ArrayList<Playlist>,
    private val itemClickListener: (String, String) -> Unit
) : RecyclerView.Adapter<PlaylistsAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(playlist: Playlist) {
            itemView.apply {
                val playlistName = this.findViewById<TextView>(R.id.playlistName)
                val playlistId = this.findViewById<TextView>(R.id.playlistId)
                val playlistImage = this.findViewById<ImageView>(R.id.playlistImage)

                playlistName.text = playlist.name
                playlistId.text = playlist.tracks.total.toString() + " tracks"
                this.let { Glide.with(it).load(playlist.images[0].url).into(playlistImage) };
            }
        }

        fun onClick(itemClickListener: (String, String) -> Unit) {}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsAdapter.DataViewHolder {

        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_item_layout, parent, false)
        val vh = DataViewHolder(view);
        vh.onClick(itemClickListener)
        return vh
    }

    override fun onBindViewHolder(holder: PlaylistsAdapter.DataViewHolder, position: Int) {
        holder.bind(playlists[position])
        holder.itemView.setOnClickListener { view ->
            itemClickListener.invoke(playlists[position].id, playlists[position].name)
        }
    }

    fun addPlaylists(playlists: List<Playlist>) {
        this.playlists.apply {
            clear()
            addAll(playlists)
        }
    }

    override fun getItemCount(): Int = playlists.size


}
