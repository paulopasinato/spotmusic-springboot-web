package br.com.ppasinato.service;

import br.com.ppasinato.domain.Playlist;

import java.util.List;

/**
 * @author Paulo Pasinato
 */

public interface PlaylistService {

    void create(Playlist playlist);
    List<Playlist> getList();
    Playlist getListById(long id);
    void update(Playlist playlist);
    void delete(long id);
}
