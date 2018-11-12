package com.funsocietry.noq.service;

import com.funsocietry.noq.domain.QrCode;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@AllArgsConstructor
public class QrPaymentService {

    public QrCode getPaymentCode() throws IOException {
        QrCode qr = new QrCode();
        qr.setEncodedQrCode(getBytes(new File("src/main/resources/static/qr/example_qr.png")));
        return qr;
    }
    
    private byte[] getBytes(File file) throws IOException {
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStreamReader.read(bytes);
        return bytes;
    }
}
