package com.cg.cs.service;

import java.util.List;

import com.cg.cs.entity.Cart;
import com.cg.cs.exception.CartNotFoundException;
import com.cg.cs.exception.NoProperDataException;

public interface CartService {

	public List<Cart> getAllCarts() throws CartNotFoundException;

	public Cart addCarts(Cart cart) throws NoProperDataException;

	public Cart updateCarts(Cart cart, Long id) throws CartNotFoundException;

	public String deleteCarts(Long id) throws CartNotFoundException;

	public Cart getCartsById(Long id) throws CartNotFoundException;

}
