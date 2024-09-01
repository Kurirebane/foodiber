package com.team2.foodiber;

import com.team2.foodiber.model.ShoppingList;
import com.team2.foodiber.repository.IngredientsRepository;
import com.team2.foodiber.repository.ShoppingListRepository;
import com.team2.foodiber.service.ShoppingListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class testShoppingList {
    @Mock
    private ShoppingListRepository shoppingListRepository;
    @Mock
    private IngredientsRepository ingredientsRepository;

    @InjectMocks
    ShoppingListService shoppingListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetLatestShoppingList_WhenListExists() {
        ShoppingList shoppingList = new ShoppingList();
        when(shoppingListRepository.findTopByOrderByCreatedDateDesc()).thenReturn(shoppingList);
        ShoppingList result = shoppingListService.getLatestShoppingList();
        Assertions.assertEquals(shoppingList, result);
        verify(shoppingListRepository, never()).save(any(ShoppingList.class));
    }

    @Test
    public void testGetLatestShoppingList_WhenListDoesNotExists() {
        when(shoppingListRepository.findTopByOrderByCreatedDateDesc()).thenReturn(null);
        ShoppingList result = shoppingListService.getLatestShoppingList();
        assertNotNull(result);
        assertNotNull(result.getItems());
        assertTrue(result.getItems().isEmpty());
        verify(shoppingListRepository).save(result);
    }

}
