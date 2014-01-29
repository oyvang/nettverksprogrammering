package oving1;

/**
 * Created by GeirMorten on 27.01.14.
 */
public class Prime extends Thread {
    private int from, to;

    public Prime (int from, int to){
        this.from = from;
        this.to = to;
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

    public void run () {
        for (int i = from; i <=to ; i++) {
        if(isPrime(i)) PrimeMain.addPrime(i);
        }
    }
}
