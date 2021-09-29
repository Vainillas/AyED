package tp_primero;

public class ArbolBinarioDeBusqueda {
	private NodoBinarioDeBusqueda raiz;
	public ArbolBinarioDeBusqueda() {
		raiz = null;
	}
	public ArbolBinarioDeBusqueda(Comparable dato) {
		raiz = new NodoBinarioDeBusqueda(dato);
	}
	private ArbolBinarioDeBusqueda(NodoBinarioDeBusqueda nodo) {
		raiz = nodo;
	}
	private NodoBinarioDeBusqueda getRaiz() {
		return raiz;
	}
	public Object getDatoRaiz() {
		if(getRaiz()!=null) {
			return getRaiz().getDato();
		}
		else
			return null;
	}
	public ArbolBinarioDeBusqueda getHijoIzquierdo() {
		if(this.getRaiz()!=null) {
			if(this.getRaiz().getHijoIzquierdo()!=null)
				return new ArbolBinarioDeBusqueda(getRaiz().getHijoIzquierdo());	
			else return new ArbolBinarioDeBusqueda();
		}
		else return new ArbolBinarioDeBusqueda();
	}
	public ArbolBinarioDeBusqueda getHijoDerecho() {
		if(this.getRaiz()!=null) {
			if(this.getRaiz().getHijoDerecho()!=null)
				return new ArbolBinarioDeBusqueda(getRaiz().getHijoDerecho());	
			else return new ArbolBinarioDeBusqueda();
		}
		else return new ArbolBinarioDeBusqueda();
	}
	public boolean incluye(Comparable dato) {
		if(this.getRaiz()==null) {
			return false;
		}
		else if (this.getDatoRaiz()==dato) {
			return true;
		}
		else if(dato.compareTo(this.getDatoRaiz())>0) {
			return this.getHijoDerecho().incluye(dato);
		}
		else {
			return this.getHijoIzquierdo().incluye(dato);
		}
	}
	public void agregar(Comparable dato) {
		if(this.incluye(dato)==false) {
			if(this.getRaiz()==null) {
				this.getRaiz().setDato(dato);
			}
			else if(dato.compareTo(this.getDatoRaiz())>0) {
				this.getHijoDerecho().agregar(dato);
			}
			else
				this.getHijoIzquierdo().agregar(dato);
		}
		else
			System.out.println("\nEste dato ya existe en el árbol.");
	}
	public void eliminar(Comparable dato) {//Implementar
		if(this.incluye(dato)==true) {
		}
		else
			System.out.println("\nEste dato no existe en el árbol.");
	}
}
