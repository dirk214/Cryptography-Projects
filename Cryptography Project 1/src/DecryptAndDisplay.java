import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

/**
 * This will attempt to decrypt and display the text supplied from MATH 4175 HW 1.
 * @author Andrew Herbert
 * @version Sep 4, 2017
 */
public class DecryptAndDisplay {

    /**
     * The text to decipher.
     */
    private static final String encryptedText = "AVMXISYXEGPIEVWXEXIQIRXSJCSYVIBTIGXEXMSRWALIRCSYWMKRIHYTJSVXLMWGPEWW. TVMRXSYXEGSTCERHOIITMXMREWEJITPEGI. HSRSXLERHMXMR.";
    
    /**
     * The standard lower case alphabet used to shift the elements.
     */
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    /**
     * The main method used to execute the decryption. 
     * @param args Is just here to begin the method and has no specific use in this program.
     * @throws IOException If an problem with the Input or Output is encountered.
     */
    public static void main(String[] args) throws IOException {
        File output = new File("Output.txt");
        FileWriter fileWriter = new FileWriter(output);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Decryption Results : \n\n");
        String lowerText = encryptedText.toLowerCase();
        for (int i = 0; i <= 26; i++) {
            bufferedWriter.write(decrypt(lowerText, i) + " : " + i + "\n\n");
        }
        bufferedWriter.close();
    }

    /**
     * The decryption function.
     * @param cipherText The text to decrypt.
     * @param shiftKey The key to shift by.
     * @return The decrypted text.
     */
    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = alphabet.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) keyVal = alphabet.length() + keyVal;
            char replaceVal = alphabet.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
    
}
