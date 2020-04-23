package encryptdecrypt.datamanipulation;

abstract class DataShifter {
    protected String data;
    protected int key;
    protected String algorithm;

    public DataShifter(String data, int key, String algorithm) {
        this.data = data;
        this.key = key;
        this.algorithm = algorithm;
    }

    public final String encrypt() {
        if ("unicode".equals(algorithm)) {
            return unicode();
        } else {
            return shift();
        }
    }

    protected abstract String unicode();

    protected abstract String shift();
}
