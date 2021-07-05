package DAO;

import java.util.*;
import DTO.*;

public class FundingDAO {
    private List<Funding> fundings = new LinkedList<Funding>();

    public List<Funding> getFundings(){
        return fundings;
    }

    public void addFunding(Funding funding){
        fundings.add(funding);
    }

    public void removeFunding(Funding funding){
        fundings.remove(funding);
    }

    public List<Funding> getSponsor(Product product){
        List<Funding> tmp = new ArrayList<Funding>();
        Iterator it = fundings.iterator();
        while(it.hasNext()){
            Funding funding = (Funding)it.next();
            if(funding.getProduct() == product){
                tmp.add(funding);
            }
        }
        return tmp;
    }

    public List<Funding> getFundingList(User user){
        List<Funding> tmp = new ArrayList<Funding>();
        Iterator it = fundings.iterator();
        while(it.hasNext()){
            Funding funding = (Funding)it.next();
            if(funding.getUser()==user){
                tmp.add(funding);
            }
        }
        return tmp;
    }
}
