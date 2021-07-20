package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

public class SHA256 {
    public static String encrypt(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        //Stream.of(bytes).forEach(s -> builder.append(String.format("%02x", s)));  이게 왜 안될까요??
        for(byte b : bytes){
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
