package tp_primero;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		         ArbolBinario miArbolA=new ArbolBinario("A");
		         ArbolBinario miArbolB=new ArbolBinario("B");
		         ArbolBinario miArbolC=new ArbolBinario("C");
		         ArbolBinario miArbolD=new ArbolBinario("D");
		         ArbolBinario miArbolE=new ArbolBinario("E");
		         ArbolBinario miArbolF=new ArbolBinario("F");
		         ArbolBinario miArbolG=new ArbolBinario("G");
		         ArbolBinario miArbolH=new ArbolBinario("H");
		         ArbolBinario miArbolI=new ArbolBinario("I");

		         miArbolA.agregarHijoIzquierdo(miArbolB);
		         miArbolA.agregarHijoDerecho(miArbolC);

		         miArbolB.agregarHijoIzquierdo(miArbolD);
		         miArbolB.agregarHijoDerecho(miArbolE);

		         miArbolC.agregarHijoIzquierdo(miArbolF);
		         miArbolC.agregarHijoDerecho(miArbolG);

		         miArbolG.agregarHijoIzquierdo(miArbolH);
		         miArbolG.agregarHijoDerecho(miArbolI);
		         System.out.println("\nImpresi�n INORDEN");
		         miArbolA.imprimirInOrden();
		         System.out.println("\nImpresi�n PREORDEN");
		         miArbolA.imprimirPreOrden();
		         System.out.println("\nImpresi�n POSTORDEN");
		         miArbolA.imprimirPostOrden();
		         System.out.println("\nImpresi�n POR NIVELES");
		         miArbolA.imprimirNiveles();
		         System.out.println("\nFRONTERA");
		         ArrayList<Object>listaHojas=new ArrayList<>();
		         listaHojas=miArbolA.frontera();
		         System.out.println(listaHojas);
		         System.out.println("\nImpresi�n INORDEN ESPEJO");
		         ArbolBinario miArbolAEspejo=miArbolA.espejo();
		         miArbolAEspejo.imprimirInOrden();
		         if(miArbolA.lleno())
		        	 System.out.println("\nEl arbol A est� lleno");
		         else
		        	 System.out.println("\nEl arbol A no est� lleno");
		         if(miArbolA.completo())
		        	 System.out.println("\nEl arbol A est� completo");
		         else
		        	 System.out.println("\nEl arbol A no est� completo");

		         

		     }
	

}
