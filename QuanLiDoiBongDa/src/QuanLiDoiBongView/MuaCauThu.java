package QuanLiDoiBongView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import QuanLiDoiBongView.MuaBanTimKiemCauThu;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import java.util.Calendar; 
import java.util.Date;

public class MuaCauThu extends JFrame {

	private JPanel contentPane;
	private JTextField tfHoTen;
	private JTextField tfQuocTich;
	private JTextField tfViTri;
	private JTextField tfSoAo;
	private JTextField tfTienLuong;
	private JDateChooser dateChooser_1;
	private JTextField tfGiaMua;
	
	
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuaCauThu frame = new MuaCauThu();
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
	public MuaCauThu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/Paris-Saint-Germain-icon.png"));
		setTitle("MUA CẦU THỦ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbHoTen = new JLabel("Họ tên cầu thủ : ");
		lbHoTen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbHoTen.setForeground(new Color(0, 0, 0));
		lbHoTen.setBounds(10, 81, 131, 14);
		contentPane.add(lbHoTen);
		
		JLabel lbQuocTich = new JLabel("Quốc tịch:");
		lbQuocTich.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbQuocTich.setBounds(265, 81, 90, 14);
		contentPane.add(lbQuocTich);
		
		JLabel lbViTri = new JLabel("Vị trí:");
		lbViTri.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbViTri.setBounds(10, 140, 66, 14);
		contentPane.add(lbViTri);
		
		JLabel lbSoAo = new JLabel("Số áo :");
		lbSoAo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbSoAo.setForeground(Color.BLACK);
		lbSoAo.setBounds(137, 140, 70, 14);
		contentPane.add(lbSoAo);
		
		JLabel lbTienLuong = new JLabel("Tiền lương($):");
		lbTienLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbTienLuong.setBounds(265, 140, 120, 14);
		contentPane.add(lbTienLuong);
		
		tfHoTen = new JTextField();
		tfHoTen.setBounds(154, 79, 86, 20);
		contentPane.add(tfHoTen);
		tfHoTen.setColumns(10);
		
		tfQuocTich = new JTextField();
		tfQuocTich.setColumns(10);
		tfQuocTich.setBounds(365, 78, 86, 20);
		contentPane.add(tfQuocTich);
		
		tfViTri = new JTextField();
		tfViTri.setColumns(10);
		tfViTri.setBounds(70, 138, 57, 20);
		contentPane.add(tfViTri);
		
		tfSoAo = new JTextField();
		tfSoAo.setColumns(10);
		tfSoAo.setBounds(204, 138, 48, 20);
		contentPane.add(tfSoAo);
		
		tfTienLuong = new JTextField();
		tfTienLuong.setColumns(10);
		tfTienLuong.setBounds(395, 137, 86, 20);
		contentPane.add(tfTienLuong);
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(324, 169, 145, 20);
		contentPane.add(dateChooser_1);
		
		JButton btnMua = new JButton("Mua");
		btnMua.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(tfHoTen.getText().isEmpty()||tfQuocTich.getText().isEmpty()||tfSoAo.getText().isEmpty()||tfViTri.getText().isEmpty()||tfTienLuong.getText().isEmpty()||tfGiaMua.getText().isEmpty()||dateChooser_1.getDate()==null) {
					JOptionPane.showMessageDialog(null, " Vui lòng nhập đầy đủ thông tin của cầu thủ  !!");
					
				}
				
				String strTime = tfGiaMua.getText();
		          Float iTime;
		        
		        iTime = Float.parseFloat(strTime);
				if(/*tfGiaBan.getText().contains("[a-zA-Z]+")==false||tfGiaBan.getText().length()>2||*/iTime <=0) {
					JOptionPane.showMessageDialog(null," Giá mua phải là một giá trị số và lớn hơn 0");
				}
				else  {
				try {
				
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=PSG;user=phipham;password=phamvanphi06122003";
					Connection con = DriverManager.getConnection(url);
					String query = "INSERT INTO abc.player(hoten,quoctich,soao,vitri,tienluong,ngaymua,giamua) VALUES (?,?,?,?,?,?,?)";
					Statement stmt=null;
					stmt=con.createStatement();
					String query2= "update dbo.ngansach set tongtien=tongtien-? where id=1";
					//stmt.executeUpdate(query2);
					PreparedStatement stmt1 =con.prepareStatement(query2);
					stmt1.setString(1,tfGiaMua.getText());
					stmt1.executeUpdate();
					PreparedStatement pst = con.prepareStatement(query);
					//PreparedStatement pst1 =con.prepareStatement(query2);
					/*if(tfHoTen.getText().equals(" ")||tfQuocTich.getText().equals(" ")||tfSoAo.getText().equals(" ")||tfViTri.getText().equals(" ")||tfTienLuong.getText().equals(" ")) {
						JOptionPane.showMessageDialog(null, " Vui lòng nhập đầy đủ thông tin của cầu thủ  !!");
						
					}*/
					
					pst.setString(1,tfHoTen.getText());
					pst.setString(2,tfQuocTich.getText());
					pst.setString(3,tfSoAo.getText());
					pst.setString(4,tfViTri.getText());
					pst.setString(5,tfTienLuong.getText());
					Date date = (Date) dateChooser_1.getDate();
					String dateInput = new SimpleDateFormat("yyyy-MM-dd").format(date);
					pst.setString(6,dateInput);
					pst.setString(7,tfGiaMua.getText());
					//pst1.executeUpdate();
					pst.executeUpdate();
					
					
					
					JOptionPane.showMessageDialog(null, "Mua thành công ");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null," Mua chưa thành công, có thể là do số áo này đã có cầu thủ khác sở hữu");
				
				}
			}
			}});
		btnMua.setBounds(107, 214, 89, 23);
		contentPane.add(btnMua);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfHoTen.setText(" ");
				tfQuocTich.setText(" ");
				tfViTri.setText(" ");
				tfSoAo.setText(" ");
				tfTienLuong.setText(" ");
				dateChooser_1.setCalendar(null);
				
				
			}
		});
		btnReset.setBounds(283, 214, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("MUA CẦU THỦ ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(182, 29, 119, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lbNgayMua = new JLabel("Ngày mua :");
		lbNgayMua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNgayMua.setBounds(224, 175, 90, 14);
		contentPane.add(lbNgayMua);
		
		tfGiaMua = new JTextField();
		tfGiaMua.setColumns(10);
		tfGiaMua.setBounds(128, 169, 86, 20);
		contentPane.add(tfGiaMua);
		
		JLabel lbGiaMua = new JLabel("Giá mua ($):");
		lbGiaMua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbGiaMua.setBounds(10, 175, 89, 14);
		contentPane.add(lbGiaMua);
		
		/*JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(240, 169, 145, 20);
		contentPane.add(dateChooser_1);*/
	}
}
