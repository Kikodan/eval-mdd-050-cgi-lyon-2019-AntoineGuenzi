package com.ipiecoles.java.eval.mdd050.service;

import com.ipiecoles.java.eval.mdd050.model.Album;
import com.ipiecoles.java.eval.mdd050.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;


    public Album creerAlbum(Album album) {
        /*if(albumRepository.findAll() > 5){
            throw  new EntityExistsException("Il existe déja 5 Album pour cette artiste");
        }*/
        return albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.delete(id);
    }
}
