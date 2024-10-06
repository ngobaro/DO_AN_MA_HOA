package model;

public class VegernereModel {
    // Thuộc tính
    private String plainText;
    private String cipherText;
    private String key;
    //---------------------------------

    //hàm khởi tạo
    public VegernereModel() {
        this.cipherText = "";
    }

    public VegernereModel(String plainText, String cipherText, String key) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
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
    //---------------------------------

    public boolean isAlphabetic(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}

    public String generateKey() {
		String result = "";
		int j=0;
		for(int i = 0; i<plainText.length(); i++) {
			if(plainText.charAt(i) == ' ') {
				result += " ";
			}else result += key.charAt(j++);
			
			if(j == key.length()) {
				j = 0;
			}
		}
		return result;
	}

	public void Encryption() {
		for(int i = 0, j = 0; i < plainText.length(); i++) {
			char ch = plainText.charAt(i);
	
			if(isAlphabetic(ch)) {
				// Tính giá trị dịch chuyển (shift)
				int temp = key.charAt(j % key.length()) - 'A';
	
				// Nếu là ký tự thường, chuyển thành chữ hoa
				if (ch >= 'a' && ch <= 'z') {
					ch = (char) (ch - 'a' + 'A');  // Chuyển chữ thường thành chữ hoa
				}
	
				// Áp dụng công thức mã hóa (encryption)
				char encryptedCh = (char)((ch + temp - 'A') % 26 + 'A');
	
				cipherText += encryptedCh;  // Thêm ký tự đã mã hóa vào chuỗi cipherText
				j++;  // Chuyển sang ký tự tiếp theo của khóa
			} else {
				cipherText += ch;  // Nếu không phải chữ cái, giữ nguyên ký tự
			}
		}
	}	

	public void Decryption() {
		for(int i = 0, j = 0; i < plainText.length(); i++) {
			char ch = plainText.charAt(i);
	
			if(isAlphabetic(ch)) {
				// Tính giá trị dịch chuyển (shift)
				int temp = key.charAt(j % key.length()) - 'A';
	
				// Nếu là ký tự thường, chuyển thành chữ hoa
				if (ch >= 'a' && ch <= 'z') {
					ch = (char) (ch - 'a' + 'A');  // Chuyển chữ thường thành chữ hoa
				}
	
				// Áp dụng công thức giải mã (decryption)
				char decryptedCh = (char)((ch - temp - 'A' + 26) % 26 + 'A');
	
				cipherText += decryptedCh;  // Thêm ký tự giải mã vào văn bản gốc
				j++;
			} else {
				cipherText += ch;  // Nếu không phải chữ cái, giữ nguyên ký tự
			}
		}
	}
}
