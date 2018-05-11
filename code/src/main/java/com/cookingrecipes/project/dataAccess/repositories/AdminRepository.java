package com.cookingrecipes.project.dataAccess.repositories;

import com.cookingrecipes.project.dataAccess.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query("SELECT a from Admin a where a.username=:ua and a.passw=:up")
    public Admin getAdminByUsernameAndPassword(@Param("ua")String username, @Param("up")String password);
}
