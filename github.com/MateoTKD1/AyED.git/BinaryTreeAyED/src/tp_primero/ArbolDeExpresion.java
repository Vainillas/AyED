package tp_primero;

import java.util.ArrayList;

public class ArbolDeExpresion extends ArbolBinario { //Acá hay algún problema con la herencia
	private NodoBinario raiz;
	
	public ArbolDeExpresion() {
		this.raiz=null;
	}

	public ArbolDeExpresion(Object dato) {
		super(dato);
	}
	private ArbolDeExpresion(NodoBinario nodo) {
		this.raiz=nodo;
	}
	static public ArbolDeExpresion convertirPostfija(String exp) {
		ArrayList<NodoBinario>pila = new ArrayList<>();
		for(int i=0; i<exp.length();i++) {
			char caracter = exp.charAt(i);
			if(caracter=='%' || caracter=='/' || caracter=='*' || caracter=='^' || caracter=='-' || caracter=='+') {
				NodoBinario nodo = new NodoBinario(caracter);
				nodo.setHijoDerecho(pila.get(pila.size()-1));
				pila.remove(pila.size()-1);
				nodo.setHijoIzquierdo(pila.get(pila.size()-1));
				pila.remove(pila.size()-1);
				pila.add(nodo);
			}
			else {
				NodoBinario nodo = new NodoBinario(caracter);
				pila.add(nodo);
			}
		}
		ArbolDeExpresion arbolExpresion = new ArbolDeExpresion(pila.get(pila.size()-1));
		return arbolExpresion;
	}

}
