package encryptdecrypt.datamanipulation;

import encryptdecrypt.datamanipulation.DataRetriever;
import encryptdecrypt.datamanipulation.DataShifter;
import encryptdecrypt.datamanipulation.Decrypt;
import encryptdecrypt.datamanipulation.Encrypt;

class EncryptionFactory {
    protected DataRetriever retriever;

    protected EncryptionFactory(String[] args) {
        retriever = new DataRetriever(args);
    }

    protected final String performEncryption() {
        String mode = retriever.getData().getMode();
        int key = retriever.getData().getKey();
        String input = retriever.getData().getText();
        String algorithm = retriever.getData().getAlgorithm();

        DataShifter shifter;
        if ("enc".equals(mode) || "Failure".equals(mode)) {
            shifter = new Encrypt(input, key, algorithm);
        } else {
            shifter = new Decrypt(input, key, algorithm);
        }

        return shifter.encrypt();
    }
}
