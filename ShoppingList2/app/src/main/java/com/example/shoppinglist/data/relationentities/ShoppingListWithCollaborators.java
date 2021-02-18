package com.example.shoppinglist.data.relationentities;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppinglist.data.entities.Collaborator;
import com.example.shoppinglist.data.views.ShoppingListView;

import java.util.List;

public class ShoppingListWithCollaborators {
    @Embedded
    public ShoppingListView shoppingList;

    @Relation(
            entity = Collaborator.class,
            parentColumn = "shopping_list_id",
            entityColumn = "shopping_list_id",
            projection = {"name"}
    )
    public List<String> collaboratorNames;
}
