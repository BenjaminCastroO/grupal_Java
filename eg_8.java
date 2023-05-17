import java.net.StandardSocketOptions;
import java.util.Scanner;

public class EG_8 {
    public static void main(String[] args) {
        // Se define el arreglo matrix como un arreglo String de 10 filas y 10 columnas
        String[][] matrix = new String[10][10];
        int opcion;
        do {
            opcion = mostrar_menu();
            matrix = opcion_menu(opcion, matrix);
        } while (opcion != 6);

        String xd = "asd";
        
    }
    public static int mostrar_menu()
    {
        int opcion = 0;
        boolean valido = false;
        do {
            System.out.println("Menú principal");
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("(1) Registrar usuario");
            System.out.println("(2) Mostrar usuarios");
            System.out.println("(6) Salir");
            String respuesta = leer("Ingrese una opción");
            if (leer_solo_num(respuesta))
            {
                opcion = Integer.parseInt(respuesta);
                if(opcion != 1 && opcion != 2 && opcion !=6) System.out.println("Ingresa un número válido (1, 2, 6)");
                else valido = true;
            }
        } while (!valido);
        return opcion;
    }
    public static String[][] opcion_menu(int opcion, String[][] matriz)
    {
        switch (opcion) {
            case 1 -> matriz = registrar_usuario(matriz, contar_registros(matriz));
            case 2 -> mostrar_usuarios(matriz);
            case 6 -> System.out.println("Ingresaste la opción: Salir");
        }
        return matriz;
    }
    public static void mostrar_usuarios(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (matriz[i][j] != null) System.out.print("[" + matriz[i][j] + "]");
            }
            if (matriz[i][0] != null) System.out.println("");
        }
    }
    public static String[][] registrar_usuario(String[][] matriz, int indice)
    {
        String respuesta;
        int respuesta_a_numero;
        boolean validado;
        // leer campos comunes: nombre, fecha de nacimiento, rut y tipo de usuario.
        matriz[indice][0] = ingresar_char_noVacio("Ingrese el nombre del usuario");
        matriz[indice][1] = ingresar_noVacio("Ingrese la fecha de nacimiento del usuario");
        matriz[indice][2] = ingresar_num_noVacio("Ingrese el rut del usuario sin puntos, ni guión ni digito verificador");
        matriz[indice][3] = ingresar_tipo_usuario();

        // leer campos tipo cliente
        if(matriz[indice][3].equals("1"))
        {
            matriz[indice][3] = "Cliente";
            matriz[indice][4] = ingresar_noVacio("Ingrese la dirección del cliente");
            matriz[indice][5] = ingresar_noVacio("Ingrese el número de teléfono del cliente");
            matriz[indice][6] = ingresar_num_noVacio("Ingrese la cantidad de empleados de la empresa cliente");
        }
        // leer campos tipo Profesional
        if(matriz[indice][3].equals("2"))
        {
            matriz[indice][3] = "Profesional";
            matriz[indice][4] = ingresar_num_noVacio("Ingrese los años de experiencia del profesional");
            matriz[indice][5] = ingresar_noVacio("Ingrese el departamento al cual pertenece el profesional");
        }
        // leer campos tipo Administrativo
        if(matriz[indice][3].equals("3"))
        {
            matriz[indice][3] = "Administrativo";
            matriz[indice][4] = ingresar_char_noVacio("Ingrese la función del administrativo");
            matriz[indice][5] = ingresar_char_noVacio("Ingrese el nombre del superior del administrativo");
        }
        return matriz;
    }
    public static String ingresar_tipo_usuario(){
        String respuesta;
        boolean valido = true;
        do {
            System.out.println("Ingresa el tipo de usuario:");
            System.out.println("(1) para Cliente");
            System.out.println("(2) para Profesional");
            System.out.println("(3) para Administrativo");
            respuesta = leer("Ingresa el tipo de usuario");
            if (!(respuesta.equals("1") || respuesta.equals("2") || respuesta.equals("3")))
            {
                System.out.println("Ingresa una opción correcta.");
                valido = false;
            }
        } while (!((leer_no_vacio(respuesta)) && leer_solo_num(respuesta)) && valido);
        return respuesta;
    }
    public static String ingresar_char_noVacio(String mensaje) {
        String respuesta;
        do {
            respuesta = leer(mensaje);
        } while (!((leer_solo_char(respuesta) && leer_no_vacio(respuesta))));
        return respuesta;
    }
    public static String ingresar_num_noVacio(String mensaje){
        String respuesta;
        do {
            respuesta = leer(mensaje);
        } while (!(leer_no_vacio(respuesta) && leer_solo_num(respuesta)));
        return respuesta;
    }
    public static String ingresar_noVacio(String mensaje) {
        String respuesta;
        do {
            respuesta = leer(mensaje);
        } while (!(leer_no_vacio(respuesta)));
        return respuesta;
    }
    public static String leer(String mensaje)
    {
        System.out.println(mensaje);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static boolean leer_solo_num(String ingreso)
    {
        String car;
        boolean valido = true;
        for (int i = 0; i < ingreso.length(); i++) {
            car = ingreso.substring(i,i+1);
            if (!(car.equals("0") || car.equals("1") || car.equals("2") || car.equals("3") ||
                    car.equals("4") || car.equals("5") || car.equals("6") ||
                    car.equals("7") || car.equals("8") || car.equals("9")))
            {
                valido = false;
            }
        }
        if (!valido) System.out.println("Debes ingresar un número, no se permiten caracteres.");
        return valido;
    }
    public static boolean leer_solo_char(String ingreso)
    {
        String car;
        boolean valido = true;
        for (int i = 0; i < ingreso.length(); i++) {
            car = ingreso.substring(i,i+1);
            if ((car.equals("0") || car.equals("1") || car.equals("2") || car.equals("3") ||
                    car.equals("4") || car.equals("5") || car.equals("6") ||
                    car.equals("7") || car.equals("8") || car.equals("9")))
            {
                valido = false;
                System.out.println("Debes ingresar caracteres, no se permiten números.");
            }
        }
        return valido;
    }

    public static boolean leer_no_vacio(String ingreso)
    {
        if (ingreso.equals("")) System.out.println("Este campo es obligatorio");
        return !ingreso.equals("");
    }

    public static int contar_registros(String[][] matriz)
    {
        int contador= 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null) contador++;
        }
        return contador;
    }

}

