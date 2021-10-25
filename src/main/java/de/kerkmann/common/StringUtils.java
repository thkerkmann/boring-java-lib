/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kerkmann.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// import org.apache.commons.text.StringEscapeUtils;

public class StringUtils {

    public static String getStringValue(String AString) {
        return isEmptyString(AString) ? "" : AString;
    }

    // duplicate implementation to avoid importing com.java.sql.StringUtils
    public final static boolean isEmptyString(String AString) {
        return (AString == null) || (AString.length() == 0);
    }
    public final static boolean isNullOrEmpty(String AString) {
        return (AString == null) || (AString.length() == 0);
    }

    public static String removeHTMLTags(String AString) {
        try {
            //String s = StringEscapeUtils.unescapeHtml4(AString);
            return AString.replaceAll("\\<.*?>", "").trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String separateLeft(String string, String sep) {
        int i = string.indexOf(sep);
        if (i >= 0) {
            return string.substring(0, i);
        }
        return string;
    }

    public static String separateRight(String string, String sep) {
        int i = string.indexOf(sep);
        if (i >= 0) {
            return string.substring(i + sep.length());
        }
        return string;
    }

    /**
     * make a base64 string urlsave by replacing the 3 special chars + / = with
     * - _ .
     *
     * @param base64 = normal base64 encoded string
     * @return urlsave base64 string
     */
    public static final String encode64urlsave(String base64) {
        return base64.replace("=", ".").replace("/", "_").replace("+", "-");
    }

    /**
     * return normal base64 string from urlsave bas64 string by replacing back
     * special chars - _ . with + / =
     *
     * @param urlbase64 = urlsave base64 encoded string
     * @return normal base64 string
     */
    public static final String decode64urlsave(String urlbase64) {
        return urlbase64.replace(".", "=").replace("_", "/").replace("-", "+");
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String includeTrailingUrlDelimiter(String part) {
        if (part == null) {
            return "/";
        }
        if (part.length() == 0) {
            return "/";
        }
        if (part.endsWith("/")) {
            return part;
        }
        return part + "/";
    }

    public static String includeTrailingPathDelimiter(String part) {
        if (part == null) {
            return File.separator;
        }
        if (part.length() == 0) {
            return File.separator;
        }
        if (part.endsWith(File.separator)) {
            return part;
        }
        return part + File.separator;
    }

    public static int StrToIntDef(String value, int def) {
        int result = def;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // silently use the default value
        }
        return result;
    }

    public static Boolean StrToBoolean(String value){
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) ||
            "true".equalsIgnoreCase(value) || "on".equalsIgnoreCase(value))
            returnValue = true;

        return returnValue;
    }

    public static String sortRoomCommaList(String sAv) {
        List<String> rooms = Arrays.asList(sAv.split(","));
        RoomNumberComperator comp = new RoomNumberComperator();
        Collections.sort(rooms, comp);

        String r = "";
        for (int i = 0; i < rooms.size(); i++) {
            if (i > 0) {
                r = r + ",";
            }
            r = r + rooms.get(i);
        }
        return r;
    }

    public static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
