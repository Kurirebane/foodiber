package com.team2.foodiber.controller;

import java.io.IOException;
import java.util.Optional;

import com.team2.foodiber.model.Image;
import com.team2.foodiber.repository.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("api/images")
public class ImageUploadController {

    private final ImageRepository imageRepository;

    public ImageUploadController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    @GetMapping
    public String getImageUploadPage() {return "upload";}

    @PostMapping("/upload")
public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Select right file");
        }
        try {
            Image image = new Image();
            image.setName(file.getOriginalFilename());
            image.setType(file.getContentType());
            image.setSize(file.getSize());
            image.setImageData(file.getBytes());

            imageRepository.save(image);

            return ResponseEntity.ok("Image uploaded");
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload image"
             + file.getOriginalFilename());

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Image image = imageOptional.get();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getImageData());

    }
}