package com.techelevator;
import java.util.regex.Pattern;

public class Solution {
	String[] l = {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"};


    
    public static String[] solution(String[] l) {

        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                
                // Tokenize
                String[] a = l[i].split(Pattern.quote("."));
                String[] b = l[i].split(Pattern.quote("."));
                
                // check to see if the first int is bigger than the second
                if (Integer.parseInt(a[0]) < Integer.parseInt(b[0])) {
                    
                    String temp = l[i];
                    l[i] = l[j];
                    l[j] = temp;
                    
                } else if (Integer.parseInt(a[0])==Integer.parseInt(b[0])) {
                        
                        // check to see they're both great than 1
                        if (a.length > 1 && b.length > 1) {
                            
                            // check the second value
                            if (Integer.parseInt(a[1]) < Integer.parseInt(b[1])) {
                                
                                // temp hold value
                                String temp = l[i];
                                l[i] = l[j];
                                l[j] = temp;
                                
                            } else if (Integer.parseInt(a[2])<Integer.parseInt(b[2])) {
                                
                                // check if the length is greater than 2
                                if (a.length>2 && b.length>2) {
                                    
                                    // check the 3 element
                                    if (Integer.parseInt(a[2]) < Integer.parseInt(b[2])) {
                                        
                                        // temp hold value
                                        String temp = l[i];
                                        l[i] = l[j];
                                        l[j] = temp;
                                    }
                                } else {
                                    
                                    if (a.length<b.length) {
                                        String temp = l[i];
                                        l[i] = l[j];
                                        l[j] = temp;
                                        
                                    }
                                }
                            
                        }  else {
                            if (a.length < b.length) {
                                String temp = l[i];
                                l[i] = l[j];
                                l[j] = temp;
                            }
                        } 
                    }
                }
            }
        }
        return l;
    }
}
