package QuanLiDoiBongView;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LichSuMuaCauThuChinhThuc {

	private JFrame jfrLichSuMuaCauThu;
	private JLabel lbThoiGianHienTai;
	private JTable tbLichSuMuaCauThu;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LichSuMuaCauThuChinhThuc window = new LichSuMuaCauThuChinhThuc();
					window.jfrLichSuMuaCauThu.setVisible(true);
					window.jfrLichSuMuaCauThu.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void clock() {
		Thread clock = new Thread()
		{
			public void run()
			{
				try {
					while(true) {
					Calendar cal = new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);
					lbThoiGianHienTai.setText("Time "+hour+":"+minute+":"+second+"----- Date :"+day+"/"+"1"+"/"+year);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	/**
	 * Create the application.
	 */
	public  void showDuLieu() {
		try
		{
		tbLichSuMuaCauThu.removeAll();
		final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Vị trí","Tiền lương","Ngày mua","Giá mua"};
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
			vector.add(rs.getString("ngaymua"));
			vector.add(rs.getString("giamua"));

			
			
			model.addRow(vector);
		}
		tbLichSuMuaCauThu.setModel(model);
		rs.close();
		connection.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public LichSuMuaCauThuChinhThuc() {
		initialize();
		clock();
		showDuLieu();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfrLichSuMuaCauThu = new JFrame();
		jfrLichSuMuaCauThu.getContentPane().setBackground(Color.PINK);
		jfrLichSuMuaCauThu.setIconImage(Toolkit.getDefaultToolkit().getImage("images/history+24px-131985192419062346_24.png"));
		jfrLichSuMuaCauThu.setTitle("LỊCH SỬ MUA CẦU THỦ ");
		jfrLichSuMuaCauThu.setBounds(100, 100, 652, 507);
		//frmLchSMua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrLichSuMuaCauThu.getContentPane().setLayout(null);
		
	    lbThoiGianHienTai = new JLabel("");
	    lbThoiGianHienTai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
	    lbThoiGianHienTai.setForeground(Color.RED);
		lbThoiGianHienTai.setBounds(345, 11, 281, 42);
		jfrLichSuMuaCauThu.getContentPane().add(lbThoiGianHienTai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 616, 305);
		jfrLichSuMuaCauThu.getContentPane().add(scrollPane);
		
		tbLichSuMuaCauThu = new JTable();
		scrollPane.setViewportView(tbLichSuMuaCauThu);
		tbLichSuMuaCauThu.setModel(new DefaultTableModel(
				new Object[][] {
					{},
				},
				new String[] {
				}
			));
		
		lblNewLabel = new JLabel("LỊCH SỬ MUA CẦU THỦ ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(207, 64, 196, 62);
		jfrLichSuMuaCauThu.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Trở về giao diện chính");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienPSGchinhthuc gdc = new GiaoDienPSGchinhthuc();
				gdc.main(null);
				jfrLichSuMuaCauThu.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 11, 176, 23);
		jfrLichSuMuaCauThu.getContentPane().add(btnNewButton);
	}
}
