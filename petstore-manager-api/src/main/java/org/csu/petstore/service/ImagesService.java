package org.csu.petstore.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImagesService {

    void uploadSaveImages(MultipartFile file, String path) throws IOException;
}
