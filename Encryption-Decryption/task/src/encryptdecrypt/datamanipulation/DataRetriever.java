package encryptdecrypt.datamanipulation;

import encryptdecrypt.datamanipulation.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DataRetriever {
    private String[] args;

    private Data data;

    public DataRetriever(String[] args) {
        this.args = args.clone();
        data = new Data();
        data.setMode(getMode());
        data.setKey(getKey());
        data.setText(getText());
        data.setLocation(getOutputLocation());
        data.setAlgorithm(getAlgorithm());
    }

    public final Data getData() {
        return data;
    }

    private String getMode() {
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                return args[i + 1];
            }
        }
        return new String("Failure");
    }

    private String getAlgorithm() {
        for (int i = 0; i < args.length; i++) {
            if ("-alg".equals(args[i])) {
                return args[i + 1];
            }
        }
        return "shift";
    }

    private int getKey() {
        for (int i = 0; i < args.length; i++) {
            if ("-key".equals(args[i])) {
                return Integer.parseInt(args[i + 1]);
            }
        }
        return 0;
    }

    private String getText() {
        for (int i = 0; i < args.length; i++) {
            if ("-data".equals(args[i])) {
                return args[i + 1];
            }
        }
        for (int i = 0; i < args.length; i++) {
            if ("-in".equals(args[i])) {
                return getDataFromFile(args[i+ 1]);
            }
        }
        return "";
    }

    private String getDataFromFile(String input) {
        File file = new File(input);
        if (file.isFile()) {
            try (Scanner scanner = new Scanner(file)) {
                input = scanner.nextLine();
                while (scanner.hasNextLine()) { input += scanner.nextLine(); };
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found");
            }
        }
        return input;
    }

    private File getOutputLocation() {
        File outputFile = null;
        for (int i = 0; i < args.length; i++) {
            if ("-out".equals(args[i])) {
                outputFile = new File(args[i + 1]);
            }
        }
        return outputFile;
    }
}
