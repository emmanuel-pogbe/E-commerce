package com.shopleft.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopleft.ecommerce.dto.AddToCartRequest;
import com.shopleft.ecommerce.dto.CartItemResponse;
import com.shopleft.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/customers")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{customerId}/cart")
    public ResponseEntity<CartItemResponse> addToCart(@PathVariable Long customerId,
                                                      @RequestBody AddToCartRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addToCart(customerId, request));
    }

    @GetMapping("/{customerId}/cart")
    public ResponseEntity<List<CartItemResponse>> getCart(@PathVariable Long customerId) {
        return ResponseEntity.ok(cartService.getCartItemResponses(customerId));
    }
}
