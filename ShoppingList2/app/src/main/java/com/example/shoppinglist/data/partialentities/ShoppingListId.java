package com.example.shoppinglist.data.partialentities;

import androidx.room.ColumnInfo;

public class ShoppingListId {
    @ColumnInfo(name = "shopping_list_id")
    public String id;

    public ShoppingListId(String id) {
        this.id = id;
    }
}
