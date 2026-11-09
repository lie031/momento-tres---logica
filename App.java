
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String[] clothingCollection = {"Jeans AirFlex", "Graphic Tee", "Denim Jacket", null, null};
        Scanner scanner = new Scanner(System.in);
        int menuOption;
        
        do {
            System.out.println("\n========================================");
            System.out.println("       CATÁLOGO DE PRENDAS - BODEGA     ");
            System.out.println("========================================");
            System.out.println(" 1. Listar colecciones en bodega");
            System.out.println(" 2. Buscar en el catálogo");
            System.out.println(" 3. Añadir prenda");
            System.out.println(" 4. Salir");
            System.out.println("----------------------------------------");
            System.out.print(" Por favor, seleccione una opción: ");
            
            menuOption = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------------------------");

            switch (menuOption) {
                case 1:
                    System.out.println("--- LISTADO DE PRENDAS ---");
                    listCatalog(clothingCollection);
                    break;
                    
                case 2:
                    System.out.print("Escriba el nombre de la referencia que quiere buscar: ");
                    String referenceName = scanner.nextLine();
                    boolean isFound = searchItem(clothingCollection, referenceName);
                    if (isFound) {
                        System.out.println("-> ¡Se ha encontrado en la coleccion!");
                    } else {
                        System.out.println("-> No se ha encontrado en la colección.");
                    }
                    break;
                
                case 3:
                    System.out.print("Escriba el nombre de la prenda que quiere agregar: ");
                    String garmentName = scanner.nextLine();
                    boolean isAdded = addGarment(clothingCollection, garmentName);
                    if (isAdded) {
                        System.out.println("-> ¡Producto agregado con éxito!");
                    } else {
                        System.out.println("-> No hay espacios disponibles para agregar.");
                    }
                    break;
                    
                case 4:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("-> Opción no válida. Intente de nuevo.");
            }

        } while (menuOption != 4);

        scanner.close();
    }

    public static void listCatalog(String[] collection) {
        for (String item : collection) {
            if (item != null) {
                System.out.println(" • " + item);
            }
        }
    }

    public static boolean searchItem(String[] batch, String targetName) {
        for (String item : batch) {
            if (item != null && targetName.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static boolean addGarment(String[] collection, String garmentName) {
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == null) {
                collection[i] = garmentName;
                return true;
            }
        }
        return false;
    }
}


