package nl.hu.bep.shopping.webservices.ikweetniethoeikditmoetnoemen;

import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.Shopper;
import nl.hu.bep.shopping.model.ShoppingList;


public class ShoppingListDTOishThing {
    String name;
    String shopperName;

    public String getName() {
        return name;
    }

    public String getShopperName() {
        return shopperName;
    }

    public static ShoppingList createShoppingList(String listName, String shopperName) {
        Shopper shopper = Shop.getShop().getShopper(shopperName);
        return new ShoppingList(listName, shopper);
    }
}
