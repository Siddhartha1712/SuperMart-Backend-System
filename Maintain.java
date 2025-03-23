package htp;

import java.io.*;

import java.util.*;
    public class Maintain extends Data{

        static HashMap<String, Integer> bil_pro = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        Maintain() throws IOException {
            String i;
            do{
                System.out.println("\n1.Add Product to Bill\n2.Remove Product from bill\n3.Show Bill\n4.Bill the Products on Cart\n5.All Product Detail\n6.Check Product Detail\n7.Exit");
                System.out.print("Enter here: ");
                i= bf.readLine();

                switch(i){
                    case "1":{
                        billing();
                        break;
                    }case "2":{
                        System.out.print("Enter the Name of the Product to Remove: ");
                        String key = bf.readLine();
                        key = key.toLowerCase();
                        remove_from_bill(key);
                        break;
                    }case "3":{
                        Show_bill();
                        break;
                    }case "4":{
                        System.out.println();
                        Show_Cart_bill();
                        System.out.println();
                        break;
                    }case "5":{
                        show_pro();
                        break;
                    }case "6":{
                       System.out.print("Enter the Product Name: ");
                       String name = bf.readLine();
                        System.out.println("Product: "+name+"     Quantity: "+Product.get(name)+"     Price: "+PPrice.get(name));
                        break;
                    }default:{
                    if(!i.equals("7")){
                        System.out.println("Invalid Entry");
                    }
                    break;
                }
            }
        }while(!i.equals("7"));

    }
    public void billing() throws IOException {
        boolean b = false;
        do{
            System.out.print("\nEnter the Product :");
            String pro = bf.readLine();
            pro = pro.trim();
            pro = pro.toLowerCase();

            if(!Product.containsKey(pro)){
                System.out.println("Invalid Product");
                continue;
            }
            System.out.print("Enter number of items :");
            int ct = sc.nextInt();
            if(Product.get(pro)-ct<=0){
                System.out.println("Product out of stock");
                continue;
            }

            bil_pro.put(pro,ct);
            product_maintain(pro,ct);
            System.out.println("Enter C to Continue or E to End");
            char c = sc.next().charAt(0);
            c = Character.toLowerCase(c);
            if(c=='c'){
                b = true;
            }else{
                b =false;
            }
        }while(b);

    }
    public void Show_bill(){
        int total=0;
        if(bil_pro.isEmpty()){
            System.out.println("No Products Added for Billing");
            return;
        }
        System.out.println();
        System.out.println("___________________BILL___RECEIPT____________________");
        System.out.println("      Product          |    Quantity    |      Price ");
        for(Map.Entry<String,Integer> e :bil_pro.entrySet()){
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
        System.out.println("Tax "+get_tax()+"%      "+calc_tax(total));
        System.out.println("Total Amount : "+(total+calc_tax(total)));
        System.out.println("_____________________________________________________");
        System.out.println();

       // show_pro();
    }

    public void product_maintain(String Key,Integer Val){
        int count;
        if(Product.containsKey(Key)){
            count = Product.get(Key);
            Product.put(Key,count-Val);
        }
    }
    public void remove_from_bill(String key){
        if(bil_pro.containsKey(key)){
            bil_pro.remove(key);
            System.out.println("Product "+key+" Removed from the bill");
        }else{
            System.out.println("Product Doesn't Found");
        }
    }
    public void Show_Cart_bill(){
        int total=0;
        System.out.println();
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
            product_maintain(e.getKey(),e.getValue());
            System.out.println(hh+"  |       "+ss+"    |       "+PPrice.get(e.getKey())*e.getValue());
        }
        System.out.println();
        System.out.println("Tax "+get_tax()+"%      "+calc_tax(total));
        System.out.println("Total Amount : "+(total+calc_tax(total)));
        System.out.println("_____________________________________________________");
        show_pro();
    }



}
