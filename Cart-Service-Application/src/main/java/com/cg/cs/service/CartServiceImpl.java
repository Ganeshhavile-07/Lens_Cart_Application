package com.cg.cs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cs.entity.Cart;

import com.cg.cs.exception.CartNotFoundException;

import com.cg.cs.exception.NoProperDataException;
import com.cg.cs.repository.CartRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;

	@Override
	public List<Cart> getAllCarts() throws CartNotFoundException {
		// TODO Auto-generated method stub
		List<Cart> cartproducts = new ArrayList<>();
		cartproducts = cartRepo.findAll();
		try {
			if (cartproducts.size() == 0) {
				throw new CartNotFoundException("Cart is empty");
			}
		} catch (CartNotFoundException e) {
			log.error(e.getMessage());
		}
		return cartproducts;
	}

	@Override
	public Cart addCarts(Cart cart) throws NoProperDataException {
		// TODO Auto-generated method stub
		Cart bean = cartRepo.save(cart);
		log.debug("added to cart successfully ");
		return bean;
	}

	@Override
	public Cart updateCarts(Cart cart, Long id) throws CartNotFoundException {
		// TODO Auto-generated method stub
		log.info("update");
		Cart carts = cartRepo.findById(id).orElseThrow(() -> new CartNotFoundException("No cart Availble wth this id"));
		carts.setProductname(cart.getProductname());
		carts.setProductcount(cart.getProductcount());
		carts.setTotal(cart.getTotal());

		final Cart updatedcart = cartRepo.save(carts);
		return updatedcart;
	}

	@Override
	public String deleteCarts(Long id) throws CartNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete by id");
		var deleted = cartRepo.findById(id);
		if (deleted.isPresent()) {
			cartRepo.deleteById(id);
			log.debug("deleted succesfully {}", deleted.get());
			return "Deleted";
		} else {
			throw new CartNotFoundException("cart id not available to given id");
		}
	}

	@Override
	public Cart getCartsById(Long id) throws CartNotFoundException {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findById(id).orElseThrow(() -> new CartNotFoundException("Cart Not Found with id " + id));
		return cart;
	}

}
