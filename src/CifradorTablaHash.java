import java.util.HashMap;

/**
 * The CifradorTablaHash class uses a HashMap to encrypt and decrypt messages
 * through a customized character mapping. This allows for flexible encryption
 * based on a user-defined character substitution table.
 */
public class CifradorTablaHash {
    // HashMap to store the encryption mapping of characters.
    private HashMap<Character, Character> taboaHash;

    /**
     * Constructor that accepts a custom hash table for character-based encryption.
     * 
     * @param tablaPersonalizada A HashMap with user-defined character mappings for
     *                           encryption.
     */
    public CifradorTablaHash(HashMap<Character, Character> tablaPersonalizada) {
        this.taboaHash = tablaPersonalizada; // Initialize the hash table with the provided mappings.
    }

    /**
     * Encrypts a message using the character mappings in the hash table.
     * 
     * @param mensaje The original message to encrypt.
     * @return The encrypted message as a String.
     */
    public String cifrar(String mensaje) {
        StringBuilder mensajeCifrado = new StringBuilder(); // StringBuilder for constructing the encrypted message.

        // Iterate over each character in the original message.
        for (char c : mensaje.toCharArray()) {
            // Obtain the encrypted character from the hash table.
            Character cifrado = taboaHash.get(c);

            // Append either the encrypted character or the original character
            // if it is not in the hash table.
            mensajeCifrado.append(cifrado != null ? cifrado : c);
        }

        return mensajeCifrado.toString(); // Return the encrypted message as a string.
    }

    /**
     * Decrypts an encrypted message using the character mappings in the hash table.
     * 
     * @param mensajeCifrado The encrypted message to decrypt.
     * @return The decrypted message as a String.
     */
    public String descifrar(String mensajeCifrado) {
        StringBuilder mensajeDescifrado = new StringBuilder(); // StringBuilder for constructing the decrypted message.

        // Create a reverse hash table to map encrypted characters back to the original
        // characters.
        HashMap<Character, Character> taboaInversa = new HashMap<>();
        for (HashMap.Entry<Character, Character> entry : taboaHash.entrySet()) {
            // Invert the key-value pairs in the hash table for decryption.
            taboaInversa.put(entry.getValue(), entry.getKey());
        }

        // Iterate over each character in the encrypted message.
        for (char c : mensajeCifrado.toCharArray()) {
            // Obtain the decrypted character from the inverted hash table.
            Character descifrado = taboaInversa.get(c);

            // Append either the decrypted character or the original encrypted character
            // if it is not in the inverted hash table.
            mensajeDescifrado.append(descifrado != null ? descifrado : c);
        }

        return mensajeDescifrado.toString(); // Return the decrypted message as a string.
    }

    /**
     * Main method demonstrating the usage of CifradorTablaHash for encrypting
     * and decrypting a sample message.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a hash table with ASCII values as an example.
        HashMap<Character, Character> tablaPersonalizada = new HashMap<>();

        // Populate the hash table to shift each character by 3 positions.
        for (char i = 0; i < 253; i++) {
            tablaPersonalizada.put(i, (char) (i + 3));
        }

        // Special handling for high ASCII values to avoid overflow.
        tablaPersonalizada.put((char) 253, (char) 0);
        tablaPersonalizada.put((char) 254, (char) 1);
        tablaPersonalizada.put((char) 255, (char) 2);

        // Instantiate CifradorTablaHash with the custom table.
        CifradorTablaHash cifrador = new CifradorTablaHash(tablaPersonalizada);

        // Define a sample message to encrypt and decrypt.
        String mensaje = "Hello, world!";

        // Encrypt the message.
        String mensajeCifrado = cifrador.cifrar(mensaje);

        // Decrypt the encrypted message.
        String mensajeDescifrado = cifrador.descifrar(mensajeCifrado);

        // Display original, encrypted, and decrypted messages.
        System.out.println("Original message: " + mensaje);
        System.out.println("Encrypted message: " + mensajeCifrado);
        System.out.println("Decrypted message: " + mensajeDescifrado);
    }
}
