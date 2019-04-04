
package plecak_zachłanny;


public class Plecak_Zachłanny {

    static float[] wagi = {6, 2, 3, 2, 3, 1};
    static float[] wartosci = {6, 4, 5, 7, 10, 2};
    
    static float Pojemnosc, kasa;
    
    public static void main(String[] args) {
               
            wartosc();
        
            waga();
            
            stosunek();
    }

    public static void wartosc()
    {
        System.out.println("Strategia największej wartości");
        kasa = 0; Pojemnosc = 10;
        //Sortowanie wartości od największej do najmniejszej
        float z;
        for(int i = 0; i  < wartosci.length - 1 ; i++)
        {
            for(int j = 0; j < wartosci.length - 1; j++)
            {
                if(wartosci[j]  < wartosci[j+1])
                {
                    z = wartosci[j];
                    wartosci[j] = wartosci[j+1];
                    wartosci[j+1] = z;
                    
                    z = wagi[j];
                    wagi[j] = wagi[j+1];
                    wagi[j+1] = z;
                }
            }
        }
        //Wybieranie elementów
        
        for(int i = 0; i < wartosci.length; i++) // wyświetlanie po sortowaniu
        {
            System.out.println(wartosci[i] + " " + wagi[i]);
        }
        
        for(int i = 0; i < wartosci.length; i++)
        {
            if(Pojemnosc - wagi[i] >= 0)
            {
                Pojemnosc -= wagi[i];
                kasa += wartosci[i];
            }
        }
        
        System.out.println("Zostało nam miejsca : " + Pojemnosc + " Zrabowano przedmioty o wartosci : " + kasa);
    }
    public static void waga()
    {
        System.out.println("Strategia najmniejszej wagi");
        kasa = 0; Pojemnosc = 10;
        //sortowanie od najmniejszej wagi do największej
        float z;
        for(int i = 0; i  < wagi.length - 1 ; i++)
        {
            for(int j = 0; j < wagi.length - 1; j++)
            {
                if(wagi[j]  > wagi[j+1])
                {
                    z = wartosci[j];
                    wartosci[j] = wartosci[j+1];
                    wartosci[j+1] = z;
                    
                    z = wagi[j];
                    wagi[j] = wagi[j+1];
                    wagi[j+1] = z;
                }
            }
        }
        //Wybieranie elementów
        
        for(int i = 0; i < wartosci.length; i++) // wyświetlanie po sortowaniu
        {
            System.out.println(wartosci[i] + " " + wagi[i]);
        }
        
        for(int i = 0; i < wagi.length; i++)
        {
            if(Pojemnosc - wagi[i] >= 0)
            {
                Pojemnosc -= wagi[i];
                kasa += wartosci[i];
            }
        }
        
        System.out.println("Zostało nam miejsca : " + Pojemnosc + " Zrabowano przedmioty o wartosci : " + kasa);
    }
    
    public static void stosunek()
    {
        System.out.println("Strategia stosunku wartości do wagi");
        kasa = 0; Pojemnosc = 10;
        float[] stosunki = new float[wagi.length];
        
        for(int i = 0; i < stosunki.length; i++)
        {
            stosunki[i] = wartosci[i] / wagi[i];
        }
        //sortowanie od największego
        float z;
        for(int i = 0; i  < stosunki.length - 1 ; i++)
        {
            for(int j = 0; j < stosunki.length - 1; j++)
            {
                if(stosunki[j] < stosunki[j+1])
                {
                    z = stosunki[j];
                    stosunki[j] = stosunki[j+1];
                    stosunki[j+1] = z;
                    
                    z = wartosci[j];
                    wartosci[j] = wartosci[j+1];
                    wartosci[j+1] = z;
                    
                    z = wagi[j];
                    wagi[j] = wagi[j+1];
                    wagi[j+1] = z;
                    
                }
            }
        }
        for(int i = 0; i < stosunki.length; i++) // wyświetlanie po sortowaniu
        {
            System.out.println(stosunki[i] + " " + wartosci[i] + " " + wagi[i]);
        }
        
        for(int i = 0; i < stosunki.length; i++) 
        {
            if(Pojemnosc - wagi[i] >= 0)
            {
                Pojemnosc -= wagi[i];
                kasa += wartosci[i];
            }
        }
        System.out.println("Zostało nam miejsca : " + Pojemnosc + " Zrabowano przedmioty o wartosci : " + kasa);
    }
    
}
