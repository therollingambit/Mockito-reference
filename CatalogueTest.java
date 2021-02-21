package com.fdmgroup.BookstoreTDDMockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CatalogueTest {
	
	Catalogue catalogue;
	
	@Mock
	IReadItemCommand readItemMock;
	
	@Mock
	IWriteItemCommand writeItemMock;
	
	@Mock
	List<Book> bookList;
	
	@Mock
	Book book;
	
	@BeforeEach
	public void initialize() {
		MockitoAnnotations.openMocks(this);
		catalogue = new Catalogue(readItemMock, writeItemMock);
	}
	
	@DisplayName("Test 1")
	@Test
	public void test_GetAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue() {
		// Act
		int bookListSize = catalogue.getAllBooks().size();
		// Assert
		assertEquals(0, bookListSize);	
	}
	
	@DisplayName("Test 2")
	@Test
	public void test_GetAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() {
		// Act
		catalogue.getAllBooks();
		// Assert
		verify(readItemMock, times(1)).readAll();
	}
	
	@DisplayName("Test 3")
	@Test
	public void test_GetAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() {
		// Act
		catalogue.getAllBooks();
		when(readItemMock.readAll()).thenReturn(bookList);
		// Assert
		assertEquals(bookList, catalogue.getAllBooks());	
	}
	
	@DisplayName("Test 4")
	@Test
	public void test_AddBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
		// Act
		catalogue.addBook(null);
		// Assert
		verify(writeItemMock, times(1)).insertItem(null);
	}
	
	@DisplayName("Test 5")
	@Test
	public void test_AddBook_PassBookGivenToInsertItemMethodOfWriteItemCommand_WhenCalled() {
		// Act
		catalogue.addBook(book);
		// Assert
		verify(writeItemMock, times(1)).insertItem(book);
	}


}
