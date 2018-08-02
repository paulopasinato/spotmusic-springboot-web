package br.com.ppasinato.service;

import br.com.ppasinato.dao.PlaylistDAO;
import br.com.ppasinato.domain.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Paulo Pasinato
 */

@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistDAO playlistDao;

    @Override
    public void create(Playlist playlist) {
        playlistDao.create(playlist);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> getList() {
        return playlistDao.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public Playlist getListById(long id) {
        return playlistDao.getListById(id);
    }

    @Override
    public void update(Playlist playlist) {
        playlistDao.update(playlist);
    }

    @Override
    public void delete(long id) {
        playlistDao.delete(id);
    }
}
