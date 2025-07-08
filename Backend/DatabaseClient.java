import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class DatabaseClient {
    public static void main(String[] args) {

        // Definir uma query padrão caso nenhum argumento seja fornecido
        String query = "SELECT * FROM  Medicos m ;"; // Exemplo de query padrão

        if (args.length >= 1) {
            query = args[0];
        } else {
            System.out.println("Nenhuma query fornecida. Usando query padrão: " + query);
        }

        try {
            // Localizar o registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");

            // Fazer a query ao servidor
            List<String> results = service.queryDatabase(query);
            for (String result : results) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
