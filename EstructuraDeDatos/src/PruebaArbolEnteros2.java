import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PruebaArbolEnteros2 {
    public static void main(String[] args) {

        List<Integer> Lista = new ArrayList<>();
        for (int i = 0; i <= 128; i++) {
            Lista.add(i);
        }
        Collections.shuffle(Lista);


        ArbolBinarioDeBusquedaEnteros<Integer> Arbol2 = new ArbolBinarioDeBusquedaEnteros<>();

        for (int i = 0; i <= 128; i++) {
            int elemento = Lista.get(i);
            Arbol2.addNodo(elemento);

        }
        System.out.println("Suma " + Arbol2.getSuma() + "\n");

        int SumaPostorden2 = 0;
        List<Integer> ListaPostorden2 = Arbol2.getListapostOrden();
        for (int i = 0; i < ListaPostorden2.size(); i++) {
            int elemento = ListaPostorden2.get(i);
            SumaPostorden2 += elemento;
        }
        System.out.println("Suma Postorden " + SumaPostorden2 + "\n");
        int SumaPreorden2 = 0;
        List<Integer> ListaPreorden2 = Arbol2.getListapreOrden();
        for (int i = 0; i < ListaPreorden2.size(); i++) {
            int elemento = ListaPreorden2.get(i);
            SumaPreorden2 += elemento;
        }
        System.out.println("Suma Preorden " + SumaPreorden2 + "\n");
        int SumaOrdenCentral2 = 0;
        List<Integer> ListaOrdenCentral2 = Arbol2.getListaOrdenCentral();
        for (int i = 0; i < ListaOrdenCentral2.size(); i++) {
            int elemento = (int) ListaOrdenCentral2.get(i);
            SumaOrdenCentral2 += elemento;
        }
        System.out.println("Suma OrdenCentral " + SumaOrdenCentral2 + "\n");



        System.out.println("Arbol subIzq2: " + Arbol2.getSubArbolIzquierda().getListaOrdenCentral());
        System.out.println("Arbol subDer2: " + Arbol2.getSubArbolDerecha().getListaOrdenCentral());

        List<Integer> ListaSubIzq2 = Arbol2.getSubArbolIzquierda().getListaOrdenCentral();
        List<Integer> ListaSubDer2 = Arbol2.getSubArbolDerecha().getListaOrdenCentral();

        int SumaTotalArbol2 = 0;
        for (int i = 0; i < ListaSubIzq2.size(); i++) {
            int elemento = ListaSubIzq2.get(i);
            SumaTotalArbol2 += elemento;
        }
        for (int i = 0; i < ListaSubDer2.size(); i++) {
            int elemento = ListaSubDer2.get(i);
            SumaTotalArbol2 += elemento;
        }
        System.out.println("Suma Total Arbol " + SumaTotalArbol2 + "\n");

        System.out.println("Altura del arbol: " + Arbol2.getAltura() + "\n");
        System.out.println("Camino a 110: " + Arbol2.getCamino(110));

        List<Integer> ListaCamino110Arbol2 = Arbol2.getCamino(110);
        int longitudCamino2 = ListaCamino110Arbol2.size();
        System.out.println("Longitud del camino: " + longitudCamino2 );

    }

}
