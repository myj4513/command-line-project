package dao;

import java.util.*;
import java.util.stream.Stream;

import dto.*;
import exceptions.IndexOutOfBoundsException;

public class FundingDAO {
    private List<Funding> fundings = new LinkedList<Funding>();

    public void addFunding(Funding funding){
        fundings.add(funding);
    }

    public void removeFunding(Funding funding){
        fundings.remove(funding);
    }

    public List<Funding> getSponsor(Product product){
        List<Funding> tmp = new ArrayList<Funding>();
        fundings.stream().filter(s->s.getProduct().equals(product)).forEach(s->tmp.add(s));
        return tmp;
    }

    public List<Funding> getFundingProductList(User user){
        List<Funding> tmp = new ArrayList<Funding>();
        fundings.stream().filter(s->s.getUser().equals(user)).forEach(s->tmp.add(s));
        return tmp;
    }

    public Funding getFunding(List<Funding> list, int index) {
        if(index<1 || index > list.size())
            throw new IndexOutOfBoundsException();
        return list.get(index-1);
    }
}
