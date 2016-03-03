package Number_17;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;



public class P469 extends AbstractList<Integer>{
	private int size;
    public P469(int size){
    	this.size=size;
    }
    
   
    
    public int size(){
    	return size;
    }
    public static void main(String[] args) {
		System.out.println(new P469(10));
	}



	public void replaceAll(UnaryOperator<Integer> operator) {
		// TODO Auto-generated method stub
		
	}



	public void sort(Comparator<? super Integer> c) {
		// TODO Auto-generated method stub
		
	}



	public Spliterator<Integer> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean removeIf(Predicate<? super Integer> filter) {
		// TODO Auto-generated method stub
		return false;
	}



	public Stream<Integer> stream() {
		// TODO Auto-generated method stub
		return null;
	}



	public Stream<Integer> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}



	public void forEach(Consumer<? super Integer> action) {
		// TODO Auto-generated method stub
		
	}



	
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return index;
	}



	
}