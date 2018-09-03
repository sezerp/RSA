package com.pawelzabczynski;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Rsa w = new Rsa();

        BigInteger p = w.getPrime(1024);
        System.out.println("p: " + p);
        BigInteger q = w.getPrime(1024);
        System.out.println("q: " + q);
        BigInteger n = w.calculateN(p, q);
        System.out.println("n: " + n);
        BigInteger r = w.calculateR(p, q);
        System.out.println("r: " + r);
        BigInteger[] e;
        e = w.getCoprime(r);
        for(int i = 0; i < 4; i++)System.out.println("e[" + i + "]: " + e[i]);
        BigInteger d = w.getMultipicativeInverse(r, e[2]);
        System.out.println("d: " + d);

        BigInteger valutToEncrypted = BigInteger.valueOf(122345);

        BigInteger encryptedValue = w.publicFunction(valutToEncrypted, e[3], n);
        System.out.println("pub: " + encryptedValue);
        BigInteger decryptedValue = w.privateFunction(encryptedValue, d, n);
        System.out.println("priv: " + decryptedValue);


    }
}
