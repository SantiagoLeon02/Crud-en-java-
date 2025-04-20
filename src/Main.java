import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        ArrayList<String> listProductos = new ArrayList<>();

        while(continuar){

            System.out.println("------Menu------");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Revisar la lista de procutos");
            System.out.println("3. Modificar un producto");
            System.out.println("4. Eliminar un producto o eliminar todo");
            System.out.println("5. Salir");

            System.out.print("Escoge una opcion: ");
            int opcion = scan.nextInt();

            scan.nextLine();

                switch (opcion){
                    case 1:
                        while(true){
                            System.out.print("Ingresa un producto: ");
                            String producto = scan.nextLine().trim().toLowerCase();
                            listProductos.add(producto);
                            System.out.println("Producto agregado.");

                            System.out.println("Deseas agregar otro producto? Si/No");
                            String respuesta = scan.nextLine().trim().toLowerCase();

                            if (respuesta.equals("no")){
                                System.out.println("Regresando al menu");
                                break;
                            }
                        }
                    break;

                    case 2:
                        System.out.println("Revision de productos");

                        if(listProductos.isEmpty()){
                            System.out.println("No ha productos agregados");
                        }else{
                            for(int i =0; i<listProductos.size(); i++){
                                System.out.println(listProductos.get(i));
                            }
                        }
                    break;

                    case 3:
                        while(true){

                            System.out.println("Lista de productos");
                            for(int i =0; i<listProductos.size(); i++){
                                System.out.println((i+1)+": "+listProductos.get(i));
                            }

                            System.out.println("Que producto quieres modificar? ");
                            String viejo = scan.nextLine();

                            if(listProductos.contains(viejo)){
                                int i = listProductos.indexOf(viejo);
                                System.out.println("Digite el nuevo valor");
                                String nuevo = scan.nextLine();
                                listProductos.set(i, nuevo);
                                System.out.println("Producto modificado con exito success");
                            }else {
                                System.out.println("Producto no encontrado");
                            }

                            System.out.println("Desea modificar otro prodcuto? si/no");
                            String respuestaMOdficar = scan.nextLine().trim().toLowerCase();

                            if(respuestaMOdficar.equals("no")){
                                System.out.println("volviendo al menu");
                                break;
                            }
                        }

                    break;

                    case 4: {

                        boolean continuarEliminacion = true;

                        while(continuarEliminacion){
                            System.out.println("Menu");
                            System.out.println("1. Eliminar un producto");
                            System.out.println("2. vaciar por completo");
                            System.out.println("3. Volver al menu principal");
                            System.out.println("Digite una opcion");
                            int valorEliminar = scan.nextInt();

                            scan.nextLine();

                            switch (valorEliminar){
                                case 1:
                                    for (int i =0; i< listProductos.size(); i++){
                                        System.out.print((i+1)+": "+listProductos.get(i));
                                    }

                                    System.out.println("Ingrese el producto a eliminar");
                                    String productoEliminar = scan.nextLine();

                                    if(listProductos.contains(productoEliminar)){
                                        listProductos.remove(productoEliminar);
                                        System.out.println("Producto eliminado");
                                    }else {
                                        System.out.println("Producto no encontrado");
                                    }
                                break;

                                case 2:
                                    System.out.println("Desea eliminar todos los productos de la lista?");
                                    System.out.println("Esta opcion es irreversible");
                                    System.out.println("Digite si/no");
                                    String eliminarTodo = scan.nextLine();

                                    if(eliminarTodo.equals("si")){
                                        listProductos.clear();
                                        System.out.println("todos los productos fueron eliminados");
                                    }
                                break;

                                case 3: continuarEliminacion = false;
                                    System.out.println("Volviendo al menu principal");
                                break;
                            }
                        }
                     break;
                    }

                    case 5:
                        continuar = false;
                        System.out.println("Saliendo del programa. ");
                        System.out.println("Adios");
                    break;

                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
        }
        scan.close();
    }
}
