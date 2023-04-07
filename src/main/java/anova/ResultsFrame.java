package anova;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultsFrame extends JFrame{
	private DecimalFormat df = new DecimalFormat("0.0000");
	public ResultsFrame(Anova a) {
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(650,432);
		JLabel lblNewLabel = new JLabel("Izvor varijacije");
		lblNewLabel.setBounds(40, 29, 89, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alternative");
		lblNewLabel_1.setBounds(218, 29, 119, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Greska");
		lblNewLabel_2.setBounds(393, 29, 89, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ukupno");
		lblNewLabel_3.setBounds(522, 29, 89, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Suma kvadrata");
		lblNewLabel_4.setBounds(41, 86, 119, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Broj stepeni slobode");
		lblNewLabel_5.setBounds(40, 141, 150, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Varijanse");
		lblNewLabel_6.setBounds(53, 197, 76, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Izracunata F vrijed");
		lblNewLabel_7.setBounds(40, 258, 150, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tabelarna F vrijed");
		lblNewLabel_8.setBounds(40, 308, 150, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Interval povjerenja za kontrast");
		lblNewLabel_9.setBounds(10, 357, 180, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel ssaLabel = new JLabel();
		ssaLabel.setText("SSA="+df.format(a.getSSA()));
		ssaLabel.setBounds(218, 86, 131, 14);
		getContentPane().add(ssaLabel);
		
		JLabel dfAltLbl = new JLabel();
		dfAltLbl.setText("k-1 ="+ a.getDfAlt());
		dfAltLbl.setBounds(218, 141, 119, 14);
		getContentPane().add(dfAltLbl);
		
		JLabel varianceSaLbl = new JLabel();
		varianceSaLbl.setText("Sa^2="+df.format(a.getVarSa()));
		varianceSaLbl.setBounds(218, 197, 144, 14);
		getContentPane().add(varianceSaLbl);
		
		JLabel FizrLbl = new JLabel();
		FizrLbl.setText(df.format(a.getF_Test())+"");
		FizrLbl.setBounds(218, 258, 119, 14);
		getContentPane().add(FizrLbl);
		
		JLabel FtabLbl = new JLabel();
		FtabLbl.setText(df.format(a.getF_Table())+"");
		FtabLbl.setBounds(218, 308, 119, 14);
		getContentPane().add(FtabLbl);
		
		JLabel intPovLbl = new JLabel();
		intPovLbl.setText("["+df.format(a.getInterval().getItem1())+","+df.format(a.getInterval().getItem2())+"]");
		intPovLbl.setBounds(218, 357, 312, 14);
		getContentPane().add(intPovLbl);
		
		JLabel sseLabel = new JLabel();
		sseLabel.setText("SSE= "+df.format(a.getSSE()));
		sseLabel.setBounds(393, 86, 108, 14);
		getContentPane().add(sseLabel);
		
		JLabel dfErrorLbl = new JLabel();
		dfErrorLbl.setText("k(n-1) = "+a.getDfErr());
		dfErrorLbl.setBounds(393, 141, 119, 14);
		getContentPane().add(dfErrorLbl);
		
		JLabel varianceSeLbl = new JLabel();
		varianceSeLbl.setText("Se^2= "+df.format(a.getVarSe()));
		
		varianceSeLbl.setBounds(393, 197, 137, 14);
		getContentPane().add(varianceSeLbl);
		
		JLabel sstLabel = new JLabel();
		sstLabel.setText("SST = "+df.format(a.getSST()));
		sstLabel.setBounds(522, 86, 102, 14);
		getContentPane().add(sstLabel);
		
		JLabel ukupnoBrStepSlLbl = new JLabel();
		int x=(a.getK()*a.getN())-1;
		ukupnoBrStepSlLbl.setText("kn-1 = "+x);
		ukupnoBrStepSlLbl.setBounds(522, 141, 102, 14);
		getContentPane().add(ukupnoBrStepSlLbl);
		
	}
	
}
