package ProyectoFinal;

// import pilasNodo.nodoP;

// import pilasNodo.nodoP;
public class pila {
    // private Nodo cima;
    Lista list;

    public pila() {
        this.list = new Lista();
    }

    
    public void push(String codServ, String nomServ) {
        list.push(codServ,nomServ);
    }
    public void mostrarPila(){
        list.mostrarPila();
    }

    // verificar si la lista esta vacía
    public boolean esVacia() {
        return list.esVacia();
    }
    // metodo push
    // public void push(Lista list) {
    //     // list.Spila();
    //     Nodo nuevo = list.cima;
    //     while(nuevo != null){
    //         listaConvertida.insertar(doc,codServ, nomServ,precServ,cantPrendas,cantPerSpa,
    //         cajaFuerte,cantDiasVehic);
    //         nuevo = nuevo.sig;
    //     }
    // }

}