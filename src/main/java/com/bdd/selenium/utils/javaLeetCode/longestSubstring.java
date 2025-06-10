package com.bdd.selenium.utils.javaLeetCode;

import java.util.HashMap;

public class longestSubstring {
    public static void main(String[] args)
    {
        String str="abcraywgbva";
        char[] ch=str.toCharArray();
        int pos=0;
        String maxString="";
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:ch)
        {
            if( map.containsKey(c))
            {
                break;
            }
            else{
                map.put(c,1);
                maxString+=c;
                pos++;
            }
        }

        System.out.println("Longest substring without repeating characters is: "+map.keySet()+"-"+maxString+" and length is "+pos);


    }
    
}
