package com.music.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {
	 private Long albumId;
	    private String title;
	    private Integer releaseYear;
	    private String coverImage;

	    private Long artistId;
	    private String artistName;

	    private String genre;
}
