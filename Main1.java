package lotto;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main1 extends JFrame{
	public Main1() {
		JPanel pnl = new JPanel(null);
		pnl.setPreferredSize(new Dimension(500, 500));
		
		JButton btn = new JButton("Click me");
		btn.setBounds(150, 150, 100, 100);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setLocation((int) (Math.random() * 400), (int) (Math.random() * 400));
			}
		});
		
		pnl.add(btn);
		getContentPane().add(pnl);
		
		JButton btn2 = new JButton("그만할래..");
		btn2.setBounds(198, 450, 97, 23);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//여기에 다시 로그인 창으로 돌아가게 하고싶다~~
			}
		});
		pnl.add(btn2);
		
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false); //프레임크기 고정
	}
	public static void main(String[] args) {
		new Main1().setVisible(true);

	}

}
