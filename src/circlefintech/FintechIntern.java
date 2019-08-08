/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlefintech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tanvirul Islam
 */
public class FintechIntern {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //list to store the Height, Price , and index of the Tiles of back row
        List<List> list_back_row = new ArrayList<>();

        //list to store the Height, Price , and index of the Tiles of front row
        List<List> list_front_row = new ArrayList<>();
        sc.nextLine();

        // Taking User Input, Price, height of each row 
        String[] price_back_row = sc.nextLine().split(" ");
        String[] height_back_row = sc.nextLine().split(" ");
        String[] price_front_row = sc.nextLine().split(" ");
        String[] height_front_row = sc.nextLine().split(" ");

        
        //Comperator for sorting List
        Comparator<List> cm = new Comparator<List>() {
            @Override
            public int compare(List o1, List o2) {
                if (o1.get(1).equals(o2.get(1))) {
                    return ((int) o1.get(2) - (int) o2.get(2));
                } else {
                    return ((int) o1.get(1) - (int) o2.get(1));}}};
        

        for (int i = 0; i < n; i++) {
            
            //Adding price , size and index of tiles of back row, in List
            List<Integer> temp = new ArrayList<>();
            temp.add(i + 1);
            temp.add(Integer.parseInt(price_back_row[i]));
            temp.add(Integer.parseInt(height_back_row[i]));
            list_back_row.add(temp);
            
             //Adding price , size and index of tiles of font row, in List
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(i + 1);
            temp2.add(Integer.parseInt(price_front_row[i]));
            temp2.add(Integer.parseInt(height_front_row[i]));
            list_front_row.add(temp2);

        }
        
        //sorting both list....According to tiles price
        Collections.sort(list_back_row, cm);
        Collections.sort(list_front_row, cm);
        
        //Initializing two Stringbuilder, to store the index of arranged tiles
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        
        // a boolean variable, to keep track if each tiles in back row are taller than the tiles of front row 
        boolean flag1 = true;
        for (int i = 0; i < n; i++) {
            int h1 = (int) list_back_row.get(i).get(2);
            int h2 = (int) list_front_row.get(i).get(2);
            
            //if any tiles in back row are not taller than the tiles of front row 
            if (h1 <= h2) {
                //then Break, and change the boolean variable flase, to print "impossible"
                flag1 = false;
                break;
            }
            //else append the inxed of tiles of both row, to print later
            sb.append(list_back_row.get(i).get(0) + " ");
            sb2.append(list_front_row.get(i).get(0) + " ");
        }

        
        if (flag1) {
            System.out.println(sb);
            System.out.println(sb2);
        } else {
            System.out.println("impossible");
        }

    }

}
