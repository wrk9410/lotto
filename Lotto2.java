//로또창 - 등록 수정 

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


class Lotto3 extends JFrame{
	
}
public class Lotto2 extends JFrame {
	JCheckBox NumBox;
	private List<JCheckBox> list;

	public Lotto2() {
		super("로또");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnl = new JPanel();// 큰 패널
		JPanel pnl2 = new JPanel();// 로또 입력 패널
		JPanel pnl3 = new JPanel();// 1~45 패널
		JPanel pnl4 = new JPanel();// 자동,반자동,등록 패널

		JButton regNum1 = new JButton(); // 뽑은 로또 번호 보여주기1
		regNum1.setBounds(313, 39, 55, 46);
		JButton regNum2 = new JButton(); // 뽑은 로또 번호 보여주기2
		regNum2.setBounds(179, 39, 55, 46);
		JButton regNum3 = new JButton(); // 뽑은 로또 번호 보여주기3
		regNum3.setBounds(380, 39, 55, 46);
		JButton regNum4 = new JButton(); // 뽑은 로또 번호 보여주기4
		regNum4.setBounds(45, 39, 55, 46);
		JButton regNum5 = new JButton(); // 뽑은 로또 번호 보여주기5
		regNum5.setBounds(246, 39, 55, 46);
		JButton regNum6 = new JButton(); // 뽑은 로또 번호 보여주기6
		regNum6.setBounds(112, 39, 55, 46);

		for (int i = 1; i <= 45; i++) {
			NumBox = new JCheckBox(String.valueOf(i));
			pnl3.add(NumBox); // 1~45번 번호
			list.add(NumBox);
		}

		JButton btnAuto = new JButton("자동"); // 자동
		JButton btnSAuto = new JButton("반자동");// 반자동
		JButton btnEnter = new JButton("등록하기");// 등록

		BoxLayout box = new BoxLayout(pnl, BoxLayout.Y_AXIS);
		pnl.setLayout(box);
		pnl2.setLayout(null);
		pnl2.add(regNum1);
		pnl2.add(regNum2);
		pnl2.add(regNum3);
		pnl2.add(regNum4);
		pnl2.add(regNum5);
		pnl2.add(regNum6);
		pnl3.add(NumBox);
		pnl4.add(btnAuto);
		pnl4.add(btnSAuto);
		pnl4.add(btnEnter);

		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl4);
		getContentPane().add(pnl);
		
		
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//등록을 누르면 lotto3이 나오게 
			}
		});
	}

	public static void main(String[] args) {
		new Lotto2().setVisible(true);
	}
}
