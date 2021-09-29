package tp_primero;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
	private NodoBinario raiz;
	private ArrayList<Object> listaHojas = new ArrayList<Object>();
	
	public ArbolBinario() {
		this.raiz=null;
	}
	public ArbolBinario(Object dato) {
		this.raiz = new NodoBinario(dato);
	}
	ArbolBinario(NodoBinario nodo) {
		raiz=nodo;
	}
	private NodoBinario getRaiz() {
		return this.raiz;
	}
	public Object getDatoRaiz() {
		return getRaiz().getDato();
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
	
	public void agregarHijoIzquierdo(ArbolBinario unHijo) {
		this.getRaiz().setHijoIzquierdo(unHijo.getRaiz());
	}
	public void agregarHijoDerecho(ArbolBinario unHijo) {
		this.getRaiz().setHijoDerecho(unHijo.getRaiz());
	}
	public void eliminarHijoIzquierdo() {
		this.getRaiz().setHijoDerecho(null);
	}
	public void eliminarHijoDerecho() {
		this.getRaiz().setHijoDerecho(null);
	}
	public int getAltura() {
		if(this.getRaiz()==null) {
			return 0;
		}
		else {
			int alturaIzq=this.getHijoIzquierdo().getAltura();
			int alturaDer=this.getHijoDerecho().getAltura();
		
			if(alturaIzq>alturaDer) {
				return(alturaIzq+1);
			}
			else {
				return(alturaDer+1);
			}
		}
	}
	
	
	
	
	
	public void imprimirInOrden() {
		if(getRaiz()==null) {
			return;
		}
		this.getHijoIzquierdo().imprimirInOrden();
		System.out.print(" " +this.getDatoRaiz()+ " ");
		this.getHijoDerecho().imprimirInOrden();
	}
	public void imprimirPreOrden() {
		if(this.getRaiz()==null) {
			return;
		}
		System.out.print(" " +this.getDatoRaiz()+ " ");
		this.getHijoIzquierdo().imprimirPreOrden();
		this.getHijoDerecho().imprimirPreOrden();
	}
	public void imprimirPostOrden() {
		if(this.getRaiz()==null) {
			return;
		}
		this.getHijoIzquierdo().imprimirPostOrden();
		this.getHijoDerecho().imprimirPostOrden();
		System.out.print(" " +this.getDatoRaiz()+ " ");
	}
	public void imprimirNiveles() { //Implementar
		int altura=this.getAltura();
		for(int i=1;i<=altura;i++) {
			imprimirNivel(this,i);
		}
	}
	private void imprimirNivel(ArbolBinario arbolBinario, int nivel) {
		if(arbolBinario.getRaiz()==null)
			return;
		if(nivel==1)
			System.out.print(" "+arbolBinario.getDatoRaiz()+" ");
		else if(nivel>1) {
			imprimirNivel(arbolBinario.getHijoIzquierdo(),nivel-1);
			imprimirNivel(arbolBinario.getHijoDerecho(),nivel-1);
		}
	}
	public ArrayList<Object> frontera(){
		if(this.getRaiz()!=null) {
			if(this.getRaiz().getHijoDerecho()==null && this.getRaiz().getHijoIzquierdo()==null) {
				listaHojas.add(this.getRaiz().getDato());
			}
			else {
				listaHojas.add(this.getHijoIzquierdo().frontera());
				listaHojas.add(this.getHijoDerecho().frontera());
			}
		}
		return listaHojas;
	}
	public ArbolBinario espejo() { //Implementar
		if(this.getRaiz()==null) {
			return null;
		}
		ArbolBinario nuevo = new ArbolBinario(this.getRaiz());
		ArbolBinario der = this.getHijoDerecho();
		ArbolBinario izq = this.getHijoIzquierdo();
		if(der.getRaiz()!=null)
			nuevo.agregarHijoIzquierdo(der.espejo());
		else
			nuevo.agregarHijoIzquierdo(new ArbolBinario());
		if(izq.getRaiz()!=null)	
			nuevo.agregarHijoDerecho(izq.espejo());
		else
			nuevo.agregarHijoDerecho(new ArbolBinario());
		return nuevo;
	}
	public boolean lleno() {
		if(this.getRaiz()==null) {
			return true;
		}
		if(this.getHijoIzquierdo().getRaiz()==null && this.getHijoDerecho().getRaiz()==null) {
			return true;
		}
		if(this.getHijoIzquierdo().getRaiz()!=null && this.getHijoDerecho().getRaiz()!=null) {
			return(this.getHijoIzquierdo().lleno() && this.getHijoDerecho().lleno());
		}
		return false;
	}
	public int cantidadNodos() {
		if(this.getRaiz()==null)
			return 0;
		else
			return(1 + this.getHijoIzquierdo().cantidadNodos() + this.getHijoDerecho().cantidadNodos());
	}
	
	public boolean completo() {
		int i=0;
		int cantNodos=this.cantidadNodos();
		return(this.esCompleto(i,cantNodos));
	}
	private boolean esCompleto(int indice, int cantNodos) {
		if(this.getRaiz()==null) {
			return true;
		}
		if(indice>=cantNodos) {
			return false;
		}
		return(this.getHijoIzquierdo().esCompleto(2 * indice + 1, cantNodos) && this.getHijoDerecho().esCompleto(2 * indice + 2, cantNodos));
	}
	public int trayectoriaPesada() {
		int nivel=0;
		return this.sumaTrayectoria(nivel);
	}
	private int sumaTrayectoria(int nivel) {
		if(this.getRaiz()==null) {
			return 0;
		}
		int resultado = 0;
		//resultado=nivel * this.getDatoRaiz();
		return(resultado + this.getHijoIzquierdo().sumaTrayectoria(nivel+1) + this.getHijoDerecho().sumaTrayectoria(nivel+1));
	}
	
}

