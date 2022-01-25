package QuanLiDoiBongView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LichSuBanCauThu {

	private JFrame jfrLichSuBanCauThu;
	private JTable tbLichSuBanCauThu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LichSuBanCauThu window = new LichSuBanCauThu();
					window.jfrLichSuBanCauThu.setVisible(true);
					window.jfrLichSuBanCauThu.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  void showDuLieu() {
		try
		{
		tbLichSuBanCauThu.removeAll();
		final String []arr= {"Họ tên cầu thủ","Quốc tịch","Số áo","Giá bán","Ngày bán"};
		DefaultTableModel model = new DefaultTableModel(arr,0);
		String query = "SELECT *FROM dbo.lichsubancauthu";
		Connection connection= DBConnnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Vector vector = new Vector();
			vector.add(rs.getString("hoten"));
			vector.add(rs.getString("quoctich"));
			vector.add(rs.getString("soao"));
			vector.add(rs.getString("giaban"));
			vector.add(rs.getString("ngayban"));
			model.addRow(vector);
		}
		tbLichSuBanCauThu.setModel(model);
		rs.close();
		connection.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the application.
	 */
	public LichSuBanCauThu() {
		initialize();
		showDuLieu();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfrLichSuBanCauThu = new JFrame();
		jfrLichSuBanCauThu.getContentPane().setBackground(Color.PINK);
		jfrLichSuBanCauThu.setTitle("LỊCH SỬ BÁN CẦU THỦ CỦA PSG");
		jfrLichSuBanCauThu.setIconImage(Toolkit.getDefaultToolkit().getImage("images/history+24px-131985192419062346_24.png"));
		jfrLichSuBanCauThu.setBounds(100, 100, 627, 359);
		jfrLichSuBanCauThu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrLichSuBanCauThu.getContentPane().setLayout(null);
		
		JLabel lbLichSuBanCauThu = new JLabel("LỊCH SỬ BÁN CẦU THỦ");
		lbLichSuBanCauThu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbLichSuBanCauThu.setForeground(Color.BLACK);
		lbLichSuBanCauThu.setBounds(201, 53, 203, 36);
		jfrLichSuBanCauThu.getContentPane().add(lbLichSuBanCauThu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 591, 202);
		jfrLichSuBanCauThu.getContentPane().add(scrollPane);
		
		tbLichSuBanCauThu = new JTable();
		tbLichSuBanCauThu.setBackground(Color.PINK);
		scrollPane.setViewportView(tbLichSuBanCauThu);
		
		JButton btnTroVeGiaoDienChinh = new JButton("Trở về giao diện chính");
		btnTroVeGiaoDienChinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienPSGchinhthuc gdc = new GiaoDienPSGchinhthuc();
				gdc.main(null);
				jfrLichSuBanCauThu.setVisible(false);
			}
		});
		btnTroVeGiaoDienChinh.setBounds(10, 11, 180, 23);
		jfrLichSuBanCauThu.getContentPane().add(btnTroVeGiaoDienChinh);
	}
}
