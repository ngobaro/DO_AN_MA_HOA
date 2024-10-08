package model;

public class VegernereModel {
	// Thuộc tính
	private String plainText;
	private String cipherText;
	private String key;
	// ---------------------------------

	// hàm khởi tạo
	public VegernereModel() {
		this.cipherText = "";
	}

	public VegernereModel(String plainText, String cipherText, String key) {
		this.plainText = plainText;
		this.cipherText = cipherText;
		this.key = key;
	}
	// ---------------------------------

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
		this.key = key.replaceAll("\\s+", "");
	}
	// ---------------------------------

	public boolean isAlphabetic(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}

	public String formatPlainText() {
		plainText = plainText.replaceAll("\\s", "");

		return plainText;
	}

	public String generateKey() {
		String result = "";
		int j = 0;
		
		// Chuyển plainText thành dạng không có khoảng trắng
		String formattedPlainText = formatPlainText();
	
		for (int i = 0; i < formattedPlainText.length(); i++) {
			if (formattedPlainText.charAt(i) == ' ') {
				result += " "; // Giữ lại khoảng trắng (nếu cần, nhưng trong trường hợp này sẽ không có khoảng trắng)
			} else {
				result += key.charAt(j % key.length());
				j++; // Tăng chỉ số khóa
			}
		}

		result = result.replaceAll("\\s", "");

		return result; // Trả về khóa đã được tạo
	}

	public void encryption() {
		resetCipherText();
		String plain_Text = formatPlainText().toUpperCase();
		String formatKey = generateKey().toUpperCase();
		for (int i = 0, j = 0; i < plain_Text.length(); i++) {
			char ch = plain_Text.charAt(i);

			if (isAlphabetic(ch)) {
				// Tính giá trị dịch chuyển (shift)
				int temp = formatKey.charAt(j % formatKey.length()) - 'A';

				// Áp dụng công thức mã hóa (encryption)
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
		String plain_Text = formatPlainText().toUpperCase();
		String formatKey = generateKey().toUpperCase();
		for (int i = 0, j = 0; i < plain_Text.length(); i++) {
			char ch = plain_Text.charAt(i);

			if (isAlphabetic(ch)) {
				// Tính giá trị dịch chuyển (shift)
				int temp = formatKey.charAt(j % formatKey.length()) - 'A';

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
