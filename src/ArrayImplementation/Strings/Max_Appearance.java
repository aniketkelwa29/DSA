package ArrayImplementation.Strings;

import java.util.*;
import java.lang.*;


class Max_Appearance
{
    public static void Appearance(String str)
    {
        HashMap <Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int maxCount =0 ;
        char maxChar = 'z' ;
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue()>maxCount){
                maxCount=entry.getValue();
                maxChar = entry.getKey();
            }
            System.out.println(entry + " ");
        }
        System.out.println("the character appeared maximum times is : "+ maxCount +" and the character is "+ maxChar);
    }
    public static void main(String[] args)
    {
        String str = "auduewgdbsahd6y7qgAa";
        Appearance(str);
    }
}