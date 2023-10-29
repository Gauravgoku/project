package com.myProject.project.inventory.service;


import com.myProject.project.Constants;
import com.myProject.project.inventory.DtoConverter.InventoryConverter;
import com.myProject.project.inventory.domain.Inventory;
import com.myProject.project.inventory.dto.InventoryDto;
import com.myProject.project.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryConverter inventoryConverter;

    @Override
    public InventoryDto addItemInInventory(InventoryDto inventoryDto){
        Inventory inventory= inventoryConverter.convertFrom(inventoryDto);
        InventoryDto inventoryDto1 = inventoryConverter.convertTo(inventory);
         inventoryRepository.save(inventory);
         return inventoryDto1;


    }


    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findByItemIdToUpdate(inventoryDto.getItemId());
        //Inventory home=null;
            if (Objects.isNull(inventoryDto)) {
                inventory = inventoryConverter.convertFrom(inventoryDto);
                inventory.setDeliverItemDate(System.currentTimeMillis());
                inventory.setDateCreated(System.currentTimeMillis());
                inventory.setCreatedBy(Constants.SYSTEM);
            }else {
                if (Objects.nonNull(inventoryDto.getItemName())) {
                    inventory.setItemName(inventoryDto.getItemName());
                }
                if (Objects.nonNull(inventoryDto.getItemImage())) {
                    inventory.setItemImage(inventoryDto.getItemImage());
                }
                if (Objects.nonNull(inventoryDto.getItemValue())) {
                    inventory.setItemValue(inventoryDto.getItemValue());
                }
                if (Objects.nonNull(inventoryDto.getItemModelNumber())) {
                    inventory.setItemModelNumber(inventoryDto.getItemModelNumber());
                }
                if (Objects.nonNull(inventoryDto.getBuyerName())) {
                    inventory.setBuyerName(inventoryDto.getBuyerName());
                }
                if (Objects.nonNull(inventoryDto.getSellerName())) {
                    inventory.setSellerName(inventoryDto.getSellerName());
                }
                if (Objects.nonNull(inventoryDto.getEmptyItem())) {
                    inventory.setEmptyItem(inventoryDto.getEmptyItem());
                }
            }
            inventory.setLastModified(System.currentTimeMillis());
            inventory.setLastModifiedBy(Constants.SYSTEM);
            inventory.setReceiveItemDate(System.currentTimeMillis());
            inventoryRepository.save(inventory);

         return inventoryConverter.convertTo(inventory);
    }

    @Override
    public InventoryDto getItemToWarehouse(String query) {
        Inventory inventory = inventoryRepository.findByNameToDisplay(query);
        InventoryDto inventoryDto = inventoryConverter.convertTo(inventory);
        return inventoryDto;
    }

        }





