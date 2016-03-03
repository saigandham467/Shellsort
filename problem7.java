package algos.shell;

import java.util.*;
public class LogarithmicScale{

		
	public static void main(String[] args) throws InterruptedException{
		List<Integer>hlist = null;
		for(int i=1;i<=6;i++){
			for (int hsequence=1;hsequence<5;hsequence++){
				if(hsequence==1){
					hlist=gapSequence1((long)Math.pow(10, i));
				}
				
				else if(hsequence==2){
					hlist=gapSequence2((long)Math.pow(10, i));
				}
				else if(hsequence==3){
					hlist=gapSequence3((long)Math.pow(10, i));
				}
				else if(hsequence==4){
					hlist=gapSequence4((long)Math.pow(10, i));
				}
				int sum=0;
				for(int j=0;j<10;j++){
					sum=sum+sort(createRandomArray((int)Math.pow(10, i)),hlist);
				}
				double avgc=sum/10;
				System.out.println("Average number of comparisons for input"+Math.pow(10, i)+" and for gap sequence "+hsequence+" is="+avgc);
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

