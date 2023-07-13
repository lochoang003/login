package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.model.Account;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    RoleDao roleDao;

    public List<Account> getAll() {
        return accountDao.getAll();
    }

    public Account getFindById(int id) {
        return accountDao.getFindById(id);
    }

    public void save(Account account, MultipartFile multipartFile, int idRole) {
       newAccount(account,multipartFile,idRole);
        accountDao.save(account);
    }
    public void edit(Account account, MultipartFile multipartFile, int idRole) {
        newAccount(account,multipartFile,idRole);
        accountDao.edit(account);
    }


    public Account newAccount(Account account, MultipartFile multipartFile, int idRole) {
        String nameFile = multipartFile.getOriginalFilename();
        try {
            multipartFile.transferTo(new File("C:\\Users\\Pc\\IdeaProjects\\demo\\src\\main\\webapp\\WEB-INF\\img\\" + nameFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        account.setImg("/img/" + nameFile);
        Role role = roleDao.getFindById(idRole);
        account.setRole(role);
        return account;
    }

    public void delete(Account account) {
        accountDao.remove(account);
    }

}
