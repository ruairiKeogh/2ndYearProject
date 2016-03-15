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
    
    //Admin Creates
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
    
    //Admin Updates
    public void updateUsername(int userId, String usernameIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setUsername(usernameIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updatePassword(int userId, String passwordIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setPassword(passwordIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateFname(int userId, String fNameIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setFname(fNameIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateLname(int userId, String lNameIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setLname(lNameIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateAddress1(int userId, String address1In){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setAddress1(address1In);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateAddress2(int userId, String address2In){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setAddress2(address2In);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateEmail(int userId, String emailIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setEmail(emailIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updatePnumber(int userId, String pNumberIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setPnumber(pNumberIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateContract(int userId, String contractIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setContract(contractIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updatePosition(int userId, String positionIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setPosition(positionIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    //Staff Creates
    public StaffClass createStaff(int userId, String password, String username, String flag, String fname, String lname, String address1, String address2, String email, String pnumber, String contract, String position){
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
    
    /*public void updateFname(int userId, String fNameIn){
        em.getTransaction().begin();
        StaffClass staff = em.find(StaffClass.class, userId);
        staff.setFname(fNameIn);
        em.merge(staff);
        em.getTransaction().commit();
    }
    */
}
