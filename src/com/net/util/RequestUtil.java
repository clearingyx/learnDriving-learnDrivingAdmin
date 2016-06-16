package com.net.util;

public class RequestUtil {

    public static String escape(String str) {
        String sBack = "";
        for (int i = 0; i < str.length(); i++) {
            char cMain = str.charAt(i);
            if (cMain == '%')
                sBack += "%25";
            else if (cMain == '&')
                sBack += "%26";
            else if (cMain == ' ')
                sBack += "%20";
            else if (cMain == '=')
                sBack += "%3D";
            else if (cMain == '+')
                sBack += "%2B";
            else if (cMain == '-')
                sBack += "%2D";
            else if (cMain == '#')
                sBack += "%23";
            else if (cMain == '*')
                sBack += "%2A";
            else if (cMain == '?')
                sBack += "%3F";
            else
                sBack += str.charAt(i);
        }

        return sBack;
    }
}
