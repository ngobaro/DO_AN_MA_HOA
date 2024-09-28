package model;

public class SubstitutionModel {
    // thuộc tính
    private String plaintext;
    private String ciphertext;
    //---------------------------------

    // hàm khởi tạo
    public SubstitutionModel() {
    }


    public SubstitutionModel(String plaintext, String ciphertext) {
        this.plaintext = plaintext;
        this.ciphertext = ciphertext;
    }
    //---------------------------------

    //hàm geter và seter 
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
    //---------------------------------
    


    
}
