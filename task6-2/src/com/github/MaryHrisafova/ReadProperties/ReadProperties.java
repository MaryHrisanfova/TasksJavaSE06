package com.github.MaryHrisafova.ReadProperties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 * Created by Маша on 27.10.2015.
 */
public class ReadProperties {

    public static Map<String, String> readPropertiesFileAsMap(String filename, String delimiter)
            throws IOException {
        Map<String, String> map = new HashMap();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) continue;
                if (line.charAt(0) == '#') continue;
                int delimPosition = line.indexOf(delimiter);
                String key = line.substring(0, delimPosition).trim();
                String value = line.substring(delimPosition +1).trim();
                map.put(key, value);
                System.out.println("key = " + key);
                System.out.println("value = " + value);
            }
            reader.close();


        }
        catch (FileNotFoundException r){
            System.out.println("Произошла ошибка. Файл не найден.");
        }
        catch (Exception e){
            System.out.println("Произошла ошибка");
        }
        return map;

    }

    public static void main(String[] args) throws IOException{
        Map <String,String> properties= readPropertiesFileAsMap("rainbow","=");
    }
}
