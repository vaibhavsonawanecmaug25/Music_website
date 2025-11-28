package com.music.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistsDto {
	private Long playlistId;
	private String name;
	private Long userId;
    private LocalDateTime createdAt; 
    
  private  List<Long> songId; //post
  private List<String> songName; //get

}
