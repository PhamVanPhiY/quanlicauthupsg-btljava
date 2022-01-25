package QuanLiDoiBongView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserName;
	private JTextField tfCurrentPassword;
	private JLabel lbNewPassword;
	private JTextField tfNewpassword;
	private JButton btnDoiMatKhau;
	private JButton btnReset;
	private JButton btnQuayLai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/secrecy-icon.png"));
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUserName = new JLabel("Username :");
		lbUserName.setBounds(42, 61, 98, 14);
		contentPane.add(lbUserName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(176, 58, 150, 20);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lbCurrentPassword = new JLabel("Current password :");
		lbCurrentPassword.setBounds(20, 102, 120, 14);
		contentPane.add(lbCurrentPassword);
		
		tfCurrentPassword = new JTextField();
		tfCurrentPassword.setColumns(10);
		tfCurrentPassword.setBounds(176, 99, 150, 20);
		contentPane.add(tfCurrentPassword);
		
		lbNewPassword = new JLabel("New password :");
		lbNewPassword.setBounds(20, 147, 120, 14);
		contentPane.add(lbNewPassword);
		
		tfNewpassword = new JTextField();
		tfNewpassword.setColumns(10);
		tfNewpassword.setBounds(176, 144, 150, 20);
		contentPane.add(tfNewpassword);
		
		btnDoiMatKhau = new JButton("Change");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfUserName.getText().isEmpty()||tfCurrentPassword.getText().isEmpty()||tfNewpassword.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, " Vui lòng nhập đầy đủ thông tin   !!");}
					else {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=DangNhap;user=phipham;password=phamvanphi06122003";
				Connection con = DriverManager.getConnection(url);
				String query = " UPDATE DangNhap SET password =? where username= ? and password=(select password from DangNhap where username=?) ";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,tfNewpassword.getText());
				pst.setString(2,tfUserName.getText());
				pst.setString(3,tfUserName.getText());
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null," Thay đổi mật khẩu thành công !");
				DangNhap dn= new DangNhap();
				dn.main(null);
				setVisible(false);
					}
					// TODO Auto-generated catch block
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null," Thay đổi mật khẩu không thành công,kiểm tra lại username và password !");
					
				
				}
			}
		});
		btnDoiMatKhau.setBounds(280, 204, 89, 23);
		contentPane.add(btnDoiMatKhau);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfUserName.setText("");
				tfCurrentPassword.setText("");
				tfNewpassword.setText("");
				
			}
		});
		btnReset.setBounds(72, 204, 89, 23);
		contentPane.add(btnReset);
		
		btnQuayLai = new JButton("Sign In");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DangNhap dn= new DangNhap();
				dn.main(null);
				setVisible(false);
				}
			
			
		});
		btnQuayLai.setBounds(10, 11, 103, 23);
		contentPane.add(btnQuayLai);
		
		JLabel lbHinhNen = new JLabel("");
		lbHinhNen.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\backgroundnhapthongtin.jpg"));
		lbHinhNen.setBounds(0, 0, 434, 261);
		contentPane.add(lbHinhNen);
	}
}
