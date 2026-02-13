package com.example.gisdashboard.controller;

import com.example.gisdashboard.service.GISLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private GISLayerService gisLayerService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            gisLayerService.saveLayer(file);
            return ResponseEntity.ok("File uploaded!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload error: " + e.getMessage());
        }
    }
}
