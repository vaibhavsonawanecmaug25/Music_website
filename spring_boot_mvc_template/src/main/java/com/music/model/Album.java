package com.music.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "albums")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(length = 100, nullable = false)
    private String title;

    private Integer releaseYear;

    private String coverImage;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
