package com.programming.leetcode.Easy;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA_1_Java {

    public static void main(String[] args) throws Exception {
        String value = "https://www.abcdefg.com/mobile";
        MessageDigest digest = null;
        digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(value.getBytes("utf8"));
        String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        System.out.println(sha1);
    }
}
