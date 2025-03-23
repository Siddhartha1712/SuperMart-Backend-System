package htp;

import java.io.*;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class User extends Data{
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(in);
    Scanner sc = new Scanner(System.in);
    User() throws IOException {
        String chi;
        System.out.print("____________________________Welcome__________________________");
        while(true){
            System.out.println("\n1.Search Product\n2.Cart\n3.Check Product Detail\n4.Exit");
            System.out.print("Enter Your Choice: ");
            chi = bf.readLine();
            switch(chi){
                case "1" :{
                    System.out.print("Enter the Product Name: ");
                    String pro = bf.readLine();
                    search(pro);
                    break;
                }
                case "2":{
                    String n;
                    do{
                        System.out.println("\n1.Add to Cart\n2.Remove from Cart\n3.Show Cart Items\n4.Exit");
                            System.out.println("Enter here: ");
                            n = bf.readLine();
                        switch(n) {
                            case "1": {
                                Add_To_Cart();
                                break;
                            }
                            case "2": {
                                String s;
                                System.out.println("Enter the Name of Product: ");
                                String pn = bf.readLine();
                                if (Cart.containsKey(pn) && Cart.get(pn) > 1) {
                                    System.out.println("1.Remove All\n2.Reduce the Quantity");
                                    System.out.print("Enter Here: ");
                                    s = bf.readLine();
                                    switch (s) {
                                        case "1": {
                                            Remove_from_cart(pn);
                                            break;
                                        }
                                        case "2": {
                                            System.out.println("Enter the Number of Products to Remove :");
                                            int q = sc.nextInt();
                                            Remove_from_cart(pn, q);
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("Products Doesn't Found in the Cart");
                                }
                                break;
                            }
                            case "3":{
                                int total =0;
                                System.out.println("      Product          |    Quantity    |      Price ");
                                for(Map.Entry<String,Integer> e :Cart.entrySet()){
                                        String hh = e.getKey();
                                        hh = hh.trim();
                                        for(int i=hh.length();i<=20;i++){
                                            hh += " ";

                                        }
                                        String ss= ""+e.getValue();
                                        for(int i=5-ss.length();i>0;i--){
                                            ss+=" ";
                                        }
                                        total += PPrice.get(e.getKey())*e.getValue();
                                        System.out.println(hh+"  |       "+ss+"    |       "+PPrice.get(e.getKey())*e.getValue());
                                }
                                System.out.println("Total Amount :  "+total);
                                break;
                            }default:{
                                if(n.equals("4")){

                                }
                                else{
                                    System.out.println("Invalid Choice ");
                                }
                            }
                        }
                    }while(!n.equals("4"));
                    break;
                }
                case "3":{
                    System.out.print("Enter the Product Name: ");
                    String key = bf.readLine();
                    if(Product.containsKey(key)){
                        System.out.println();
                        System.out.println("Product ="+key+"       |       Quantity = "+Product.get(key)+"         |         Price = "+PPrice.get(key));
                    }
                    break;

                } case "4":{
                    return;
                }
                default:{
                    System.out.println("Invalid choice ");
                    break;
                }
            }
        }

    }
    public void Add_To_Cart() throws IOException{
        String prdct,c;
        int n;
        do{
            System.out.print("\nEnter the Product name :");
            prdct = bf.readLine();
            System.out.print("Enter the Quantity of Product :");
            n = sc.nextInt();
            sc.nextLine();
            if(Cart.containsKey(prdct)){
                if(Product.containsKey(prdct)){
                    n = Cart.get(prdct)+n;
                    Cart.put(prdct,n);
                    System.out.println("Product Updated in Cart\n");
                }else{
                    System.out.println("Invalid Product Name or Product Doesn't Found");
                }
            }else{
                if(Product.containsKey(prdct)){
                    if(Product.get(prdct)>0){
                        Cart.put(prdct,n);
                        System.out.println("Product Added to Cart\n");
                    }else{
                        System.out.println("Product is out of stock");
                    }
                }else{
                    System.out.println("Invalid Product Name or Product Doesn't Found");
                }
            }

            System.out.println("Enter E to Exit or Press Any Key to Continue");
            c = bf.readLine();
            c = c.toLowerCase();
        }while(!Objects.equals(c, "e"));
        System.out.println();
        System.out.println("Products added to Cart Successfully\n");
    }

    public void Remove_from_cart(String s){
        if(Cart.containsKey(s)){
            Cart.remove(s);
            System.out.println("Product Removed From the Cart\n");
        }else{
            System.out.println("Product Doesn't Found \n");
        }
    }
    public void Remove_from_cart(String s,int n){
        if(Cart.containsKey(s)){
            Cart.put(s,Cart.get(s)-n);
            System.out.println("Product Quantity Updated\n");
        }else{
            System.out.println("Product Doesn't Added Yet \n");
        }
    }
  /*  public void Show_cart_bill(){
        int total=0;
        System.out.println("___________________BILL___RECEIPT____________________");
        System.out.println("      Product          |    Quantity    |      Price ");
        for(Map.Entry<String,Integer> e :Cart.entrySet()){
            String hh = e.getKey();
            hh = hh.trim();
            for(int i=hh.length();i<=20;i++){
                hh += " ";

            }
            String ss= ""+e.getValue();
            for(int i=5-ss.length();i>0;i--){
                ss+=" ";
            }
            total += PPrice.get(e.getKey())*e.getValue();
            System.out.println(hh+"  |       "+ss+"    |       "+PPrice.get(e.getKey())*e.getValue());
        }
        System.out.println();
        System.out.println("Tax 18%      :"+calc_tax(total));
        System.out.println("Total Amount : "+(total+calc_tax(total)));
    }

   */
}
