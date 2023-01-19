package com.examen.orellana.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.examen.orellana.errors.RSRuntimeException;
import com.examen.orellana.model.Members;
import com.examen.orellana.model.Song;
import com.examen.orellana.repository.SongRepository;
import com.examen.orellana.utils.RSCode;

@Service
public class SongService {
    private final SongRepository songRespository;

    public SongService(SongRepository songRespository) {
        this.songRespository = songRespository;
    }

    public String getSinger(String song){
        Optional<Song> optSong = this.songRespository.findById(song);
        if(optSong.isPresent()){
            Song objSong = optSong.get();
            String singer = objSong.getSinger();
            return singer; 
        } else {
            throw new RSRuntimeException("Artista no encontrado", RSCode.NOT_FOUND);
        }
    }

    public void createSong(Song song){
        try{
            this.songRespository.save(song);
        } catch (Exception e){
            throw new RSRuntimeException("Failure", RSCode.BAD_REQUEST);
        }
    }

    public void updateSong(String id, Integer year){
        try{
            Optional<Song> optSong = this.songRespository.findById(id);
            if(optSong.isPresent()){
                Song song = optSong.get();
                song.setYear(year);
                this.songRespository.save(song);
            } else {
                throw new RSRuntimeException("No encontrado", RSCode.NOT_FOUND);
            }
        } catch (Exception e){
            throw new RSRuntimeException("Failure", RSCode.BAD_REQUEST);
        }
    }

    public void saveMembers(String id, List<Members> members){
        Optional<Song> optSong = this.songRespository.findById(id);
        if(optSong.isPresent()){
            Song song = optSong.get();
            song.setMembers(members);
            this.songRespository.save(song);
        } else {
            throw new RSRuntimeException("Failure", RSCode.BAD_REQUEST);
        }
    }
}
