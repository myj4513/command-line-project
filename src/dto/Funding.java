package dto;

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

    public boolean equals(Funding funding){
        if(this == funding) return true;
        return user.equals(funding.user) && product.equals(funding.product) && time.isEqual(funding.time);
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
