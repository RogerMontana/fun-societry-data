package com.funsocietry.noq.domain;

import com.google.appengine.repackaged.org.apache.commons.codec.binary.Base64;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QrCode {
    private String encodedQrCode;

    public void setEncodedQrCode(byte[] bytes) throws UnsupportedEncodingException {
        encodedQrCode = new String(Base64.encodeBase64(bytes), "UTF-8");
    }

}
