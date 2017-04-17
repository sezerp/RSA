package com.pawelzabczynski;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by PrZ on 17/04/2017.
 */
public class Rsa {

    private BigInteger p = new BigInteger("0");
    private BigInteger q = new BigInteger("0");
    private BigInteger n = new BigInteger("0");
    private BigInteger r = new BigInteger("0");

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


    private void calculateN()
    {
        this.n = this.q.multiply(this.p);
    }

    private void calculateR()
    {
        this.r = p.add(BigInteger.valueOf(-1));
        this.r = r.multiply( q.add(BigInteger.valueOf(-1)) );
    }

    private int randOddNumber()
    {
        Random ranndNum = new Random();
        int randN;
        do {
            randN = 5000 + (int)(ranndNum.nextFloat() * 5000);
        }while( ( randN % 10 ) % 2 != 1);

        return randN;
    }








    BigInteger getP()
    {
        return this.p;
    }

    BigInteger getQ()
    {
        return this.q;
    }
    BigInteger getN()
    {
        return this.n;
    }


}
