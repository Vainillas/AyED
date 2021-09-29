package tp_primero;

public class NodoBinario {
	private Object dato;
	private NodoBinario hijoIzquierdo;
	private NodoBinario hijoDerecho;
	private String color;
	
	public NodoBinario(Object dato) {
		this.dato=dato;
		hijoIzquierdo=null;
		hijoDerecho=null;
		this.color="";
	}
	public Object getDato() {
		return dato;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public NodoBinario getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public NodoBinario getHijoDerecho() {
		return hijoDerecho;
	}
	public void setDato(Object dato) {
		this.dato=dato;
	}
	public void setHijoIzquierdo(NodoBinario unHijo) {
		this.hijoIzquierdo=unHijo;
	}
	public void setHijoDerecho(NodoBinario unHijo) {
		this.hijoDerecho=unHijo;
	}
}
