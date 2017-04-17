package com.pawelzabczynski;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by PrZ on 17/04/2017.
 */
public class Rsa {

    private BigInteger p = new BigInteger("0");
    private BigInteger q = new BigInteger("0");
    private Random rand = new Random();
    private final int nBit = 1024;

    Rsa()
    {
        do {
            p = p.probablePrime(this.nBit, rand);
        }
        while(!p.isProbablePrime(100));

        do {
            q = q.probablePrime(this.nBit, rand);
        }
        while(!q.isProbablePrime(100));
    }

    Rsa(int n)
    {

        do {
            p = p.probablePrime(n, rand);
        }
        while(!p.isProbablePrime(100));

        do {
            q = q.probablePrime(n, rand);
        }
        while(!q.isProbablePrime(100));
    }

    BigInteger getP()
    {
        return this.p;
    }

    BigInteger getQ()
    {
        return this.q;
    }


}
