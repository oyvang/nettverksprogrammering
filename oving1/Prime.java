package oving1;

/**
 * Created by GeirMorten on 27.01.14.
 */
public class Prime extends Thread {
    private int from, to, interval;

    public Prime (int from, int to, int interval){
        this.from = from;
        this.to = to;
        this.interval = interval;
    }

    boolean isPrime(int n) {
        if(n==2)return true;
        if (n%2==0 || n == 1) return false;  //Sjekker om det er delelig på 2
        for(int i=3;i*i<=n;i+=2) {    //vist ikke så sjekker vi alle oddetall fra 3 til sqrt(n);
            if(n%i==0)
                return false;
        }
        return true;
    }
    // kjører gjennom alle tall slik at alle tråder får sih like store tall å jobbe med
    public void run () {
        for (int i = from; i <=to ; i+= interval) {
        if(isPrime(i)) PrimeMain.addPrime(i);
        }
    }
}
