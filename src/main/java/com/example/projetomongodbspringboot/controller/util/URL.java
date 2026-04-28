package com.example.projetomongodbspringboot.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    public static String decodeparam(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, "UTF-8");
    }
}
