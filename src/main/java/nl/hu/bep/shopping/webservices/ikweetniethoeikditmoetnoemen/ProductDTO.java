package nl.hu.bep.shopping.webservices.ikweetniethoeikditmoetnoemen;

import nl.hu.bep.shopping.model.Product;
import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.ShoppingList;

public class ProductDTO {
    String productName;
    String listName;
    int amount;

    public String getProductName() {
        return productName;
    }

    public String getListName() {
        return listName;
    }

    public int getAmount() {
        return amount;
    }

    public static ShoppingList addToList(String productName, String listName, int amount){
        ShoppingList list = Shop.getShop().getShoppingList(listName);
        list.addItem(Shop.getShop().getProduct(productName), amount);
        return list;
    }

}
