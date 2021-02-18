package com.example.shoppinglist.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.shoppinglist.data.daos.ItemDao;
import com.example.shoppinglist.data.daos.ShoppingListDao;
import com.example.shoppinglist.data.daos.ShoppingListItemDao;
import com.example.shoppinglist.data.entities.Collaborator;
import com.example.shoppinglist.data.entities.Info;
import com.example.shoppinglist.data.entities.Item;
import com.example.shoppinglist.data.entities.ShoppingListItem;
import com.example.shoppinglist.data.partialentities.ShoppingListId;
import com.example.shoppinglist.data.partialentities.ShoppingListInsert;
import com.example.shoppinglist.data.relationentities.ShoppingListWithCollaborators;
import com.example.shoppinglist.data.relationentities.ShoppingListWithItems;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListRepository {
    private final ShoppingListDao mShoppingListDao;
    private final ShoppingListDatabase mDb;
    private final ItemDao mItemDao;
    private final ShoppingListItemDao mShoppingListItemDao;

    public ShoppingListRepository(Context context) {
        mDb = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = mDb.shoppingListDao();
        mItemDao = mDb.itemDao();
        mShoppingListItemDao = mDb.shoppingListItemDao();
    }

    public LiveData<List<ShoppingListWithCollaborators>> getShoppingLists() {
        return mShoppingListDao.shoppingLists();
    }

    public LiveData<List<ShoppingListWithCollaborators>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }

    public LiveData<ShoppingListWithItems> getShoppingList(String id) {
        return mShoppingListDao.shoppingListWithItems(id);
    }

    public void insert(ShoppingListInsert shoppingList, Info info,
                       List<Collaborator> collaborators, List<Item> items) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mDb.runInTransaction(
                        () -> processInsert(shoppingList, info, collaborators, items)
                )
        );
    }

    private void processInsert(ShoppingListInsert shoppingList, Info info,
                               List<Collaborator> collaborators, List<Item> items) {
        // Insertar lista de compras
        mShoppingListDao.insertWithInfoAndCollaborators(shoppingList, info, collaborators);

        // Insertar items
        mItemDao.insertAll(items);

        // Generar registros de relación
        List<ShoppingListItem> shoppingListItems = new ArrayList<>();
        for (Item item : items) {
            shoppingListItems.add(new ShoppingListItem(shoppingList.id, item.id));
        }

        // Insertar registros de relación
        mShoppingListItemDao.insertAll(shoppingListItems);
    }

    public void markFavorite(String shoppingListId) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.markFavorite(shoppingListId)
        );
    }

    public void deleteShoppingList(ShoppingListId id) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.deleteShoppingList(id)
        );
    }

    public void deleteAll() {
        ShoppingListDatabase.dbExecutor.execute(
                mShoppingListDao::deleteAll
        );
    }
}

