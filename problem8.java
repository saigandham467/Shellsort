package algos.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Linearlogarithmic {
	public static void main(String[] args) throws InterruptedException{
		List<Integer>hlist = null;
		for(int i=1;i<=10;i++){
			for (int hsequence=1;hsequence<5;hsequence++){
				if(hsequence==1){
					hlist=gapSequence1(100000*i);
				}
				
				else if(hsequence==2){
					hlist=gapSequence2(100000*i);
				}
				else if(hsequence==3){
					hlist=gapSequence3(100000*i);
				}
				else if(hsequence==4){
					hlist=gapSequence4(100000*i);
				}
				int sum=0;
				for(int j=0;j<10;j++){
					sum=sum+sort(createRandomArray(100000*i),hlist);
				}
				Double logtotal=0.0;
				int num=100000*i;
				for(double var=num;var>0;var--){
					logtotal=logtotal+(Math.log10(var)/Math.log10(2));
					
				}
				double avgc=sum/10;
				avgc=avgc/logtotal;
				System.out.println("Average number of comparisons for input"+100000*i+" and for gap sequence "+hsequence+" is="+avgc);
			}
			
		}
			
		
	}

	//givensequence
	public static List<Integer>gapSequence1(long n){
		List<Integer>hlist=new ArrayList<Integer>();
		int h=1;
		int i=0;
		while(h<n){
			hlist.add(i,h);
			h=2*h+1;
			i++;
		}
		return hlist;
	}
	//tokudusequence
	public static List<Integer>gapSequence2(long n){
		List<Integer>hlist=new ArrayList<Integer>();
		int h=1;
		int i=0;
		while(h<n){
			h=(int)((Math.pow(9, i+1)-Math.pow(4, i+1))/(5*Math.pow(4, i)));
			hlist.add(i,h);
			i++;
		}
		return hlist;
	}
	//prattsequence
	public static List<Integer>gapSequence3(long n){
		List<Integer>hlist=new ArrayList<Integer>();
		int h=1;
		int i=0;
		while(h<n){
			h=(int) ((Math.pow(3, i+1)-1)/2);
			hlist.add(i,h);
			i++;
		}
		return hlist;
	}
	//mysequence
		public static List<Integer>gapSequence4(long n){
			List<Integer>hlist=new ArrayList<Integer>();
			int h=1;
			int i=0;
			while(h<n){
				h=(int) Math.pow(2.71828182846, i);
				hlist.add(i,h);
				i++;
			}
			return hlist;
		}
		public static double[] createRandomArray(int size){
		double[] A=new double[size];
		Random random=new Random();
		for(int i=0;i<size;i++){
			A[i]=random.nextDouble();
		}
		return A;
		}


		public static int sort(double[] A, List<Integer>hlist){
				int n=A.length;
				int h;
				int count=0;
				for(int pointer_h=hlist.size()-1;pointer_h>=0;pointer_h--){
					h=hlist.get(pointer_h).intValue();
					for(int j=h;j<n;j++){
						double key=A[j];
						int i=j-h;
						while(i>=0){
							if(A[i]>key){
								count++;
								A[i+h]=A[i];
								i=i-h;
							}
							else {
								count++;
								break;
							}
							
						}
						A[i+h]=key;
					}
				
				}
					return count;
		}
		
		
		
		
		
		
		

}



