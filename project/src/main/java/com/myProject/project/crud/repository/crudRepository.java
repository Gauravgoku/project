package com.myProject.project.crud.repository;

import com.myProject.project.crud.domain.crudDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface crudRepository extends JpaRepository<crudDomain,Integer>{
    @Query(nativeQuery = true,value = "SELECT * FROM crud WHERE crudId = ?1")
    crudDomain findByCrudId(String crudId);

    @Query(nativeQuery = true,value = "SELECT * FROM crud WHERE crudName = ?1")
    crudDomain findByName(String crudName);

    @Query(nativeQuery = true,value="DELETE FROM crud WHERE crudId = ?1")
    crudDomain userDelete(String crudId);
}
