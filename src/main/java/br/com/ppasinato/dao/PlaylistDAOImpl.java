package br.com.ppasinato.dao;

import br.com.ppasinato.domain.Playlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Paulo Pasinato
 */

@Repository
public class PlaylistDAOImpl implements PlaylistDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Playlist playlist) {
        em.persist(playlist);
    }

    @Override
    public List<Playlist> getList() {
        return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
    }

    @Override
    public Playlist getListById(long id) {
        return em.find(Playlist.class, id);
    }

    @Override
    public void update(Playlist playlist) {
        em.merge(playlist);
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(Playlist.class, id));
    }
}
