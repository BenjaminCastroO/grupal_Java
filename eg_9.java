import java.util.*;

public class eg_9 {
    public static void main(String[] args)
    {
        // se llama a una función que dimensiona el arreglo.
        String[][] matrix = creaArreglo();
        int opcion = mostrar_menu();
        opcion_menu(opcion, matrix);
        mostrar_usuarios(matrix);

    }

    public static String[][] creaArreglo()
    {
        System.out.println("Se está creando un arreglo . . .");
        // se definen dimensiones 10 filas 10 columnas
        return new String[10][10];
    }

    public static int mostrar_menu()
    {
        boolean valido = false;
        int opcion = 0;
        do {
            System.out.println("Menú principal");
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("(1) Registrar usuario");
            System.out.println("(2) Mostrar usuarios");
            System.out.println("(3) Contar usuarios por categoría");
            System.out.println("(4) Modificar usuario");
            System.out.println("(5) Eliminar usuario");
            System.out.println("(6) Salir");
            String respuesta = leer("Ingrese una opción");
            valido = leer_solo_num(respuesta);
            if (valido)
            {
                opcion = Integer.parseInt(respuesta);
                if(opcion < 1 || opcion > 6) {
                    System.out.println("Ingresa un número válido (1, 2, 3, 4, 5, 6)");
                    valido = false;
                }
            }
        } while (!valido);
        return opcion;
    }

    public static void opcion_menu(int opcion, String[][] matriz)
    {
        switch (opcion) {
            case 1 -> registrar_usuario(matriz,0);
            case 2 -> mostrar_usuarios(matriz);
            case 3 -> contar_usuarios_categoria(matriz);
            case 4 -> System.out.println("Ingresaste la opción: Modificar usuario");
            case 5 -> System.out.println("Ingresaste la opción: Eliminar usuario");
            case 6 -> System.out.println("Ingresaste la opción: Salir");
        }
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
                System.out.println("Debes ingresar un número, no se permiten caracteres.");
            }
        }
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
    public static String[][] registrar_usuario(String[][] matriz, int indice)
    {
        String respuesta;
        int respuesta_a_numero;
        boolean validado;
        // leer nombre
        matriz[indice][0] = ingresar_nombre();
        // leer fecha de nacimiento
        matriz[indice][1] = ingresar_fecha_de_nacimiento();
        // leer RUT
        matriz[indice][2] = ingresar_rut();
        // leer tipo de usuario
        matriz[indice][3] = ingresar_tipo_usuario();

        // leer campos tipo cliente
        if(matriz[indice][3].equals("1"))
        {
            matriz[indice][3] = "Cliente";
            matriz[indice][4] = ingresar_cliente_direccion();
            matriz[indice][5] = ingresar_cliente_telefono();
            matriz[indice][6] = ingresar_cliente_empleados();
        }
        // leer campos tipo Profesional
        if(matriz[indice][3].equals("2"))
        {
            matriz[indice][3] = "Profesional";
            matriz[indice][4] = ingresar_profesional_experiencia();
            matriz[indice][5] = ingresar_profesional_depto();
        }
        // leer campos tipo Administrativo
        if(matriz[indice][3].equals("3"))
        {
            matriz[indice][3] = "Administrativo";
            matriz[indice][4] = ingresar_administrativo_funcion();
            matriz[indice][5] = ingresar_administrativo_superior();
        }
        return matriz;
    }

    public static String ingresar_nombre() {
        String respuesta;
        do {
            respuesta = leer("Ingresa nombre del usuario");
        } while (!((leer_solo_char(respuesta) && leer_no_vacio(respuesta))));
        return respuesta;
    }
    public static String ingresar_fecha_de_nacimiento() {
        String respuesta;
        do {
            respuesta = leer("Ingresa fecha de nacimiento del usuario");
        } while (!(leer_no_vacio(respuesta)));
        return respuesta;
    }
    public static String ingresar_rut() {
        String respuesta;
        do {
            respuesta = leer("Ingresa el rut del usuario");
        } while (!(leer_no_vacio(respuesta)));
        return respuesta;
    }
    public static String ingresar_tipo_usuario(){
        String respuesta;
        do {
            System.out.println("Ingresa el tipo de usuario:");
            System.out.println("(1) para Cliente");
            System.out.println("(2) para Profesional");
            System.out.println("(3) para Administrativo");
            respuesta = leer("Ingresa el tipo de usuario");
            if (!(respuesta.equals("1") || respuesta.equals("2") || respuesta.equals("3")))
            {
                System.out.println("Ingresa una opción correcta.");
            }
        } while (!((leer_no_vacio(respuesta)) && leer_solo_num(respuesta)));
        return respuesta;
    }
    public static String ingresar_cliente_direccion(){
        String respuesta;
        do {
            respuesta = leer("Ingresa direccion del usuario");
        } while (!(leer_no_vacio(respuesta)));
        return respuesta;
    }
    public static String ingresar_cliente_telefono(){
        String respuesta;
        do {
            respuesta = leer("Ingresa número telefónico del usuario");
        } while (!(leer_no_vacio(respuesta) && leer_solo_num(respuesta)));
        return respuesta;
    }
    public static String ingresar_cliente_empleados(){
        String respuesta;
        do {
            respuesta = leer("Ingresa cantidad de empleados del usuario");
        } while (!(leer_no_vacio(respuesta) && leer_solo_num(respuesta)));
        return respuesta;
    }
    public static String ingresar_profesional_experiencia(){
        String respuesta;
        do {
            respuesta = leer("Ingresa años de experiencia del usuario");
        } while (!(leer_no_vacio(respuesta) && leer_solo_num(respuesta)));
        return respuesta;
    }
    public static String ingresar_profesional_depto() {
        String respuesta;
        do {
            respuesta = leer("Ingresa departamento del usuario");
        } while (!(leer_no_vacio(respuesta)));
        return respuesta;
    }
    public static String ingresar_administrativo_funcion() {
        String respuesta;
        do {
            respuesta = leer("Ingresa la función del usuario");
        } while (!((leer_solo_char(respuesta) && leer_no_vacio(respuesta))));
        return respuesta;
    }
    public static String ingresar_administrativo_superior() {
        String respuesta;
        do {
            respuesta = leer("Ingresa el nombre del superior del usuario");
        } while (!((leer_solo_char(respuesta) && leer_no_vacio(respuesta))));
        return respuesta;
    }

    public static void mostrar_usuarios(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }
    public static void contar_usuarios_categoria(String[][] matriz){
        int clientes, profesionales, administrativos;
        clientes = 0;
        profesionales = 0;
        administrativos = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (matriz[i][3].equals("Cliente")) clientes ++;
                if (matriz[i][3].equals("Profesional")) profesionales ++;
                if (matriz[i][3].equals("Aministrativo")) administrativos ++;
            }
        }
        System.out.println("la cantidad de usuarios clientes son: " + clientes);
        System.out.println("la cantidad de usuarios profesionales son: " + profesionales);
        System.out.println("la cantidad de usuarios administrativos son: " + administrativos);
    }

}