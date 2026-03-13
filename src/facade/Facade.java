package facade;

import java.io.IOException;
import subsystem.FileEncryptor;
import subsystem.FileReader;
import subsystem.FileWriter;

public class Facade {

    private static Facade instance;

    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FileEncryptor fileEncryptor;

    private Facade() {
        this.fileReader    = new FileReader();
        this.fileWriter    = new FileWriter();
        this.fileEncryptor = new FileEncryptor();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    // Lee un archivo, cifra su contenido y lo guarda en otro archivo
    public void encryptFile(String inputPath, String outputPath) throws IOException {
        String content   = fileReader.read(inputPath);
        String encrypted = fileEncryptor.encrypt(content);
        fileWriter.write(outputPath, encrypted);
    }

    // Lee un archivo cifrado, lo descifra y lo guarda en otro archivo
    public void decryptFile(String inputPath, String outputPath) throws IOException {
        String content   = fileReader.read(inputPath);
        String decrypted = fileEncryptor.decrypt(content);
        fileWriter.write(outputPath, decrypted);
    }
}
