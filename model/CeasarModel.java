package model;

/**
 * CeasarModel
 */
public class CeasarModel {
    // Thuộc tính
    private String plainText;
    private String cipherText;
    private int key;
    // ---------------------------------

    // Thuộc Tính
    public CeasarModel() {
        key = 0;
    }

    public CeasarModel(String plainText, String cipherText, int key) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
    }
    // ---------------------------------

    // hàm geter và seter
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    // ---------------------------------

}