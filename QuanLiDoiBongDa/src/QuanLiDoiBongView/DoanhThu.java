package QuanLiDoiBongView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.concurrent.Callable;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoanhThu {

	private JFrame jfrDoanhThu;
	private JTextField tfTongTienMuaCauThu;
	private JTextField tfTongTienBanCauThu;
	private JButton btnTroVeGiaoDienChinh;
	private JLabel lbTongTienHienCo;
	private JTextField tfTongTienHienCo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanhThu window = new DoanhThu();
					window.jfrDoanhThu.setVisible(true);
					window.jfrDoanhThu.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void ShowDuLieu() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getConstructor().newInstance();
		String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=PSG";
		String user = "phipham";
		String password = "phamvanphi06122003";
		
		  Connection cn =DriverManager.getConnection(url, user, password);
		  CallableStatement cs = cn.prepareCall("{call sp_cauthu_tonggiamuacauthu()}");
		  CallableStatement cs1 = cn.prepareCall("{call sp_cauthu_tonggiatienbancauthu()}");
		  CallableStatement cs2 = cn.prepareCall("select tongtien from ngansach where id =1");
		  ResultSet rs = cs.executeQuery();
		  ResultSet rs1=cs1.executeQuery();
		  ResultSet rs2=cs2.executeQuery();
		   tfTongTienMuaCauThu.setEditable(false);
		   while(rs.next()) {
			   tfTongTienMuaCauThu.setText(rs.getString(1));
		   }
		   tfTongTienBanCauThu.setEditable(false);
		   while(rs1.next()) {
			   tfTongTienBanCauThu.setText(rs1.getString(1));
		   }
		   while(rs2.next()) {
			   tfTongTienHienCo.setText(rs2.getString(1));
		   }
		   
		
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the application.
	 */
	public DoanhThu() {
		initialize();
		ShowDuLieu();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfrDoanhThu = new JFrame();
		jfrDoanhThu.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Paris-Saint-Germain-icon.png"));
		jfrDoanhThu.setTitle("DOANH THU CỦA PSG");
		jfrDoanhThu.setBounds(100, 100, 438, 223);
		//frDoanhThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrDoanhThu.getContentPane().setLayout(null);
		
		JLabel lbTongTienMuaCauThu = new JLabel("Tổng tiền mua cầu thủ :");
		lbTongTienMuaCauThu.setBounds(66, 66, 161, 30);
		jfrDoanhThu.getContentPane().add(lbTongTienMuaCauThu);
		
		tfTongTienMuaCauThu = new JTextField();
		tfTongTienMuaCauThu.setBounds(254, 71, 86, 20);
		jfrDoanhThu.getContentPane().add(tfTongTienMuaCauThu);
		tfTongTienMuaCauThu.setColumns(10);
		
		JLabel lbTongTienBanCauThu = new JLabel("Tổng tiền bán cầu thủ :");
		lbTongTienBanCauThu.setBounds(66, 107, 161, 30);
		jfrDoanhThu.getContentPane().add(lbTongTienBanCauThu);
		
		tfTongTienBanCauThu = new JTextField();
		tfTongTienBanCauThu.setColumns(10);
		tfTongTienBanCauThu.setBounds(254, 112, 86, 20);
		jfrDoanhThu.getContentPane().add(tfTongTienBanCauThu);
		
		btnTroVeGiaoDienChinh = new JButton("");
		btnTroVeGiaoDienChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienPSGchinhthuc gdc = new GiaoDienPSGchinhthuc();
				gdc.main(null);
				jfrDoanhThu.setVisible(false);
			}
		});
		btnTroVeGiaoDienChinh.setIcon(new ImageIcon("images/icons8-back-arrow-50.png"));
		btnTroVeGiaoDienChinh.setBounds(23, 11, 48, 30);
		jfrDoanhThu.getContentPane().add(btnTroVeGiaoDienChinh);
		
		lbTongTienHienCo = new JLabel("Tổng tiền hiện có :");
		lbTongTienHienCo.setBounds(66, 143, 161, 30);
		jfrDoanhThu.getContentPane().add(lbTongTienHienCo);
		
		tfTongTienHienCo = new JTextField();
		tfTongTienHienCo.setEditable(false);
		tfTongTienHienCo.setColumns(10);
		tfTongTienHienCo.setBounds(254, 148, 86, 20);
		jfrDoanhThu.getContentPane().add(tfTongTienHienCo);
	}
}
