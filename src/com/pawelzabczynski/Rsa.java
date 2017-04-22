package com.pawelzabczynski;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by PrZ on 17/04/2017.
 */
public class Rsa {


    Rsa()
    {

    }


    private BigInteger getPrime(int n)
    {
        Random rand = new Random();
        BigInteger prime = new BigInteger("0");

        do {
            prime = prime.probablePrime(n, rand);
        }
        while(!prime.isProbablePrime(100));

        return prime;
    }

    private BigInteger calculateN(BigInteger p, BigInteger q)
    {
        return q.multiply(p);
    }

    private BigInteger calculateR(BigInteger p, BigInteger q)
    {
        BigInteger r = new BigInteger("0");
        BigInteger x = new BigInteger("0");

        r = p.subtract(BigInteger.valueOf(1));
        x = q.subtract(BigInteger.valueOf(1));

        return r.multiply(x);
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

    public BigInteger[] extendetEuclideanAlgoritm(BigInteger a, BigInteger b)
    {

        BigInteger[] ret = new BigInteger[3];


        BigInteger s0 = new BigInteger("0");
        BigInteger t0 = new BigInteger("1");
        BigInteger r0 = b;

        BigInteger s1 = new BigInteger("1");
        BigInteger t1 = new BigInteger("0");
        BigInteger r1 = a;

        BigInteger q = new BigInteger("0");

        BigInteger buff = new BigInteger("0");

        while(0 != r0.compareTo(BigInteger.ZERO))
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
        ret[1] = t0;
        ret[2] = s0;

        return ret;
    }

    public BigInteger[] getCoprime(BigInteger a)
    {
        BigInteger[] coprime = new BigInteger[4];
        BigInteger[] eukEx = new BigInteger[3];

        do {
            coprime[3] = BigInteger.valueOf(randOddNumber(10));
            eukEx = extendetEuclideanAlgoritm(coprime[3], a);

        }while(!(extendetEuclideanAlgoritm(coprime[3], a)[0].compareTo(BigInteger.ONE) == 0) && coprime[3].compareTo(BigInteger.ZERO) != 0 );

        for(int i=0; i < 3; i++)coprime[i] = eukEx[i];
        return coprime;
    }

    private BigInteger getMultipicativeInverse(BigInteger r, BigInteger j)
    {
        BigInteger mulInv;

        if(j.signum() == 1 || j.signum() == 0){
            mulInv = j.mod(r);
        }
        else {
            mulInv = j.add(r);
        }
        return mulInv;
    }

    public BigInteger privateFunction(BigInteger x, BigInteger e, BigInteger n) {return x.modPow(e, n);}

    public BigInteger publicFunction(BigInteger x, BigInteger d, BigInteger n) {return x.modPow(d, n);}


}
