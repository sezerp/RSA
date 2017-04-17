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

    private int i;
    private int j;

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

    private int randOddNumber(int partition)
    {
        Random ranndNum = new Random();
        int randN;
        do {
            randN = (partition / 2) + (int)(ranndNum.nextFloat() * (partition / 2 ) );
        }while( ( randN % 10 ) % 2 != 1);

        return randN;
    }

    private BigInteger getCoprime(BigInteger a, BigInteger b)
    {
        BigInteger coprime = new BigInteger("0");


        return coprime;
    }

    public BigInteger[] extendetEuclideanAlgoritm(BigInteger a, BigInteger b)
    {

        BigInteger[] ret = new BigInteger[3];


        BigInteger s0 = BigInteger.ZERO;
        BigInteger t0 = BigInteger.ONE;
        BigInteger r0 = b;

        BigInteger s1 = BigInteger.ONE;
        BigInteger t1 = BigInteger.ZERO;
        BigInteger r1 = a;

        BigInteger q = BigInteger.valueOf(0);

        BigInteger buff = BigInteger.ZERO;

        while(r0 != BigInteger.ZERO)
        {
            q = r1.divide(r0);
            buff = r0;
            r0 = r1.subtract(q.multiply(r0));
            r1 = buff;

            buff = s0;
            s0 = s1.subtract(q.multiply(s0));
            s1 = buff;

            buff = t0;
            t0 = t1.subtract(q.multiply(t0));
            t1 = buff;

        }

        ret[0] = r1;
        ret[1] = s0;
        ret[2] = t1;;
        return ret;
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

    BigInteger getR()
    {
        return this.r;
    }


}
