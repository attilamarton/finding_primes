package com.company;

/*kéne írni egy alkalmazást, ami paraméterül számokat vár, és visszatérési értéknek visszaadja a számok közül a prímeket.
ehhez kéne unit tesztet is írni. mit szólsz ehhez kiindulásként? */

import java.io.*;
import java.util.Arrays;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        System.out.print("Gimme some numbers, gimme, gimme! ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NumbersIn = null;

        try {
            NumbersIn = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your numbers!");
            System.exit(1);
        }

        System.out.println("Workiing........");

        String[] StrArray = NumbersIn.split("\\s+");

        int i=0;
        int[] IntArray = new int[StrArray.length];
        while(i<StrArray.length) {
            try {
                IntArray[i] = Integer.parseInt(StrArray[i]);
            }
            catch(NumberFormatException nfe){

                //System.out.println("NaN!");
                IntArray[i] = 0;
            }
            i++;
        }

        //System.out.println(Arrays.toString(IntArray));
        int j = 0;
        int k;
        boolean ItsAPrime;
        int NofPrimes=0;
        int[] PrimeArray = new int[StrArray.length];
        while (j  < StrArray.length) {
            k=2;
            ItsAPrime = true;
            while (k <= IntArray[j]/2) {
                if (IntArray[j] % k == 0) {
                    k=99999;
                    ItsAPrime = false;
                }
                k++;
            }
            if (ItsAPrime) {
                if (IntArray[j] > 1) {
                    PrimeArray[NofPrimes] = IntArray[j];
                    NofPrimes++;
                    //System.out.println(IntArray[j]);

                }
            }
            j++;
        }
        if (NofPrimes == 0) {
            System.out.println("OOh Dios Mio, no he encontrado ningún números primos!");
        }
        else {
            System.out.println("No. of Primes I found is " + NofPrimes + "!");
            for (i = 0; i < NofPrimes; i++) {
                System.out.println(PrimeArray[i]);
            }
        }
    }

}
