package com.example.hotelreservation.models;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "city")
public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private int availableRooms;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnore
    private City city;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = true)
    private String photo;  // Фото отеля

    // Конструктор без photo, если это необходимо
    public Hotel(String hotelName, int availableRooms, City city, String description) {
        this.hotelName = hotelName;
        this.availableRooms = availableRooms;
        this.city = city;
        this.description = description;
    }

    // Конструктор с photo, если это необходимо
    public Hotel(String hotelName, int availableRooms, City city, String description, String photo) {
        this.hotelName = hotelName;
        this.availableRooms = availableRooms;
        this.city = city;
        this.description = description;
        this.photo = photo;
    }

    // Геттеры и сеттеры автоматически генерируются Lombok
}
