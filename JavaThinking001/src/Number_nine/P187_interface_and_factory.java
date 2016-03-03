package Number_nine;
 interface ProductA  {
	 
}
 
 class ProductA1 implements ProductA  {
       public String toString(){
    	   return "new ProucrA1";
       }
}
 
 
 class ProductA2 implements ProductA  {
 
}
 
 interface ProductB  {
 
}
 
 class ProductB1 implements ProductB  {
	 public String toString(){
  	   return "new ProucrB1";
     }
}
 
 class ProductB2 implements ProductB  {
 
}
 
 interface Creator  {
 
    public ProductA factoryA();
     
    public ProductB factoryB();
     
}
 
 class Creator1 implements Creator  {
 
    public ProductA factoryA()  {
        return new ProductA1();
    }
 
    public ProductB factoryB()  {
        return new ProductB1();
    }
 
}
 
 class Creator2 implements Creator  {
 
    public ProductA factoryA()  {
        return new ProductA2();
    }
 
    public ProductB factoryB()  {
        return new ProductB2();
    }
 
}
 
public class P187_interface_and_factory  {
     
    ProductA pa;
    ProductB pb;
     
    public static void main(String[] args)  {
    	P187_interface_and_factory client = new P187_interface_and_factory();
        Creator1 c1 = new Creator1();
        client.pa = c1.factoryA();
        client.pb = c1.factoryB();
        System.out.println(client.pa);
        System.out.println(client.pb);
    }
 
}

