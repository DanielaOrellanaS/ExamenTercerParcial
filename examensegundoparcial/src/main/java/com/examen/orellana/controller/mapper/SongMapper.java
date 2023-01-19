package com.examen.orellana.controller.mapper;

import com.examen.orellana.controller.dto.RQSong;
import com.examen.orellana.controller.dto.RSSong;
import com.examen.orellana.model.Song;

public class SongMapper {

    //De Modelo a Response 
    public static RSSong map(Song song){
        return RSSong.builder()
        .title(song.getTitle())
        .album(song.getAlbum())
        .year(song.getYear())
        .singer(song.getSinger())
        .build();
    }

    //De Request a modelo 

    public static Song map(RQSong rqSong){
        return Song.builder()
        .title(rqSong.getTitle())
        .album(rqSong.getAlbum())
        .year(rqSong.getYear())
        .singer(rqSong.getSinger())
        .build();
    }
}
