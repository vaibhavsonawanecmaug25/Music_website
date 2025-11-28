package com.music.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class FavouritesongDto {
	private Long songId;
	private String title;
	private String artist_name;

}
