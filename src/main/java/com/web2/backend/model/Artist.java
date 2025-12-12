package com.web2.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;

    private String city;
    private String state;

    @Column(length = 1000)
    private String imageUrl;
}
