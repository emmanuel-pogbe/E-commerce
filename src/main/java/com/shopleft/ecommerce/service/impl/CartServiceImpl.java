package com.shopleft.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopleft.ecommerce.dto.AddToCartRequest;
import com.shopleft.ecommerce.dto.CartItemResponse;
import com.shopleft.ecommerce.model.CartItem;
import com.shopleft.ecommerce.model.Customer;
import com.shopleft.ecommerce.model.Product;
import com.shopleft.ecommerce.repository.CartItemRepository;
import com.shopleft.ecommerce.repository.CustomerRepository;
import com.shopleft.ecommerce.repository.ProductRepository;
import com.shopleft.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartItemRepository cartItemRepository, CustomerRepository customerRepository,
                           ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartItem addToCart(Long customerId, Long productId, int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be at least 1");
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartItemRepository.findByCustomerIdAndProductId(customerId, productId)
                .orElse(new CartItem(customer, product, 0));

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItemResponse addToCart(Long customerId, AddToCartRequest request) {
        CartItem cartItem = addToCart(customerId, request.getProductId(), request.getQuantity());
        return toResponse(cartItem);
    }

    @Override
    public List<CartItem> getCartItems(Long customerId) {
        return cartItemRepository.findByCustomerId(customerId);
    }

    @Override
    public List<CartItemResponse> getCartItemResponses(Long customerId) {
        return getCartItems(customerId).stream()
                .map(this::toResponse)
                .toList();
    }

    private CartItemResponse toResponse(CartItem cartItem) {
        CartItemResponse response = new CartItemResponse();
        response.setProductId(cartItem.getProduct().getId());
        response.setProductName(cartItem.getProduct().getProductName());
        response.setProductPrice(cartItem.getProduct().getProductPrice());
        response.setQuantity(cartItem.getQuantity());
        return response;
    }
}
