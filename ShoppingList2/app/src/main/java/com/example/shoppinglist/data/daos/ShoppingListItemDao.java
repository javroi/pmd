package com.example.shoppinglist.data.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.shoppinglist.data.entities.ShoppingListItem;

import java.util.List;

@Dao
public abstract class ShoppingListItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insertAll(List<ShoppingListItem> shoppingListItems);
}
