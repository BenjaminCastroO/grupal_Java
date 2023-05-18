package clase11;
public class EjercicioGrupal11 {
  public static void main(String[] args) {
    final boolean VALOR_CONSTANTE = false;
    String mensaje = "Lorem ipsum dolor sit amet, consectetur adipiscing elit" +
            ". Donec facilisis est ac ante viverra, vel efficitur leo " +
            "consequat. Maecenas quis lorem sit amet diam " +
            "consequat lacinia non nec lacus. Phasellus egestas quam non dui " +
            "dictum, sed fermentum dolor efficitur. Aliquam volutpat ex " +
            "sodales pulvinar scelerisque. Donec sodales cursus tortor eu " +
            "aliquam. Curabitur id purus arcu. Vestibulum ante ipsum primis " +
            "in faucibus orci luctus et ultrices posuere cubilia curae; " +
            "Suspendisse pretium, quam non consectetur scelerisque, diam " +
            "tortor iaculis arcu, nec tincidunt diam eros sed urna. Ut at " +
            "consequat enim. Orci varius natoque penatibus et magnis dis " +
            "parturient montes, nascetur ridiculus mus. Donec sit amet " +
            "ultricies dui. Donec aliquet rhoncus velit et sollicitudin.";
    int cantidadValores = 10;
    for (int i = 0; i < cantidadValores; i++) {
      System.out.println("Valor: " + (i * i));
    }
    /* Esto es un comentario
      demasiado grande
      para que esté en una
      Sola línea
     */
    System.out.println("El mensaje es: ");
    System.out.println(mensaje.substring(0, 79));
    System.out.println(mensaje.substring(80, 159));
    System.out.println(mensaje.substring(160, 239));
    System.out.println(mensaje.substring(240, 319));
    System.out.println(mensaje.substring(320, 399));
    System.out.println(mensaje.substring(400, 479));
    System.out.println(mensaje.substring(480, 559));
    System.out.println(mensaje.substring(560, 639));
    System.out.println(mensaje.substring(640, 719));
    System.out.println(mensaje.substring(720));
    System.out.println("El valor de la constante es: " + VALOR_CONSTANTE);
  }
}
