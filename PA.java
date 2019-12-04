package PA;

import java.util.Scanner;

class PA {
    void print( int i, int f, int p ) {
        System.out.print( i + " " );
        if( i < f )
            print( i + p, f , p);
    }
   
    public static void main() {
        Scanner in = new Scanner(System.in);

        System.out.print(" \n Informe o ponto inicial da PA: ");
        int i = in.nextInt();

        System.out.print(" \n Informe o ponto final da PA: ");
        int f = in.nextInt();

        System.out.print(" \n Informe o passo da PA: ");
        int p = in.nextInt();

        System.out.println(" \n\n Sequência em PA: \n ");
       
        new PA().print( i, f, p );    
    }
}