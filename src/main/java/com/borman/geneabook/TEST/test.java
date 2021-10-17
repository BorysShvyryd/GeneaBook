package com.borman.geneabook.TEST;

import com.borman.geneabook.service.ImageService;

import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        ImageService imageService = new ImageService();
        System.out.println(Arrays.toString(imageService.blobImage("E:\\geneo-book\\src\\main\\webapp\\resources\\img\\pic01.jpg")));
    }
}
