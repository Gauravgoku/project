package com.myProject.project.product.utility;


import org.springframework.web.multipart.MultipartFile;


public class FileUtils {


    public static boolean checkFileIsExcel(MultipartFile file) {

        String content = file.getContentType();

        return content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }


}
