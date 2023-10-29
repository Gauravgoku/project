package com.myProject.project.deal.repository;

import com.myProject.project.deal.domain.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface DealRepository extends JpaRepository<Deal,Integer> {

    @Query(value = "SELECT * FROM deals WHERE dealId=:dealId", nativeQuery = true)
    Deal findByDealId(String dealId);


}
