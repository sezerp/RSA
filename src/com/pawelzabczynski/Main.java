package com.pawelzabczynski;

public class Main {

    public static void main(String[] args) {

        Rsa w = new Rsa(512);

        System.out.println(w.getP());
        System.out.println(w.getQ());


    }
}
