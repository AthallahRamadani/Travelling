package com.travelling.travelling.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "accommodations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String category;
    private Integer price;
}
