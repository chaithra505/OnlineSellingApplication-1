package com.sonata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonata.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	Cart findByUserId(int userId);
	Cart findByCartId(int cartId);

}
