package com.example.ecommerce.presentation;


import com.example.ecommerce.domain.Product;
import com.example.ecommerce.domain.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
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

    private final ProductService productService;

    @Inject
    public ProductResource(ProductMapper mapper, ProductService productService) {
        this.mapper = mapper;
        this.productService = productService;
    }


    @GET
    public List<ProductResponse> getAllProducts() {
        return productService.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GET
    @Path("/{id}")
    public ProductResponse getProductById(@PathParam("id") String id) {
        return productService.findById(id).map(this.mapper::toResponse).orElseThrow(
                () -> new WebApplicationException("Product with id " + id + " not found",
                        Response.Status.NOT_FOUND));
    }


    @DELETE
    @Path("/{id}")
    public void deleteProductById(@PathParam("id") String id) {
        productService.delete(id);
    }

    @POST
    public ProductResponse insert(ProductRequest request) {
        Product product = productService.save(mapper.toDomain(request));
        return mapper.toResponse(product);
    }

}
