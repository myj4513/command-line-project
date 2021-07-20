package view;

import dto.*;
import java.util.*;
import dao.FundingDAO;
import java.time.format.*;
import java.util.stream.IntStream;

import exceptions.InvalidValueException;
import exceptions.NotEnoughMoneyException;
import exceptions.IndexOutOfBoundsException;
import service.*;

public class FundingView {
    static Scanner s = new Scanner(System.in);
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss");

    public static void showSponsor(FundingDAO fundingDAO, Product product){
        List<Funding> list = fundingDAO.getSponsor(product);
        list.stream().forEach(f->System.out.println(list.indexOf(f)+1+"."+f.getUser().getId()+"   "+f.getTime().format(formatter)));
    }

    public static void showFundingProductList(FundingDAO fundingDAO, User user){
        List<Funding> list = fundingDAO.getFundingProductList(user);
        if(list.size()==0){
            System.out.println("펀딩 내역이 존재하지 않습니다.");
            return;
        }
        list.stream().forEach(f->System.out.println(list.indexOf(f)+1+"."+f.getProduct().getName()+"   펀딩일시 : "+f.getTime().format(formatter)));
    }

    public static void showFunding(UserService userService, ProductService productService, FundingDAO fundingDAO, int index){
        ShowPage.drawLine();
        Product product;
        try{
            product = productService.productDAO.getProduct(index);
        } catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("[상품정보]\n");
        ProductView.showProduct(product);
        System.out.println();
        System.out.println("현재 잔액은 "+userService.getCurrentUser().getAccount()+"원입니다.");
        System.out.print("펀딩 하시겠습니까?[y/n] : ");
        String tmp = s.nextLine();
        try{
            if(tmp.charAt(0)=='y' || tmp.charAt(0)=='Y'){
                // 펀딩: yes;
                try{
                    userService.subtractAccount(product.getFundingPrice());
                } catch(NotEnoughMoneyException e){
                    System.out.println(e.getMessage());
                    return;
                }
                Funding funding = new Funding(userService.getCurrentUser(), product);
                fundingDAO.addFunding(funding);
                productService.addCurrentAmount(product);
                System.out.println("펀딩이 완료되었습니다.");
            }else if(tmp.charAt(0)=='n' || tmp.charAt(0)=='N'){
                // 펀딩: no
                return;
            }else{
                throw new InvalidValueException();
            }
        } catch(InvalidValueException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showCancelFunding(UserService userService, ProductService productService, FundingService fundingService, FundingDAO fundingDAO, int index){
        List<Funding> list = fundingDAO.getFundingProductList(userService.getCurrentUser());
        try{
            Funding funding = fundingDAO.getFunding(list, index);
            fundingService.cancelFunding(userService, productService, funding);
            System.out.println("\"상품명 : "+funding.getProduct().getName()+"   펀딩일시 : "+funding.getTime().format(formatter)+"\" 펀딩이 취소되었습니다.");
        } catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
