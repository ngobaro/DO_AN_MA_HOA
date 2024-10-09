package model;

public class VeginereModel {
	// Thuộc tính
	private String plainText;
	private String cipherText;
	private String key;
	// ---------------------------------

	// Thuộc tính
	public VeginereModel() {
		this.cipherText = "";
	}

	public VeginereModel(String plainText, String cipherText, String key) {
		this.plainText = plainText;
		this.cipherText = cipherText;
		this.key = key;
	}
	// ---------------------------------

	// Hàm geter và seter
	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText.replaceAll("\\s", "").toUpperCase();
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
		this.key = key.replaceAll("\\s+", "").toUpperCase();
	}
	// ---------------------------------

	public String generateKey() {
		String result = "";
		int j = 0;

		for (int i = 0; i < plainText.length(); i++) {
			result += key.charAt(j % key.length());
			j++; // Tăng chỉ số khóa
		}
		result = result.replaceAll("\\s", ""); // Bỏ qua các khoảng trắng

		return result; // Trả về khóa đã được tạo
	}

	public void encryption() {
		resetCipherText();
		for (int i = 0, j = 0; i < plainText.length(); i++) {
			char ch = plainText.charAt(i); // Lấy từng kí tự trong plain text

			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				// Tính giá trị dịch chuyển
				int temp = key.charAt(j % key.length()) - 'A';

				// Áp dụng công thức mã hóa 
				char encryptedCh = (char) ((ch + temp - 'A') % 26 + 'A');

				cipherText += encryptedCh; // Thêm ký tự đã mã hóa vào chuỗi cipherText
				j++; // Chuyển sang ký tự tiếp theo của khóa
			} else {
				cipherText += ch; // Nếu không phải chữ cái, giữ nguyên ký tự
			}
		}
	}

	public void decryption() {
		resetCipherText();
		for (int i = 0, j = 0; i < plainText.length(); i++) {
			char ch = plainText.charAt(i);

			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				// Tính giá trị dịch chuyển 
				int temp = key.charAt(j % key.length()) - 'A';

				// Áp dụng công thức giải mã (decryption)
				char decryptedCh = (char) ((ch - temp - 'A' + 26) % 26 + 'A');

				cipherText += decryptedCh; // Thêm ký tự giải mã vào văn bản gốc
				j++;
			} else {
				cipherText += ch; // Nếu không phải chữ cái, giữ nguyên ký tự
			}
		}
	}

	public void resetCipherText() {
		this.setCipherText("");
	}
}
