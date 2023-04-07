package anova;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnovaGUI extends JFrame {
	
	private Anova anova;
	JTextField[][] altFields;
	private JTextField alt1;
	private JTextField alt2;
	public AnovaGUI(Anova a) {
		this.anova=a;
		final JFrame frame=this;
		this.setSize(900,700);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 86, 660, 452);
		
		panel.setLayout(new GridLayout(5,3,5,5));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(panel);
		
		JPanel nthMesure = new JPanel();
		nthMesure.setBorder(BorderFactory.createLineBorder(Color.black));
		nthMesure.setBounds(10, 101, 53, 437);
		nthMesure.setLayout(new GridLayout(anova.getN(),1));
		for(int i=1;i<=anova.getN();i++) {
			JLabel label=new JLabel(String.valueOf(i));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			nthMesure.add(label);
		}
		getContentPane().add(nthMesure);
		
		JPanel altPanel = new JPanel();
		altPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		altPanel.setBounds(100, 36, 660, 39);
		getContentPane().add(altPanel);
		altPanel.setLayout(new GridLayout(1,1));
		JLabel label_1 = new JLabel("Mjerenja");
		label_1.setBounds(10, 24, 51, 75);
		getContentPane().add(label_1);
		
		JLabel ukupnaSrVrLabel = new JLabel("<html> Ukupna srednja vrijednost </html>");
		ukupnaSrVrLabel.setBounds(795, 54, 63, 45);
		getContentPane().add(ukupnaSrVrLabel);
		
		JButton btnNewButton = new JButton("Izracunaj");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anova.calculateMeanColumnValues(altFields);
				anova.calculateEffect(altFields);
				anova.calculateSSAnSSTnSSEnVariances(altFields);
				anova.calculateFTable();
				anova.calculateStudentDistribution(anova.getDfErr());
				anova.calculateContrast(Integer.parseInt(alt1.getText()),Integer.parseInt(alt2.getText()));
				System.out.println(anova.getSSE());
				anova.formInterval();
				EventQueue.invokeLater(new Runnable() {
			        public void run() {
			        	new ResultsFrame(anova);
			        	frame.dispose();
			        }
			    });
				
			}
		});
		btnNewButton.setBounds(671, 593, 89, 23);
		getContentPane().add(btnNewButton);
		
		alt1 = new JTextField();
		alt1.setBounds(415, 563, 86, 20);
		getContentPane().add(alt1);
		alt1.setColumns(10);
		
		alt2 = new JTextField();
		alt2.setBounds(415, 594, 86, 20);
		getContentPane().add(alt2);
		alt2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Racunanje kontrasta");
		lblNewLabel.setBounds(100, 578, 128, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alternativa 1");
		lblNewLabel_1.setBounds(249, 566, 113, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alternativa 2");
		lblNewLabel_2.setBounds(249, 597, 113, 14);
		getContentPane().add(lblNewLabel_2);
		
		
		
		altFields=new JTextField[anova.getN()][anova.getK()];
		
		for(int i=0;i<anova.getN();i++) {
			for(int j=0;j<anova.getK();j++) {
				altFields[i][j]=new JTextField();
				panel.add(altFields[i][j]);
				if(i==0) {
					JLabel altLabels=new JLabel(String.valueOf(j+1));
					altLabels.setHorizontalAlignment(SwingConstants.CENTER);
					altPanel.add(altLabels);
				}
			}
		}
		
		
	}
}
