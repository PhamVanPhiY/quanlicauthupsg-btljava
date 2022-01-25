package QuanLiDoiBongView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import java.util.Calendar; 
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MuaBanTimKiemCauThu {

	private JFrame jfrDanhSachCauThu;
	private JTextField tfHoTenCauThu;
	private JTextField tfQuocTich;
	private JTextField tfSoAo;
	private JTextField tfViTri;
	private JTextField tfTienLuong;
	public JTable tbDanhSachCauThu;
	Connection connection = null;
	private JTextField tfGiaBan;
	private JDateChooser dateChooser;
	private JRadioButton radiobtnSapXepHoTen;
	private JTextField tfTimKiem;
	private DefaultTableModel model;


	public  void showDuLieu() {
		try
		{
		tbDanhSachCauThu.removeAll();
		final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Vị trí","Tiền lương"};
		DefaultTableModel model = new DefaultTableModel(arr,0);
		String query = "SELECT *FROM abc.[player]";
		Connection connection= DBConnnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Vector vector = new Vector();
			vector.add(rs.getString("hoten"));
			vector.add(rs.getString("quoctich"));
			vector.add(rs.getString("soao"));
			vector.add(rs.getString("vitri"));
			vector.add(rs.getString("tienluong"));
			model.addRow(vector);
		}
		tbDanhSachCauThu.setModel(model);
		rs.close();
		connection.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbDanhSachCauThu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(tbDanhSachCauThu.getSelectedRow()>=0) {
					tfHoTenCauThu.setText(tbDanhSachCauThu.getValueAt(tbDanhSachCauThu.getSelectedRow(),0)+" ");
					tfQuocTich.setText(tbDanhSachCauThu.getValueAt(tbDanhSachCauThu.getSelectedRow(),1)+" ");
					tfSoAo.setText(tbDanhSachCauThu.getValueAt(tbDanhSachCauThu.getSelectedRow(),2)+" ");
					tfViTri.setText(tbDanhSachCauThu.getValueAt(tbDanhSachCauThu.getSelectedRow(),3)+" ");
					tfTienLuong.setText(tbDanhSachCauThu.getValueAt(tbDanhSachCauThu.getSelectedRow(),4)+" ");
					
				}
			}
		});
	}
	public void timkiem(String str) {
		model=(DefaultTableModel) tbDanhSachCauThu.getModel();
		TableRowSorter<DefaultTableModel>ts = new TableRowSorter<>(model);
		tbDanhSachCauThu.setRowSorter(ts);
		ts.setRowFilter(RowFilter.regexFilter(str));
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MuaBanTimKiemCauThu window = new MuaBanTimKiemCauThu();
					window.jfrDanhSachCauThu.setVisible(true);
					window.jfrDanhSachCauThu.setLocationRelativeTo(null);
					window.jfrDanhSachCauThu.setExtendedState(JFrame.MAXIMIZED_HORIZ);
					
					window.jfrDanhSachCauThu.setResizable(false);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	public MuaBanTimKiemCauThu() {
		initialize();
		//showBang();
		showDuLieu();
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfrDanhSachCauThu = new JFrame();
		jfrDanhSachCauThu.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Paris-Saint-Germain-icon.png"));
		jfrDanhSachCauThu.setTitle("DANH SÁCH CẦU THỦ ");
		jfrDanhSachCauThu.setBounds(100, 100, 875, 553);
		//frmDanhSchCu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrDanhSachCauThu.getContentPane().setLayout(null);
		
		JLabel lbDanhSachCauThu = new JLabel("DANH SÁCH CẦU THỦ CỦA PSG");
		lbDanhSachCauThu.setForeground(Color.RED);
		lbDanhSachCauThu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbDanhSachCauThu.setBounds(309, 24, 275, 66);
		jfrDanhSachCauThu.getContentPane().add(lbDanhSachCauThu);
		
		JLabel lbHoTenCauThu = new JLabel("Họ tên cầu thủ :");
		lbHoTenCauThu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbHoTenCauThu.setForeground(Color.RED);
		lbHoTenCauThu.setBounds(10, 86, 118, 30);
		jfrDanhSachCauThu.getContentPane().add(lbHoTenCauThu);
		
		tfHoTenCauThu = new JTextField();
		tfHoTenCauThu.setBackground(Color.LIGHT_GRAY);
		tfHoTenCauThu.setBounds(122, 92, 176, 20);
		jfrDanhSachCauThu.getContentPane().add(tfHoTenCauThu);
		tfHoTenCauThu.setColumns(10);
		
		JLabel lbQuocTich = new JLabel("Quốc tịch :");
		lbQuocTich.setForeground(Color.RED);
		lbQuocTich.setBounds(339, 87, 86, 30);
		jfrDanhSachCauThu.getContentPane().add(lbQuocTich);
		
		tfQuocTich = new JTextField();
		tfQuocTich.setBackground(Color.LIGHT_GRAY);
		tfQuocTich.setColumns(10);
		tfQuocTich.setBounds(417, 92, 176, 20);
		jfrDanhSachCauThu.getContentPane().add(tfQuocTich);
		
		JLabel lbSoAo = new JLabel("Số áo:");
		lbSoAo.setForeground(Color.RED);
		lbSoAo.setBounds(22, 127, 42, 30);
		jfrDanhSachCauThu.getContentPane().add(lbSoAo);
		
		tfSoAo = new JTextField();
		tfSoAo.setBackground(Color.LIGHT_GRAY);
		tfSoAo.setColumns(10);
		tfSoAo.setBounds(80, 132, 48, 20);
		jfrDanhSachCauThu.getContentPane().add(tfSoAo);
		
		JLabel lbViTri = new JLabel("Vị trí :");
		lbViTri.setForeground(Color.RED);
		lbViTri.setBounds(155, 127, 48, 30);
		jfrDanhSachCauThu.getContentPane().add(lbViTri);
		
		tfViTri = new JTextField();
		tfViTri.setBackground(Color.LIGHT_GRAY);
		tfViTri.setColumns(10);
		tfViTri.setBounds(220, 132, 68, 20);
		jfrDanhSachCauThu.getContentPane().add(tfViTri);
		
		JLabel lbTienLuong = new JLabel("Tiền lương :");
		lbTienLuong.setForeground(Color.RED);
		lbTienLuong.setBounds(320, 127, 76, 30);
		jfrDanhSachCauThu.getContentPane().add(lbTienLuong);
		
		tfTienLuong = new JTextField();
		tfTienLuong.setBackground(Color.LIGHT_GRAY);
		tfTienLuong.setColumns(10);
		tfTienLuong.setBounds(417, 132, 86, 20);
		jfrDanhSachCauThu.getContentPane().add(tfTienLuong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 251, 755, 263);
		jfrDanhSachCauThu.getContentPane().add(scrollPane);
		
		
		
		tbDanhSachCauThu = new JTable();
		tbDanhSachCauThu.setBackground(Color.PINK);
		scrollPane.setViewportView(tbDanhSachCauThu);
		tbDanhSachCauThu.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		
		JButton btnMuaCauThu = new JButton("Mua thêm cầu thủ ");
		btnMuaCauThu.setBackground(Color.WHITE);
		btnMuaCauThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MuaCauThu mct= new MuaCauThu();
				mct.main(null);
				
			}
		});
		btnMuaCauThu.setBounds(32, 172, 150, 23);
		jfrDanhSachCauThu.getContentPane().add(btnMuaCauThu);
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.LIGHT_GRAY);
		dateChooser.setBounds(707, 96, 142, 20);
		jfrDanhSachCauThu.getContentPane().add(dateChooser);
		
	/*	String strTime = tfGiaBan.getText();
         final Float iTime;
        
        iTime = Float.parseFloat(strTime);*/
		
		JButton btnBanCauThu = new JButton("Bán cầu thủ");
		btnBanCauThu.setBackground(Color.WHITE);
		btnBanCauThu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(tfHoTenCauThu.getText().isEmpty()||tfQuocTich.getText().isEmpty()||tfSoAo.getText().isEmpty()||tfViTri.getText().isEmpty()||tfTienLuong.getText().isEmpty()||tfGiaBan.getText().isEmpty()||dateChooser.getDate()==null) {
					JOptionPane.showMessageDialog(null, " Vui lòng nhập đầy đủ thông tin  trước khi bán !!");
					
				}
				String strGB = tfGiaBan.getText();
		          Float giaban;
		        
		        giaban = Float.parseFloat(strGB);
				if(/*tfGiaBan.getText().contains("[a-zA-Z]+")==false||tfGiaBan.getText().length()>2||*/giaban <=0) {
					JOptionPane.showMessageDialog(null," Giá bán phải là một giá trị số và lớn hơn 0");
				}
				else {
				
				int opt = JOptionPane.showConfirmDialog	(null, "Bạn có chắc là muốn bán cầu thủ này không ?"," Bán",JOptionPane.YES_NO_OPTION);
				if(opt==0) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=PSG;user=phipham;password=phamvanphi06122003";
				Connection con = DriverManager.getConnection(url);
				int row = tbDanhSachCauThu.getSelectedRow();
				String value = tbDanhSachCauThu.getModel().getValueAt(row, 2).toString();
				String query = " DELETE FROM abc.player where soao="+value ;
				PreparedStatement pst = con.prepareStatement(query);
				pst.executeUpdate();
				DefaultTableModel model = (DefaultTableModel)tbDanhSachCauThu.getModel();
				model.setRowCount(0);
				showDuLieu();

				String query3= "update dbo.ngansach set tongtien=tongtien+? where id=1";
				//stmt.executeUpdate(query2);
				PreparedStatement stmt1 =con.prepareStatement(query3);
				stmt1.setString(1,tfGiaBan.getText());
				stmt1.executeUpdate();
				PreparedStatement pst2 = con.prepareStatement(query);
				
				JOptionPane.showMessageDialog(null," Bán cầu thủ  thành công");
				String query2= " INSERT INTO dbo.lichsubancauthu (hoten,quoctich,soao,giaban,ngayban) VALUES (?,?,?,?,?)";
				PreparedStatement pst1 = con.prepareStatement(query2);
				pst1.setString(1,tfHoTenCauThu.getText());
				pst1.setString(2,tfQuocTich.getText());
				pst1.setString(3,tfSoAo.getText());
				pst1.setString(4,tfGiaBan.getText());
				Date date = (Date) dateChooser.getDate();
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//String date = sdf.format(dateChooser_1.getDate());
				String dateInput = new SimpleDateFormat("yyyy-MM-dd").format(date);
				pst1.setString(5,dateInput);
				
				pst1.executeUpdate();
					// TODO Auto-generated catch block
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				}
				
			}
		});
		btnBanCauThu.setBounds(279, 172, 150, 23);
		jfrDanhSachCauThu.getContentPane().add(btnBanCauThu);
		
		JButton btnCapNhat = new JButton("Cập nhật ");
		btnCapNhat.setBackground(Color.WHITE);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=PSG;user=phipham;password=phamvanphi06122003";
				Connection con = DriverManager.getConnection(url);
				int row = tbDanhSachCauThu.getSelectedRow();
				String value = tbDanhSachCauThu.getModel().getValueAt(row, 2).toString();
				String query = " UPDATE abc.player SET hoten=?,quoctich=?,soao=?,vitri=?,tienluong=? where soao="+value ;
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,tfHoTenCauThu.getText());
				pst.setString(2,tfQuocTich.getText());
				pst.setString(3,tfSoAo.getText());
				pst.setString(4,tfViTri.getText());
				pst.setString(5,tfTienLuong.getText());
				pst.executeUpdate();
				DefaultTableModel model = (DefaultTableModel)tbDanhSachCauThu.getModel();
				model.setRowCount(0);
				showDuLieu();
				JOptionPane.showMessageDialog(null," Cập nhật thành công");
					// TODO Auto-generated catch block
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null," Cập nhập không thành công ,số áo này đã có cầu thủ khác sỡ hữu");	
				}
			}
		});
		btnCapNhat.setBounds(481, 172, 150, 23);
		jfrDanhSachCauThu.getContentPane().add(btnCapNhat);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setForeground(Color.RED);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tbDanhSachCauThu.removeAll();
					final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Vị trí","Tiền lương"};
					DefaultTableModel model = new DefaultTableModel(arr,0);
					String query = "SELECT *FROM abc.[player]";
					Connection connection= DBConnnection.getConnection();
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						Vector vector = new Vector();
						vector.add(rs.getString("hoten"));
						vector.add(rs.getString("quoctich"));
						vector.add(rs.getString("soao"));
						vector.add(rs.getString("vitri"));
						vector.add(rs.getString("tienluong"));
						model.addRow(vector);
					}
					tbDanhSachCauThu.setModel(model);
					rs.close();
					connection.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnRefresh.setBounds(748, 43, 89, 23);
		jfrDanhSachCauThu.getContentPane().add(btnRefresh);
		
		JLabel lbGiaBan = new JLabel("Giá bán :");
		lbGiaBan.setForeground(Color.RED);
		lbGiaBan.setBounds(545, 127, 76, 30);
		jfrDanhSachCauThu.getContentPane().add(lbGiaBan);
		
		tfGiaBan = new JTextField();
		tfGiaBan.setBackground(Color.LIGHT_GRAY);
		tfGiaBan.setColumns(10);
		tfGiaBan.setBounds(620, 132, 127, 20);
		jfrDanhSachCauThu.getContentPane().add(tfGiaBan);
		
		JLabel lbNgayBan = new JLabel("Ngày bán :");
		lbNgayBan.setForeground(Color.RED);
		lbNgayBan.setBounds(620, 87, 76, 30);
		jfrDanhSachCauThu.getContentPane().add(lbNgayBan);
		
		JButton btnTroVeGiaoDienChinh = new JButton("");
		btnTroVeGiaoDienChinh.setForeground(Color.WHITE);
		btnTroVeGiaoDienChinh.setBackground(Color.WHITE);
		btnTroVeGiaoDienChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienPSGchinhthuc gdc = new GiaoDienPSGchinhthuc();
				gdc.main(null);
				jfrDanhSachCauThu.setVisible(false);
			}
		});
		btnTroVeGiaoDienChinh.setIcon(new ImageIcon("images/icons8-back-arrow-50.png"));
		btnTroVeGiaoDienChinh.setBounds(10, 24, 61, 42);
		jfrDanhSachCauThu.getContentPane().add(btnTroVeGiaoDienChinh);
		
		final JRadioButton radiobtnSapXepHoTen = new JRadioButton("Sắp xếp theo tên");
		radiobtnSapXepHoTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==radiobtnSapXepHoTen) {
					try {
						tbDanhSachCauThu.removeAll();
						final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Vị trí","Tiền lương"};
						DefaultTableModel model = new DefaultTableModel(arr,0);
						String query = "SELECT *FROM abc.[player] ORDER BY hoten";
						Connection connection= DBConnnection.getConnection();
						PreparedStatement ps = connection.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()) {
							Vector vector = new Vector();
							vector.add(rs.getString("hoten"));
							vector.add(rs.getString("quoctich"));
							vector.add(rs.getString("soao"));
							vector.add(rs.getString("vitri"));
							vector.add(rs.getString("tienluong"));
							model.addRow(vector);
						}
						tbDanhSachCauThu.setModel(model);
						rs.close();
						connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
		});
		radiobtnSapXepHoTen.setBounds(58, 232, 145, 23);
		jfrDanhSachCauThu.getContentPane().add(radiobtnSapXepHoTen);
		
		final JRadioButton radiobtnSapXepTheoSoAo = new JRadioButton("Sắp xếp theo số áo");
		radiobtnSapXepTheoSoAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==radiobtnSapXepTheoSoAo) {
					try {
						tbDanhSachCauThu.removeAll();
						final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Vị trí","Tiền lương"};
						DefaultTableModel model = new DefaultTableModel(arr,0);
						String query = "SELECT *FROM abc.[player] ORDER BY soao";
						Connection connection= DBConnnection.getConnection();
						PreparedStatement ps = connection.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()) {
							Vector vector = new Vector();
							vector.add(rs.getString("hoten"));
							vector.add(rs.getString("quoctich"));
							vector.add(rs.getString("soao"));
							vector.add(rs.getString("vitri"));
							vector.add(rs.getString("tienluong"));
							model.addRow(vector);
							
						}
						tbDanhSachCauThu.setModel(model);
						rs.close();
						connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				
			}
		});
		radiobtnSapXepTheoSoAo.setBounds(345, 232, 158, 23);
		jfrDanhSachCauThu.getContentPane().add(radiobtnSapXepTheoSoAo);
		
		
		final JRadioButton radiobtnSapXepTheoTienLuong = new JRadioButton("Sắp xếp theo tiền lương");
		radiobtnSapXepTheoTienLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==radiobtnSapXepTheoTienLuong) {
					try {
						tbDanhSachCauThu.removeAll();
						final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Vị trí","Tiền lương"};
						DefaultTableModel model = new DefaultTableModel(arr,0);
						String query = "SELECT *FROM abc.[player] ORDER BY tienluong";
						Connection connection= DBConnnection.getConnection();
						PreparedStatement ps = connection.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()) {
							Vector vector = new Vector();
							vector.add(rs.getString("hoten"));
							vector.add(rs.getString("quoctich"));
							vector.add(rs.getString("soao"));
							vector.add(rs.getString("vitri"));
							vector.add(rs.getString("tienluong"));
							model.addRow(vector);
						}
						tbDanhSachCauThu.setModel(model);
						rs.close();
						connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			}
		});
		
		radiobtnSapXepTheoTienLuong.setBounds(645, 232, 168, 23);
		jfrDanhSachCauThu.getContentPane().add(radiobtnSapXepTheoTienLuong);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radiobtnSapXepTheoTienLuong);
		group.add(radiobtnSapXepHoTen);
		group.add(radiobtnSapXepTheoSoAo);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfGiaBan.setText("");
				tfHoTenCauThu.setText("");
				tfQuocTich.setText("");
				tfSoAo.setText("");
				tfTienLuong.setText("");
				tfViTri.setText("");
				dateChooser.setCalendar(null);
				
		
			}
		});
		
		btnReset.setBounds(707, 172, 89, 23);
		jfrDanhSachCauThu.getContentPane().add(btnReset);
		
		tfTimKiem = new JTextField();
		tfTimKiem.addKeyListener(new KeyAdapter() {

			
			
			@Override
			public void keyReleased(KeyEvent e) {
				String search = tfTimKiem.getText();
				timkiem(search);
			}
		});
		tfTimKiem.setBounds(103, 206, 210, 20); 
		jfrDanhSachCauThu.getContentPane().add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		JLabel lbTimKiem = new JLabel("");
		lbTimKiem.setIcon(new ImageIcon("images/Zoom-icon.png"));
		lbTimKiem.setBounds(42, 198, 51, 42);
		jfrDanhSachCauThu.getContentPane().add(lbTimKiem);
		
		/*Tắt jframe */
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				//jfrDanhSachCauThu.dispose();
			}
		});
		btnClose.setForeground(Color.RED);
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(791, 0, 68, 23);
		jfrDanhSachCauThu.getContentPane().add(btnClose);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images/hinh-nen-bong-da-dep-2.jpg"));
		lblNewLabel.setBounds(0, -1, 859, 515);
		jfrDanhSachCauThu.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}
