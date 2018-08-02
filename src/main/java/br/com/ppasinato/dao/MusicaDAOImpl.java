package br.com.ppasinato.dao;

import br.com.ppasinato.domain.Musica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Paulo Pasinato
 */

@Repository
public class MusicaDAOImpl implements MusicaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Musica musica) {
        em.persist(musica);
    }

    @Override
    public List<Musica> getListByPlaylist(long playlistId) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlistId", Musica.class)
                .setParameter("playlistId", playlistId)
                .getResultList();
    }

    @Override
    public Musica getListByPlaylistIdAndMusicaId(long playlistId, long musicaId) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId", Musica.class)
                .setParameter("playlistId", playlistId)
                .setParameter("musicaId", musicaId)
                .getSingleResult();
    }

    @Override
    public void update(Musica musica) {
        em.merge(musica);
    }

    @Override
    public void delete(long musicaId) {
        em.remove(em.getReference(Musica.class, musicaId));
    }
}
