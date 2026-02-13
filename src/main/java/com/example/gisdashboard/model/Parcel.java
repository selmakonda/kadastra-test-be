package com.example.gisdashboard.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "parcels", schema = "gis-test")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parcelNo;
    private Double area;

    @Column(columnDefinition = "geometry")
    private Geometry geom;

    @ManyToOne
    @JoinColumn(name="owner_id") // if you want owner relationship
    private Owner owner;

    // getters & setters
}
