package oving1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by GeirMorten on 27.01.14.
 */
public class PrimeMain {
    private static List<Integer> primeNumbers = new ArrayList();

    public static synchronized void addPrime(int n){
        primeNumbers.add(n);
    }

    private static List<Integer> getPrimes(){
        Collections.sort(primeNumbers);
        return primeNumbers;
    }

    private static void soutPrimes(){
      for(Integer n : getPrimes()){
          System.out.println(n);
        }
    }
    public static void main(String[] args) {
        int from = 1;
        int to = 10000000;
        int threads = 4;
        ArrayList<Prime> p = new ArrayList<>();

        // Fordeler arbeid og oppretter tråder
        for (int i = 0; i <threads; i++) {
            p.add(new Prime(from, to, threads));
            p.get(i).start();
            from++;
        }
//        //starter trådan
//        for (int i = 0; i <threads ; i++) {
//            p.get(i).start();
//        }
        //Fortsetter etter at alle tråder er ferdig
        try{
            for (int i = 0; i <threads; i++) {
                p.get(i).join();
            }

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted\n"+e);
        }

        System.out.println("Prime numbers from " + from + " to " + to);
        soutPrimes();

        System.out.println("\nAntall primtall: "+primeNumbers.size());
    }
}
