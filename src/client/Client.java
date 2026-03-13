package client;

import facade.Facade;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {

    public static void main(String[] args) {
        String inputPath     = "File/input.txt";
        String encryptedPath = "File/output_encrypted.txt";
        String decryptedPath = "File/output_decrypted.txt";

        try {
            // Crea la carpeta File si no existe
            Files.createDirectories(Paths.get("File"));

            // Crea input.txt con texto de prueba si no existe
            if (!Files.exists(Paths.get(inputPath))) {
                Files.write(Paths.get(inputPath), "¡Hola, patrón Facade en Java!".getBytes());
                System.out.println("=== input.txt creado con texto de prueba.");
            }

            Facade facade = Facade.getInstance();

            // Cifrar
            System.out.println("\n=== Cifrando: " + inputPath);
            facade.encryptFile(inputPath, encryptedPath);
            System.out.println("=== Archivo cifrado guardado en: " + encryptedPath);

            // Descifrar
            System.out.println("\n=== Descifrando: " + encryptedPath);
            facade.decryptFile(encryptedPath, decryptedPath);
            System.out.println("=== Archivo descifrado guardado en: " + decryptedPath);

            // Verificar
            String original  = new String(Files.readAllBytes(Paths.get(inputPath)));
            String decrypted = new String(Files.readAllBytes(Paths.get(decryptedPath)));

            System.out.println("\n=== Contenido original:    " + original);
            System.out.println("=== Contenido descifrado:  " + decrypted);
            System.out.println("=== ¿Son iguales? " + original.equals(decrypted));

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}