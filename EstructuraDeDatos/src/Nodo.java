public class Nodo<T> {
     T valor;
     Nodo<T> mayor;
     Nodo<T> menor;

    public Nodo(T valor) {
        this.valor = valor;
        this.mayor = null;
        this.menor = null;
    }
}
