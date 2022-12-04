package com.it_academy.APITests;

import com.google.common.collect.ImmutableMap;
import com.it_academy.catalogOnlinerTests.model.Product;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.it_academy.catalogOnlinerTests.endpoins.OnlinerEndpoints.getCatalogProductEndPoint;
import static com.it_academy.catalogOnlinerTests.endpoins.OnlinerEndpoints.getCatalogProductRollsEndPoint;
import static com.it_academy.utils.GetRequestUtils.makeRequestAndGetResponseBody;
import static org.assertj.core.api.Assertions.assertThat;

public class APITest {
    private static final String PRODUCTS_ROLLS_JSON_PATH = "products.name_prefix";
    private static final String PRODUCTS_JSON_PATH = "products";

    private Map<String, Object> configureRequestHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    @Test
    public void apiTest1() {
       ResponseBody responseBody = makeRequestAndGetResponseBody(getCatalogProductEndPoint(), configureRequestHeaders(), null);
       List<Product> products = responseBody.jsonPath()
               .getList(PRODUCTS_JSON_PATH, Product.class);
        List<String> names = products
                .stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        assertThat(names)
                .as("Name field is empty ")
                .isNotEmpty()
                .isNotNull();
    }

    @Test
    public void apiTest2() {
        ResponseBody responseBody = makeRequestAndGetResponseBody(getCatalogProductRollsEndPoint(), configureRequestHeaders(), null);
        List<String> namePrefix = responseBody.jsonPath()
                .getList(PRODUCTS_ROLLS_JSON_PATH);
        assertThat(namePrefix)
                .as("Name prefix does not match the specified filter")
                .containsAll(Collections.singleton("Роллы"));
    }
}
