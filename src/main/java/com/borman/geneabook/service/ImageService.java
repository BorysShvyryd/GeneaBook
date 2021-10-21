package com.borman.geneabook.service;

import com.borman.geneabook.entity.UserPhoto;
import com.borman.geneabook.entity.UserProfile;
import com.borman.geneabook.repository.ImageRepository;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Blob imageBytes(UserPhoto userPhoto) {
        try {
            return new SerialBlob(userPhoto.getUserImage().getBytes(1,
                    (int) userPhoto.getUserImage().length()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public UserPhoto getMainUserPhotoFromList(UserProfile userProfile) {
        Optional<UserPhoto> userPhoto = userProfile.getUserFotoList()
                .stream()
                .filter(f -> f.getStatusImage() == 1)
                .findFirst();

        return userPhoto.orElse(null);

    }

    public Blob blobImageFromFile(String imageFilePath) {
        try {
            File file = new File(imageFilePath);
            byte[] picInBytes = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
            return new SerialBlob(picInBytes);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void saveImage(UserPhoto userPhoto) {
        imageRepository.save(userPhoto);
    }

    public UserPhoto findImageById(Long id) {
        return imageRepository.getById(id);
    }

}
