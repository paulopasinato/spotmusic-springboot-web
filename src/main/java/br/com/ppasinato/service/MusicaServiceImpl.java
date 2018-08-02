package br.com.ppasinato.service;

import br.com.ppasinato.dao.MusicaDAO;
import br.com.ppasinato.domain.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Paulo Pasinato
 */

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    private MusicaDAO musicaDao;

    @Autowired
    private PlaylistService playlistService;


    @Override
    public void create(Musica musica, long playlistId) {
        musica.setPlaylist(playlistService.getListById(playlistId));
        musicaDao.create(musica);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Musica> getListByPlaylist(long playlistId) {
        return musicaDao.getListByPlaylist(playlistId);
    }

    @Override
    @Transactional(readOnly = true)
    public Musica getListByPlaylistIdAndMusicaId(long playlistId, long musicaId) {
        return musicaDao.getListByPlaylistIdAndMusicaId(playlistId, musicaId);
    }

    @Override
    public void update(Musica musica, long playlistId) {
        musica.setPlaylist(playlistService.getListById(playlistId));
        musicaDao.update(musica);
    }

    @Override
    public void delete(long playlistId, long musicaId) {
        musicaDao.delete(getListByPlaylistIdAndMusicaId(playlistId, musicaId).getId());
    }
}
