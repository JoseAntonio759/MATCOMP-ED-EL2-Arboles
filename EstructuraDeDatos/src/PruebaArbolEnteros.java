public class PruebaArbolEnteros {
    public static void main(String[] args) {

        ArbolBinarioDeBusquedaEnteros<Integer> arbol = new ArbolBinarioDeBusquedaEnteros<>();
        for (int i = 0; i <= 128; i++){
            arbol.addNodo(i);
        }
        System.out.println("Suma del arbol: " + arbol.getSuma());


    }
}