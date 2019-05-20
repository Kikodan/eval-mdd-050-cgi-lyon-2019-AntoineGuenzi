package com.ipiecoles.java.eval.mdd050.controler;

import com.ipiecoles.java.eval.mdd050.model.Album;
import com.ipiecoles.java.eval.mdd050.model.Artist;
import com.ipiecoles.java.eval.mdd050.service.AlbumService;
import com.ipiecoles.java.eval.mdd050.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/albums")
public class AlbumControler {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album)
    {
        return albumService.creerAlbum(album);
    }

    @RequestMapping(value = "/{albumId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delAlbum(@PathVariable(name = "albumId") Long id)
    {
        albumService.deleteAlbum(id);
    }
}
