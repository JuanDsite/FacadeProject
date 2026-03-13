package subsystem;

public class FileEncryptor {

        private static final int SHIFT = 3; // cifrado César simple

    public String encrypt(String text) {
        System.out.println("[FileEncryptor] Cifrando contenido...");
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }
        return encrypted.toString();
    }
    
    public String decrypt(String text) {
        System.out.println("[FileEncryptor] Descifrando contenido...");
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            decrypted.append((char) (c - SHIFT));
        }
        return decrypted.toString();
    }

}
