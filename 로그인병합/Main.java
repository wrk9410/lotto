//로그인창

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main extends JFrame {
	private JTextField tf;
	private JPasswordField pf;
	private HashMap<String, String> map = new HashMap<>();
	
	public HashMap getMap() {
		return map;
	}
	
	public void setMap(HashMap a) {
		map.putAll(a);
	}
	
	public Main() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel idlbl = new JLabel("아이디: ");
		idlbl.setBounds(114, 86, 57, 15);
		getContentPane().add(idlbl);

		JLabel pwlbl = new JLabel("비밀번호:");
		pwlbl.setBounds(114, 132, 57, 15);
		getContentPane().add(pwlbl);

		tf = new JTextField();
		tf.setBounds(213, 83, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);

		JPasswordField pf = new JPasswordField();
		pf.setBounds(213, 129, 116, 21);
		getContentPane().add(pf);
		pf.setColumns(15);

		JButton loginbtn = new JButton("로그인");
		loginbtn.setBounds(91, 223, 97, 23);
		getContentPane().add(loginbtn);

		JButton joinbtn = new JButton("회원가입");
		joinbtn.setBounds(270, 223, 97, 23);
		getContentPane().add(joinbtn);

		loginbtn.addActionListener(new ActionListener() { // 아이디 비번맞을 시 로그인 완료

			@Override
			public void actionPerformed(ActionEvent e) {
				if (map.containsKey(tf.getText()) && map.get(tf.getText()).equals(pf.getText())) {
					JOptionPane.showMessageDialog(Main.this, "로그인에 성공하셨습니다."); 
					Main1 m = new Main1(); //효정이 만든 게임창 오픈
					m.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(Main.this, "로그인에 실패하셨습니다.");
				}
			}
		});
		
		joinbtn.addActionListener(new ActionListener() { //회원가입
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main2 m = new Main2(); //대수가 만든 회원가입창 오픈
				m.setVisible(true);
			}
		});
		
	}
	

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
