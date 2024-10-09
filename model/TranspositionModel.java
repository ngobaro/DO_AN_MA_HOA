package model;

public class TranspositionModel {
    // thuộc tính
    private String plaintext;
    private String ciphertext;
    private String key;
    // ---------------------------------

    // hàm khởi tạo
    public TranspositionModel() {
        this.ciphertext = "";
    }

    public TranspositionModel(String plaintext, String ciphertext, String key) {
        this.plaintext = plaintext;
        this.ciphertext = ciphertext;
        this.key = key;
    }
    // ---------------------------------

    // hàm geter và hàm seter
    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext.replaceAll("\\s", "").toUpperCase();
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
        this.key = key.replaceAll("\\s", "").toUpperCase();
    }
    // ---------------------------------

    // Hàm lấy vị trí của từng kí tự trong key
    public int[] getNumberLocation() {
        int keywordLength = key.length();
        int[] keyPosition = new int[keywordLength];
        char[] chKey = key.toCharArray();

        // Khởi tạo mảng vị trí
        for (int i = 0; i < keywordLength; i++) {
            keyPosition[i] = i;
        }

        // Thực hiện Bubble Sort để sắp xếp chKey và keyPosition
        for (int i = 0; i < keywordLength - 1; i++) {
            for (int j = 0; j < keywordLength - i - 1; j++) {
                if (chKey[j] > chKey[j + 1]) {
                    // Hoán đổi ký tự trong chKey
                    char tempChar = chKey[j];
                    chKey[j] = chKey[j + 1];
                    chKey[j + 1] = tempChar;

                    // Hoán đổi vị trí tương ứng trong keyPosition
                    int tempIndex = keyPosition[j];
                    keyPosition[j] = keyPosition[j + 1];
                    keyPosition[j + 1] = tempIndex;
                }
            }
        }

        return keyPosition; // Trả về mảng vị trí
    }

    // Hàm mã hóa
    public void encryption() {
        char[] chArr = plaintext.toCharArray(); // Chuyển đổi thông điệp thành mảng ký tự
        int keywordLength = key.length();
        int numOfRows = (chArr.length + keywordLength - 1) / keywordLength; // Tính số hàng cần thiết
        char[][] arr = new char[numOfRows][keywordLength];

        // Điền ký tự vào ma trận
        for (int i = 0, z = 0; i < numOfRows; i++) {
            for (int j = 0; j < keywordLength; j++) {
                if (z < chArr.length) {
                    arr[i][j] = chArr[z++];
                } else {
                    arr[i][j] = ' '; // Nếu ma trận thiếu kí tự thì thêm "X" vào
                }
            }
        }
        // Tạo chuỗi mã hóa
        int[] keyPosition = getNumberLocation();
        for (int i = 0; i < keywordLength; i++) {
            int col = keyPosition[i]; // Lấy chỉ số cột từ vị trí
            for (int j = 0; j < numOfRows; j++) {
                ciphertext += arr[j][col]; // Thêm ký tự vào chuỗi mã hóa
            }
        }
    }

    // Hàm giải mã
    public void decryption() {
        int keywordLength = key.length();
        int numOfRows = plaintext.length() / keywordLength; // Tính số hàng
        char[][] arr = new char[numOfRows][keywordLength];

        int[] keyPosition = getNumberLocation();

        // Điền ký tự vào ma trận theo vị trí đã xác định
        for (int i = 0, z = 0; i < keywordLength; i++) {
            int col = keyPosition[i];
            for (int j = 0; j < numOfRows; j++) {
                arr[j][col] = plaintext.charAt(z++);
            }
        }

        // Xây dựng chuỗi thông điệp giải mã
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < keywordLength; j++) {
                ciphertext += arr[i][j]; // Thêm ký tự vào chuỗi thông điệp
            }
        }
    }

    public void resetCipherText() {
        this.ciphertext = "";
    }
}
