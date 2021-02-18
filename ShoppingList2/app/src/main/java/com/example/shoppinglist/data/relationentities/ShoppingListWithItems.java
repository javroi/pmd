package com.example.shoppinglist.data.relationentities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.shoppinglist.data.entities.Item;
import com.example.shoppinglist.data.entities.ShoppingList;
import com.example.shoppinglist.data.entities.ShoppingListItem;

import java.util.List;

public class ShoppingListWithItems {
    @Embedded
    public ShoppingList shoppingList;

    @Relation(
            parentColumn = "shopping_list_id",
            entityColumn = "item_id",
            associateBy = @Junction(ShoppingListItem.class)
    )
    public List<Item> items;
}
