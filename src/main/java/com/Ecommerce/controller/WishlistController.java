package com.Ecommerce.controller;

import com.Ecommerce.DTO.AddAndDeleteToWishlistDTO;
import com.Ecommerce.model.Wishlist;
import com.Ecommerce.model.WishlistItem;
import com.Ecommerce.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist)")
public class WishlistController {
    private WishlistItemService wishlistItemService;

    @Autowired
    public WishlistController(WishlistItemService wishlistItemService) {
        this.wishlistItemService = wishlistItemService;
    }

    @PostMapping("/create")
    public Wishlist addToWishlist(@RequestBody AddAndDeleteToWishlistDTO addAndDeleteToWishlistDTO) {
        return wishlistItemService.addItemToWishlist(addAndDeleteToWishlistDTO);
    }

    @GetMapping("/{user_id}")
    public List<WishlistItem> getAllWishlistItem(@PathVariable Long user_id) {
        return wishlistItemService.getAllWishlistItems(user_id);
    }

    @DeleteMapping("/delete")
    public void deleteProductFromWishlist(@RequestBody AddAndDeleteToWishlistDTO addAndDeleteToWishlistDTO) {
        wishlistItemService.deleteWishListItemFromWishlistOfUser(addAndDeleteToWishlistDTO);
    }
}