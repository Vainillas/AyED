package tp_primero;

public class ArbolBinario {
	private NodoBinario raiz;
	
	public ArbolBinario() {
		this.raiz=null;
	}
	public ArbolBinario(Object dato) {
		NodoBinario raiz = new NodoBinario(dato);
		new ArbolBinario(raiz);
	}
	private ArbolBinario(NodoBinario nodo) {
		raiz=nodo;
	}
	private NodoBinario getRaiz() {
		return raiz;
	}
	public Object getDatoRaiz() {
		return raiz.getDato();
	}
	public ArbolBinario getHijoIzquierdo() {
		return new ArbolBinario(raiz.getHijoIzquierdo());
	}
	public ArbolBinario getHijoDerecho() {
		return new ArbolBinario(raiz.getHijoDerecho());	}
	
	public void agregarHijoIzquierdo(ArbolBinario unHijo) {
		
	}
	public void agregarHijoDerecho(ArbolBinario unHijo) {
		
	}
	public void eliminarHijoIzquierdo() {
		
	}
	public void eliminarHijoDerecho() {
		
	}
}
