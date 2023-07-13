package com.example.demo.dao;

import com.example.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.xml.ws.Action;
import java.util.List;

@Component
public class AccountDao {
    @Autowired
    EntityManager entityManager;
    public List<Account> getAll(){
        String queryStr = "SELECT a FROM Account a";
        TypedQuery<Account> query = entityManager.createQuery(queryStr, Account.class);
        return query.getResultList();
    }
    public Account getFindById( int id){
        String queryStr = "SELECT a FROM Account a where a.id = :id";
        TypedQuery<Account> query = entityManager.createQuery(queryStr, Account.class).setParameter("id",id);
        return query.getSingleResult();
    }

    public void save(Account account){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(account);
        txn.commit();
    }
    public void edit(Account account){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(account);
        txn.commit();
    }
    public void remove(Account account){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(account);
        txn.commit();
    }
}
