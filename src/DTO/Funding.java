package DTO;

import java.time.*;

public class Funding {
    private User user;
    private Product product;
    private LocalDateTime time;

    public Funding(User user, Product product){
        this.user = user;
        this.product = product;
        this.time = LocalDateTime.now();
    }

    public User getUser(){
        return user;
    }

    public Product getProduct(){
        return product;
    }

    public LocalDateTime getTime(){
        return time;
    }
}
