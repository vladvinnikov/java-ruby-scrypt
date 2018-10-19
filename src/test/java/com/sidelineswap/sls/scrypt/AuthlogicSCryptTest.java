/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidelineswap.sls.scrypt;

import static org.junit.Assert.*;

/**
 *
 * @author vladvinnikov
 */
public class AuthlogicSCryptTest {
    AuthlogicSCrypt sCrypter;
    String secret;
    
    @org.junit.Before
    public void setUp() {
        sCrypter = new AuthlogicSCrypt();
        secret   = "password";
    }
    
    @org.junit.Test
    public void testEncrypt() {
        String encryptedSecret = sCrypter.encrypt(secret);
        assertEquals(encryptedSecret.length(), 90);
    }
    
    @org.junit.Test
    public void testIsMatch() {
        String hash = sCrypter.encrypt(secret);
        assertTrue(sCrypter.isMatched(secret, hash));
    }
    
    @org.junit.Test
    public void testIsMatchAsRubyDoes() {
        secret = "some_password_in_rubySj1YSBnw0XvgawVLj1A2";
        String hash = "400$8$37$e07fb1edb216f8af$3d2a076b5effe3dece33d1c55b9607160197584f7744e6e6afc20cc9fc791409";
        assertTrue(sCrypter.isMatched(secret, hash));
    }
    
    
}
