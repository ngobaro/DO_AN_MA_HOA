package model;

import java.util.Random;

public class SingleLetterSubstitutionModel {
    private String key;
    private String plainText;
    private String cipherText;

    // Constructor
    public SingleLetterSubstitutionModel() {
        cipherText = "";
    }

    public SingleLetterSubstitutionModel(String plainText, String cipherText, String key) {
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

    // Hàm tạo ra random key
    public void generateRandomKey() {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random random = new Random();

        // Xáo trộn bảng chữ cái
        for (int i = alphabet.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = alphabet[i];
            alphabet[i] = alphabet[j];
            alphabet[j] = temp;
        }

        key = new String(alphabet); // Trả về key vừa được random
    }

    // Hàm mã hóa
    public void encryption() {
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

    // Hàm giải mã
    public void decryption() {
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

    public boolean duplicateKey(String test) {
        // Kiểm tra chiều dài của key có đúng 26 hay không
        if (test.length() != 26) {
            System.out.println("khong du do dai");
            return false; // Nếu không đúng 26 ký tự, trả về false
        }

        // Tạo một mảng boolean để theo dõi các ký tự đã thấy
        boolean[] seenCharacters = new boolean[26];

        // Duyệt qua từng ký tự trong key
        for (char c : test.toCharArray()) {
            // Chuyển đổi ký tự thành chỉ mục (a=0, b=1, ..., z=25)
            int index = c - 'A';

            // Kiểm tra xem ký tự có nằm trong khoảng 'a' đến 'z' không
            if (index < 0 || index >= 26) {
                return false; // Nếu ký tự không hợp lệ, trả về false
            }

            // Kiểm tra xem ký tự đã xuất hiện chưa
            if (seenCharacters[index]) {
                return false; // Ký tự trùng lặp, trả về false
            }

            // Đánh dấu ký tự đã thấy
            seenCharacters[index] = true;
        }

        // Nếu không có ký tự trùng lặp và chiều dài là 26, trả về true
        return true;
    }

}
