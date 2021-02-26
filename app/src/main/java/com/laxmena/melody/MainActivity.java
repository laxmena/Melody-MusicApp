package com.laxmena.melody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

/**
 * Melody App is a Music Index Android application.
 *
 * - This app can switch between List View and Grid View based on User's preference.
 * - Can help users navigate to Wikipedia pages of the song, artist.
 * - If a user wishes to listen to a song, this apps takes the user straight to
 * the music video on YouTube.
 * - This app adapts itself if the user has activated 'Dark Mode'.
 *
 * @author Lakshmanan Meiyappan
 * @version 1.0
 * @since 02/20/2020
 */

public class MainActivity extends AppCompatActivity {
    boolean isListView = true;
    private Toolbar toolbar;
    RecyclerView songsView;
    ArrayList<Song> songsList;
    String IS_LIST_VIEW = "isListView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songsView = (RecyclerView) findViewById(R.id.songsView);
        toolbar = (Toolbar) findViewById(R.id.app_toolbar);

        // Melody App uses Toolbar widget in place of default AppBar.
        setSupportActionBar(toolbar);

        // Get List of songs to be populated in the recycler view
        // Details of songs are hardcoded, and are handled in a Separate helper class.
        songsList = SongListHelper.getSongList();

        // Get saved layout state from the saved state.
        if(savedInstanceState != null) {
            isListView = savedInstanceState.getBoolean(IS_LIST_VIEW);
        }

        // When a song is clicked on the view, this listener is invoked
        // and it creates an intent to play the song.
        RVClickListener listener = (view, position) -> {
            Uri songUrl = songsList.get(position).getSongUrl();
            Intent playSongIntent = new Intent(Intent.ACTION_VIEW, songUrl);
            startActivity(playSongIntent);
        };

        // Create and bind Adapter to the recycler view
        SongListAdapter adapter = new SongListAdapter(songsList, listener);
        songsView.setHasFixedSize(true);
        songsView.setAdapter(adapter);

        // isListView boolean variable is true when the user's preference is a list view.
        // Based on the user's preference, List view or Grid View is used to display the songs.
        songsView.setLayoutManager(isListView? new LinearLayoutManager(this): new GridLayoutManager(this, 2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // This method creates the Options menu in the toolbar widget.
        // Menu options: 1. List View, 2. Grid View
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // If the user selects a different view to display the songs, the view is toggled.
        // No action is performed when the user selects the current view in the options.
        switch (item.getItemId()) {
            case R.id.menu_list_view:
                if(!isListView) toggleLayout();
                return true;
            case R.id.menu_grid_view:
                if(isListView) toggleLayout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save isListView variable, so the state can be preserved in case of configuration change.
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_LIST_VIEW, isListView);
    }

    private void toggleLayout() {
        // This method toggles layout between List and Grid view. Also updates 'isListView' variable.
        songsView.setLayoutManager(
                isListView? new GridLayoutManager(this, 2): new LinearLayoutManager(this)
        );
        isListView = !isListView;
    }
}