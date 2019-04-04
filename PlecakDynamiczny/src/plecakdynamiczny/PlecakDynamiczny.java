
package plecakdynamiczny;

import static java.lang.Integer.max;

public class PlecakDynamiczny {
    
    final static int N = 6;
    final static int MAX_V = 10;
    final static int[] V = {6, 2, 3, 2, 3, 1};
    final static int[] W = {6, 4, 5, 7, 10, 2}; 
    final static int[][] D = new int[N+1][MAX_V+1];
    
    static int plecak()
    {
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= MAX_V; j++)
            {
                if(V[i-1] > j)
                {
                    D[i][j] = D[i-1][j];
                }
                else
                {
                    D[i][j] = max(D[i-1][j], W[i-1]+ D[i-1][j-V[i-1]]);
                }
            }
        } 
        return D[N][MAX_V];
    }
    
    public static void main(String[] args) {
        System.out.println("Maksymalna Wartość : " +  plecak());
        for(int i = 0; i <= N; i++)
        {
            for(int j = 0; j <= MAX_V; j++)
            {
                System.out.print(D[i][j] + " ");
            }
            System.out.println("");
        }
      
    }
}
