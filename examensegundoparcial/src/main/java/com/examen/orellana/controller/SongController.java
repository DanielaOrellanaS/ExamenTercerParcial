package com.examen.orellana.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.orellana.controller.dto.RQSong;
import com.examen.orellana.controller.dto.RQYear;
import com.examen.orellana.controller.mapper.SongMapper;
import com.examen.orellana.errors.RSRuntimeException;
import com.examen.orellana.model.Members;
import com.examen.orellana.model.Song;
import com.examen.orellana.service.SongService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/song")
@RestController
@Slf4j
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/{song}")
    public ResponseEntity<String> getArtist(@PathVariable("song") String song) {
        try {
            String singer = this.songService.getSinger(song);
            return ResponseEntity.ok().body(singer);
        } catch (RSRuntimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity createSong(
        @RequestBody RQSong rqSong) {
        try {
            log.info(rqSong.toString());
            Song song = SongMapper.map(rqSong);
            this.songService.createSong(song);
            return ResponseEntity.ok().build();
        } catch (RSRuntimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/members/{id}")
    public ResponseEntity createMembers(
        @PathVariable("id") String id, 
        @RequestBody List<Members> members) {
        try {
            this.songService.saveMembers(id, members);
            return ResponseEntity.ok().build();
        } catch (RSRuntimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSong(
        @PathVariable("id") String id, 
        @RequestBody RQYear year){
        try {
            this.songService.updateSong(id, year.getYear());
            return ResponseEntity.ok().build();
        } catch (RSRuntimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }



}
