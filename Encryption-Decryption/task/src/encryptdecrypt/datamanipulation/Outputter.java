package encryptdecrypt.datamanipulation;

import encryptdecrypt.datamanipulation.EncryptionFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Outputter extends EncryptionFactory {
    String output;

    public Outputter(String[] args) {
        super(args);
        output = performEncryption();
        System.out.println("Encrypted Data: " + retriever.getData().getText() + " " + output);
        outputData();
    }

    private void outputData() {
        File outputFile = retriever.getData().getLocation();
        if (outputFile != null) {
            try (FileWriter fileWriter = new FileWriter(outputFile)) {
                fileWriter.write(output);
            } catch (IOException e) {
                System.out.println("Error: Failed to write file");
            }
        } else {
            System.out.println(output);
        }
    }
}
