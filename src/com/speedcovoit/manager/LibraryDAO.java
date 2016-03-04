package com.speedcovoit.manager;

import javax.persistence.EntityManager;

public class LibraryDAO {

	EntityManager em;
    
    public LibraryDAO() {
        super();
    }

    public LibraryDAO(EntityManager em) {
        super();
        this.em = em;
    }
    
   /* @SuppressWarnings("unchecked")
    List<AlbumShortDTO> findAllAlbums() {
        List<AlbumShortDTO> res;
        Query q = em.createQuery(
                "SELECT NEW com.cordani.data.dto.AlbumShortDTO("
                + "album.titreAlbum, serie.titreSerie)"
                + "FROM Album album, Serie serie"
                + "WHERE album.serie = serie");
        
        res =((List<AlbumShortDTO>)q.getResultList());
        return res;
    }*/
	
}
