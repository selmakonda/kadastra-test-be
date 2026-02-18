package com.example.gisdashboard.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "parcels", schema = "gis-test")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parcel_no", nullable = false)
    private String parcelNo;

    @Column(nullable = false)
    private double area;

    @Column(columnDefinition = "geometry")
    private Geometry geom;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Parcel() {}

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getParcelNo() {
        return parcelNo;
    }

    public void setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
