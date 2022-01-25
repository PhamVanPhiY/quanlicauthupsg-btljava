package QuanLiDoiBongView;

import java.awt.Color;

import javax.swing.JTextField;

public class PhiDiCheckhihi {
	public static boolean checkHoTen(JTextField field ,StringBuilder sb,String msg) {
		boolean ok= true;
		if(field.getText().equals(" ")) {
			sb.append(msg).append("\n");
			field.setBackground(Color.red);
			ok = false;
		}
		else {
			field.setBackground(Color.white);
		}
		return ok;
	}
	public static boolean checkQuocTich(JTextField field ,StringBuilder sb) {
		boolean ok=true;
		if(!checkHoTen(field, sb, "Bạn cần nhập vào quốc tịch của cầu thủ")) {
			return false ;
		}
		
		return ok;
	
		
	}
	public static boolean checkSoAo(JTextField field ,StringBuilder sb) {
		boolean ok=true;
		if(!checkHoTen(field, sb, "Bạn cần nhập vào số áo của cầu thủ ")) {
			return false ;
		}
		
		return ok;
	
		
	}
	public static boolean checkTienLuong(JTextField field ,StringBuilder sb) {
		boolean ok=true;
		if(!checkHoTen(field, sb, "Bạn cần nhập vào tiền lương của cầu thủ ")) {
			return false ;
		}
		
		return ok;
	
		
	}
	public static boolean checkViTri(JTextField field ,StringBuilder sb) {
		boolean ok=true;
		if(!checkHoTen(field, sb, "Bạn cần nhập vào vị trị của cầu thủ ")) {
			return false ;
		}
		
		return ok;
	
		
	}
	public static boolean checkGiaMua(JTextField field ,StringBuilder sb) {
		boolean ok=true;
		if(!checkHoTen(field, sb, "Bạn cần nhập vào giá tiền mua cầu thủ")) {
			return false ;
		}
		
		return ok;
	
		
	}
}
