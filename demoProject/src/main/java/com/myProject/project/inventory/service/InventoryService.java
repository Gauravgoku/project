package com.myProject.project.inventory.service;

import com.myProject.project.inventory.dto.InventoryDto;

public interface InventoryService {
    InventoryDto addItemInInventory(InventoryDto inventoryDto);

    InventoryDto updateInventory(InventoryDto inventoryDto);

    InventoryDto getItemToWarehouse(String query);
}
