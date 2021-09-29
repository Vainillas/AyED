package tp_primero;

public class NodoBinarioDeBusqueda {
	private Comparable dato;
	private NodoBinarioDeBusqueda hijoIzquierdo;
	private NodoBinarioDeBusqueda hijoDerecho;
	
	public NodoBinarioDeBusqueda(Comparable dato) {
		this.dato=dato;
		hijoIzquierdo=null;
		hijoDerecho=null;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Comparable dato) {
		this.dato=dato;
	}
	public NodoBinarioDeBusqueda getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public NodoBinarioDeBusqueda getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoizquierdo(NodoBinarioDeBusqueda unHijo) {
		hijoIzquierdo=unHijo;
	}
	public void setHijoDerecho(NodoBinarioDeBusqueda unHijo) {
		hijoDerecho=unHijo;
	}
	public boolean esHoja() {
		if(hijoIzquierdo==null && hijoDerecho==null)
			return true;
		else
			return false;
	}
}
