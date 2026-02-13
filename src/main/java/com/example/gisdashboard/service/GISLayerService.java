package com.example.gisdashboard.service;

import com.example.gisdashboard.model.Parcel;
import com.example.gisdashboard.repository.ParcelRepository;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@Service
public class GISLayerService {

    @Autowired
    private ParcelRepository parcelRepository;

    public void saveLayer(MultipartFile file) throws Exception {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);

        // Example: assuming file is GeoJSON
        GeoJsonReader reader = new GeoJsonReader();
        Geometry geom = reader.read(content);

        Parcel parcel = new Parcel();
        parcel.setParcelNo("uploaded_parcel");
        parcel.setArea(100.0);
        parcel.setGeom(geom);

        parcelRepository.save(parcel);
    }
}
