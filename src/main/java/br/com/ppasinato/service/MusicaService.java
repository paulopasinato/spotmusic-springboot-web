package br.com.ppasinato.service;

import br.com.ppasinato.domain.Musica;

import java.util.List;

/**
 * @author Paulo Pasinato
 */

public interface MusicaService {

    void create(Musica musica, long playlistId);
    List<Musica> getListByPlaylist(long playlistId);
    Musica getListByPlaylistIdAndMusicaId(long playlistId, long musicaId);
    void update(Musica musica, long playlistId);
    void delete(long playlistId, long musicaId);
}
