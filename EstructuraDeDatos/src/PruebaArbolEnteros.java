import java.util.ArrayList;
import java.util.List;



public class PruebaArbolEnteros {
    public static void main(String[] args) {

        ArbolBinarioDeBusquedaEnteros<Integer> Arbol = new ArbolBinarioDeBusquedaEnteros<>();
        for (int i = 0; i <= 128; i++){
            Arbol.addNodo(i);
        }
        System.out.println("Suma: " + Arbol.getSuma() + "\n");
        int sumaPostorden = 0;
        List<Integer> ListaPostorden = Arbol.getListapostOrden();
        for (int i = 0; i < ListaPostorden.size(); i++) {
            int elemento = ListaPostorden.get(i);
            sumaPostorden += elemento;
        }
        System.out.println("Suma Postorden: " + sumaPostorden + "\n");

        int sumaPreorden = 0;
        List<Integer> ListaPreorden = Arbol.getListapreOrden();
        for (int i = 0; i < ListaPreorden.size(); i++) {
            int elemento = ListaPreorden.get(i);
            sumaPreorden += elemento;
        }
        System.out.println("Suma Preorden: " + sumaPreorden + "\n");

        int SumaOrdenCentral = 0;
        List<Integer> ListaOrdenCentral = Arbol.getListaOrdenCentral();
        for (int i = 0; i < ListaOrdenCentral.size(); i++) {
            int elemento = ListaOrdenCentral.get(i);
            SumaOrdenCentral += elemento;
        }
        System.out.println("Suma OrdenCentral: " + SumaOrdenCentral + "\n");



        System.out.println("Arbol subIzq: " + Arbol.getSubArbolIzquierda().getListaOrdenCentral());
        System.out.println("Arbol subDer: " + Arbol.getSubArbolDerecha().getListaOrdenCentral());

        List<Integer> ListaSubIzq = Arbol.getSubArbolIzquierda().getListaOrdenCentral();
        List<Integer> ListaSubDer = Arbol.getSubArbolDerecha().getListaOrdenCentral();

        int SumaTotalArbol = 0;
        for (int i = 0; i < ListaSubIzq.size(); i++) {
            int elemento = ListaSubIzq.get(i);
            SumaTotalArbol += elemento;
        }
        for (int i = 0; i < ListaSubDer.size(); i++) {
            int elemento = ListaSubDer.get(i);
            SumaTotalArbol += elemento;
        }
        System.out.println("Suma Total de sub arboles derecho e izquierdo: " + SumaTotalArbol + "\n");


        System.out.println("Altura del arbol: " + Arbol.getAltura() + "\n");

        System.out.println("Camino a 110: " + Arbol.getCamino(110));

        List<Integer> ListaCamino110 = Arbol.getCamino(110);
        int longitudCamino = ListaCamino110.size();
        System.out.println("Longitud del camino: " + longitudCamino + "\n");



    }
}