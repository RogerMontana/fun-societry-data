package com.funsocietry.snippy.dto;

import java.io.UnsupportedEncodingException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImgSnippet {
    public static final String CHARSET_NAME = "UTF-8";
    private String code;

    public void setEncodedCode(byte[] bytes) throws UnsupportedEncodingException {
        code = new String(Base64.encodeBase64(bytes), CHARSET_NAME);
    }

}
