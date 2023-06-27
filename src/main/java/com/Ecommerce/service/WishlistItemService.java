package com.Ecommerce.service;

import com.Ecommerce.DTO.AddAndDeleteToWishlistDTO;
import com.Ecommerce.model.Product;
import com.Ecommerce.model.User;
import com.Ecommerce.model.Wishlist;
import com.Ecommerce.model.WishlistItem;
import com.Ecommerce.repository.ProductRepository;
import com.Ecommerce.repository.UserRepository;
import com.Ecommerce.repository.WishlistItemRepository;
import com.Ecommerce.repository.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class WishlistItemService {
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private WishlistItemRepository wishlistItemRepository;
    private WishlistRepository wishlistRepository;

    @Autowired
    public WishlistItemService(ProductRepository productRepository, UserRepository userRepository, WishlistItemRepository wishlistItemRepository, WishlistRepository wishlistRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.wishlistItemRepository = wishlistItemRepository;
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist addItemToWishlist(AddAndDeleteToWishlistDTO addAndDeleteToWishlistDTO) {
        Product foundProduct = productRepository.findById(addAndDeleteToWishlistDTO.getProduct_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!"));
        User foundUser = userRepository.findById(addAndDeleteToWishlistDTO.getUser_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Wishlist foundWishlist = foundUser.getWishlist();
        foundWishlist.setUser(foundUser);
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setProduct(foundProduct);
        wishlistItem.setWishlist(foundWishlist);
        foundWishlist.getWishlistItems().add(wishlistItem);

        return wishlistRepository.save(foundWishlist);
    }

    public List<WishlistItem> getAllWishlistItems(Long user_id) {
        User foundUser = userRepository.findById(user_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));

        return wishlistItemRepository.findWishlistItemByWishlist_User(foundUser);
    }

    public void deleteWishListItemFromWishlistOfUser(AddAndDeleteToWishlistDTO addAndDeleteToWishlistDTO) {
        Product foundProduct = productRepository.findById(addAndDeleteToWishlistDTO.getProduct_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found!"));
        User foundUser = userRepository.findById(addAndDeleteToWishlistDTO.getUser_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        WishlistItem wishlistItemToDelete = wishlistItemRepository.findWishlistItemByWishlist_UserAndProduct(foundProduct, foundUser);
        wishlistItemRepository.delete(wishlistItemToDelete);
        foundUser.getWishlist().getWishlistItems().remove(wishlistItemToDelete);
        wishlistRepository.save(foundUser.getWishlist());
    }
}