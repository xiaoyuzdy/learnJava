package Number_eight;

import java.util.Random;

/**
 * ºóÆÚ°ó¶¨
 * 
 * @author he
 *
 */

class Shap{
	public void draw(){}
}

class Cricle extends Shap{
	public void draw(){
		System.out.println("Cricle.draw()");
	}
}

class Triangle extends Shap{
	public void draw(){
		System.out.println("Triangle.draw()");
	}
}

class RandomShapeGenerator{
	private Random random=new Random();
	
	public Shap next(){
		switch(random.nextInt(4)){
		default:
			case 0 : return new Cricle();
			case 1 : return new Triangle();
			case 2 : return new Cricle();
			case 3 : return new Triangle();
			
		}
		
	}
	
	
}


public class P152 {
	private static RandomShapeGenerator gen=new RandomShapeGenerator();
	public static void main(String[] args) {
		Shap []a=new Shap[8];
		for (int i = 0; i < a.length; i++) {
			a[i]=gen.next();
		}
		
		for(Shap shap :a){
			shap.draw();
		}
	}

}
