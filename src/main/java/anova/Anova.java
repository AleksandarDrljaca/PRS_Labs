package anova;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import javax.swing.JTextField;

public class Anova {
	private int k,n;
	private double[] meanColumn; //y.j
	private double totalMean; //y..
	private int dfAlternative;
	private int dfError;
	private double[] effect; //alfa_j
	private double SST=0d;
	private double SSA=0d;
	private double SSE=0d;
	private double varianceSSA;
	private double varianceSSE;
	private double Sc;
	private double F_Test;
	private double F_Table;
	private double T_Table;
	private double altFieldsSum=0d;
	private double contrast=0d;
	private IntervalTuple<Double,Double> confidenceInterval;
	public Anova() {
		super();
	}
	public Anova(int n,int k) {
		this.n=n;
		this.k=k;
		this.meanColumn=new double[k];
		this.effect=new double[k];
		this.dfAlternative=this.k-1;
		this.dfError=this.k*(this.n-1);
	}
	public int getN() {
		return this.n;
	}
	public int getK() {
		return this.k;
	}
	public double getSSA() {
		return SSA;
	}
	public double getSST() {
		return SST;
	}
	public double getSSE() {
		return SSE;
	}
	public int getDfAlt() {
		return dfAlternative;
	}
	public int getDfErr() {
		return dfError;
	}
	public double getF_Test() {
		return F_Test;
	}
	public double getF_Table() {
		return F_Table;
	}
	public double[] getEffect() {
		return effect;
	}
	public double getContrat() {
		return contrast;
	}
	public double getVarSe() {
		return varianceSSE;
	}
	public double getVarSa() {
		return varianceSSA;
	}
	public IntervalTuple<Double,Double> getInterval(){
		return confidenceInterval;
	}
	public void calculateMeanColumnValues(JTextField[][] matrix) {
		double currSum=0;
		for(int i=0;i<getK();i++) {
			currSum=0d;
			for(int j=0;j<getN();j++) {
				currSum+=Double.valueOf(matrix[j][i].getText());
				altFieldsSum+=Double.valueOf(matrix[j][i].getText());
			}
			meanColumn[i]=currSum/this.getN();
			
		}
		calculateTotalMean();
		
	}
	public void calculateEffect(JTextField[][] matrix) {
		
		for(int i=0;i<getK();i++) 
			effect[i]=meanColumn[i]-totalMean;
	
	}
	public void calculateTotalMean() {
		this.totalMean=altFieldsSum/(getK()*getN());
		
	}
	public void calculateSSAnSSTnSSEnVariances(JTextField[][] matrix) {
		for(int j=0;j<getK();j++) {
			for(int i=0;i<getN();i++) {
				SSE+=Math.pow((Double.valueOf(matrix[i][j].getText())-meanColumn[j]),2.0);
				SST+=Math.pow((Double.valueOf(matrix[i][j].getText())-totalMean),2.0);
			}
		}
		SSA=SST-SSE;
		varianceSSA=SSA/dfAlternative;
		varianceSSE=SSE/dfError;
		F_Test=varianceSSA/varianceSSE;
		
	}
	
	public void calculateFTable() {
		FDistribution fd=new FDistribution(dfAlternative,dfError);
		double probabilityTest = 0.000;
		double probability=0.95;
		double step=0.001;
		while(probability >= fd.cumulativeProbability(probabilityTest)) {
			probabilityTest += step;
		}
		F_Table=probabilityTest;
	}
	public void calculateStudentDistribution(double x) {
		TDistribution fd=new TDistribution(dfAlternative,dfError);
		double probabilityTest = 0.000;
		double probability=0.90;
		double step=0.001;
		while(probability >= fd.cumulativeProbability(probabilityTest)) {
			probabilityTest += step;
		}
		T_Table=probabilityTest;
	}
	public void calculateContrast(int a1,int a2) {
		contrast=effect[a1-1]-effect[a2-1];
	
	}
	
	private void calculateSc() {
		double Se=Math.sqrt(varianceSSE);
		int kn=getK()*getN();
		Sc=Se*(double)(Math.sqrt(2.0/(double)kn));
		System.out.println(Sc);
	}
	public void formInterval() {
		calculateSc();
		double c1=0d,c2=0d;
		c1=contrast-(T_Table*Sc);
		c2=contrast+(T_Table*Sc);
		confidenceInterval= new IntervalTuple<Double,Double>(c1,c2);
		
	}
	
	
	
}
