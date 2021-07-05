package DAO;

import java.util.*;
import DTO.Product;
import Exception.IndexOutOfBoundsException;

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

    public Iterator getProductsIterator(){
        return products.iterator();
    }
}
