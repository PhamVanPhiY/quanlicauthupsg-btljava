package QuanLiDoiBongView;

import java.awt.*;
import javax.swing.*;

public class Progressbar {

	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar(0,100);
	
	Progressbar(){
		
		bar.setValue(0);
		bar.setBounds(0,0,420,50);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli",Font.BOLD,25));
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);
			
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 90);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Paris-Saint-Germain-icon.png"));
		
		fill();
	}
	
	public void fill() {
		int counter =0;
		
		while(counter<=100) {
			
			bar.setValue(counter);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter +=1;
		}
		bar.setString("Done! :)");
		GiaoDienPSGchinhthuc gdc= new GiaoDienPSGchinhthuc();
		gdc.main(null);
		frame.setVisible(false);
		
	}
	public static void main(String[] args) {
		Progressbar prs = new Progressbar();
		
	}
}