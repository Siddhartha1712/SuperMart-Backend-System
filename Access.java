package htp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Access{
    //Sumith
    static int i=1;
    private static final HashMap<String,String> pass = new HashMap<>();

    private static final HashMap<String, String> sup = new HashMap<>();
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(in);
    Access(){
        while(i==1){
            sup.put("UNO123","001100");
            sup.put("UNO098","556655");

            pass.put("FA001","Anvi");
            pass.put("FA002","A1B2C3D4");
            pass.put("FA003","A1B2C3D4");
            pass.put("FA004","A1B2C3D4");
            pass.put("FA005","A1B2C3D4");
            pass.put("FA006","A1B2C3D4");
            pass.put("FA007","A1B2C3D4");
            pass.put("FA008","A1B2C3D4");
            pass.put("FA009","A1B2C3D4");
            i++;
        }
    }
    boolean pass_check(String id, String pwd){

        if(pass.containsKey(id)){

            if(pass.get(id).equals(pwd)){
                System.out.println("Request Accepted");
                return true;
            }else{
                System.out.println("Incorrect Password :|");
            }

        }
        return false;

    }
    public void add_employ(String id, String pass){
        Access a = new Access();
        Access.pass.put(id,pass);
        System.out.println("new Id "+id+" Added Successfully");
    }
    public void remove_employ_access(String id) throws IOException {
        System.out.println(id);
        System.out.println(pass.containsKey(id));
        if(pass.containsKey(id)){
            System.out.print("Enter C to continue :");
            String s = bf.readLine();
            s=s.toLowerCase();
            if(s.equals("c")){
                pass.remove(id);
                System.out.println("Removed Access to Employ of ID: "+id);
            }
        }else{
            System.out.println("Employ Id doesn't exist");
        }
    }
    public boolean super_pass_check(String s, String pass){
        s =s.trim();
        pass = pass.trim();
        return (sup.containsKey(s)&&sup.get(s).equals(pass));
    }


}
