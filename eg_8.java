
import java.util.Scanner;

public class eg_8 {

    public static void main(String[] args){

        // se pide la cantidad de usuarios a ingresar
        int cantidad_usuarios = ingresaInt("¿Cuántos usuarios deseas ingresar?");

        // se pide el ingreso de los datos de usuario
        for (int i = 0; i < cantidad_usuarios; i++)
        {
            // CAMPOS COMUNES
            String nombre = ingresaString("Ingrese su nombre: ");
            String fecha_nacimiento = ingresaString("Ingrese su fecha de nacimiento: ");
            String run = ingresaString("Ingrese su RUN: ");

            System.out.println("Su nombre es: " + nombre);
            System.out.println("Su fecha de nacimiento es: " + fecha_nacimiento);
            System.out.println("Su run es: " + run);

            String tipo = ingresaString("Ingrese el tipo de usuario: (1) para cliente, (2) para profesional y " +
                    "(3) para administrativo");
            if (tipo.equals("1")) {
                // CLIENTES
                String direccion = ingresaString("Ingrese su dirección: ");
                String numeroTelefono = ingresaString("Ingrese su número de teléfono: ");
                String cantidad_empleados = ingresaString("Ingrese la cantidad de empleados: ");

                System.out.println("Su dirección es: " + direccion);
                System.out.println("Su número de teléfono es: " + numeroTelefono);
                System.out.println("La cantidad de empleados del cliente es: " + cantidad_empleados);
            }
            if (tipo.equals("2")) {
                //PROFESIONALES
                String anios_experiencia = ingresaString("Ingrese sus años de experiencia: ");
                String departamento = ingresaString("Ingrese su departamento: ");
                System.out.println("Ud tiene " + anios_experiencia + " años de experiencia.");
                System.out.println("Su departamento es: " + departamento);
            }

            if (tipo.equals("3")) {
                //ADMINISTRATIVOS
                String funcion = ingresaString("Ingrese su función: ");
                String nombre_superior = ingresaString("Ingrese el nombre de su superior: ");
                System.out.println("Su función es: " + funcion);
                System.out.println("El nombre de su superior es: " + nombre_superior);
            }

        }

    }



    public static String ingresaString(String mensaje)
    {
        System.out.println(mensaje);
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        return scan.next();
    }
    public static int ingresaInt(String mensaje)
    {
        System.out.println(mensaje);
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        return scan.nextInt();
    }

}
