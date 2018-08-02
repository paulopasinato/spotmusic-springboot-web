package br.com.ppasinato.dao;

import br.com.ppasinato.domain.Playlist;
import java.util.List;

/**
 * @author Paulo Pasinato
 */

public interface PlaylistDAO {

    void create(Playlist playlist);
    List<Playlist> getList();
    Playlist getListById(long id);
    void update(Playlist playlist);
    void delete(long id);
}
