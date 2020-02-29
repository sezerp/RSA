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
    for (int i = 0; i < 4; i++) System.out.println("e[" + i + "]: " + e[i]);
    BigInteger d = w.getMultiplicativeInverse(r, e[2]);
    System.out.println("d: " + d);

    BigInteger valueToEncrypted = BigInteger.valueOf(122345);

    BigInteger encryptedValue = w.encrypt(valueToEncrypted, e[3], n);
    System.out.println("Value to encrypted: " + valueToEncrypted);
    System.out.println("Encrypted value key: " + encryptedValue);
    BigInteger decryptedValue = w.decrypt(encryptedValue, d, n);
    System.out.println("Decrypted value: " + decryptedValue);
  }
}
