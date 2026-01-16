package ArrayImplementation.Strings;

import java.util.*;
import java.lang.*;


class Appearance_Of_Character
{
    public static void Appearance(String str)
    {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : str.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        System.out.println("the character a appears : "+map.getOrDefault('a',0));

    }
    public static void main(String[] args)
    {
        String str = "auduewgdbsahd6y7qgAa";
        Appearance(str);
    }
}