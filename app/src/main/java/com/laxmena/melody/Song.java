package com.laxmena.melody;

import android.net.Uri;

/**
 * Song class stores Song Title, Artist Name, Song's Youtube URL, Artist Wiki Page, Song's Wiki page
 * in one place.
 *
 * @author Lakshmanan Meiyappan
 * @version 1.0
 * @since 02/20/2020
 */

public class Song {
    private String songTitle;
    private String artistName;
    private String songUrl;
    private String songWikiUrl;
    private String artistWikiUrl;
    private Integer imageRId;

    public Song(String songTitle,
                String artistName,
                String songUrl,
                String songWikiUrl,
                String artistWikiUrl,
                Integer imageRId) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.songUrl = songUrl;
        this.songWikiUrl = songWikiUrl;
        this.artistWikiUrl = artistWikiUrl;
        this.imageRId = imageRId;
    }

    // Getter Methods
    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public Integer getImageRId() {
        return imageRId;
    }

    public Uri getSongUrl() {
        return Uri.parse(songUrl);
    }

    public Uri getSongWikiUrl() {
        return Uri.parse(songWikiUrl);
    }

    public Uri getArtistWikiUrl() {
        return Uri.parse(artistWikiUrl);
    }
}
