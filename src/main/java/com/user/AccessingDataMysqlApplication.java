package com.user;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
		System.out.println( "Hello World!" );

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4);
		arr.add(6);
		arr.add(7);
		arr.add(4);
		arr.add(7);
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i: arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}
			else {
				map.put(i,1);
			}
		}
		Set set = map.entrySet();
		/*
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry 
		}
		import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class HelloWorld{

static ArrayList<ArrayList<Integer>> numPath = new ArrayList<ArrayList<Integer>>();

    public static void someRecursiveMethod(int num) {
    while (num < 10) {
        num++;
        someRecursiveMethod(num);
        System.out.println("Current num = " + num);
    }
}
    public static int find(int old,int found, List<Integer> ar1, ArrayList<Integer> ar2, ArrayList<Integer> numpath,int height ){
        int numFound;
        int saveNum=100;
        
        int cur_row = old;
        if(cur_row==found){
             System.out.println("yayay");
            return cur_row;
        }
        
        for(int i = 0; i<ar1.size();i++){
            System.out.println(cur_row + " " + ar1.get(i));
            if(ar1.get(i).equals(cur_row)){
                 System.out.println(ar2.get(i));
                 
                cur_row = ar2.get(i);
                numpath.add(cur_row);
                numpath.add(height);
                numFound = find(cur_row,found,ar1,ar2,numpath,++height);
                height--;
                if(numFound==found){
                    //numpath.add(cur_row);
                    saveNum = numFound;
                    System.out.println("yayay " + cur_row);
                    if(old==1){
                         numPath.add(numpath);
                        
                         if(i<ar1.size()){
                              cur_row = old;
                              numpath = new ArrayList<Integer>();
                             continue;
                         }
                    }
                   
                // find(ar1.get(i),found,ar1.subList(i++,ar1.size()),ar2,numpath);
                      
                   // numpath = new ArrayList<Integer>();
                   
                   // return numFound;
                }
                else{
                  // numpath = new ArrayList<Integer>();
                   if(numpath.size()>0){
                   numpath.remove(numpath.size()-1);
                   numpath.remove(numpath.size()-1);
                   }
                }
                cur_row = old;
            }
            if(saveNum==found && (i == (ar1.size()-1))){
                        return saveNum;
                    }
        }
       return 100;
        
    }
     
     public static void main(String []args){
        System.out.println("Hello World");
        List<Integer> ar1 = new ArrayList<Integer>();
        ArrayList<Integer> ar2 = new ArrayList<Integer>();
        ArrayList<Integer> numpath = new ArrayList<Integer>();
        ar1.addAll(Arrays.asList(1,2,2,3,5,1,4));
        ar2.addAll(Arrays.asList(2,3,4,7,7,3,7));
        int old = 1;
        int found = 7;
        int cur_row = old;
        
        cur_row = find(cur_row,found,ar1,ar2,numpath,0);
        for(ArrayList<Integer> x: numPath){
           
            System.out.println("s " + x);
            
        }
        
        someRecursiveMethod(8);
        
     }
}
		*/
		
	}

}