package model;
public class TranspositionModel {
    // thuộc tính
    private String plaintext;
    private String ciphertext;
    private String key;
    //---------------------------------
    
    // hàm khởi tạo
    public TranspositionModel() {
        this.ciphertext = "";
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
     //---------------------------------

     // Hàm lấy vị trí của từng kí tự trong key
     public int[] getNumberLocation() {
        int keywordLength = key.length();
        int[] keyPosition = new int[keywordLength];

        // Xác định vị trí của các ký tự trong từ khóa
        for (int i = 0; i < keywordLength; i++) {
            int index = 0;
            for (int j = 0; j < keywordLength; j++) {
                if (key.charAt(j) < key.charAt(i)) {
                    index++;
                }
            }
            keyPosition[index] = i; // Gán vị trí
        }

        return keyPosition; // Trả về vị trí của kí tự
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
                    arr[i][j] = 'Z'; // Nếu ma trận thiếu kí tự thì thêm "Z" vào
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
}