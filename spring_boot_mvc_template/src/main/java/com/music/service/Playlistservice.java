package com.music.service;
import java.util.List;

import com.music.dto.PlaylistsDto;

public interface Playlistservice {
    String createPlaylist(PlaylistsDto dto);
    PlaylistsDto getPlaylist(Long id);
    List<PlaylistsDto> getAll();
    String deletePlaylist(Long id);
}
