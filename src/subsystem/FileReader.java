package subsystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public String read(String filePath) throws IOException {
        // Simulación de lectura de archivo (en realidad, no se lee nada)
        System.out.println("[FileReader] Simulando lectura del archivo: " + filePath);
        return new String(Files.readAllBytes(Paths.get(filePath)));// Retorna un contenido cifrado simulado
    }

}
