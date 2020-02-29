package com.pawelzabczynski;

import static java.math.BigInteger.probablePrime;

import java.math.BigInteger;
import java.util.Random;

/** Created by PrZ on 17/04/2017. */
public class Rsa {

  Rsa() {}

  public BigInteger getPrime(int n) {
    Random rand = new Random();
    BigInteger prime;

    do {
      prime = probablePrime(n, rand);
    } while (!prime.isProbablePrime(100));

    return prime;
  }

  public BigInteger calculateN(BigInteger p, BigInteger q) {
    return q.multiply(p);
  }

  public BigInteger calculateR(BigInteger p, BigInteger q) {
    BigInteger r = new BigInteger("0");
    BigInteger x = new BigInteger("0");

    r = p.subtract(BigInteger.valueOf(1));
    x = q.subtract(BigInteger.valueOf(1));

    return r.multiply(x);
  }

  public int randOddNumber(int partition) {
    Random ranndNum = new Random();
    int randN;
    do {
      randN = (partition / 2) + (int) (ranndNum.nextFloat() * (partition / 2));
    } while ((randN % 10) % 2 != 1);

    return randN;
  }

  public BigInteger[] extendedEuclideanAlgorithm(BigInteger a, BigInteger b) {

    BigInteger[] ret = new BigInteger[3];

    BigInteger r0 = a;
    BigInteger s0 = new BigInteger("1");
    BigInteger t0 = new BigInteger("0");

    BigInteger r1 = b;
    BigInteger s1 = new BigInteger("0");
    BigInteger t1 = new BigInteger("1");

    BigInteger q = new BigInteger("0");

    BigInteger buff = new BigInteger("0");

    while (0 != r0.compareTo(BigInteger.ZERO)) {
      q = r1.divide(r0); //  374, 2, 1

      buff = r0; // buff = 5, buff = 2, buff = 1
      r0 = r1.subtract(q.multiply(r0)); // 1872 - 5*374 = 2, 5 - 2*2 = 1, 2 - 1*1 = 1
      r1 = buff; // r1 = 5, r1 = 2, r1 = 1

      buff = s0;
      s0 = s1.subtract(q.multiply(s0));
      s1 = buff;

      buff = t0;
      t0 = t1.subtract(q.multiply(t0));
      t1 = buff;
    }

    ret[0] = r1;
    ret[1] = t1;
    ret[2] = s1;

    return ret;
  }

  public BigInteger[] getCoprime(BigInteger a) {
    BigInteger[] coprime = new BigInteger[4];
    BigInteger[] eukEx;

    do {
      coprime[3] = BigInteger.valueOf(randOddNumber(10));
      eukEx = extendedEuclideanAlgorithm(coprime[3], a);

    } while (eukEx[0].compareTo(BigInteger.ONE) != 0);

      System.arraycopy(eukEx, 0, coprime, 0, 3);
    return coprime;
  }

  public BigInteger getMultiplicativeInverse(BigInteger r, BigInteger j) {
    BigInteger mulInv;

    if (j.signum() != 1 && j.signum() != 0) {
      do {
        j = j.add(r);
      } while (j.signum() == -1);

    }
    mulInv = j.mod(r);
    return mulInv;
  }

  public BigInteger decrypt(BigInteger x, BigInteger e, BigInteger n) {
    return x.modPow(e, n);
  }

  public BigInteger encrypt(BigInteger x, BigInteger d, BigInteger n) {
    return x.modPow(d, n);
  }
}
