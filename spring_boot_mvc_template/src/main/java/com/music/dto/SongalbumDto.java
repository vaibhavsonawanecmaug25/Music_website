package com.music.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class SongalbumDto {
	private Long songId;
	private String name;
	private String artist_name;
	private String genre;
	private Integer duration;
	private String audioUrl;
	
	

}
