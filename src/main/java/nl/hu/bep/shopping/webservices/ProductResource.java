package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.webservices.exception.ResponseError;
import nl.hu.bep.shopping.webservices.ikweetniethoeikditmoetnoemen.ProductDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok(Shop.getShop().getAllProducts()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductDTO newProduct) {
        try{
            return Response.ok(ProductDTO.addToList(newProduct.getProductName(), newProduct.getListName(), newProduct.getAmount())).build();
        }
        catch (NullPointerException npe){
            return Response.status(404).entity(ResponseError.createError("list not found")).build();
        }
    }
}
