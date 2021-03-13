package com.ahmadenaya.practice_tddExercise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckoutTest {
	Basket basket;
	Book book;
	Checkout checkOut;
	
	@BeforeEach
	public void init() {
		basket = new Basket();
		book = new Book(10.00);
		checkOut = new Checkout();
	}

	@DisplayName("Test 1")
	@Test
	public void calculatePriceMethod_ReturnsDoubleTen_WhenCalled() {
		// Act
		basket.addBook(book);
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(10.00, totalPrice);
	}
	
	@DisplayName("Test 2")
	@Test
	public void calculatePriceMethod_ReturnsDoubleTwenty_WhenCalled() {
		// Act
		basket.addBook(book);
		basket.addBook(book);
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(20.00, totalPrice);
	}
	
	@DisplayName("Test 3")
	@Test
	public void calculatePriceMethod_ReturnsDoubleTwentyNinePointSeventy_WhenCalled() {
		// Act
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(29.70, totalPrice);
	}
	
	@DisplayName("Test 4")
	@Test
	public void calculatePriceMethod_ReturnsDoubleFiftyEightPointEight_WhenCalled() {
		// Act
		for (int i=0; i<6; i++) {
			basket.addBook(book);
		}
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(58.80, totalPrice);
	}
	
	@DisplayName("Test 5")
	@Test
	public void calculatePriceMethod_ReturnsDoubleEightySevenPointThree_WhenCalled() {
		// Act
		for (int i=0; i<9; i++) {
			basket.addBook(book);
		}
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(87.30, totalPrice);
	}
	
	@DisplayName("Test 6")
	@Test
	public void calculatePriceMethod_ReturnsDoubleZero_WhenCalled() {
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(0.00, totalPrice);
	}
	
	@DisplayName("Test 7")
	@Test
	public void calculatePriceMethod_ReturnsDoubleSeventyEightPointFour_WhenCalled() {
		// Act
		for (int i=0; i<8; i++) {
			basket.addBook(book);
		}
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(78.40, totalPrice);
	}
	
	@DisplayName("Test 8")
	@Test
	public void calculatePriceMethod_ReturnsDoubleOneHundredAndThreePointTwo_WhenCalled() {
		// Act
		for (int i=0; i<12; i++) {
			basket.addBook(book);
		}
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(103.20, totalPrice);
	}
	
	@DisplayName("Test 9")
	@Test
	public void calculatePriceMethod_ReturnsDoubleOneHundredAndSeventyFourPointThree_WhenCalled() {
		// Act
		for (int i=0; i<21; i++) {
			basket.addBook(book);
		}
		double totalPrice = checkOut.calculatePrice(basket);
		// Assert
		assertEquals(174.30, totalPrice);
	}

}
