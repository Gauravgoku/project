package com.myProject.project.inventory.DtoConverter;

import com.myProject.project.inventory.domain.Inventory;
import com.myProject.project.inventory.dto.InventoryDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class InventoryConverter {

     public Inventory convertFrom(InventoryDto inventoryDto){
       if(Objects.isNull(inventoryDto)){
          return null;
       }
       return Inventory.Builder.inventory()
               .withLastModifiedBy(inventoryDto.getLastModifiedBy())
               .withLastModified(inventoryDto.getLastModified())
               .withCreatedBy(inventoryDto.getCreatedBy())
               .withDateCreated(inventoryDto.getDateCreated())
               .withIsDeleted(inventoryDto.getIsDeleted())
               .withItemId(inventoryDto.getItemId())
               .withItemName(inventoryDto.getItemName())
               .withItemImage(inventoryDto.getItemImage())
               .withItemValue(inventoryDto.getItemValue())
               .withItemModelNumber(inventoryDto.getItemModelNumber())
               .withDeliverItemDate(inventoryDto.getDeliverItemDate())
               .withBuyerName(inventoryDto.getBuyerName())
               .withSellerName(inventoryDto.getSellerName())
               .withReceiveItemDate(inventoryDto.getReceiveItemDate())
               .withEmptyItem(inventoryDto.getEmptyItem())
               .build();
     }

     public InventoryDto convertTo(Inventory inventory){
       if(Objects.isNull(inventory)){
          return null;
       }
       return InventoryDto.Builder.inventoryDto()
               .withDateCreated(inventory.getDateCreated())
               .withLastModified(inventory.getLastModified())
               .withCreatedBy(inventory.getCreatedBy())
               .withLastModifiedBy(inventory.getLastModifiedBy())
               .withIsDeleted(inventory.getIsDeleted())
               .withItemId(inventory.getItemId())
               .withItemName(inventory.getItemName())
               .withItemImage(inventory.getItemImage())
               .withItemValue(inventory.getItemValue())
               .withItemModelNumber(inventory.getItemModelNumber())
               .withBuyerName(inventory.getBuyerName())
               .withSellerName(inventory.getSellerName())
               .withDeliverItemDate(inventory.getDeliverItemDate())
               .withReceiveItemDate(inventory.getReceiveItemDate())
               .withEmptyItem(inventory.getEmptyItem())
               .build();
     }
}
