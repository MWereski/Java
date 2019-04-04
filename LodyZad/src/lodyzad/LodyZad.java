
package lodyzad;


public class LodyZad {

    final static int R = 6;
    private static int[] l = new int[R];
    private static int[] bestCombo = new int[R];
    
    static int bestTime = 1000;

    public static void main(String[] args) {
      
        int[][] tab = {
             {0, 7, 20, 21, 12, 23},
             {27, 0, 13, 16, 46, 5},
             {53, 15, 0, 25, 27, 6},
             {16, 2, 35, 0, 47, 10},
             {31, 29, 5, 18, 0, 4},
             {28, 24, 1, 17, 5, 0}};
        
        permutacje(0, tab);
        for(int j = 0; j < R; j++)
                     {
                        System.out.print(bestCombo[j] + " ");
                     }
        
        System.out.print("Czas : " + bestTime);
        System.out.println();
       
    }
    
    public static void permutacje(int i, int tab[][])
    {
        if(i == R)
        {
            int suma = 0;
            for(int j = 1; j < R; j++)
            {
                //System.out.print(tab[l[j-1]-1][l[j]-1] + " ");
                suma += tab[l[j-1]-1][l[j]-1];
            }
            suma += tab[l[5]-1][l[0]-1];
            if(suma < bestTime)
            {
                System.arraycopy(l, 0, bestCombo, 0, R);
                bestTime = suma;
            }
            else if(suma == bestTime)
            {
                
                for(int j = 0; j < R; j++)
                     {
                        System.out.print(l[j] + " ");
                     }
                System.out.println("Czas : " + suma);
            }
            //System.out.println(suma);
        }else
        {
            for(int j = 1; j <= R; j++)
            {
                int k;
                for(k = 0; k < i; k++)
                {
                    if(l[k] == j)
                    {
                        break;
                    }
                }
                if(k == i)
                {
                    l[k] = j;
                    permutacje(i+1, tab);
                }
            }
        }
    }  
}
