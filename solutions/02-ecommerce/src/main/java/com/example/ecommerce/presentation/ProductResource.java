package com.example.ecommerce.presentation;


import com.example.ecommerce.domain.Product;
import com.example.ecommerce.domain.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/products")
public class ProductResource {

    private final ProductMapper mapper;

    private final ProductService service;

    @Inject
    public ProductResource(ProductMapper mapper, ProductService service) {
        this.mapper = mapper;
        this.service = service;
    }


    @GET
    public List<ProductResponse> getAllProducts() {
        return service.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GET
    @Path("/{id}")
    public ProductResponse getProductById(@PathParam("id") String id) {
        return service.findById(id).map(this.mapper::toResponse).orElseThrow(
                () -> new WebApplicationException("Product with id " + id + " not found",
                        Response.Status.NOT_FOUND));
    }


    @DELETE
    @Path("/{id}")
    public void deleteProductById(@PathParam("id") String id) {
        service.delete(id);
    }

    @POST
    public ProductResponse insert(ProductRequest request) {
        Product product = service.save(mapper.toDomain(request));
        return mapper.toResponse(product);
    }

    @PATCH
    @Path("{id}/price")
    public void changePrice(@PathParam("id") String id, UpdatePriceRequest body) {
        service.changePrice(id, body.price());
    }

}
