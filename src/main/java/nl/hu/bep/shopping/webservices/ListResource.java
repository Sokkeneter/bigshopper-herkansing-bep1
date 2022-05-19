package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Product;
import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.ShoppingList;
import nl.hu.bep.shopping.webservices.exception.ResponseError;
import nl.hu.bep.shopping.webservices.ikweetniethoeikditmoetnoemen.ShoppingListDTOishThing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("list")
public class ListResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppingLists() {
        List<ShoppingList> shoppingLists = Shop.getShop().getAllShoppingLists();
        return Response.ok().entity(shoppingLists).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Response getShoppingListByName(@PathParam("name") String name) {
        Shop shop = Shop.getShop();
        try{
            ShoppingList list = shop.getShoppingListByName(name);
            return Response.ok().entity(list).build();
        }catch (NullPointerException npe){
            return Response.status(404).entity(ResponseError.createError("No list by that name")).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createShoppingList(ShoppingListDTOishThing list) {
        try{
            ShoppingList newList = ShoppingListDTOishThing.createShoppingList(list.getName(), list.getShopperName());
            return Response.ok(newList).entity(list).build();
        }catch (NullPointerException npe){
            return Response.status(404).entity(ResponseError.createError(npe.getMessage())).build();
        }
    }
}
