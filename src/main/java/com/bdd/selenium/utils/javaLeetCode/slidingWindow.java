package com.bdd.selenium.utils.javaLeetCode;

import java.util.HashMap;
import java.util.Map;

public class slidingWindow
{
    public static void main(String[] args)
    {
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "lazy", "dog"};
        int windowSize = 3;


        for(int i=0;i<=words.length-windowSize;i++)
        {
            HashMap<String,Integer> map=new HashMap<>();

            // System.out.print("Window"+(i+1)+" : ");

            for(int j =i;j<i+windowSize;j++)
            {
                // System.out.print(words[j]+" ");
                if(map.containsKey(words[j]))
                map.put(words[j],map.get(words[j])+1);
                else
                map.put(words[i],1);
            }

            // for(Map.Entry<String, Integer> entry:map.entrySet())
            // {
            //     System.out.println(entry.getKey()+"-"+entry.getValue());
            // }
            System.out.println(map.entrySet());
            map=new HashMap<>();

        }
    }
}