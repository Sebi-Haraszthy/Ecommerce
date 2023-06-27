package com.Ecommerce.repository;

import com.Ecommerce.model.Product;
import com.Ecommerce.model.User;
import com.Ecommerce.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    Optional<WishlistItem> findWishlistItemByWishlist_UserAndProduct(Product product, User user);

    List<WishlistItem> findWishlistItemByWishlist_User(User user);
}