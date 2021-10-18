package com.borman.geneabook.TEST;

import com.borman.geneabook.service.ImageService;

import java.io.IOException;
import java.util.Arrays;

public class test {
    private final ImageService imageService;

    public test(ImageService imageService) {
        this.imageService = imageService;
    }

    public ImageService getImageService() {
        return imageService;
    }

    public static void main(String[] args) throws IOException {

//        System.out.println(Arrays.toString(.blobImageFromFile("E:\\geneo-book\\src\\main\\webapp\\resources\\img\\genealogy.jpg")));
    }
}
