package client;

import facade.Facade;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {

    public static void main(String[] args) {
        String inputPath  = "File/input.txt";
        String outputPath = "File/output_encrypted.txt";

        try {
            // Crea la carpeta File si no existe
            Files.createDirectories(Paths.get("File"));

            // Crea input.txt con texto de prueba si no existe
            if (!Files.exists(Paths.get(inputPath))) {
                Files.write(Paths.get(inputPath), "¡Hola, patrón Facade en Java!".getBytes());
                System.out.println("=== input.txt creado con texto de prueba.");
            }

            Facade facade = Facade.getInstance();

            System.out.println("=== Cifrando: " + inputPath);
            facade.encryptFile(inputPath, outputPath);
            System.out.println("=== Archivo cifrado guardado en: " + outputPath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}