/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Figuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IFigura[] figuras=new IFigura[3];
        Scanner sc=new Scanner(System.in); 
        System.out.println("Introduzca el lado del cuadrado");
        int lado=sc.nextInt();
        figuras[0]=new Cuadrado(lado);
        System.out.println("Introduzca la base del triangulo ");
        int base=sc.nextInt();
        System.out.println("Introduzca la altura del triangulo ");
        int altura=sc.nextInt();
        figuras[1]=new Triangulo(base,altura);
        System.out.println("Introduzca el radio del circulo ");
        int radio=sc.nextInt();
        figuras[2]=new Circulo(radio);
        int perimetroTotal=0;
        for (IFigura figura:figuras)
        {
            perimetroTotal+=figura.perimetro();
        }
        System.out.println("el Total de las figuras Perimetro es"+perimetroTotal);
        
        
        
    }
    
}
