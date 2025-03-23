package htp;
import java.util.*;
public class Data {

    static int i=1;
    static HashMap<String,Integer> Product = new HashMap<>();
    static HashMap<String,Integer> PPrice = new HashMap<>();
    static HashMap<String,Integer> Cart = new HashMap<>();
    private static float tax_rate=18;
    Data(){
        while(i==1){
            Product.put("mango juice",250);
            Product.put("grape juice",190);
            Product.put("lemon juice",230);
            Product.put("chiku juice",110);
            Product.put("banana juice",270);
            Product.put("strawberry juice",130);
            Product.put("orange juice",190);
            Product.put("apple juice",90);
            Product.put("papaya juice",140);
            Product.put("coconut juice",330);


            PPrice.put("mango juice",110);
            PPrice.put("grape juice",70);
            PPrice.put("lemon juice",40);
            PPrice.put("chiku juice",40);
            PPrice.put("banana juice",30);
            PPrice.put("strawberry juice",80);
            PPrice.put("orange juice",60);
            PPrice.put("apple juice",90);
            PPrice.put("papaya juice",40);
            PPrice.put("coconut juice",40);
            i++;
        }
    }

    public void add_pro(String Name, int Quantity, int Price){
        if(!Product.containsKey(Name)){
            System.out.println("Product added successfully");
            Product.put(Name,Quantity);
            PPrice.put(Name,Price);
        }else{
            int v = Product.get(Name);
            v += Quantity;
            System.out.println("Product Already Exists");
            Product.put(Name, v);
            System.out.println("Product Updated : "+Name+" = "+Product.get(Name));
        }
    }
    public void set_price(String pro,int cash){
        if(PPrice.containsKey(pro)){
            PPrice.put(pro,cash);
            System.out.println("Price Updated Successfully");
        }else{
            System.out.println("Can't found Product ");
        }
    }
    public void show_pro() {
        System.out.println("______________Total Product Available________________");
        System.out.println("      Product          |    Quantity    |      Price ");
        for (Map.Entry<String, Integer> e : Product.entrySet()) {
            String hh = e.getKey();
            hh = hh.trim();
            for (int i = hh.length(); i <= 20; i++) {
                hh += " ";
            }
            String ss = "" + e.getValue();
            for (int i = 5 - ss.length(); i > 0; i--) {
                ss += " ";
            }
            System.out.println(hh + "  |       " + ss + "    |       " + PPrice.get(e.getKey()));
        }
        System.out.println("_____________________________________________________");
        System.out.println();
    }
    public void search(String s){
        System.out.println();
        if(Product.containsKey(s)){
            System.out.println("Product : "+s+"    |     Price : "+PPrice.get(s));
            if(Product.get(s)>1){
                System.out.println("Status : Available");
            }else{
                System.out.println("Product Status : UnAvailable");
            }
        }else{
            System.out.println("Product Doesn't Found ");
        }
    }
    public float calc_tax(float amount){
        float t = tax_rate/100;
        amount = amount*t;
        return amount;
    }
    public float get_tax(){
        return tax_rate;
    }
    public void set_tax(float tax1){
        tax_rate = tax1;
    }

}
