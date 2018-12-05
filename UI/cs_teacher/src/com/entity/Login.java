package com.entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * 
* <p>Title: Login</p>
* <p>Description: ��ʦ��½����</p>
* @author Luan Xiaoyue
* @date 2018��12��5��
 */
public class Login extends JFrame {

	private JPanel bgContentPane;
	private JTextField username;
	private JPasswordField password;

	

	/**
	 * Create the frame.
	 */
	public Login getLogin() {
		return this;
	}
	
	
	public Login() {
		//���ñ���ͼ
		bgContentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("img/img1.png");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        bgContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(bgContentPane);
		bgContentPane.setLayout(null);
		//���ò��ַ�ʽΪ���Զ�λ
		getContentPane().setLayout(null);
		//�û���username
		username = new JTextField();
		username.setBackground(new Color(240, 248, 255));
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(SystemColor.activeCaptionBorder);
		username.setFont(new Font("����", Font.BOLD, 14));
		username.setBounds(102, 160, 187, 30);
		bgContentPane.add(username);
		username.setColumns(15);
		//�����password
		password = new JPasswordField();
		password.setToolTipText("����");
		password.setBackground(new Color(240, 248, 255));
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(SystemColor.activeCaptionBorder);
		password.setFont(new Font("����", Font.BOLD, 14));
		password.setBounds(102, 211, 187, 30);
		bgContentPane.add(password);
		//��¼loginButton
		JButton loginButton = new JButton("��  ¼");
		loginButton.setForeground(new Color(169, 169, 169));
		loginButton.setFont(new Font("����", Font.BOLD, 18));
		loginButton.setBackground(null);
		loginButton.setBounds(102, 300, 130, 43);
		bgContentPane.add(loginButton);
		 // ����ť���1���¼�
		loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String str=e.getActionCommand();
                if("��  ¼".equals(str)){
                    String getName =username.getText();
                    String getPwd =password.getText();
//                    JOptionPane.showMessageDialog(parentComponent, message);
                     JOptionPane.showConfirmDialog(null, "��������û�����"+getName);
                }
            	Login login=getLogin();
            	login.dispose();
            	new Index();
            }
        });
		
		JLabel lblNewLabel = new JLabel("�û���");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel.setBounds(38, 164, 54, 22);
		bgContentPane.add(lblNewLabel);
//		
		JLabel lblNewLabel_1 = new JLabel("�� ��");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1.setBounds(38, 219, 54, 15);
		bgContentPane.add(lblNewLabel_1);
		//��ס����rememberPassword
		JRadioButton rememberPassword = new JRadioButton("��ס����");
		rememberPassword.setForeground(SystemColor.textInactiveText);
		rememberPassword.setBounds(102, 260, 121, 23);
		bgContentPane.add(rememberPassword);
		//�޸�����modifyPassword
		JLabel modifyPassword = new JLabel("�޸�����");
		modifyPassword.setForeground(SystemColor.textInactiveText);
		modifyPassword.setBounds(235, 264, 54, 15);
		modifyPassword.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//new Modify();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		bgContentPane.add(modifyPassword);
		//logo
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("img/logo1.png"));
		logo.setBounds(102, 0, 110, 110);
		bgContentPane.add(logo);
		
		JLabel logoword = new JLabel("��ѧ����ϵͳ");
		logoword.setForeground(SystemColor.activeCaption);
		logoword.setFont(new Font("����", Font.BOLD, 18));
		logoword.setHorizontalAlignment(SwingConstants.CENTER);
		logoword.setBounds(89, 120, 130, 22);
		bgContentPane.add(logoword);
		
		this.setBounds(0, 0, 320, 382);
		//�����С���ܸı�
		this.setResizable(false);
		//������ʾ
		this.setLocationRelativeTo(null);
		//����ͼ��
		this.setIconImage(null);
		//����ɼ�
		this.setVisible(true);
	}
}