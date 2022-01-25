package QuanLiDoiBongView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField tfPassWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/secrecy-icon.png"));
		setTitle("Đăng nhập vào hệ thống quản lí đội bóng PSG");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUserName = new JLabel("Username:");
		lbUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbUserName.setBounds(80, 74, 68, 14);
		contentPane.add(lbUserName);
		
		JLabel lbPassWord = new JLabel("Password:");
		lbPassWord.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbPassWord.setBounds(80, 136, 89, 14);
		contentPane.add(lbPassWord);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(176, 71, 117, 20);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		JButton btnResetLogin = new JButton("Reset");
		btnResetLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfUserName.setText(" ");
				tfPassWord.setText(" ");
			}
		});
		btnResetLogin.setBounds(10, 197, 89, 23);
		contentPane.add(btnResetLogin);
		
		JButton btnSignIn = new JButton("SignIn");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=DangNhap;user=phipham;password=phamvanphi06122003";
				Connection con = DriverManager.getConnection(url);
				
				String sql = " SELECT *FROM DangNhap where username = ? and password = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1,tfUserName.getText());
				pst.setString(2,tfPassWord.getText());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog( null, " Đăng nhập thành công");
					GiaoDienPSGchinhthuc gdc = new GiaoDienPSGchinhthuc();
					gdc.main(null);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Đăng nhập không thành công.Vui lòng đăng nhập lại");
					tfUserName.getText();
					tfPassWord.getText();
				}
				con.close();
			
				
					// TODO Auto-generated catch block
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSignIn.setBounds(322, 197, 89, 23);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(173, 11, 89, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnDoiMatKhau = new JButton("Change password");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword change = new ChangePassword();
				change.main(null);
				setVisible(false);
				
			}
		});
		btnDoiMatKhau.setBounds(131, 197, 162, 23);
		contentPane.add(btnDoiMatKhau);
		
		tfPassWord = new JPasswordField();
		tfPassWord.setBounds(176, 134, 114, 20);
		contentPane.add(tfPassWord);
		
		final JCheckBox cbShowPassword = new JCheckBox("Show password");
		cbShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbShowPassword.isSelected()) {
					tfPassWord.setEchoChar((char)0);
				}
				else {
					tfPassWord.setEchoChar('*');
				}
			}
		});
		cbShowPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbShowPassword.setBounds(176, 161, 117, 23);
		contentPane.add(cbShowPassword);
		
		JLabel lbHinhNen = new JLabel("");
		lbHinhNen.setIcon(new ImageIcon("images/backgroundnhapthongtin.jpg"));
		lbHinhNen.setBounds(0, 0, 434, 261);
		contentPane.add(lbHinhNen);
	}
}
