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
        int to = 10000;
        int threads = 4;
        ArrayList<Prime> p = new ArrayList<>();

        for (int i = threads; i >0; i--) {
            p.add(new Prime(from, to/i));
            from = (to/i) +1;
        }

//        Prime p1 = new Prime(from, to/4);
//        Prime p2 = new Prime(to/4+1, to/3);
//        Prime p3 = new Prime(to/3+1, to/2);
//        Prime p4 = new Prime(to/2+1, to);
        for (int i = 0; i <threads ; i++) {
            p.get(i).start();
        }
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();

        try{
            for (int i = 0; i <threads; i++) {
                p.get(i).join();
            }
//            p1.join();
//            p2.join();
//            p3.join();
//            p4.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted\n"+e);
        }

//        System.out.println("Prime numbers from " + from + " to " + to);
//        soutPrimes();

        System.out.println(primeNumbers.size());
    }
}
