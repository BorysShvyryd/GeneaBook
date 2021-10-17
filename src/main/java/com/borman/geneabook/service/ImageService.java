package com.borman.geneabook.service;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ImageService {

    public byte[] blobImage(String pathImg) throws IOException {
        File file = new File(pathImg);
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();
        return picInBytes;
    }
}
