package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Object[] hayStack1 = {"3", "234234", null, "needle", true, 2};

        System.out.println(findNeedle(hayStack1));


    }

    public static String findNeedle(Object [] x){
       for (int i = 0; i<x.length ; i++){
          if("needle".equals(x[i])){
              return "found in "+ i;
          }
       }
        return "";
    }
}
