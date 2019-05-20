package com.ipiecoles.java.eval.mdd050.controler;

import com.ipiecoles.java.eval.mdd050.model.Artist;
import com.ipiecoles.java.eval.mdd050.service.AlbumService;
import com.ipiecoles.java.eval.mdd050.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/artists")
public class ArtistControler {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/{artistId}", method = RequestMethod.GET)
    public Artist infosArtists(@PathVariable(name = "artistId") Long id){
        return artistService.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Artist> listeArtist(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    @RequestParam(value = "sortProperty") String sortProperty,
                                    @RequestParam(value = "sortDirection") String sortDirection)
    {
        return artistService.findAllArtists(page, size, sortProperty, sortDirection);
    }

    @RequestMapping(params = "name", method = RequestMethod.GET)
    public Page<Artist> listeArtistByName(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    @RequestParam(value = "sortDirection") String sortDirection)
    {
        return artistService.findByNameLikeIgnoreCase(name, page, size, "name", sortDirection);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Artist createArtist(@RequestBody Artist artist)
    {
        return artistService.creerArtiste(artist);
    }

    @RequestMapping(value = "/{artistId}", method = RequestMethod.PUT)
    public Artist updateArtist(@PathVariable(name = "artistId") Long id,
                               @RequestBody Artist artist)
    {
        return artistService.updateArtiste(id, artist);
    }

    @RequestMapping(value = "/{artistId}", method = RequestMethod.DELETE)
    public void delArtist(@PathVariable(name = "artistId") Long id)
    {
        artistService.deleteArtist(id);
    }


}
