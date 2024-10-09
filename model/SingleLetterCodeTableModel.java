package model;

public class SingleLetterCodeTableModel {
    private String key;
    private String plainText;
    private String cipherText;

    // Constructor
    public SingleLetterCodeTableModel() {
        cipherText = "";
    }

    public SingleLetterCodeTableModel(String plainText, String cipherText, String key) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
    }
    
    // Hàm getter và setter 
    public String getPlaintext() {
        return plainText;
    }

    public void setPlaintext(String plainText) {
        this.plainText = plainText.replaceAll("\\s", "").toUpperCase();
    }

    public String getCiphertext() {
        return cipherText;
    }

    public void setCiphertext(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key.replaceAll("\\s", "").toUpperCase();
    }

    // Mã hóa phương thức
    public void enCryption() {
        resetCipherText();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            // Kiểm tra xem ch có phải là ký tự chữ hoa hay không (A-Z)
            if (ch >= 'A' && ch <= 'Z') {
                int index = ch - 'A'; 
                
                if (index < key.length()) {
                    cipherText += key.charAt(index); // Thêm ký tự tương ứng từ key
                }
            } else {
                cipherText += ch; // Giữ nguyên ký tự nếu không phải là chữ cái
            }
        }
    }

    // Giải mã phương thức
    public void deCryption() {
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            // Tìm vị trí của ký tự trong key
            int index = key.indexOf(ch);
            if (index != -1) {
                cipherText += (char) ('A' + index); // Thêm ký tự tương ứng từ bảng chữ cái
            } else {
                cipherText += ch; // Giữ nguyên ký tự nếu không phải là chữ cái
            }
        }
    }

    public void resetCipherText() {
        this.setCiphertext("");
    }
}
