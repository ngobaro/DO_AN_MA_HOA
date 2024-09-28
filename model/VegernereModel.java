package model;

public class VegernereModel {
    // Thuộc tính
    private String plainText;
    private String cipherText;
    private String key;
    //---------------------------------

    //hàm khởi tạo
    public VegernereModel() {
    }

    public VegernereModel(String plainText, String cipherText, String key) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
    }
    //---------------------------------

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    //---------------------------------

    

}
