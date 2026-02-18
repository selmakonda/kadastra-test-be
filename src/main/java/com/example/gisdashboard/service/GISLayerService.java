package com.example.gisdashboard.service;

import com.example.gisdashboard.model.Parcel;
import com.example.gisdashboard.repository.ParcelRepository;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GISLayerService {

    private final ParcelRepository parcelRepository;

    public GISLayerService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public void saveLayer(MultipartFile file) {
        try {
            // For now assume file contains WKT geometry as text
            String content = new String(file.getBytes());

            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(content);

            Parcel parcel = new Parcel();
            parcel.setParcelNo("AUTO-" + System.currentTimeMillis());
            parcel.setArea(geometry.getArea());
            parcel.setGeom(geometry);

            parcelRepository.save(parcel);

        } catch (Exception e) {
            throw new RuntimeException("Error processing GIS layer", e);
        }
    }
}
