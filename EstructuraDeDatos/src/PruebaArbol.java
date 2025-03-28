import java.util.List;


public class PruebaArbol {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        arbol.addNodo(10);
        arbol.addNodo(5);
        arbol.addNodo(15);
        arbol.addNodo(3);
        arbol.addNodo(7);
        arbol.addNodo(12);
        arbol.addNodo(18);


        arbol.imprimirEnOrden();
        System.out.println();

        int altura = arbol.getAltura();
        System.out.println("Altura del árbol: " + altura);

        int nivel = 1;
        List<Integer> valoresNivel = arbol.getListaDatosNivel(nivel);
        System.out.println("Valores en el nivel " + nivel + ": " + valoresNivel);

        System.out.println("¿El árbol es homogéneo? " + arbol.isArbolHomogeneo());

        System.out.println("¿El árbol es completo? " + arbol.isArbolCompleto());

        System.out.println("Suma de los valores del árbol: " + arbol.getSuma());

        ArbolBinarioDeBusqueda<Integer> subArbolIzquierdo = arbol.getSubArbolIzquierda();
        System.out.println("Subárbol izquierdo en orden:");
        subArbolIzquierdo.imprimirEnOrden();
        System.out.println();

        ArbolBinarioDeBusqueda<Integer> subArbolDerecho = arbol.getSubArbolDerecha();
        System.out.println("Subárbol derecho en orden:");
        subArbolDerecho.imprimirEnOrden();
        System.out.println();

        System.out.println("Grado del árbol: " + arbol.getGrado());
        System.out.println("Camino:" + arbol.getCamino(11));




    }

}
