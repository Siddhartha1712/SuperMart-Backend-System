package htp;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class update extends Access{
    Scanner sc = new Scanner(System.in);
    Access Ac = new Access();
    Data Fa;
    Boolean access=false;
    update() throws IOException {
        String ch;
            do{
                System.out.println("\nC :Customer Login\nM :Maintenance Login\nS :Holder Login");
                System.out.print("Enter Your Choice :");
                ch = bf.readLine();
                ch = ch.toLowerCase();

                switch(ch){
                    case "c":{
                        User u = new User();
                        break;
                    }
                    case "m":{
                        System.out.println("Enter Your ID: ");
                        String id = sc.next();
                        System.out.println("Enter Your Password");
                        String pwd = sc.next();
                        access = Ac.pass_check(id,pwd);
                        if(access){
                            Fa = new Maintain();
                            System.out.println();
                        }else{
                            System.out.println("Access Denied");
                            System.out.println();
                        }
                        break;
                    }
                    case "s":{
                        System.out.print("Enter Your Id: ");
                        String s = sc.next();
                        System.out.print("Enter Your Password: ");
                        String pas = sc.next();
                        if(super_pass_check(s,pas)){
                            Fa = new Super();
                        }else{
                            System.out.println("Access Denied");
                            System.out.println();
                        }
                        break;
                    }
                    default:{
                        System.out.println("Invalid Choice ");
                        System.out.println();
                    }
                }
            }while(true);

    }


}
