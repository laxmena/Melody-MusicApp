package com.laxmena.melody;

import java.util.ArrayList;

/**
 * SongListHelper creates a list of Songs Objects for this project.
 * Note: This project uses Hardcoded values for the song list.
 *
 * @author Lakshmanan Meiyappan
 * @version 1.0
 * @since 02/20/2020
 */

public class SongListHelper {
    static ArrayList songList = new ArrayList();

    public static ArrayList getSongList() {
        // If the songList is already populated, return the song list.
        if(songList.size() != 0) {
            return songList;
        }

        // If the songList array is empty, populate the list.
        songList.add(new Song("How Far Ill Go",
                "Aulii Cravalho",
                "https://www.youtube.com/watch?v=cPAbx5kgCJo&ab_channel=DisneyMusicVEVO",
                "https://en.wikipedia.org/wiki/How_Far_I%27ll_Go",
                "https://en.wikipedia.org/wiki/Auli%CA%BBi_Cravalho",
                R.drawable.how_far_ill_go));
        songList.add(new Song("Cricle of Life",
                "Carmen Twillie",
                "https://www.youtube.com/watch?v=GibiNy4d4gc&ab_channel=DisneyMusicVEVO",
                "https://en.wikipedia.org/wiki/Circle_of_Life",
                "https://en.wikipedia.org/wiki/Carmen_Twillie_(actress)",
                R.drawable.circle_of_life));
        songList.add(new Song("Let It Go",
                "Idina Menzel",
                "https://www.youtube.com/watch?v=L0MK7qz13bU&ab_channel=DisneyUK",
                "https://en.wikipedia.org/wiki/Let_It_Go",
                "https://en.wikipedia.org/wiki/Idina_Menzel",
                R.drawable.let_it_go));
        songList.add(new Song("Pokemon Theme",
                "Jason Paige",
                "https://www.youtube.com/watch?v=fCkeLBGSINs&ab_channel=JasonPaige",
                "https://en.wikipedia.org/wiki/Pok%C3%A9mon_Theme",
                "https://en.wikipedia.org/wiki/Jason_Paige",
                R.drawable.pokemon));
        songList.add(new Song("Try Everything",
                "Shakira",
                "https://www.youtube.com/watch?v=c6rP-YP4c5Iab_channel=shakiraVEVO",
                "https://en.wikipedia.org/wiki/Try_Everything",
                "https://en.wikipedia.org/wiki/Shakira",
                R.drawable.try_every));
        songList.add(new Song("A Million Dreams",
                "Hugh Jackman",
                "https://www.youtube.com/watch?v=pSQk-4fddDI&ab_channel=AtlanticRecords",
                "https://en.wikipedia.org/wiki/A_Million_Dreams",
                "https://en.wikipedia.org/wiki/Hugh_Jackman",
                R.drawable.million_dreams));
        songList.add(new Song("The Greatest Show",
                "Zendaya",
                "https://www.youtube.com/watch?v=RW61RQZojMQ&ab_channel=FoxFamilyEntertainment",
                "https://en.wikipedia.org/wiki/The_Greatest_Show",
                "https://en.wikipedia.org/wiki/Zendaya",
                R.drawable.never_enough));
        songList.add(new Song("I see the Light",
                "Mandy Moore",
                "https://www.youtube.com/watch?v=hYbHzzWmKUs&ab_channel=R.Jojenan",
                "https://en.wikipedia.org/wiki/I_See_the_Light",
                "https://en.wikipedia.org/wiki/Mandy_Moore",
                R.drawable.i_see_light));
        songList.add(new Song("I wanna be like you",
                "Louis Prima",
                "https://www.youtube.com/watch?v=9JDzlhW3XTM",
                "https://en.wikipedia.org/wiki/I_Wan%27na_Be_like_You_(The_Monkey_Song)",
                "https://en.wikipedia.org/wiki/Louis_Prima",
                R.drawable.jungle_book));
        songList.add(new Song("Lost Stars",
                "Adam Levine",
                "https://www.youtube.com/watch?v=vyT-oGDnMqE&ab_channel=InterscopeRecords",
                "https://en.wikipedia.org/wiki/Lost_Stars",
                "https://en.wikipedia.org/wiki/Adam_Levine",
                R.drawable.lost_stars));

        return songList;
    }
}
