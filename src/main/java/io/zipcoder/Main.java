package io.zipcoder;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
        int numOfExceptions = 0;
        // TODO: parse the data in output into items, and display to console.

        ItemParser ourItemParser = new ItemParser();

        String sanitizedOutput = ourItemParser.rawItemToLowerCase(output);
        ArrayList<String> rawDataArrayList = ourItemParser.parseRawDataIntoStringArray(sanitizedOutput);
        ArrayList<Item> listOfItems = new ArrayList<Item>();

        for(String element: rawDataArrayList){
            try {
                Item item = ourItemParser.parseStringIntoItem(element);
                listOfItems.add(item);
            } catch(ItemParseException e){
                numOfExceptions++;
            }

        }

        System.out.println("Here is our number of exceptions: " + numOfExceptions);
        System.out.println(listOfItems.toString());

        /*
        To do: Group items by name and price and #of times seen.

        Steps to do that:
        1
        2
        3


         */

    }
}
