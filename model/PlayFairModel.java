package model;

public class PlayFairModel {
    // Thuộc tính
    private String plainText;
    private String cipherText;
    private String key;
    private char[][] array = new char[5][5];

    // Khởi tạo
    public PlayFairModel() {
        this.cipherText = "";
    }

    public PlayFairModel(String plainText, String cipherText, String key, char[][] array) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
        this.array = array;
    }

    // Hàm getter và setter
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

    public char[][] getArray() {
        return array;
    }

    public void setArray(char[][] array) {
        this.array = array;
    }

    public void generateKeyFromKey(String key) {
        boolean[] visited = new boolean[26];
        char[][] matrix = new char[5][5];
        int index = 0;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'j') continue;
            if (c < 'a' || c > 'z') continue; // Bỏ qua ký tự không hợp lệ
            if (!visited[c - 'a']) {
                visited[c - 'a'] = true;
                matrix[index / 5][index % 5] = c;
                index++;
            }
        }

        char ch = 'a';
        while (index < 25) {
            if (ch != 'j' && !visited[ch - 'a']) {
                matrix[index / 5][index % 5] = ch;
                index++;
            }
            ch++;
        }

        this.array = matrix; // Lưu ma trận khóa vào thuộc tính array
    }

    public String formatPlainText(String plain_Text) {
        String message = "";
        int plainText_Length = plainText.length();

        for (int i = 0; i < plainText_Length; i++) {
            char c = plain_Text.charAt(i);
            if (c == 'j') {
                message += 'i';
            } else if (c >= 'a' && c <= 'z') {
                message += c;
            }
        }

        // Chèn 'x' vào giữa các ký tự giống nhau
        for (int i = 0; i < message.length() - 1; i++) {
            if (message.charAt(i) == message.charAt(i + 1)) {
                message = message.substring(0, i + 1) + 'x' + message.substring(i + 1);
                i++; // Bỏ qua ký tự vừa thêm
            }
        }

        if (message.length() % 2 != 0) {
            message += 'x'; // Nếu chuỗi lẻ, thêm 'x' vào cuối
        }

        return message.replaceAll("\\s", ""); // Xóa khoảng trắng
    }

    public int[] getCharacterPosition(char ch) {
        int[] keyPosition = new int[2]; // Sửa kích thước thành 2
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (array[i][j] == ch) {
                    keyPosition[0] = i;
                    keyPosition[1] = j;
                    return keyPosition; // Trả về ngay khi tìm thấy
                }
            }
        }
        return keyPosition; // Nếu không tìm thấy
    }

    public void Encryption() {
        String plaintext = formatPlainText(plainText);

        for (int i = 0; i < plaintext.length(); i += 2) {
            char ch1 = plaintext.charAt(i);
            char ch2 = plaintext.charAt(i + 1); // Sử dụng 'x' nếu không có ký tự thứ hai

            int[] ch1pos = getCharacterPosition(ch1);
            int[] ch2pos = getCharacterPosition(ch2);


            int r1 = ch1pos[0];
            int c1 = ch1pos[1];
            int r2 = ch2pos[0];
            int c2 = ch2pos[1];

            if (r1 == r2) { // Cùng hàng
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
            } else if (c1 == c2) { // Cùng cột
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;
            } else { // Khác hàng, khác cột
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            // cipherText += array[r1][c1]; // Thêm kết quả vào chuỗi
            // cipherText += array[r2][c2];
        }
    }

    public void Decryption() {
        String plaintext = formatPlainText(plainText);

        for (int i = 0; i < plaintext.length(); i += 2) {
            char ch1 = plaintext.charAt(i);
            char ch2 = plaintext.charAt(i + 1); // Sử dụng 'x' nếu không có ký tự thứ hai

            int[] ch1pos = getCharacterPosition(ch1);
            int[] ch2pos = getCharacterPosition(ch2);


            int r1 = ch1pos[0];
            int c1 = ch1pos[1];
            int r2 = ch2pos[0];
            int c2 = ch2pos[1];

            if (r1 == r2) { // Cùng hàng
                c1 = (c1 - 1) % 5;
                c2 = (c2 - 1) % 5;
            } else if (c1 == c2) { // Cùng cột
                r1 = (r1 - 1) % 5;
                r2 = (r2 - 1) % 5;
            } else { // Khác hàng, khác cột
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            cipherText += array[r1][c1]; // Thêm kết quả vào chuỗi
            cipherText += array[r2][c2];
        }
    }
}