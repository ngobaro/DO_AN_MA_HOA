package model;

public class CeasarModel {
    // Thuộc tính
    private String plainText;
    private String cipherText;
    private int key;
    // ---------------------------------

    public CeasarModel() {
        this.key = 0;
    }
    // Thuộc Tính

    public CeasarModel(String plainText, String cipherText, int key) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
    }

    // hàm geter và seter
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText.replaceAll("//s", "");
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
        if (key < 0) {
            this.key = 26 - (26 * (key / 26) - key);
        } else if (key > 26) {
            this.key = key % 26;
        } else {
            this.key = key;
        }
    }
    // ---------------------------------

    // Hàm mã hóa
    public void Encryption() {
        char[] plaintextChars = this.plainText.toCharArray(); // Chuyển chuỗi thành mảng ký tự

        for (int i = 0; i < plaintextChars.length; i++) {
            char chars = plaintextChars[i];
            // Mã hóa chữ thường
            if (chars >= 'a' && chars <= 'z') {
                chars = (char) (chars + this.key);
                if (chars > 'z') {
                    chars = (char) (chars - 'z' + 'a' - 1);
                }
                plaintextChars[i] = chars;
            }
            // Mã hóa chữ hoa
            else if (chars >= 'A' && chars <= 'Z') {
                chars = (char) (chars + this.key);
                if (chars > 'Z') {
                    chars = (char) (chars - 'Z' + 'A' - 1);
                }
                plaintextChars[i] = chars;
            }
        }
        this.cipherText = new String(plaintextChars); // Chuyển mảng ký tự về chuỗi
    }
    // ---------------------------------

    // Hàm giải mã
    public void Decryption() {
        char[] plaintextChars = this.plainText.toCharArray(); // Chuyển chuỗi thành mảng ký tự

        for (int i = 0; i < plaintextChars.length; i++) {
            char chars = plaintextChars[i];

            // Giải mã chữ thường
            if (chars >= 'a' && chars <= 'z') {
                chars = (char) (chars - this.key);
                if (chars < 'a') {
                    chars = (char) (chars + 'z' - 'a' + 1);
                }
                plaintextChars[i] = chars;
            }
            // Giải mã chữ hoa
            else if (chars >= 'A' && chars <= 'Z') {
                chars = (char) (chars - this.key);
                if (chars < 'A') {
                    chars = (char) (chars + 'Z' - 'A' + 1);
                }
                plaintextChars[i] = chars;
            }
        }
        this.cipherText = new String(plaintextChars); // Chuyển mảng ký tự về chuỗi
    }
    // ---------------------------------

}