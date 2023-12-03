package com.myProject.project.inventory.controller;

import com.myProject.project.inventory.dto.InventoryDto;
import com.myProject.project.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController{

    @Autowired
    private InventoryService inventoryService;
     @PostMapping("/")
     public InventoryDto addItemInventory(@RequestBody InventoryDto inventoryDto){
                return inventoryService.addItemInInventory(inventoryDto);
     }

     @PostMapping("/update")
     public InventoryDto updateItemInventory(@RequestBody InventoryDto inventoryDto){
         return inventoryService.updateInventory(inventoryDto);

     }
     @GetMapping("/get")
     public InventoryDto displayInventoryItem(String query){
         return inventoryService.getItemToWarehouse(query);

     }
}
