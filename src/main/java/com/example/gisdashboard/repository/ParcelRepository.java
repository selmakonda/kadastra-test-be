package com.example.gisdashboard.repository;

import com.example.gisdashboard.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {}
