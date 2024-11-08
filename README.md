# Hash Table-based encryptor

## Description

The `CifradorTablaHash` class provides a simple way to encrypt and decrypt text messages using a customizable character mapping stored in a hash table (`HashMap`). This project demonstrates basic encryption and decryption where each character in a message is mapped to another character through a hash table. This encryption approach allows for easily customized mappings that can be tailored to specific security or obfuscation needs.

## Features

- **Custom Character Mapping**: Users can provide a custom hash map for encryption, allowing flexibility in defining the encryption "alphabet."
- **Bidirectional Encryption**: Enables both encryption and decryption by reversing the hash map.
- **Simple to Implement and Adapt**: Designed to allow experimentation with different character mappings for educational purposes.

## How It Works

1. **Character Mapping**: A hash table (`HashMap`) is used to map each character to another character for encryption. In the provided example, each ASCII character is shifted by 3, with special handling for high ASCII values (253, 254, 255).
2. **Encryption**: During encryption, each character of the message is replaced by its mapped counterpart in the hash table.
3. **Decryption**: For decryption, the hash table is reversed so that each encrypted character can be mapped back to its original character.

## Prerequisites

- Java 8 or higher.

## Usage

1. **Running the Program**

   Execute the following command to run the main program:
   ```bash
   java CifradorTablaHash
   ```

2. **Example Output**
   ```
   Original message: Hello, world!
   Encrypted message: Khoor/#zruog$
   Decrypted message: Hello, world!
   ```

## Code Structure

### 1. `CifradorTablaHash`

- **Attributes**:
  - `taboaHash`: A hash table storing the custom character mapping for encryption.
  
- **Methods**:
  - `cifrar(String mensaje)`: Encrypts a message using the hash table.
  - `descifrar(String mensajeCifrado)`: Decrypts a message by reversing the hash table.
  
- **Example in `main()`**:
  - A sample character map is created where each character is shifted by three positions. 
  - A sample message (`Hello, world!`) is encrypted and decrypted to demonstrate functionality.

## Code Explanation

1. **Character Mapping Creation**:
   The custom mapping shifts each character in the ASCII range by 3 positions. Characters at the end of the ASCII table are wrapped around to avoid overflow.

2. **Encryption (`cifrar()`)**:
   Iterates over each character in the input string and maps it to a new character using the hash table.

3. **Decryption (`descifrar()`)**:
   Reverses the hash table to map each encrypted character back to its original character.

## Notes

- This example demonstrates encryption using simple character substitution, which is best suited for educational purposes.
- The class is flexible enough to be modified for more complex mappings if desired.