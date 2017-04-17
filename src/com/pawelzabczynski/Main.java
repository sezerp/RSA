package com.pawelzabczynski;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Rsa w = new Rsa(512);

//        System.out.println(w.getP());
//        System.out.println(w.getQ());
        BigInteger[] x = new BigInteger[3];

        x = w.extendetEuclideanAlgoritm(BigInteger.valueOf(46), BigInteger.valueOf(240));

        for(int i=0; i<3; i++ )
        {
            System.out.println(x[i]);
        }


    }
}
