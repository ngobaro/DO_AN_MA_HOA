package model;

public class TranspositionModel {
    // thuộc tính
    private String plaintext;
    private String ciphertext;
    private String key;
    //---------------------------------
    
    // hàm khởi tạo
    public TranspositionModel() {
    }

    public TranspositionModel(String plaintext, String ciphertext, String key) {
        this.plaintext = plaintext;
        this.ciphertext = ciphertext;
        this.key = key;
    }
    //---------------------------------

    //hàm geter và hàm seter
    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
     //---------------------------------

    
}
