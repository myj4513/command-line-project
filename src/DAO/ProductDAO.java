package DAO;

import java.util.*;
import DTO.Product;

public class ProductDAO {
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        System.out.println("상품이 등록되었습니다.");
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void getProductList(){
        Iterator it = products.iterator();
        int num =0;
        while(it.hasNext()){
            Product product = (Product)it.next();
            System.out.println(++num+"."+product.getName());
        }
    }

    public void showProduct(int i){
        System.out.println(products.get(i-1));
    }

    public Product getProduct(int i){
        return products.get(i-1);
    }
}
