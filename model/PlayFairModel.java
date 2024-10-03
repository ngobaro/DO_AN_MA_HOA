package model;

public class PlayFairModel {
    //Thuộc tính
    private String plainText;
    private String cipherText;
    private String key;
    private char[][] array = new char[5][5];
    //---------------------------------

    // khởi tạo
    public PlayFairModel() {
        this.key = key.toLowerCase();
        this.plainText = plainText.toLowerCase();
    }

    public PlayFairModel(String plainText, String cipherText, String key, char[][] array) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
        this.array = array;
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

    public char[][] getArray() {
        return array;
    }

    public void setArray(char[][] array) {
        this.array = array;
    }
    //---------------------------------

    public String removeSameCharacter(){
        // tao mang ki tu ket qua de luu
        char []result = new char[this.plainText.length()];

        // tao mang boolean de danh dau ki tu da xuat hien
        boolean[] visited = new boolean[256];

        int index = 0;
        // duyet de so lan xuat hien
        for (int i = 0; i < this.plainText.length(); i++){
            visited[this.plainText.charAt(i)] = true;
        }
        for (int i = 0; i < this.plainText.length(); i++){
            if (visited[this.plainText.charAt(i)]){
                result[index++] = this.plainText.charAt(i);
                visited[this.plainText.charAt(i)] = false;
            }
        }
        return new String(result);
    }
    
    public void generateKeyFromKey(String key) {
        //Dùng đánh dấu các ký tự đã xuất hiện
        boolean[] visited = new boolean[26];

        // Khởi tạo ma trận lưu lại khóa
        char[][] matrix = new char[5][5];

        // Chỉ số để duyệt qua ma trận
        int index = 0;

        // Duyệt qua từng ký tự trong khóa
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            // Bỏ qua chữ 'j'
            if (c == 'j')
                continue;
            // Kiểm tra định dạng kí tự
            if (c < 'a' || c > 'z')
                break;
            // Nếu ký tự chưa xuất hiện, đánh dấu và thêm vào ma trận
            if (visited[c - 'a'] == false) {
                visited[c - 'a'] = true;
                matrix[index / 5][index % 5] = c;
                index++;
            }
        }
        // Thêm các chữ cái còn thiếu vào ma trận
        char ch = 'a';
        while (index < 25) {
            if (ch != 'j' && visited[ch - 'a'] == false) {
                matrix[index / 5][index % 5] = ch;
                index++;
            }
            ch++;
        }
        
        //Trả lại về vị trí 0
        index = 0;

        // Mang chứa kết quả
        char [] result = new char[25];
        // chuyen thanh chuoi
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result[index++] = matrix[i][j];
            }
        }
        // Lưu kết quả vào chuỗi cipher text
       this.cipherText = new String(result);
    }

    public String formatPlainText()
    {
        String message = "";
        int plainText_Length = plainText.length();
       
        for (int i = 0; i < plainText_Length; i++)
        {
            // Nếu kí tự là j thì thay bằng kí tự i
            if (plainText.charAt(i) == 'j')
                message += 'i';
            else
                message += plainText.charAt(i); //Nếu không thì giữ nguyên và lưu vào message
        }
 
        // Nếu 2 kí tự kế bên nhau giống nhau, chèn kí tự x vào giữa
        for (int i = 0; i < message.length(); i += 2) 
        {
            if (message.charAt(i) == message.charAt(i + 1))
                message = message.substring(0, i + 1) + 'x'
                          + message.substring(i + 1);
        }
        // Nếu chuỗi lẻ thì thêm x vào cuối
        if (plainText_Length % 2 == 1)
            message += 'x'; // dummy character
       
        return message;
    }
    
}
