package com.funsocietry.snippy.service;

import com.funsocietry.snippy.dto.ImgSnippet;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@AllArgsConstructor
public class ImgService {


    public ImgSnippet getImage() throws IOException {
        ImgSnippet qr = new ImgSnippet();

        ClassPathResource imgFile = new ClassPathResource("static/qr/example_qr.png");
        qr.setEncodedCode(getBytes(imgFile.getFile()));
        return qr;
    }

    private byte[] getBytes(File file) throws IOException {
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStreamReader.read(bytes);
        return bytes;
    }
}
