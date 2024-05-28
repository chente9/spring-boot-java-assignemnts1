package org.adaschool.api.service.product;

import org.adaschool.api.repository.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceMap implements ProductsService {

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Product> all() {
        return null;
    }

    @Override
    public void deleteById(String id) {     }



    @Override
    public Product createProduct(Product product) {   return product;   }




    @Override
    public List<Product> getAllProducts() {       return List.of();   }

    @Override
    public Product save(Product product) {
        return product;
    }
}
