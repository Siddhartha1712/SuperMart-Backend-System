package htp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class Super extends Data {

    Access a = new Access();
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader bf  = new BufferedReader(in);
    Scanner sc = new Scanner(System.in);
    Access ac = new Access();

    Super() throws IOException {
        Cart = new HashMap<>();
        String ch="";
        while(true){
            System.out.println("\ncp :Check Product Detail\nap: Add Product\nsp: Set Price\nstp: Show Total Product\ncq: Check Product Quantity\nst: Set Tax\nae: Add Employ\nre: Remove Employ Access\nb: Exit");
            System.out.print("Enter here :");
            ch = sc.next();
            ch = ch.toLowerCase();
            switch(ch){
                case "cp":{
                      //check product detail
                    System.out.print("Enter the Product Name :");
                    String name = bf.readLine();
                    System.out.println("Product: "+name+"     Quantity: "+Product.get(name)+"     Price: "+PPrice.get(name));
                    break;
                } case "ap":{
                    System.out.println("Enter the Product Name:");
                    String s = bf.readLine();
                    System.out.println(s);
                    System.out.println("Enter the Product Quantity :");
                    int n = sc.nextInt();
                    System.out.println(n);
                    System.out.println("Enter the Product price :");
                    int n1 = sc.nextInt();
                    System.out.println(n1);
                    add_pro(s,n,n1);
                    break;
                }
                case "sp":{
                    System.out.print("Enter the name of the product :");
                    String s = bf.readLine();
                    System.out.println(s);
                    s =s.trim();
                    s = s.toLowerCase();
                    System.out.print("Enter the Price of Product :");
                    int price = sc.nextInt();
                    set_price(s,price);
                    break;
                } case "stp":{
                    show_pro();
                    break;
                }
                case "cq":{
                    System.out.print("Enter the Product name: ");
                    String s = bf.readLine();
                    s =s.toLowerCase();
                    check_quan(s);
                    break;
                }
                case "st":{
                    System.out.print("Enter the tax Percentage :");
                    float tax = sc.nextFloat();
                    set_tax(tax);
                    break;
                }
                case "ae":{
                    System.out.print("Enter New Id: ");
                    String id = bf.readLine();
                    id = id.trim();
                    System.out.print("Enter New Password :");
                    String Pass = bf.readLine();
                    Pass = Pass.trim();
                    ac.add_employ(id,Pass);
                    break;
                }
                case "re":{
                    System.out.println("Enter the User Id");
                    String id = bf.readLine();
                    id = id.trim();
                    ac.remove_employ_access(id);
                    break;
                } case "b":{
                    return;
                }
                case "spp":{
                    show_pro();
                }
                default:{
                    System.out.println("Invalid Choice");
                    break;
                }
            }
        }

    }
    public void set_tax(float tax){
        System.out.println("Current Tax :"+super.get_tax());
        super.set_tax(tax);
        System.out.println("Updated Tax :"+super.get_tax());
    }

    public void check_quan(String s){
        if(Product.containsKey(s)){
            System.out.println(s+" :"+Product.get(s));
        }else{
            System.out.println("Product doesn't found ");
        }
    }
}
