package br.com.ppasinato.dao;

import br.com.ppasinato.domain.Musica;

import java.util.List;

/**
 * @author Paulo Pasinato
 */

public interface MusicaDAO {

    void create(Musica musica);
    List<Musica> getListByPlaylist(long playlistId);
    Musica getListByPlaylistIdAndMusicaId(long playlistId, long musicaId);
    void update(Musica musica);
    void delete(long musicaId);
}
