/*
 * Name :Anan Elayan 
 * ID :1211529 
 * sectione 3*/
package application;


public class Brand  extends  Item{

    //data fields
    private String brand;


    //NO argument constructor
    public Brand(){

    }

    // argument constructor
    public Brand(String brand , String type){
        super(type); //invoked the constructor parent
        this.brand=brand;
    }

    //method to get brand
    public String getBrand(){
        return  this.brand;
    }
    
    @Override
    public String toString() {
        return "Brand{" +
                "brand='" + brand + '\'' +
                '}';
    }

   
    
    
}
