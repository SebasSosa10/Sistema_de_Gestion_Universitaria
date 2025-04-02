package Util;

/**
 *
 * @author JOAN
 */
public class prueba {

    public static void main(String[] args) {
//        Lista nuevo = new Lista();
//        nuevo.add("hola");
//        nuevo.add("JD");
//        nuevo.add("1234");
//        nuevo.add("sosa");
//        
//        nuevo.remove(1);
//        for (int i = 0; i < nuevo.size(); i++) {
//            System.out.println(nuevo.get(i));
//        }

        IList<String> lista = new Lista<>();
        lista.add("primero");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));

        }

//        IList<int> lista1 = new IList<>();
//        lista1.add(12);
//
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//
//        }
    }

}
