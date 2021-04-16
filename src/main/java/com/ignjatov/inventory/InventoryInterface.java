package com.ignjatov.inventory;

import com.ignjatov.entity.Inventory;

import java.util.List;

public interface InventoryInterface {
    List<Inventory> getInventoryList();
    void addToList(Inventory inventory);
    void addQuantity(Inventory inventory, int amount);
    public String getName();
}
