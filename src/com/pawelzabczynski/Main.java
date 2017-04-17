package com.pawelzabczynski;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Rsa w = new Rsa(512);

//        System.out.println(w.getP());
//        System.out.println(w.getQ());
        BigInteger[] x = new BigInteger[3];
        BigInteger y;

        x = w.extendetEuclideanAlgoritm(BigInteger.valueOf(8207), BigInteger.valueOf(111111));

        for(int i=0; i<3; i++ )
        {
            System.out.println(x[i]);
        }


    }
}
