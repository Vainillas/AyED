package tp_primero;

public class TestConversion {

	public static void main(String[] args) {
		ArbolDeExpresion arbolito = new ArbolDeExpresion();
		arbolito = ArbolDeExpresion.convertirPostfija("ab+cd-*ef+/");
		System.out.println("\nImpresión INORDEN de Expresión Postfija");
		arbolito.imprimirInOrden();
	}

}
