public class ArbolBinarioDeBusquedaEnteros <T> extends ArbolBinarioDeBusqueda<Integer> {

    private int grado;
    private Nodo<T> raiz;



    public ArbolBinarioDeBusquedaEnteros() {
        this.raiz = null;
        this.grado = 2;
    }
    public int getSuma() {

        return getSumaRecursiva(getRaiz());
    }

    private int getSumaRecursiva(Nodo<Integer> nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.valor + getSumaRecursiva(nodo.menor) + getSumaRecursiva(nodo.mayor);
    }



}
