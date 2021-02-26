package com.laxmena.melody;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * SongListAdapter defines custom adapter for the recyclerview.
 * This class also defines and handles short click and Long click on the ListItem.
 *
 * Long clicking the list item opens a pop up menu, where the user can open wiki pages of the
 * artist, song or play the song itself.
 *
 * @author Lakshmanan Meiyappan
 * @version 1.0
 * @since 02/20/2020
 */

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    private ArrayList<Song> songsList;
    private RVClickListener rvListener;
    Intent intent;

    // Listener passed from the Parent Activity is recieved and stored for future reference.
    public SongListAdapter(ArrayList songsList, RVClickListener listener) {
        this.songsList = songsList;
        this.rvListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creates views where the song details can be populated.
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.song_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listView, rvListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // This method populates the song details in the views created by the view holder.
        Song song = songsList.get(position);
        System.out.println(song.getSongTitle());
        holder.songTitle.setText(song.getSongTitle());
        holder.artistName.setText(song.getArtistName());
        holder.songCover.setImageResource(song.getImageRId());
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {

        // Components in the Song List Item
        public TextView songTitle;
        public TextView artistName;
        public ImageView songCover;

        private RVClickListener rvListener;
        private View itemView;

        public ViewHolder(@NonNull View itemView, RVClickListener listener) {
            super(itemView);
            songTitle = (TextView) itemView.findViewById(R.id.songTitle);
            artistName = (TextView) itemView.findViewById(R.id.artistName);
            songCover = (ImageView) itemView.findViewById(R.id.songCover);

            this.itemView = itemView;
            this.rvListener = listener;

            // Set Listeners for short and long clicks on the list item.
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            // Invoked when a list item is clicked. This method receives the view of the item
            // clicked, which is then passed to the listener from parent class along with the
            // position of the item clicked in the list.
            rvListener.onClick(v, getAdapterPosition());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // This method creates pop up menu, when the list item is long clicked.
            MenuInflater inflater = new MenuInflater(v.getContext());
            inflater.inflate(R.menu.context_menu, menu);

            // Bind a listener to each item in the Context menu
            for(int index=0; index<menu.size(); index++) {
                menu.getItem(index).setOnMenuItemClickListener(onMenuClick);
            }
        }

        private final MenuItem.OnMenuItemClickListener onMenuClick = new MenuItem.OnMenuItemClickListener() {
            // This method handles menu options selected in the context menu.
            // Based on the users preference, this method takes the user to the artist wiki, song
            // wiki or Song's YouTube page.
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.i("ON_CLICK", "Adapter Position: " + getAdapterPosition());
                int position = getAdapterPosition();
                System.out.println("Item ID: " + item.getItemId());
                System.out.println("Song URL: " + R.id.menu_play_song);
                System.out.println("Artist wiki: " + R.id.menu_artist_wiki);
                System.out.println("Song wiki: " + R.id.menu_song_wiki);
                switch(item.getItemId()) {
                    case R.id.menu_play_song:
                        intent = new Intent(Intent.ACTION_VIEW, songsList.get(position).getSongUrl());
                        break;
                    case R.id.menu_artist_wiki:
                        intent = new Intent(Intent.ACTION_VIEW, songsList.get(position).getArtistWikiUrl());
                        break;
                    case R.id.menu_song_wiki:
                        intent = new Intent(Intent.ACTION_VIEW, songsList.get(position).getSongWikiUrl());
                        break;
                }
                itemView.getContext().startActivity(intent);
                return true;
            }
        };
    }
}
