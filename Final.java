package ProyectoFinal;

import java.util.Scanner;

public class Final {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables de informacion de huespedes
        String doc, nombre = "", genero = "", tHabitacion = "", estado = "", metPago = "";
        int edad = 0, nHabitacion = 0, tipo = 0, est = 0, opc = 0, Vh = 0, pago = 0;
        
        
        // Variables de los Servicios
        int servi = 0, precServ = 0, opcServ = 0, cantPrendas = 0, cantPerSpa = 0, cantDiasVehic = 0;
        String codServ = "", nomServ = "", cajaFuerte = "";
        boolean salir = false;
        // boolean encontro = true;

        // Lista de datos de huespedes
        Lista huesped = new Lista();
        pila pilita = new pila();

        do {// Menu de opciones
            System.out.println("-----------------Menu-----------------");
            System.out.println("1. Registrar huesped");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Adquirir servicios adicionales ");
            System.out.println("4. Check-Out y Valor a cancelar ");
            System.out.println("5. cantidad de personas por metodo pago");
            System.out.println("6. Mostrar pila");
            System.out.println("7. Mostrar totales del Hotel");
            System.out.println("8. Salir");
            System.out.print("Ingrese su opcion: ");
            opc = sc.nextInt();

            switch (opc) {

                case 1: // Registro de Huesped
                    System.out.println(" ");
                    System.out.print("Ingrese el numero de Documento: ");
                    doc = sc.next();

                    System.out.print("Nombre: ");
                    nombre = sc.next();

                    System.out.print("Edad: ");
                    edad = sc.nextInt();
                    System.out.print("Genero: ");
                    genero = sc.next();
                    System.out.print("Nro. de habitacion: ");
                    nHabitacion = sc.nextInt();
                    System.out.print("Tipo de habitacion: 1. SENCILLA, 2. DOBLE. 3. FAMILIAR \n Ingrese su opción: ");
                    tipo = sc.nextInt();

                    // Condiciones para tipos de habitacion
                    if (tipo == 1) {
                        tHabitacion = "Sencilla";
                        Vh = 155000;
                    } else if (tipo == 2) {
                        tHabitacion = "Doble";
                        Vh = 80000;
                    } else if (tipo == 3) {
                        tHabitacion = "Familiar";
                        Vh = 55000;
                    }
                    System.out.println("Estado de la habitacion: 1. DISPONIBLE, 2. OCUPADA ");
                    System.out.print("Elija su opcion: ");
                    est = sc.nextInt();

                    // Condiciones para estados de las habitaciones
                    if (est == 1) {
                        estado = "Disponible";
                    } else if (est == 2) {
                        estado = "Ocupada";
                    }
                    System.out.println("Elija su Metodo de pago: ");
                    System.out.println("1. Efectivo 2. Tarjeta Débito 3. Tarjeta de Crédito");
                    pago = sc.nextInt();
                    if (pago == 1) {
                        metPago = "efectivo";
                    } 
                    else if (pago == 2) {
                        metPago = "debito";
                    }
                    else if (pago == 3){
                        metPago = "credito";
                    }
                    else{
                        System.out.println("Sin metodo de pago");
                    }

                    huesped.insertar(doc, nombre, edad, genero, nHabitacion, tHabitacion, Vh, estado, metPago);
                    break;

                case 2: // Mostrar Lista de Huespedes Registrados

                    System.out.println("\n----------------Datos del huesped----------------- ");
                    huesped.mostrarLista();
                    break;

                case 3:// Menu de Registro de Servicios Adicionales

                    System.out.print("\nDigite su documento: ");
                    doc = sc.next();
                    System.out.println("\nElija el servicio que desea: ");
                    System.out.println("1. Restaurante: ");
                    System.out.println("2. Lavanderia: ");
                    System.out.println("3. SPA: ");
                    System.out.println("4. Caja fuerte: ");
                    System.out.println("5. Alquiler de Vehiculo: ");
                    System.out.print("Elija su opcion: ");
                    servi = sc.nextInt();

                    // Condiciones para Servicios de Restaurante
                    if (servi == 1) {
                        System.out.println(" ");
                        System.out.println("1. Desayuno______$10.000 | codigo (1010):");
                        System.out.println("2. Almuerzo______$12.000 | codigo (1011):");
                        System.out.println("3. Cena__________$14.000 | codigo (1012):");
                        System.out.print("Elija su opcion: ");
                        opcServ = sc.nextInt();
                        if (opcServ == 1) {
                            codServ = "1010";
                            // nomServ = "Desayuno";
                            precServ = 10000;
                        } else if (opcServ == 2) {
                            codServ = "1011";
                            // nomServ = "Almuerzo";
                            precServ = 12000;
                        } else if (opcServ == 3) {
                            codServ = "1012";
                            // nomServ = "Cena";
                            precServ = 14000;
                        } else {
                            System.out.println("Opcion incorrecta");
                        }
                        nomServ = "Restaurante";

                        // Condicion para Servicios de Lavanderia
                    } else if (servi == 2) {
                        System.out.print("Ingrese cantidad de prendas: ");
                        cantPrendas = sc.nextInt();
                        codServ = "2010";
                        nomServ = "Lavanderia";
                        precServ = cantPrendas * 2000;

                        // Condicion para Servicio de SPA
                    } else if (servi == 3) {
                        System.out.print("Ingrese cantidad de personas: ");
                        cantPerSpa = sc.nextInt();
                        codServ = "3010";
                        nomServ = "SPA";
                        precServ = cantPerSpa * 25000;

                        // Condicion para Servicio de Caja Fuerte
                    } else if (servi == 4) {
                        cajaFuerte = "Si";
                        codServ = "4010";
                        nomServ = "Caja Fuerte";
                        precServ = 15000;

                        // Condicion para Servicio de Alquiler de Vehiculo
                    } else if (servi == 5) {
                        System.out.print("Ingrese los dias de alquiler de vehiculo: ");
                        cantDiasVehic = sc.nextInt();
                        codServ = "5010";
                        nomServ = "Alquiler Vehiculo";
                        precServ = cantDiasVehic * 30000;
                    }
                    huesped.actualizar(doc, codServ, nomServ, precServ, cantPrendas, cantPerSpa, cajaFuerte,
                            cantDiasVehic);
                    pilita.push(codServ, nomServ);
                    break;

                case 4:// Check-Out y Valor a Cancelar

                    System.out.print("\nDigite su documento: ");
                    doc = sc.next();
                    huesped.checkOut(doc, pago);
                    break;

                case 5:// Mostrar Cantidad de Personas por Metodo de Pago
                    huesped.mostrarArrays();
                    break;
                case 6:
                    pilita.mostrarPila();
                    break;
                case 7:
                    huesped.total();
                    break;
                case 8:// Opcion de salida del programa
                    salir = true;
                    break;
            }// Cierre switch
        } while (!salir);
        sc.close();
    }

}
