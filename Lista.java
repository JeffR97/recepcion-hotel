package ProyectoFinal;

public class Lista {

    private Nodo CAB;

    // Constructor
    public Lista() {
        this.CAB = null;
    }

    // Metodo para saber si la lista esta vacia
    public boolean esVacia() {
        return CAB == null;
    }// Cierre del metodo

    // variables montos de medio de pago
    double montoEfec = 0, montoDeb = 0, montoCred = 0;

    // variables operadores por genero
    double totalFeme = 0, totalMasc = 0, totalServ = 0, Tol = 0;
    int contPer = 0, contFem = 0,contMasc;

    // variabiables operadores por servicio
    double totalservi=0,totalRes=0, totallava=0, totalSpa=0, totalCajaF=0, totalVehi=0;

    // variables descuentos
    double totaldescuento = 0, descuento = 0,Tquince = 0,Tveinte = 0,Tcinco = 0;

    // rangos de edad
    double acumMenos5 = 0,acumMas5 = 0,acumMas60 = 0;

    //mayor y menor pago
    double mayorP = 0,menorP = 999999999;
    String Nma,Nme;

    //porcentajes 
    int cont5=0,cont60=0,contI=0;

    //arrays
    int[] efectivo = new int[1];
    int[] debito = new int[1];
    int[] credito = new int[1];
    int Totalpagos = 0;

    // Metodo para insertar Informacio del huesped
    public void insertar(String doc, String nombre, int edad, String genero, int nHabitacion, String tHabitacion,
            int Vh, String estado, String metPago) {
        // Crear el nuevo nodo
        Nodo nuevo = new Nodo();
        nuevo.infoCC = doc;
        nuevo.infoNom = nombre;
        nuevo.infoEd = edad;
        nuevo.infoGen = genero;
        nuevo.infonHab = nHabitacion;
        nuevo.infotHab = tHabitacion;
        nuevo.infoValH = Vh;
        nuevo.infoEst = estado;
        nuevo.infoMetPago = metPago;
        if (esVacia()) {
            CAB = nuevo;
            nuevo.sig = null;
        } else {// Si la lista no esta vacia entonces:
            nuevo.sig = CAB;
            CAB = nuevo;
        } // Fin if
        System.out.println("Se han registrado los datos!\n");
        contPer++;
        if (genero.equals("f") || genero.equals("F")) {
            contFem++;
        } else if (genero.equals("m") || genero.equals("M")) {
            contMasc++;
        }
    }// Cierre del metodo

    // Metodo para mostrar la lista de los Huesopedes Registrados
    public void mostrarLista() {
        // Crear un nodo auxiliar para movernos
        // por la lista
        Nodo t = CAB;
        while (t != null) {

            System.out.println("| Cc: " + t.infoCC + " - Nombre: " + t.infoNom + " - Edad: " + t.infoEd
                    + " - Genero: " + t.infoGen + " - Habitacion: " + t.infonHab + " - Tipo Habitación: " + t.infotHab
                    + " Valor habitación:" + t.infoValH
                    + " - Estado: " + t.infoEst + " - Metodo Pago: " + t.infoMetPago + " - Cod Servicio: "
                    + t.infoCodServ
                    + " - Nombre servicio: " + t.infonomServ + " - Servicio adicional: " + t.infoPrecServ
                    + " - Cant. personas SPA:" + t.infoCaPerSpa + " - Cant. Dias Vehiculo: "
                    + t.infoDiasVehic + " - Cant. prendas:" + t.infoCantPrenda + " |");
            t = t.sig;
        } // Cierre while
        System.out.println("\n");
    }// Cierre Metodo

    // actualizar datos de Servicios Adquiridos
    public void actualizar(String doc, String codServ, String nomServ, int precServ, int cantPrendas, int cantPerSpa,
            String cajaFuerte, int cantDiasVehic) {
        if (!esVacia()) {
            Nodo t = CAB;
            boolean encontro = false;
            while (t != null && !encontro) {
                if (t.infoCC.equals(doc)) {
                    encontro = true;
                } else {
                    t = t.sig;
                }
            }
            if (encontro) {
                t.infoCodServ = codServ;
                t.infonomServ = nomServ;
                t.infoPrecServ = precServ;
                t.infoCantPrenda = cantPrendas;
                t.infoCaPerSpa = cantPerSpa;
                t.infoCajaF = cajaFuerte;
                t.infoDiasVehic = cantDiasVehic;
                System.out.println("Se agrego el servicio\n");
            }
        } else {
            System.out.println("Lista vacia");
        }
    }// cierre metodo

    // Metodo de salida huesped y Su Respectiva factura
    public void checkOut(String doc, int pago) {
        boolean encontro = false;
        Nodo t = CAB;
        Totalpagos++;
        // Nodo Auxiliar para el nodo anterior
        Nodo ant = null;
        if (!esVacia()) {
            while (t != null && !encontro) {
                if (t.infoCC.equals(doc)) {
                    encontro = true;
                } else {
                    ant = t;
                    t = t.sig;
                }
            } // Cierre del while
            if (encontro) {
                System.out.println("\n--------Facturación de " + t.infoNom + "----------");
                double Neto = t.infoValH + t.infoPrecServ;
                double totalSalida;
                
                //descuentos
                if (t.infoEd < 5) {
                    descuento = Neto * 0.15;
                    totalSalida = Neto - descuento;
                    Tquince+=descuento;
                    acumMenos5+=totalSalida;
                    cont5++;
                } else if (t.infoEd > 60) {
                    descuento = Neto * 0.25;
                    totalSalida = Neto - descuento;
                    Tveinte+=descuento;
                    acumMas60+=totalSalida;
                    cont60++;
                } else {
                    descuento = Neto * 0.05;
                    totalSalida = Neto - descuento;
                    Tcinco+=descuento;
                    acumMas5+=totalSalida;
                    contI++;
                }
                System.out.println("Total: " + Neto);
                System.out.println("Su descuento es de: " + descuento);
                System.out.println("Neto a pagar con descuento: " + totalSalida);
                Tol += totalSalida;


                // Condiciones para Metodos de pago
                if (t.infoMetPago.equals("efectivo")) {
                    montoEfec += totalSalida;
                    efectivo[0]++;
                } else if (t.infoMetPago.equals("debito")) {
                    montoDeb += totalSalida;
                    debito[0]++;
                } else if (t.infoMetPago.equals("credito")) {
                    montoCred += totalSalida;
                    credito[0]++;
                } else {
                    System.out.println("Error");
                }
                

                //Operaciones por genero
                if (t.infoCC != null && t.infoGen.equals("f") || t.infoGen.equals("F")) {
                    // contPer++;
                    // contFem++;
                    totalFeme += totalSalida;
                } else if (t.infoCC != null && t.infoGen.equals("m") || t.infoGen.equals("M")) {
                    totalMasc += totalSalida;
                }
                else{
                    System.err.println("Error en  genero");
                }

                //operaciones totales de servicios
                if(t.infonomServ != null){
                    if(t.infonomServ.equals("Restaurante")){
                        totalRes+=t.infoPrecServ;
                    } 
                    else if(t.infonomServ.equals("Lavanderia")){
                        totallava+=t.infoPrecServ;
                    } 
                    else if(t.infonomServ.equals("SPA")){
                        totalSpa+=t.infoPrecServ;
                    } 
                    else if(t.infonomServ.equals("Caja Fuerte")){
                        totalCajaF+=t.infoPrecServ;
                    } 
                    else if(t.infonomServ.equals("Alquiler Vehiculo")){
                        totalVehi+=t.infoPrecServ;
                    } 
                    totalservi=totalRes+totallava+totalSpa+totalCajaF+totalVehi;
                }
                
                // Totales de descuentos
                totaldescuento+=descuento;

                // mayor y menor pago
                if(totalSalida < menorP){
                    Nme=t.infoNom;
                    menorP=totalSalida;
                }
                if(totalSalida > mayorP){
                    Nma=t.infoNom;
                    mayorP=totalSalida;
                }

                if (t == CAB) {
                    CAB = CAB.sig;
                } else {
                    // validar si el nodo a eliminar es el ultimo
                    if (t.sig == null) {
                        ant.sig = null;
                    } else {
                        // se elimina el nodo intermedio
                        ant.sig = t.sig;
                    }
                }
                System.out.println("check-out terminado\n");
            } else {
                System.out.println("El usuario no esta en lista\n");
            }
        } else {
            System.out.println("La lista esta vacia\n");
        }
    }// Cierre del metodo

    public void mostrarArrays(){
        System.out.println("--------------Cantidad de huéspedes por metodo de pago-------------");
        System.out.println("En efectivo: " + efectivo[0]);
        System.out.println("En débito : " + debito[0]);
        System.out.println("En crédito : " + credito[0]);

    }// Cierre del metodo

    public void total() {
        System.out.println("\n---------------------Totales del hotel--------------------\n");
        System.out.println("Cantidad de Huespedes: " + contPer);
        System.out.println("Cantidad de Huespedes: Masculinos " + contMasc + " | Femeninas " + contFem);
        System.out.println("Total recaudado por el hotel: " + Tol);
        System.out.println("Total pago: masculino " + totalMasc + " |  Femenino " + totalFeme);
        System.out.println("Recaudado en: Efectivo " + montoEfec + " |  Debito " + montoDeb + " | Credito  " + montoCred);
        System.out.println("Recaudo por servicio:  Restaurante " + totalRes + " | Lavanderia " + totallava + " | Spa " + totalSpa +
                        " | Caja Fuerte " + totalCajaF + " | Alquiler Vehiculo " + totalVehi);
        System.out.println("Total de descuentos:  " + totaldescuento);
        System.out.println("Monto total de descuentos : Menores de 5 años " + Tquince + " | Mayores de 60 años " + Tveinte + " | Demas años " + Tcinco);
        System.out.println("El huésped que más pagó: " + Nma + " " + mayorP + " | El que menos pagó: " + Nme + " " + menorP);
        System.out.println("El porcentaje por rango: Menores de 5 años " + cont5*100/contPer + "% | Mayores de 60 años " + cont60*100/contPer 
        + "% | Demas años " + contI*100/contPer + "% ");
        System.out.println("Porcentaje recaudado por sevicio: Restaurante " + totalRes*100/totalservi + " % | Lavanderia " + totallava*100/totalservi 
         + " % | Spa " + totalSpa*100/totalservi  + " % | Caja Fuerte " + totalCajaF*100/totalservi  + " % | Alquiler Vehiculo " + totalVehi*100/totalservi 
         + " %");
        System.out.println("Porcentaje de huéspedes en cantidad: Efectivo " + efectivo[0]*100/Totalpagos + "% | Débito " + debito[0]*100/Totalpagos 
        + "% | Crédito " + credito[0]*100/Totalpagos + "%");
        System.out.println("Porcentaje de huéspedes en dinero: Efectivo " + montoEfec*100/Tol + "% | Débito " + montoDeb*100/Tol + "% | Crédito  " 
        + montoCred*100/Tol + "%");
        System.out.println("Porcentaje de huéspedes según su género: Masculino " + contMasc*100/contPer +"% | Femenino " + contFem*100/contPer + "%" );
        System.out.println("Total de dinero recaudado rango de edad: Menores de 5 años " + acumMenos5 + " | Mayores de 60 años " + acumMas60 + " | Demas años "
         + acumMas5 );
        System.out.println("\n");
    }// Cierre Metodo

    int contR = 0, contL = 0, contSpa = 0, contCaja = 0, contV = 0;

    public void push(String codServ, String nomServ) {
        // Crear el nuevo nodo
        Nodo nuevo1 = new Nodo();
        // nuevo1.infoCodServ= codServ;
        nuevo1.infonomServ = nomServ;
        if (esVacia()) {
            CAB = nuevo1;
            nuevo1.sig = null;
        } else {// Si la lista no esta vacia entonces:
            nuevo1.sig = CAB;
            CAB = nuevo1;
        } // Fin if
        if (nuevo1.infonomServ.equals("Restaurante")) {
            contR++;
        } else if (nuevo1.infonomServ.equals("Lavanderia")) {
            contL++;
        } else if (nuevo1.infonomServ.equals("SPA")) {
            contSpa++;
        } else if (nuevo1.infonomServ.equals("Caja Fuerte")) {
            contCaja++;
        } else if (nuevo1.infonomServ.equals("Alquiler Vehiculo")) {
            contV++;
        }
        System.out.println("Se han registrado los datos!\n");
    }

    public void mostrarPila() {
        // Crear un nodo auxiliar para movernos
        // por la lista
        Nodo t = CAB;
        // while (t != null) {
        System.out.println(" Restaurante:  |\t" + contR + " \t|");
        System.out.println(" Lavanderia:   |\t" + contL + " \t|");
        System.out.println(" SPA:          |\t" + contSpa + " \t|");
        System.out.println(" Caja fuerte:  |\t" + contCaja + " \t|");
        System.out.println(" Alquiler auto:|\t" + contV + " \t|");
        t = t.sig;
        // } // Cierre while

    }// Cierre Metodo

}
