
package plecak_monte_carlo;

import java.util.Random;

public class Plecak_Monte_Carlo {


    static int[] wartosci = {6, 4, 5, 7, 10, 2};
    static int[] wagi = {6, 2, 3, 2, 3, 1};
    static boolean[] czy_wzienty = {false, false, false, false, false, false};
    static int ilosc_losowan = 10;
    static int proby = 10;
    static int best_wartosc = 0;
    static int pojemnosc = 10;
            
    public static void main(String[] args) {
        
        Random r = new Random();
            for(int i = 0; i < proby; i++)
            {
                int j = 0;
                int wartosc = 0;
                while(j < ilosc_losowan)
                {
                    int los = r.nextInt(czy_wzienty.length);
                    if(pojemnosc - wagi[los] >= 0 && czy_wzienty[los] == false)
                    {
                        pojemnosc -= wagi[los];
                        wartosc += wartosci[los];
                        czy_wzienty[los] = true;
                    }
                    j++;
                }
                System.out.println("Uzyskana wartosc : " + wartosc + " Pozostało pojemności : " + pojemnosc);
                if(best_wartosc < wartosc)
                {
                    best_wartosc = wartosc;
                }
                System.out.println("Wzięte przedmioty");
                for(int k = 0; k < czy_wzienty.length; k++)
                {
                    System.out.print(czy_wzienty[k] + " ");
                }
                System.out.println("");
                
                
                for(int k = 0; k < czy_wzienty.length; k++)
                {
                    czy_wzienty[k] = false;
                }
                pojemnosc = 10;
            }
            
            System.out.println("Najlepsza uzyskana wartość skradzionych przedmiotów : " + best_wartosc );
    }
    
}
