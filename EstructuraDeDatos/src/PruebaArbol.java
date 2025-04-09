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

        System.out.println(arbol.getRaiz() + "\n");

        System.out.println("Grado del árbol: " + arbol.getGrado()  + "\n");

        System.out.println("Altura del árbol: " + arbol.getAltura() + "\n");

        int nivel = 1;
        System.out.println("Valores en el nivel " + nivel + ": " + arbol.getListaDatosNivel(nivel) + "\n");

        System.out.println("¿El árbol es homogéneo? " + arbol.isArbolHomogeneo() + "\n");

        System.out.println("¿El árbol es completo? " + arbol.isArbolCompleto() + "\n");

        System.out.println("¿El árbol es casi completo? " + arbol.isArbolCasiCompleto() + "\n");


        System.out.println("Subárbol izquierdo en orden:" + arbol.getSubArbolIzquierda().getListaOrdenCentral() + "\n");

        System.out.println("Subárbol derecho en orden:" + arbol.getSubArbolDerecha().getListaOrdenCentral() + "\n");

        System.out.println("Camino: " + arbol.getCamino(11));
        System.out.println("Camino: " + arbol.getCamino(12) + "\n");



        ArbolBinarioDeBusqueda<Integer> arbol2 = new ArbolBinarioDeBusqueda<>();
        arbol2.addNodo(10);
        arbol2.addNodo(5);
        arbol2.addNodo(15);
        arbol2.addNodo(3);
        arbol2.addNodo(17);
        System.out.println("¿arbol 2 casi completo? " + arbol2.isArbolCasiCompleto() + "\n");

        ArbolBinarioDeBusqueda<Integer> arbol3 = new ArbolBinarioDeBusqueda<>();
        arbol3.addNodo(10);
        arbol3.addNodo(5);
        arbol3.addNodo(15);
        arbol3.addNodo(3);
        System.out.println("¿arbol 3 casi completo?" + arbol3.isArbolCasiCompleto() + "\n");


        System.out.println("arbol en preorden: " + arbol.getListapreOrden());
        System.out.println("arbol en orden Central: " + arbol.getListaOrdenCentral());
        System.out.println("arbol en postosrden: " + arbol.getListapostOrden());


    }
}