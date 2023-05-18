import java.util.*;

public class EG_10 {
    public static String[][] creaArreglo() {
        System.out.println("Se está creando un arreglo . . .");
        // se definen dimensiones 10 filas 10 columnas
        return new String[10][11];
    }

    public static String leer(String mensaje) {
        System.out.println(mensaje);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String ingresar_num_noVacio(String mensaje) {
        String respuesta;
        do {
            respuesta = leer(mensaje);
        } while (!(leer_no_vacio(respuesta) && leer_solo_num(respuesta)));
        return respuesta;
    }

    public static String ingresar_char_noVacio(String mensaje) {
        String respuesta;
        do {
            respuesta = leer(mensaje);
        } while (!((leer_solo_char(respuesta) && leer_no_vacio(respuesta))));
        return respuesta;
    }

    public static String ingresar_noVacio(String mensaje) {
        String respuesta;
        do {
            respuesta = leer(mensaje);
        } while (!(leer_no_vacio(respuesta)));
        return respuesta;
    }

    public static boolean leer_no_vacio(String ingreso) {
        if (ingreso.equals("")) System.out.println("Este campo es obligatorio");
        return !ingreso.equals("");
    }

    public static boolean leer_solo_char(String ingreso) {
        String car;
        boolean valido = true;
        for (int i = 0; i < ingreso.length(); i++) {
            car = ingreso.substring(i, i + 1);
            if ((car.equals("0") || car.equals("1") || car.equals("2") || car.equals("3") ||
                    car.equals("4") || car.equals("5") || car.equals("6") ||
                    car.equals("7") || car.equals("8") || car.equals("9"))) {
                valido = false;
                System.out.println("Debes ingresar caracteres, no se permiten números.");
            }
        }
        return valido;
    }

    public static boolean leer_solo_num(String ingreso) {
        String car;
        boolean valido = true;
        for (int i = 0; i < ingreso.length(); i++) {
            car = ingreso.substring(i, i + 1);
            if (!(car.equals("0") || car.equals("1") || car.equals("2") || car.equals("3") ||
                    car.equals("4") || car.equals("5") || car.equals("6") ||
                    car.equals("7") || car.equals("8") || car.equals("9"))) {
                valido = false;
            }
        }
        if (!valido)
            System.out.println("Debes ingresar un número, no se permiten caracteres.");
        return valido;
    }

    public static String capacitacionAsistentes() {
        String respuesta;
        do {
            respuesta = leer("Ingresa Cantidad Asistentes Capacitacion");
        } while (!(leer_no_vacio(respuesta) && leer_solo_num(respuesta)));
        return respuesta;
    }

    public static int ingresarAsistentes() {
        int respuesta;
        respuesta = Integer.parseInt(capacitacionAsistentes());
        return respuesta;
    }

    public static void mostrarDatos(String[][] matriz) {
        int j;
        for (int i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[i].length; j++) {
                if (!(matriz[i][j] == null)) {
                    System.out.print("[" + matriz[i][j] + "]");
                }
            }
            if (!(matriz[i][j - 1] == null)) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        boolean salida = false;
        String[][] matrisAsistente = new String[50][3];
        String[][] matrix = creaArreglo();
        do {
            matrix[i][0] = ingresar_char_noVacio("Ingrese Nombre Capacitacion:");//nombre capacitacion
            matrix[i][1] = ingresar_noVacio("Ingrese RUT Cliente:");// Rut
            matrix[i][2] = ingresar_char_noVacio("Ingrese Nombre Cliente:");// Ingresar Nombre Cliente
            matrix[i][3] = ingresar_noVacio("Ingrese Direccion:"); // Ingresar Direccion
            matrix[i][4] = ingresar_char_noVacio("Ingrese Comuna:"); // Ingresar Comuna
            matrix[i][5] = ingresar_num_noVacio("Ingrese Numero Telefono: ");
            matrix[i][6] = ingresar_noVacio("Ingrese Dia Capacitacion:"); // Dia Capacitacion
            matrix[i][7] = ingresar_noVacio("Ingrese Hora:"); // Hora
            matrix[i][8] = ingresar_noVacio("Ingrese Lugar:");// Lugar
            matrix[i][9] = ingresar_num_noVacio("Ingrese Duracion (hrs):");//Duracion
            matrix[i][10] = ingresar_num_noVacio("Ingrese Cantidad Asistentes:");// Cantidad Asistentes
            matrisAsistente = rellena_asistentes(matrisAsistente, matrix[i][0], matrix[i][10]);
            System.out.println("matriz de capacitaciones:");
            mostrarDatos(matrix);
            System.out.println("matriz de asistentes:");
            mostrarDatos(matrisAsistente);
            contar_usuarios(matrisAsistente, Integer.parseInt(matrix[i][10]));
            i++;
            if (ingresar_char_noVacio("Ingrese Q si desea salir del programa").equals("Q")) salida = true;
        } while (!salida);
    }
    public static void contar_usuarios(String[][] matriz, int cantidad){
        double promedio = 0;
        int max = 0;
        int min = 1;
        for (int i = 0; i < cantidad; i++) {
            promedio = promedio + Integer.parseInt(matriz[i][2]);
            max = Math.max(max,Integer.parseInt(matriz[i][2]));
            min = Math.min(min,Integer.parseInt(matriz[i][2]));
        }
        System.out.println("El promedio de las notas es: " + promedio/cantidad);
        System.out.println("La nota máxima es: " + max);
        System.out.println("La nota mínima es: " + min);
    }
    public static String[][] rellena_asistentes(String[][] matriz, String nombre_capacitacion, String asistentes) {
        int cantidad = Integer.parseInt(asistentes);
        for (int i = 0; i < cantidad; i++) {
            matriz[i][0] = nombre_capacitacion;
            matriz[i][1] = ingresar_char_noVacio("Ingrese el nombre del asistente");
            do {
                matriz[i][2] = ingresar_num_noVacio("Ingresa la nota (debe " +
                        "ser entre 1 y 7)");
            } while (!(Integer.parseInt(matriz[i][2]) > 0 && Integer.parseInt(matriz[i][2]) < 8));
        }
        return matriz;
    }
}
