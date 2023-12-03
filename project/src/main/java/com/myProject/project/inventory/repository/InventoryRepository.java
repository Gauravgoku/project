package com.myProject.project.inventory.repository;

import com.myProject.project.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM inventory WHERE itemId = ?1")
    Inventory findByItemIdToUpdate(String itemId);
    @Query(nativeQuery = true,value = "SELECT * FROM inventory")
    Inventory findByNameToDisplay(String query);

}
