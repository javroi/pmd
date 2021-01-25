package com.example.shoppinglist;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface ShoppingListDao {
    @Query("SELECT * FROM shopping_list")
    LiveData<List<ShoppingList>> getAll();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertShoppingLists(List<ShoppingList> lists);
}