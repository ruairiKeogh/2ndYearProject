/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author X00121581
 */
public class Creates {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");
    EntityManager em = emf.createEntityManager();
    
    public AdminClass createAdmin(int userId, String password, String username, String flag, String fname, String lname, String address1, String address2, String email, String pnumber, String contract, String position){
        em.getTransaction().begin();
        AdminClass admin = new AdminClass();
        admin.setUserId(userId);
        admin.setPassword(password);
        admin.setUsername(username);
        admin.setFlag(flag);
        admin.setFname(fname);
        admin.setLname(lname);
        admin.setAddress1(address1);
        admin.setAddress2(address2);
        admin.setEmail(email);
        admin.setPnumber(pnumber);
        admin.setContract(contract);
        admin.setPosition(position);
        em.persist(admin);
        em.getTransaction().commit();
        return admin;
    }
    
    public StaffClass createAdmin(int userId, String password, String username, String flag, String fname, String lname, String address1, String address2, String email, String pnumber, String contract, String position){
        em.getTransaction().begin();
        StaffClass staff = new StaffClass();
        staff.setUserId(userId);
        staff.setPassword(password);
        staff.setUsername(username);
        staff.setFlag(flag);
        staff.setFname(fname);
        staff.setLname(lname);
        staff.setAddress1(address1);
        staff.setAddress2(address2);
        staff.setEmail(email);
        staff.setPnumber(pnumber);
        staff.setContract(contract);
        staff.setPosition(position);
        em.persist(staff);
        em.getTransaction().commit();
        return staff;
    }
    
}
