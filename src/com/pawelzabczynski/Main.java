package com.pawelzabczynski;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Rsa w = new Rsa();

        BigInteger[] x = new BigInteger[3];
        BigInteger[] y = new BigInteger[4];

        x = w.extendetEuclideanAlgoritm(BigInteger.valueOf(7), BigInteger.valueOf(448));

        for(int i=0; i < 3; i++ )System.out.println(x[i]);

        y = w.getCoprime(BigInteger.valueOf(448));
        for(int i=0; i < 4; i++ )System.out.println(y[i]);

    }
}
