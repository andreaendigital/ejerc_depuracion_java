/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana06;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;

/**
 *
 * @author Andrea
 */
public class Semana06 {
    
//Variables estáticas, de clase.
    static String nombreTeatro = "Teatro Moro";
    static int capacidadSala = 9;
    static int entradasDisponibles = capacidadSala; //se inicializa en su capacidad total
    //entradas disponibles = capaciadSala - entradasVendidas
    static int entradasVendidas = 0;
    static int totalPagar;
    static int devolucion;
    
//Variables de asientos del plano del teatro
    static String a1 = "A1", a2 = "A2", a3 = "A3";
    static String b1 = "B1", b2 = "B2", b3 = "B3";
    static String c1 = "C1", c2 = "C2", c3 = "C3";

    
    static char zona;
    static int numeroAsiento;
    static int cantidadEntradas;
    


        
    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        //Variables locales se declaran dentro del metodo y solo existen dentro del bloque: 
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String asientosSeleccionados = "";
       
        //MENU DE VENTA           
        do{ //ciclo principal que genera iteración del menú
            mostrarMenu();  
            
            if(scanner.hasNextInt()){ // validación al ingresar String y no int
                 opcion = scanner.nextInt();
           
                switch(opcion){
                    case 1:
                        //RESERVA DE ENTRADA
                         System.out.println("**** RESERVA DE ENTRADA ******");
                         cantidadEntradas = validacionEntradas(scanner); //BREAKPOINT 1 Transicion de reserva a compra: Validacion de entrada: verifica que la cantidad de entradas reservads, sea válida
                         if (cantidadEntradas == 0){
                             break;
                         }
                         asientosSeleccionados = seleccionAsientos(scanner); //BREAKPOINT 3 Seleccion y validacion de asientos: revisa que los asientos seleccionados correspondan a entradas validas 
                         totalPagar = (int) calculaPrecio(scanner);
                         reserva(scanner, asientosSeleccionados);
                        // impresionInfo(char zona, int numeroAsiento, int precioBase, double porcentajeDescuento, int totalPagar);
                        break;
                    case 2:
                        //COMPRA DE ENTRADAS
                        System.out.println("**** COMPRA DE ENTRADAS ******");
                        cantidadEntradas = validacionEntradas(scanner);
                        if (cantidadEntradas == 0){
                             break;
                        }
                         asientosSeleccionados = seleccionAsientos(scanner);
                         totalPagar = (int) calculaPrecio(scanner);
                         confirmarCompra(asientosSeleccionados); ////BREAKPOINT 2 Transicion de reserva a compra: asegura que se esten confirmando los asientos reservados
                        break;
                    case 3:
                        //MODIFICAR VENTA EXISTENTE
                        asientosSeleccionados = modificarVenta(scanner, asientosSeleccionados);
                        break;
                   case 4:
                        //IMPRIMIR BOLETA
                       if(cantidadEntradas == 0){
                           System.out.println("No hay informacion aun para imprimir la boleta, realice una compra.");
                       }else{
                        System.out.println("************ IMPRIMIR BOLETA ***************");
                        System.out.println("********************************************");
                        System.out.println("-----------DETALLE DE LA COMPRA -----------");
                        impresionInfo(asientosSeleccionados); // BREAKPOINT 6 Generacion de boletas: asegura que los datos entregados para la impresión estén correctos 
                       }
                        break;
                   case 5:
                          //ESTADISTICAS GENERALES
                        estadisticasGlobales();
                        break;     
                   case 6:
                       //SALIR
                        System.out.println("**** SALIR ******");
                        break;
                                             
                    default:
                        System.out.println("Opcion no valida intente nuevamente");
                }
                
            } else { //si lo ingresado NO es un número, repite:
                System.out.println("Opcion no valida, no es un numero, ingrese nuevamente su opcion");
                scanner.next(); //consumimos entrada no válida: descartamos la entrada incorrecta y evitamos un bucle infinito
            }
        } while( 6 != opcion);
           
        
    }
    
    public static void estadisticasGlobales(){
        System.out.println("*********************************");
        System.out.println("-------ESTADISTICAS GLOBALES--------");
        System.out.println("Capacidad de la Sala: " +capacidadSala + " asientos");
        System.out.println("Entradas disponibles actualmente: " + entradasDisponibles);
        System.out.println("Entradas vendidas : " + entradasVendidas);
        System.out.println("Plano con entradas disponibles actualmente: \n");
        mostrarPlano();
                
    } //Cierre de estadisticasGlobales
    
    public static String modificarVenta(Scanner scanner, String asientosSeleccionados){
        //Variables locales se declaran dentro del metodo y solo existen dentro del bloque: 
        String asientosConfirmados;
        int entradasDevueltas;
        String asientosDevueltos;
        
        if(cantidadEntradas == 0){
            System.out.println("Realice una compra antes, para acceder a este menu.");
            return "";
        }else{
        System.out.println("\n------------------------------\n****** MODIFICAR COMPRA ********");
        
        
        System.out.println("Usted ha comprado " + cantidadEntradas + " entradas");
        
        do{
        System.out.println("Cuantas entradas desea devolver?");
        if (scanner.hasNextInt()){
           entradasDevueltas = scanner.nextInt(); 
           scanner.nextLine(); //Limpia el buffer antes de leer la linea
            if(entradasDevueltas>cantidadEntradas){
            System.out.println("No puede devolver mas entradas que las compradas, intente nuevamente");
            }else{
                break;
            }
           
        }else{
            System.out.println("Opcion no valida, ingrese nuevamente.");
            scanner.next(); //consumimos entrada no válida: descartamos la entrada incorrecta y evitamos un bucle infinito
        }
        }while(true);
        

        System.out.println("\nUsted compro los siguientes asientos: " + asientosSeleccionados);
        
        do{
            System.out.println("Ingrese los asientos que devolvera: ");
            asientosDevueltos = scanner.nextLine().toUpperCase();
                
        
            if(asientosDevueltos.isEmpty()){
                System.out.println("No ha ingresado ningun asiento. Intentelo nuevamente");
            }else{
                break;
            }
        }while(true);
        
               
        // RECALCULAR TOTAL A PAGAR ------------------------
        // Se recalcula antes de enviar a eliminar las entradas por que despues de elimarlas
        // se actualiza el valor de la variable cantidadEntradas y el calculo no seria el mismo
        //System.out.println("Total a Pagar: " + totalPagar);
        //System.out.println("Valor Unitario" + (totalPagar/cantidadEntradas));
        //System.out.println("Entradas que quedan pagadas: "+(cantidadEntradas-entradasDevueltas) );
        devolucion = totalPagar - ( (totalPagar/cantidadEntradas)*(cantidadEntradas-entradasDevueltas));
        totalPagar = (totalPagar/cantidadEntradas)*(cantidadEntradas-entradasDevueltas);
        
        eliminarReserva(asientosDevueltos);  
       
        
        //Necesito identificar los o el asiento que no se modifican para que quede en la variable respectiva 
        //y pueda ser impreso en la boleta después de la modificacion
        //Para eso:
        //Convertir a lista el string original
        List<String> listaAsientosComprados = Arrays.asList(asientosSeleccionados.split(" "));
         //System.out.println("Los asientos comprados son  en lista: " + listaAsientosComprados);

        //Leer los datos del usuario
        List<String> listaAsientosDevueltos = Arrays.asList(asientosDevueltos.split(" "));
        //System.out.println("Los asientos devueltos son:  en lista " + listaAsientosDevueltos);
        
        //Crear la lista de diferencias (elementos no mencionados)
        List<String> listaAsientosConfirmados = new ArrayList<>(listaAsientosComprados);
        
        listaAsientosConfirmados.removeAll(listaAsientosDevueltos);
 
        //Convertimos la lista en un String separado por espacios
        asientosConfirmados = String.join(" ", listaAsientosConfirmados );
        
        //Ahora lo dividimos en un array
        // String[] asientos = asientosConfirmados.split(" ");
        
        
        System.out.println("\n------------------------------------------\nLos asientos confirmados son: " + asientosConfirmados);
        System.out.println("Su reembolso corresponde a : " + devolucion);
        //System.out.println("totalPagar ahora" + totalPagar);
        
        }//Cierre del else
        return asientosConfirmados;
    }//Cierre modificarVenta
  
    static void mostrarMenu(){
        System.out.println("\n****************Bienvenido al " + nombreTeatro + "*****************");
        System.out.println("1. Reserva de Entradas");
        System.out.println("2. Compra de Entradas");
        System.out.println("3. Modificacion de su compra");
        System.out.println("4. Imprimir Boleta");  
        System.out.println("5. Estadisticas Globales");  
        System.out.println("6. Salir");
        System.out.println("Ingrese numero de la opcion que desea ejecutar:");
    }    //Cierre de mostrarMenu
    
    public static void mostrarPlano(){
        System.out.println("******** ESCENARIO  *********");
        System.out.println("ZONA A: " + a1 + " - " + a2 + " - " + a3);
        System.out.println("ZONA B: " + b1 + " - " + b2 + " - " + b3);
        System.out.println("ZONA C: " + c1 + " - " + c2 + " - " + c3);
    } //Cierre de mostrarPlano
    
    public static char seleccionarZona(Scanner scanner){
        char zona;
        boolean condicion = false;
        do{
            System.out.println("\nPrimero ingrese la ZONA en que desea el asiento: (A/B/C)");

            //Solicitar ubicación del asiento, usando validación con estructura condicional if

            zona = scanner.next().trim().toUpperCase().charAt(0); 
            //charAt: método para obtener un caracter específico en función de su posición, obtiene el primer caracter de la cadena
            //scanner.next devuelve un String completo hasta el primer espacio y la variable zona está declarada como char por eso charAt es necesario
            //de lo contrario se intentará asignar un String a una variable tipo char, lo que es incompatible y genera error de compilación

            if (zona != 'A' && zona != 'B' && zona != 'C'){
                System.out.println("Zona invalida. Intente nuevamente");
                condicion = false;
            } else { 
                condicion = true;
            }
            
        }while(!condicion);
        
        return zona;
        
    } //Cierre seleccionarZona
    
    public static int seleccionarNumeroAsiento(Scanner scanner){
        
        int numeroAsiento;
        
        System.out.println("Ahora ingrese el Numero del Asiento que desea comprar:");
       
        do{
           if(scanner.hasNextInt()){ //Si es un número
                numeroAsiento = scanner.nextInt(); //se asigna
                    if (numeroAsiento < 1 || numeroAsiento > 3){ //Si el número está fuera de rango, repite.
                        System.out.println("Numero de asiento invalido, fuera del rango. Intente nuevamente.");
                        
                    } else { //Confirma el numero seleccionado.
                        System.out.println("Ha seleccionado el asiento: " + numeroAsiento);
                        break;
                    }
            } else{ //Si no es un número... repite.
                System.out.println("Opcion no valida. Ingrese un numero por favor:");
                scanner.next(); //consumimos entrada no valida para no caer en bucle.
            }
        } //cierre do
        while (true);
    return numeroAsiento;
    }//Cierre seleccionarNumeroAsiento
    
    public static int validacionEntradas (Scanner scanner){
        //debe retornar un numero de entrada y segun ese numero se ejecuta o no el resto del proceso.
        if(entradasDisponibles <=0){

            System.out.println("\n*****************************************");
            System.out.println("No hay entradas disponibles para la venta");
            System.out.println("*****************************************");
            return 0;
        } 
        
        //NUMERO DE ENTRADAS
        //manejo de error, validación ingreso usuario con ciclo while
        while(true){
            System.out.println("\nIngrese la cantidad de entradas que desea: ");
            if(scanner.hasNextInt()){
                cantidadEntradas = scanner.nextInt();
                //break; //sale del ciclo si se ingresa un numero valido
            }else{
                System.out.println("Opcion no valida, no es un numero. ");
                scanner.next(); //Limpia el buffer del scanner
            }
            System.out.println("\n***************************");
            System.out.println("Usted desea comprar " + cantidadEntradas + " entradas");
            //Validar cantidad de entradas disponibles
             if (entradasDisponibles < cantidadEntradas){
                System.out.println("Solo hay " + entradasDisponibles + " entradas disponibles.");
                 System.out.println("**************************\n");
                return 0;
            }else if(entradasDisponibles==0){
                 System.out.println("Gracias. Lo devolveremos al menu.");
                 return 0;
            }else{
                System.out.println("\n***********************\nQuedan " + entradasDisponibles + " entradas disponibles para la venta.\n***********************\n");
                   break;
            }
            
       }
        
    return cantidadEntradas;    
          
    }//Cierre validacionEntradas
   
    public static String seleccionAsientos(Scanner scanner){
       //Variables
       // char zona;
       // int numeroAsiento;
        String asientosSeleccionados = "";  //Concatenacion de asientos reservados
        int contador = 0;
        

            while (contador < cantidadEntradas) {


                //mostrar el plano del teatro con ubicaciones disponibles
                    System.out.println("************************************");
                    System.out.println("**** SELECCION DE ASIENTOS ******");
                    System.out.println("\nA continuacion le mostramos un plano del teatro con los Asientos Disponibles \n");

                    do{

                        mostrarPlano();
                        System.out.println("\nA continuacion seleccionaremos el asiento de la entrada " + (contador+1));

                        //BREAKPOINT 4 Seleccion y validacion de asientos: detecta si el asiento ya fue reservado/comprado con el uso de las variables zona y numeroAsiento en las logicas if/else
                        zona = seleccionarZona(scanner);
                        //System.out.println("Zona: " + zona);
                        numeroAsiento = seleccionarNumeroAsiento(scanner);
                        String asiento = String.valueOf(zona).toUpperCase()+numeroAsiento;

                        if ( zona == 'A'){
                            if(numeroAsiento == 1 && !"XX".equals(a1) ) {
                                a1 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else if (numeroAsiento == 2 && !"XX".equals(a2)){
                                a2 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;                            
                                break;
                            } else if (numeroAsiento == 3 && !"XX".equals(a3)){
                                a3 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else { 
                                System.out.println("\n************************************"); 
                                System.out.println("El asiento ya esta ocupado, por favor, eliga otro:");
                            } 
                        } else if ( zona == 'B'){
                            if(numeroAsiento == 1 && !"XX".equals(b1) ) {
                                b1 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else if (numeroAsiento == 2 && !"XX".equals(b2)){
                                b2 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else if (numeroAsiento == 3 && !"XX".equals(b3)){
                                b3 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else { 
                                System.out.println("\n************************************"); 
                                System.out.println("El asiento ya esta ocupado, por favor, eliga otro:");
                            } 
                        } else if ( zona == 'C'){
                            if(numeroAsiento == 1 && !"XX".equals(c1) ) {
                                c1 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else if (numeroAsiento == 2 && !"XX".equals(c2)){
                                c2 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else if (numeroAsiento == 3 && !"XX".equals(c3)){
                                c3 = "XX";
                                asientosSeleccionados += asiento + " ";
                                contador++;
                                break;
                            } else { 
                                System.out.println("\n************************************"); 
                                System.out.println("El asiento ya esta ocupado, por favor, eliga otro:");                     
                            }
                        }
                    }while(true); 
                    System.out.println("-----------------------------------------------------");
                    System.out.println("\n Usted ha apartado el siguiente asiento: " + zona + "" + numeroAsiento); //BREAKPOINT 5 Seleccion y validacion de asientos: Confirma la correcta asignacion del asiento

                mostrarPlano();
                System.out.println("");
                
                entradasVendidas++;
                entradasDisponibles--;
            }//Cierre del while
           

    
    return asientosSeleccionados.trim();
    
    } //Cierre seleccionAsientos
    
    public static double calculaPrecio(Scanner scanner){
        int edad;
        double descuento;
       // int totalPagar;
        int precioBase = 20000;
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nAhora ingrese su edad para validar aplicacion de descuentos:");

         //Validación de edad y..
        // Calcular Precio final en un ciclo do while o while, aplicando los descuentos
            //Aplicar descuento 10% para estudiantes, 
            //15 % para personas de la tercera edad, mayores de 60 años. El cálculo sería precioBase * 0.85 corresponde al 15%
        //precioBase * 0.9 corresponde  al 10% de descuento para estudiantes 

        do {

            if(scanner.hasNextInt()){ //Si la entrada es un número...
            edad = scanner.nextInt(); //Lee lo que el usuario ingresa, con nextInt captura número, lo asigno a la variable

                if(edad>60){
                System.out.println("------------------------------------");
                System.out.println("Aplica descuento del 15%, para tercera edad.");
                descuento = 0.85;
                totalPagar = (int) (precioBase * descuento)*cantidadEntradas;
                break;

                } else if (edad<23){
                     System.out.println("------------------------------------");
                    System.out.println("Aplica descuento del 10%, para estudiantes.");
                    descuento = 0.9;
                    totalPagar = (int) (precioBase * descuento)*cantidadEntradas;
                    break;

                } else{
                        System.out.println("------------------------------------");
                        System.out.println("No aplica descuentos, tarifa normal.");
                        descuento = 0;
                        totalPagar = precioBase*cantidadEntradas;
                        break;
                }

            } else {
                System.out.println("Opcion no valida. Ingrese un número por favor:");
                scanner.next(); //consumimos entrada no valida para no caer en bucle.
            }


        } while(true);
  
        
        return totalPagar;
    } //Cierre CalculaPrecio
    
    public static void impresionInfo(String asientosSeleccionados){

        System.out.println("Teatro " + nombreTeatro);
        System.out.println("Entradas Compradas: " + cantidadEntradas);
        System.out.println("Asientos: " + asientosSeleccionados); // BREAKPOINT 8 Generacion de boletas: valida que los asientos impresos coincidan con la compra y post modificacion
        //System.out.println("Precio Base de la entrada:" + precioBase);
        //System.out.println("Descuento aplicado:" + porcentajeDescuento + "%");
        System.out.println("Precio final a pagar:" + totalPagar); // BREAKPOINT 7 Generacion de boletas: verifica que el total a pagar sea correcto con la compra y post modificacion
        System.out.println("********************************************\n");
    } //Cierre de impresionInfo
    
    public static void reserva (Scanner scanner,String asientosSeleccionados){
    //avisar que esta reservada por 30 segundos ->        
    // Un temporizador en tiempo real que dure 30 segundos.
    // Permita ingresar S, N u otro valor.
    //Si no hay respuesta en 30 segundos, ejecuta eliminación.
    //Mientras tanto, acepta y valida la entrada del usuario.
        
    //Variables para Timer de Reserva:
    //Cuando se usa una clase interna anónima como TimerTask, 
    //Java te obliga a que las variables externas que se usen dentro de esa clase sean final o efectivamente final.
    //Usamos un arreglo para que sea "final pero editable"
    final boolean[] respuesta = { false };
    final int[] segundos = { 30 };
    Timer timer = new Timer(); 
        
        
        //mostrar la información reservada -> llamar a función
        
        System.out.println("\n********************************");
        System.out.println("********** SU RESERVA **********");

        impresionInfo(asientosSeleccionados);
        
        System.out.println("");
        System.out.println("Esta reserva esta vigente por 30 segundos, \nsi no confirma su compra, se eliminara del sistema.");
        System.out.println("");
       

        //*************************************
        //Timer
        TimerTask contador ;  //Cierre del TimerTask
        contador = new TimerTask() {
            @Override
            public void run() {
                if(segundos[0]>0){
                    System.out.println("Tiempo restante: " + segundos[0] + " segundos.");
                    segundos[0] --;
                }//Cierre del if que hace de contador
                else {
                    if(!respuesta[0]){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Tiempo agotado. Su reserva se ha eliminado. \nSi desea realizar otra compra vuelva al menu principal\n");
                        eliminarReserva(asientosSeleccionados);//llamar a funcion de eliminacion de reserva
                        mostrarMenu();
                    }//Cierre del if que valida si hay respuesta
                    timer.cancel(); //Detener el timer
                    
                }//Cierre del else
            
            }//Cierre del public void run
            
        };
        
        //****************************************
        //️Iniciar el contador cada 1 segundo
        timer.scheduleAtFixedRate(contador, 0, 1000);

        //****************************************
        //Esperar input del usuario en paralelo
        while (!respuesta[0] && segundos[0] > 0) {
            System.out.print("- Deseas confirmar la compra? (S/N): \n");
            String input = scanner.next().trim().toUpperCase();
            
            if (input.equals("S")) {
                respuesta[0] = true;
                timer.cancel();
                confirmarCompra(asientosSeleccionados);
            } else if (input.equals("N")) {
                respuesta[0] = true;
                timer.cancel();
                eliminarReserva(asientosSeleccionados);
                break;
            } else {
                System.out.println("Opcion no valida. Intenta nuevamente.");
            }
            
        }//Cierre del while
 
} //Cierre reserva
    
public static void confirmarCompra(String asientosSeleccionados){
    System.out.println("\n************************************"); 
    System.out.println("Su compra ha sido realizada con exito");
    System.out.println("************************************"); 
    System.out.println("");
    System.out.println("-------------DETALLE----------------");
    impresionInfo(asientosSeleccionados);
    System.out.println("------------------------------------");
    
                         
}   //Cierre confirmar compra 
public static void eliminarReserva(String asientosSeleccionados){
    //*********************************************************************************
    // limpiar variables y sacar la reserva de asiento:
    String[] asientos = asientosSeleccionados.split(" ");
    
    //for(String asiento : asientos){
    //System.out.println("asientos: " + asiento);
    //}
    
    for (String asiento : asientos) {
        zona = asiento.charAt(0);
        numeroAsiento = Character.getNumericValue(asiento.charAt(1));
        
        
       
            if ( zona == 'A'){
                if(numeroAsiento == 1 && "XX".equals(a1) ) {
                    a1 = "A1";
                    
                } else if (numeroAsiento == 2 && "XX".equals(a2)){
                    a2 = "A2";
                    
                } else if (numeroAsiento == 3 && "XX".equals(a3)){
                    a3 = "A3";
                    
                }
            } else if ( zona == 'B'){
                if(numeroAsiento == 1 && "XX".equals(b1) ) {
                    b1 = "B1";
                    
                } else if (numeroAsiento == 2 && "XX".equals(b2)){
                    b2 = "B2";
                    
                } else if (numeroAsiento == 3 && "XX".equals(b3)){
                    b3 = "B3";
                    
                }
            } else if ( zona == 'C'){
                if(numeroAsiento == 1 && "XX".equals(c1) ) {
                    c1 = "C1";
                    
                } else if (numeroAsiento == 2 && "XX".equals(c2)){
                    c2 = "C2";
                    
                } else if (numeroAsiento == 3 && "XX".equals(c3)){
                    c3 = "C3";
                    
                }
            }
        
        entradasVendidas--;
        entradasDisponibles++;    
        cantidadEntradas --;    
    }//Cierre del for each       
        mostrarPlano();
        System.out.println("Las reservas " + asientosSeleccionados + " han sido liberadas.");
        
}//Cierre eliminarReserva    
    
} //Cierre proyecto

