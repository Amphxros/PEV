package Common;

import java.util.List;
import java.util.Random;

public class GenPr3 extends Gen{
	
	protected Object [] allele;
	public GenPr3(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startGen() {
		// TODO Auto-generated method stub
		this.allele= new Object[this.length];
		Random rnd= new Random();
		
		for(int i=0;i<this.length;i++) {
			
		}
		
	}

	@Override
	public double fenotype() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void copyGen(Gen gen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAllele(int position) {
		// TODO Auto-generated method stub
		return allele[position];
	}

	@Override
	public Object[] getAlleles() {
		// TODO Auto-generated method stub
		return this.allele;
	}

	@Override
	public void setAllele(Object obj,int position) {
		this.allele[position]=obj;
	}

}
