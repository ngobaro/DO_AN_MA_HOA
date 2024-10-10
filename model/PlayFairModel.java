package model;

public class PlayFairModel {
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
        this.plainText = plainText.replaceAll("\\s", "").toLowerCase();
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
        this.key = key.replaceAll("\\s", "").toLowerCase();
    }

    public char[][] getArray() {
        return array;
    }

    public void setArray(char[][] array) {
        this.array = array;
    }

    public boolean check(String test) {
        char[] chKey = test.toCharArray();
        for (int i = 0; i < chKey.length; i++) {
            if (chKey[i] >= '0' && chKey[i] <= '9') {
                return false; 
            }
        }
        return true;
    }
    
    // Hàm tạo khóa
    public String generateKeyFromKey() {
        boolean[] visited = new boolean[26]; // Tạo biến để gán cho những kí tự đã duyệt qua
        char[][] matrix = new char[5][5]; // Mảng để lưu trữ khóa
        String result = ""; // Biến lưu khóa thành chuỗi
        int index = 0; // Biến lưu vị trí của kí tự

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'j') continue; // Bỏ qua kí tự j
            if (c < 'a' || c > 'z') continue; // Bỏ qua ký tự không hợp lệ
            if (!visited[c - 'a']) { // Nếu chưa duyệt qua kí tự 
                visited[c - 'a'] = true; // Đánh dấu là đã duyệt qua
                matrix[index / 5][index % 5] = c; // Gán vào ma trận
                index++; // Chuyển qua vị trí tiếp theo
            }
        }

        char ch = 'a'; // Bắt đầu từ kí tự 'a'
        while (index < 25) { // Tiếp tục cho đến khi đủ 25 kí tự
            if (ch != 'j' && !visited[ch - 'a']) { // Nếu kí tự khác 'j' và chưa được duyệt
                matrix[index / 5][index % 5] = ch;
                index++;
            }
            ch++; // Chuyển qua kí tự tiếp theo
        }

        this.array = matrix; // Lưu ma trận khóa vào thuộc tính array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result += matrix[i][j] + ""; // Thêm tứ tự vào chuỗi từ ma trận
            }
        }
        return result; // Trả về chuỗi
    }

    public String formatPlainText(String plain_Text) {
        String message = ""; 
        int plainText_Length = plainText.length();

        for (int i = 0; i < plainText_Length; i++) {
            char ch = plain_Text.charAt(i);
            if (ch == 'j') {
                message += 'i';
            } else if (ch >= 'a' && ch <= 'z') {
                message += ch;
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

    public void encryption() {
        String plaintext = formatPlainText(plainText);

        for (int i = 0; i < plaintext.length(); i += 2) {
            char ch1 = plaintext.charAt(i);
            char ch2 = plaintext.charAt(i + 1); // Sử dụng 'x' nếu không có ký tự thứ hai

            // Biến lưu trữ vị trí của từng kí tự
            int[] ch1pos = getCharacterPosition(ch1);
            int[] ch2pos = getCharacterPosition(ch2);

            // Lấy từng vị trí
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
            cipherText += array[r1][c1]; // Thêm kết quả vào chuỗi
            cipherText += array[r2][c2];
        }
    }

    public void Decryption() {
        String plaintext = formatPlainText(plainText);

        for (int i = 0; i < plaintext.length(); i += 2) {
            char ch1 = plaintext.charAt(i);
            char ch2 = plaintext.charAt(i + 1); 

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
            cipherText += array[r1][c1]; // Thêm kết quả vào chuỗi
            cipherText += array[r2][c2];
        }
    }

    public void decryption() {
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
                c1 = (c1 - 1 + 5) % 5;
                c2 = (c2 - 1 + 5) % 5;
            } else if (c1 == c2) { // Cùng cột
                r1 = (r1 - 1 + 5) % 5;
                r2 = (r2 - 1 + 5) % 5;
            } else { // Khác hàng, khác cột
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            cipherText += array[r1][c1]; // Thêm kết quả vào chuỗi
            cipherText += array[r2][c2];
        }
    }

    // Hàm reset CipherText
    public void resetCipherText() {
        this.setCipherText("");
    }
}