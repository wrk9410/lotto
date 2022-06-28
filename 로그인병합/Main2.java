import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JPasswordField;

public class Main2 extends JDialog {
	private JTextField id_tf;
	private JPasswordField pass_tf;
	private JPasswordField passcheck_tf;
	private HashMap map;
	
	
	public Main2() {
		Main main = new Main();
		map = main.getMap();
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		// id 입력
		JLabel id_reg = new JLabel("아이디 ");
		id_reg.setBounds(79, 60, 57, 15);
		getContentPane().add(id_reg);
		// 비밀번호 입력
		JLabel pass_reg = new JLabel("비밀번호 ");
		pass_reg.setBounds(79, 109, 57, 15);
		// 입력 비밀번호 동일 확인
		JLabel pass_check = new JLabel("비밀번호 확인 ");
		pass_check.setBounds(79, 157, 97, 15);
		getContentPane().add(pass_check);
		// 가입완료 버튼
		JButton reg_done = new JButton("가입완료 ");
		reg_done.setBounds(79, 246, 97, 23);
		getContentPane().add(reg_done);
		// 돌아가기 버튼
		JButton reg_back = new JButton("돌아가기 ");
		reg_back.setBounds(298, 246, 97, 23);
		getContentPane().add(reg_back);

		// 레이아웃
		id_tf = new JTextField();
		id_tf.setBounds(177, 56, 203, 23);
		getContentPane().add(id_tf);
		id_tf.setColumns(10);
		pass_tf = new JPasswordField();
		pass_tf.setBounds(177, 105, 203, 23);
		getContentPane().add(pass_tf);
		passcheck_tf = new JPasswordField();
		passcheck_tf.setBounds(177, 153, 203, 23);
		getContentPane().add(passcheck_tf);

		// 가입완료 누를 시 동작
		reg_done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!id_tf.getText().equals("") && !pass_tf.getText().equals("")
						&& !passcheck_tf.getText().equals("")) {
					if (map.containsKey(id_tf.getText())) { // 중복 아이디 확인
						System.out.println("중복된 아이디 입니다.");
					} else if (pass_tf.getText().equals(passcheck_tf.getText())) { // 중복 아닐 경우 진행
						if (4 <= pass_tf.getText().length() && pass_tf.getText().length() <= 12) { // 4자리 이상 12자리 이하 확인 조건
							map.put(id_tf.getText(), pass_tf.getText()); // 중복 아이디가 아닐 경우 key는 id, value는 pass 저장
							// 가입완료 후 가입할 때 작성한 아이디 및 비번 초기화
							id_tf.setText("");
							pass_tf.setText("");
							passcheck_tf.setText("");
							JOptionPane.showMessageDialog(Main2.this, "회원가입 완료!");
							main.setMap(map);
						} else {
							JOptionPane.showMessageDialog(Main2.this, "비밀번호 4자 이상, 12자 이하를 입력해주세요.");
						}
					} else { // 가입된 아이디는 있으나, 등록 아이디와 비밀번호가 맞지 않을 때
						JOptionPane.showMessageDialog(Main2.this, "비밀번호를 확인해주세요.");
					}
				} else { // 가입하려는 아이디 또는 비밀번호가 공백일 경우
					JOptionPane.showMessageDialog(Main2.this, "아이디 또는 비밀번호가 입력되지 않았습니다.");
				}
			}
		});

		reg_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				layout.show(pnl_all, "로그인 전"); | CardLayout 사용 시 로그인 창으로 이동
				dispose();
				id_tf.setText("");
				pass_tf.setText("");
				passcheck_tf.setText("");
			}
		});

		setSize(500, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Main2().setVisible(true);
	}
}
