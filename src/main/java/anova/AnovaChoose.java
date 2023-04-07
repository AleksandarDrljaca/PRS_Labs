package anova;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class AnovaChoose extends JFrame {
	private JTextField textField=new JTextField();
	private JTextField textField_1=new JTextField();
	

	public AnovaChoose() {
		final JFrame frame=this;
		this.setSize(300,200);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Broj mjerenja");
		lblNewLabel.setBounds(10, 42, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Broj alternativa");
		lblNewLabel_1.setBounds(10, 80, 125, 14);
		getContentPane().add(lblNewLabel_1);
		
		
		
		textField.setBounds(145, 39, 86, 20);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		
		textField_1.setBounds(145, 77, 86, 20);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Dalje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("")&& !textField_1.getText().equals("")) {
					new AnovaGUI(new Anova(Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText())));
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(145, 127, 89, 23);
		getContentPane().add(btnNewButton);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	        	new AnovaChoose();
	        }
	    });
	}
}
