package model;

public class PlayFairModel {
    //Thuộc tính
    private String plainText;
    private String cipherText;
    private String key;
    private String[][] array;
    //---------------------------------

    // khởi tạo
    public PlayFairModel() {
    }

    public PlayFairModel(String plainText, String cipherText, String key, String[][] array) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
        this.array = initArray();
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

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }

    public String[][] initArray(){
        String[][] a =  new String[5][5];
        return a;
    }
    //---------------------------------
    
}
