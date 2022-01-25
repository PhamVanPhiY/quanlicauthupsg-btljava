package QuanLiDoiBongView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GiaoDienPSGchinhthuc {

	private JFrame jfrGiaoDienChinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienPSGchinhthuc window = new GiaoDienPSGchinhthuc();
					window.jfrGiaoDienChinh.setVisible(true);
					window.jfrGiaoDienChinh.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoDienPSGchinhthuc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jfrGiaoDienChinh = new JFrame();
		jfrGiaoDienChinh.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Paris-Saint-Germain-icon.png"));
		jfrGiaoDienChinh.setTitle("PSG");
		jfrGiaoDienChinh.setBounds(100, 100, 634, 454);
		jfrGiaoDienChinh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrGiaoDienChinh.getContentPane().setLayout(null);
		
		JLabel lbTieuDe = new JLabel("QUẢN LÍ ĐỘI BÓNG PSG");
		lbTieuDe.setForeground(Color.RED);
		lbTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTieuDe.setBounds(190, 64, 256, 37);
		jfrGiaoDienChinh.getContentPane().add(lbTieuDe);
		
		JLabel lbLogoDoiBong = new JLabel("");
		lbLogoDoiBong.setIcon(new ImageIcon("images/Paris-Saint-Germain-icon.png"));
		lbLogoDoiBong.setBounds(179, 112, 261, 256);
		jfrGiaoDienChinh.getContentPane().add(lbLogoDoiBong);
		
		JButton btnLichSuMuaCauThu = new JButton("LỊCH SỬ MUA CẦU THỦ ");
		btnLichSuMuaCauThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichSuMuaCauThuChinhThuc ls = new LichSuMuaCauThuChinhThuc();
				ls.main(null);
				jfrGiaoDienChinh.setVisible(false);
			}
		});
		btnLichSuMuaCauThu.setBounds(10, 161, 174, 23);
		jfrGiaoDienChinh.getContentPane().add(btnLichSuMuaCauThu);
		
		JButton btnLichSuBanCauThu = new JButton("LỊCH SỬ BÁN CẦU THỦ");
		btnLichSuBanCauThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichSuBanCauThu bct= new LichSuBanCauThu();
				bct.main(null);
				jfrGiaoDienChinh.setVisible(false);
			}
		});
		btnLichSuBanCauThu.setBounds(10, 293, 174, 23);
		jfrGiaoDienChinh.getContentPane().add(btnLichSuBanCauThu);
		
		JButton btnDoanhThu = new JButton("DOANH THU");
		btnDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoanhThu dt= new DoanhThu();
				dt.main(null);
				jfrGiaoDienChinh.setVisible(false);
				
				
			}
		});
		btnDoanhThu.setBounds(450, 161, 158, 23);
		jfrGiaoDienChinh.getContentPane().add(btnDoanhThu);
		
		JButton btnDanhSachCauThu = new JButton("DANH SÁCH CẦU THỦ ");
		btnDanhSachCauThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MuaBanTimKiemCauThu mb = new MuaBanTimKiemCauThu();
				mb.main(null);
				jfrGiaoDienChinh.setVisible(false);
			}
		});
		btnDanhSachCauThu.setBounds(450, 293, 158, 23);
		jfrGiaoDienChinh.getContentPane().add(btnDanhSachCauThu);
	}

	
}
