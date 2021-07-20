package dao;

import java.util.*;
import dto.Product;
import exceptions.IndexOutOfBoundsException;

public class ProductDAO {
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public Product getProduct (int i) throws IndexOutOfBoundsException{
        if(i<=0 || i>products.size()){
            throw new IndexOutOfBoundsException();
        }
        return products.get(i-1);
    }
}
