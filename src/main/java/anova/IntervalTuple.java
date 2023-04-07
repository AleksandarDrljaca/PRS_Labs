package anova;

public class IntervalTuple <T,K>{
	
	T item1;
	K item2;
	public IntervalTuple() {
		super();
	}
	public IntervalTuple(T i1,K i2) {
		this.item1=i1;
		this.item2=i2;
	}
	public T getItem1() {
		return this.item1;
	}
	public K getItem2() {
		return this.item2;
	}
}
