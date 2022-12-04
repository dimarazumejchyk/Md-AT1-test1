package com.it_academy.catalogOnlinerTests.endpoins;

import static com.it_academy.catalogOnlinerTests.framework.PropertiesReader.getEndpointProperty;

public class OnlinerEndpoints {
    public static String getCatalogProductEndPoint() {
        return getEndpointProperty("catalog.products");
    }

    public static String getCatalogProductRollsEndPoint() {
        return getEndpointProperty("catalog.rolls.products");
    }


}
