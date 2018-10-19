/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidelineswap.sls.scrypt;

import com.lambdaworks.crypto.SCryptUtil;

/**
 *
 * @author vladvinnikov
 */
public class AuthlogicSCrypt {
    private static final int N = 1024;
    private static final int r = 8;
    private static final int p = 47;

    public String encrypt(String secret) {
        return SCryptUtil.scryptRuby(secret, N, r, p);
    }
    
    public boolean isMatched(String secret, String hash) {
        return SCryptUtil.check(secret, hash);
    }
    
    
}
