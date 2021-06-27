package dao;

import dto.Product;

import java.util.*;

public class ProductDao {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }



}
