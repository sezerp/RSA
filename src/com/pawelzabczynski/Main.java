package com.pawelzabczynski;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Rsa w = new Rsa();
        BigInteger a;
        BigInteger p = w.getPrime(6);
        System.out.println("p: " + p);
        BigInteger q = w.getPrime(6);
        System.out.println("q " + q);
        BigInteger n = w.calculateN(p, q);
        System.out.println("n " + n);
        BigInteger r = w.calculateR(p, q);
        System.out.println("r " + r);
        BigInteger[] e;
        e = w.getCoprime(r);
        for(int i = 0; i < 4; i++)System.out.println("e[" + i + "] " + e[i]);
        BigInteger d = w.getMultipicativeInverse(r, e[2]);
        System.out.println("d: " + d);

        BigInteger pub = w.publicFunction(BigInteger.valueOf(10), e[3], n);
        System.out.println("pub " + pub);
        BigInteger priv = w.privateFunction(pub, d, n);
        System.out.println("priv " + priv);

//        BigInteger[] x;
//
//        x = w.extendetEuclideanAlgoritm(BigInteger.valueOf(5), BigInteger.valueOf(1872));
//        for(int i = 0; i < 3; i++)System.out.println("x[" + i + "] " + x[i]);




    }
}
