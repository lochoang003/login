package com.example.demo.dao;

import com.example.demo.model.Account;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Component
public class RoleDao {
    @Autowired
    EntityManager entityManager;
    public Role getFindById(int id){
        String queryStr = "SELECT r FROM Role r where r.id = :id";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class).setParameter("id",id);
        return query.getSingleResult();
    }
}
