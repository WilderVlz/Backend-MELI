package com.nocountry.ecommerce.service.implementation;

import com.nocountry.ecommerce.dto.ProductCartDto;
import com.nocountry.ecommerce.model.Product;
import com.nocountry.ecommerce.service.ProductCartService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ProductCartServiceImpl implements ProductCartService {
    private final LinkedList<Product> cartProducts = new LinkedList<>();
    LinkedList<ProductCartDto> productCartDtos = new LinkedList<>();
    private ProductCartDto findProductCartDto(Product product) {
        for (ProductCartDto productCartDto : productCartDtos) {
            if (productCartDto.getProductId().equals(product.getId())) {
                return productCartDto;
            }
        }
        return null;
    }
    @Override
    public void addProduct(Product product) throws Exception {
        if (cartProducts.contains(product)) {
            ProductCartDto productCartDto = findProductCartDto(product);

            if (productCartDto != null) {
                int cartProductQuantity = productCartDto.getQuantity();
                int productQuantity = product.getQuantity();

                if (productQuantity < cartProductQuantity) {
                    throw new Exception("Producto sin stock");
                } else {
                    productCartDto.setQuantity(cartProductQuantity + 1);
                    product.setQuantity(productQuantity - 1);
                }
            }
        } else {
            cartProducts.add(product);
        }
    }

    @Override
    public void removeProduct(Long productId) {
        Product productToRemove = new Product();
        productToRemove.setId(Long.parseLong(productId.toString()));

        if (cartProducts.contains(productToRemove)) {
            ProductCartDto productCartDto = findProductCartDto(productToRemove);

            if (productCartDto != null) {
                int cartProductQuantity = productCartDto.getQuantity();

                if (cartProductQuantity < 2) {
                    cartProducts.remove(productToRemove);
                } else {
                    productCartDto.setQuantity(cartProductQuantity - 1);
                }
            }
        }
    }

    @Override
    public LinkedList<ProductCartDto> viewCartProducts() {
        for (Product product : cartProducts) {
            ProductCartDto productCartDto = new ProductCartDto();
            productCartDto.setProductId(product.getId());
            productCartDto.setQuantity(1);

            productCartDtos.add(productCartDto);
        }

        return productCartDtos;
    }
}
