package com.Ecommerce.repository;

import com.Ecommerce.model.CartItem;
import com.Ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUser_Id(Long user_id);

    void deleteByUser(User user);
}