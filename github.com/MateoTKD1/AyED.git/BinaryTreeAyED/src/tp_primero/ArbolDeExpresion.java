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
	private NodoBinario getRaiz() {
		return this.raiz;
	}
	public ArbolBinario getHijoIzquierdo() {
		if(this.getRaiz()!=null) {
			if(this.getRaiz().getHijoIzquierdo()!=null)
				return new ArbolBinario(getRaiz().getHijoIzquierdo());	
			else return new ArbolBinario();
		}
		else return new ArbolBinario();
	}
	public ArbolBinario getHijoDerecho() {
		if(this.getRaiz()!=null) {
			if(this.getRaiz().getHijoDerecho()!=null)
				return new ArbolBinario(getRaiz().getHijoDerecho());	
			else return new ArbolBinario();
		}
		else return new ArbolBinario();
	}
	
	public void imprimirInOrden() {
		if(getRaiz()==null) {
			return;
		}
		this.getHijoIzquierdo().imprimirInOrden();
		System.out.print(" " +this.getDatoRaiz()+ " ");
		this.getHijoDerecho().imprimirInOrden();
	}
	public Object getDatoRaiz() {
		return getRaiz().getDato();
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
