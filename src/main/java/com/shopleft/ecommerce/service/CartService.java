package com.shopleft.ecommerce.service;

import java.util.List;

import com.shopleft.ecommerce.dto.AddToCartRequest;
import com.shopleft.ecommerce.dto.CartItemResponse;
import com.shopleft.ecommerce.model.CartItem;

public interface CartService {
    CartItem addToCart(Long customerId, Long productId, int quantity);
    CartItemResponse addToCart(Long customerId, AddToCartRequest request);

    List<CartItem> getCartItems(Long customerId);
    List<CartItemResponse> getCartItemResponses(Long customerId);
}
