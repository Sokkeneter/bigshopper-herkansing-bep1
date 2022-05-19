package nl.hu.bep.shopping.webservices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.Shopper;
import nl.hu.bep.shopping.model.ShoppingList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("shopper")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppers() {
        List<Shopper> shoppers = Shop.getShop().getAllPersons();

        return Response.ok(shoppers).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonIgnore
    public Response getShoppingListsFromPerson(@PathParam("name") String name) {
        Shop shop = Shop.getShop();
        List<ShoppingList> allListsFromPerson = shop.getListFromPerson(name); //warning: might return null!
        if (allListsFromPerson == null) {
            Map<String, String> messages = new HashMap<>();
            messages.put("error", "no lists present");

            return Response.noContent().entity(messages).build();
        }
        else
        {
            return Response.ok().entity(allListsFromPerson).build();
        }
    }


}
