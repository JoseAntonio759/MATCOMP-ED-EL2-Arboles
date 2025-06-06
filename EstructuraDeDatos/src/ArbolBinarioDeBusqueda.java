import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioDeBusqueda<T> {
    private int grado = 2;
    private Nodo<T> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    public int getGrado() {
        return grado;
    }


    public int getAltura() {
        return getAlturaRecursivo(raiz);
    }


    private int getAlturaRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierdo = getAlturaRecursivo(nodo.menor);
        int alturaDerecha = getAlturaRecursivo(nodo.mayor);
        if (alturaIzquierdo > alturaDerecha) {
            return alturaIzquierdo + 1;
        }
        return alturaDerecha + 1;
    }

    public List<T> getListaDatosNivel(int nivel) {
        List<T> lista = new ArrayList<>();
        getListaDatosNivelRecursivo(raiz, 0, nivel, lista);
        return lista;
    }

    private void getListaDatosNivelRecursivo(Nodo<T> nodo, int NivelActual, int NivelDeseado, List<T> lista) {
        if (nodo == null) {
            return;
        }
        if (NivelActual == NivelDeseado) {
            lista.add(nodo.valor);
        } else {
            getListaDatosNivelRecursivo(nodo.menor, NivelActual + 1, NivelDeseado, lista);
            getListaDatosNivelRecursivo(nodo.mayor, NivelActual + 1, NivelDeseado, lista);
        }
    }


    public Boolean isArbolHomogeneo() {
        return isArbolHomogeneoRecursivo(raiz);
    }

    private Boolean isArbolHomogeneoRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return true;
        }
        boolean tieneHijoIzq = nodo.menor != null;
        boolean tieneHijoDer = nodo.mayor != null;

        if ((tieneHijoIzq && !tieneHijoDer) || (!tieneHijoIzq && tieneHijoDer)) {
            return false;
        }

        return isArbolHomogeneoRecursivo(nodo.menor) && isArbolHomogeneoRecursivo(nodo.mayor);
            }

    public Boolean isArbolCompleto(){
        if (raiz == null) {
            return true;
        }
        int profundidad = encontrarProfundidad(raiz);
        return esCompleto(raiz, 0, profundidad);
    }
    private int encontrarProfundidad(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int profundiadIzq= encontrarProfundidad(nodo.menor) + 1;
        int profundiadDer= encontrarProfundidad(nodo.mayor) + 1;
        if (profundiadIzq > profundiadDer) {
            return profundiadIzq;
        }
        else{
            return profundiadDer;
        }
    }

    private Boolean esCompleto(Nodo<T> nodo, int Nivel, int profundidad) {
        if (nodo == null) {
            return true;
        }
        if (nodo.menor == null && nodo.mayor == null) {
            return Nivel + 1 == profundidad;
        }

        return esCompleto(nodo.menor, Nivel + 1, profundidad) && esCompleto(nodo.mayor, Nivel + 1, profundidad);
    }

    public boolean isArbolCasiCompleto() {
        if (raiz == null) {
            return true;
        }

        int profundidad = encontrarProfundidad(raiz);
        return CasiCompletoRecursivo(raiz, 1, profundidad);
    }

    private boolean CasiCompletoRecursivo(Nodo<T> nodo, int nivelActual, int profundidad) {
        if (nodo == null) {
            return true;
        }

        if (nivelActual == profundidad - 1) {
            if (nodo.mayor != null && nodo.menor == null) {
                return false;
            }
        }

        if (nivelActual > profundidad) {
            if (nodo.menor == null || nodo.mayor == null) {
                return false;
            }
        }

        return CasiCompletoRecursivo(nodo.menor, nivelActual + 1, profundidad) &&
                CasiCompletoRecursivo(nodo.mayor, nivelActual + 1, profundidad);
    }

    public List<T> getCamino(T valorBuscado) {
        List<T> camino = new ArrayList<>();
        if (raiz== null){
            return camino;
        }
        else{
            buscarCaminoRecursivo(raiz, valorBuscado, camino);

            return camino;
        }
    }

    private boolean buscarCaminoRecursivo(Nodo<T> nodoActual, T valorBuscado, List camino){

        if (nodoActual == null) {
            return false;
        }
        camino.add(nodoActual.valor);
        if(valorBuscado == nodoActual.valor){
            return true;
        }
        if ((int) valorBuscado > (int) nodoActual.valor) {
            return buscarCaminoRecursivo(nodoActual.mayor, valorBuscado, camino);
        }

        else {
            return buscarCaminoRecursivo(nodoActual.menor, valorBuscado, camino);
        }


    }
        protected Nodo<T> addRecursivo(Nodo<T> actual, T valor) {
        if (actual == null) {
            return new Nodo<>(valor);
        }
        int elementoInt = (int) valor;
        int actualInt = (int) actual.valor;
        if (elementoInt > actualInt) {
            actual.mayor = addRecursivo(actual.mayor, valor);
        }
        if (elementoInt < actualInt) {
            actual.menor = addRecursivo(actual.menor, valor);
        }
        return actual;
    }

    public void addNodo(T valor) {
        raiz = addRecursivo(raiz, valor);
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<T> subArbolizquierda = new ArbolBinarioDeBusqueda<>();
        if (raiz != null) {
            subArbolizquierda.raiz = raiz.menor;
            return subArbolizquierda;
        } else {
            subArbolizquierda.raiz = null;
        }
        return subArbolizquierda;
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<T> subArbolDerecha = new ArbolBinarioDeBusqueda<>();
        if (raiz != null) {
            subArbolDerecha.raiz = raiz.mayor;
        } else {
            subArbolDerecha.raiz = null;
        }
        return subArbolDerecha;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }
    public List<T> getListaOrdenCentral() {
        List<T> lista = new ArrayList<>();
        getListaOrdenCentralRecursiva(raiz, lista);
        return lista;
    }
    private void getListaOrdenCentralRecursiva(Nodo<T> nodo, List<T> lista) {
        if (nodo == null) {
            return;
        }
        getListaOrdenCentralRecursiva(nodo.menor, lista);
        lista.add(nodo.valor);
        getListaOrdenCentralRecursiva(nodo.mayor, lista);
    }
    public List<T>  getListapreOrden(){
        List<T> lista = new ArrayList<>();
        getListapreOrdenRecursiva(raiz, lista);
        return lista;
    }

    private void getListapreOrdenRecursiva(Nodo<T> nodo, List<T> lista) {
        if (nodo != null) {
            lista.add(nodo.valor);
            getListapreOrdenRecursiva(nodo.menor, lista);
            getListapreOrdenRecursiva(nodo.mayor, lista);
        }
    }
    public List<T>  getListapostOrden(){
        List<T> lista = new ArrayList<>();
        getListapostOrdenRecursiva(raiz, lista);
        return lista;
    }
    private void getListapostOrdenRecursiva(Nodo<T> nodo, List<T> lista) {
        if (nodo != null) {
            getListapostOrdenRecursiva(nodo.menor, lista);
            getListapostOrdenRecursiva(nodo.mayor, lista);
            lista.add(nodo.valor);
        }

    }


}

