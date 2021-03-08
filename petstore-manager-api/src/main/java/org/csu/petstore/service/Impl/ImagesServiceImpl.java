package org.csu.petstore.service.Impl;

import org.csu.petstore.service.ImagesService;
import org.csu.petstore.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Override
    public void uploadSaveImages(MultipartFile file, String path) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            if (fileName.endsWith("png") || fileName.endsWith("jpg") ) {
//                String namePartI = UUID.randomUUID().toString();
//                String namePartII = DateUtil.getCurrentTimeStamp().toString().substring(3);
//                String namePartIII = fileType;
//
//                System.out.println(namePartI + ", " + namePartII + ", " + namePartIII);
//
//                String writeFileName = namePartI + namePartII + namePartIII;
                String writeFileName = UUID.randomUUID().toString() + "-" + DateUtil.getCurrentTimeStamp().toString().substring(3) + fileType;
                File dir = new File(path, writeFileName);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // MultipartFile自带的解析方法
                file.transferTo(dir);
            }
        }
    }
}
