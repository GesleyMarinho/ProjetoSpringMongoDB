package com.example.projetomongodbspringboot.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URL {

    public static String decodeparam(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, "UTF-8");
    }

    public static Date convertDate(String text, Date defaultValue) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(text);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
