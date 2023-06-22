package com.Ecommerce.service;

import com.Ecommerce.DTO.AddToCartDTO;
import com.Ecommerce.DTO.UserCartDTO;
import com.Ecommerce.model.CartItem;
import com.Ecommerce.model.Product;
import com.Ecommerce.model.User;
import com.Ecommerce.repository.CartItemRepository;
import com.Ecommerce.repository.ProductRepository;
import com.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    private CartItemRepository cartItemRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public CartItem addToCart(AddToCartDTO addToCartDTO) {
        Product foundProduct = productRepository.findById(addToCartDTO.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!"));
        User foundUser = userRepository.findById(addToCartDTO.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(foundProduct);
        cartItem.setUser(foundUser);
        cartItem.setQuantity(addToCartDTO.getQuantity());

        return cartItemRepository.save(cartItem);
    }

    public UserCartDTO viewCart(Long user_id) {
        List<CartItem> cartItems = cartItemRepository.findAllByUser_Id(user_id);
        UserCartDTO userCartDTO = new UserCartDTO();
        userCartDTO.setCartItems(cartItems);
        userCartDTO.setTotalPrice(computeTotalPrice(cartItems));

        return userCartDTO;
    }

    public Double computeTotalPrice(List<CartItem> cartItems) {
        Optional<Double> totalPrice = cartItems.stream()
                .map(cartItem -> cartItem.getQuantity() * cartItem.getProduct().getPrice())
                .reduce(Double::sum);

        return totalPrice.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Total price could not be computed!"));
    }

    public void deleteCartItem(Long cartItem_id) {
        CartItem cartItem = cartItemRepository.findById(cartItem_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The cart item you want to delete does not exist!"));
        cartItemRepository.delete(cartItem);
    }

    public void deleteAllUserCartItems(User user) {
        cartItemRepository.deleteAllByUser(user);
    }
}