package com.ttdys.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@RestController
public class ImageController {

    @ResponseBody
    @GetMapping("/pic/ad")
    public void getAdvertisingImage(HttpServletResponse response) {
        String path = "C:\\Users\\ttdys\\Desktop\\pic\\activity.jpg";
        response.setHeader("Cache-Control", "max-age=2592000");
        response.setContentType("image/jpeg");
        try {
            response.getOutputStream().write(IOUtils.toByteArray(new FileInputStream(path)));
        } catch (IOException e) {
            log.error("获取广告图片报错，", e);
        }
    }


}
