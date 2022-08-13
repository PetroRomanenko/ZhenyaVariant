package ZhenyaVariant;

public class Field {
    private final String[] VALUES = new String[9];

    public void setValue(int index, String value) {
        this.VALUES[index] = value;
    }

    public String getValue(int index) {
        return VALUES[index];
    }

    public void showField() {
        System.out.println(Arrays.toString(VALUES);
    }
}
