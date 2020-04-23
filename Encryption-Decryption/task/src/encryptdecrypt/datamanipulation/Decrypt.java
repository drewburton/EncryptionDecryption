package encryptdecrypt.datamanipulation;

import encryptdecrypt.datamanipulation.DataShifter;

class Decrypt extends DataShifter {
    public Decrypt(String data, int key, String algorithm) {
        super(data, key, algorithm);
    }

    @Override
    protected String unicode() {
        StringBuilder newString = new StringBuilder();
        for (char letter : data.toCharArray()) {
            newString.append((char) (letter - key));
        }
        return newString.toString();
    }

    @Override
    protected String shift() {
        StringBuilder newString = new StringBuilder();
        for (char letter : data.toCharArray()) {
            if (Character.toUpperCase(letter) < 'A' || Character.toUpperCase(letter) > 'Z') {
                newString.append(letter);
                continue;
            }

            char newLetter = (char) (Character.toUpperCase(letter) - key);

            if (newLetter < 'A') {
                newLetter += 26;
            }

            if (Character.isLowerCase(letter)) {
                newLetter = Character.toLowerCase(newLetter);
            }

            newString.append(newLetter);
        }
        return newString.toString();
    }
}
