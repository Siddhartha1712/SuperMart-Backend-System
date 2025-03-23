package htp;

import java.io.IOException;

public class Run {

    public static void main(String[] args){

        while(true){
            System.out.println();
            try {
                update up = new update();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
