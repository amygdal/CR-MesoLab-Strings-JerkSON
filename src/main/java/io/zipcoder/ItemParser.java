package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemParser {

    //breaks down array
    //returns a stringkey value pairs
    public ArrayList<String> parseRawDataIntoStringArray(String rawData) {
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern, rawData);
        return response;
    }

    public Item parseStringIntoItem(String rawItem) throws ItemParseException {

        ArrayList<String> rawItemKeyValuePairs = findKeyValuePairsInRawItemData(rawItem);
        HashMap<String, String> pairsMap = new HashMap<String, String>();

        for (String element : rawItemKeyValuePairs) {
            String[] pair = element.split(":");
            pairsMap.put(pair[0], pair[1]);
        }

        double priceToDouble = Double.parseDouble(pairsMap.get("price");

        Item ourItem = new Item(pairsMap.get("name"), priceToDouble, pairsMap.get("type"),
                pairsMap.get("expiration"));

        return ourItem;

    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem) {
        String stringPattern = "[;|^]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern, rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString) {
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }


}

//    ArrayList<String> keyValueList = findKeyValuePairsInRawItemData(rawItem);
//        for (String element: keyValueList){
//                element =
//                }
