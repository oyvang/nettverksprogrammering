package oving2.oppgave1;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.ParseException;
import static javax.swing.JOptionPane.*;


/**
 * Created by GeirMorten on 26.02.14.
 */
public class Client {
    public static void main(String[] args){

        String theProblem = "";
        Calculator calculate = new Calculator();
        while (theProblem != null) {
            theProblem = showInputDialog(null,
                    "Skriv inn et enkelt regnestykke,\n mellomrom mellom hver operator:eks (5 + 5)",
                    "proCalc",
                    QUESTION_MESSAGE);

            try {
                showMessageDialog(null, "Beregner " + theProblem + "\nresultat: \n" + calculate.Calculate(theProblem));
            } catch (ParseException pe) {
                showMessageDialog(null, pe.getMessage());
            } catch (NullPointerException npe) {
                showMessageDialog(null, "Takk for besøket! :)");
            }
        }
    }
}
