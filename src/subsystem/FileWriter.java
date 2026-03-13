package subsystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {

    public void write(String filePath, String content) throws IOException {
        // Simulación de escritura en archivo (en realidad, no se escribe nada)
        System.out.println("[FileWriter] Escribiendo en archivo: " + filePath);
        Files.write(Paths.get(filePath), content.getBytes());
    }

}
