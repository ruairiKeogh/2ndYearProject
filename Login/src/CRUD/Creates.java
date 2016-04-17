/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import login.MySQLConnect;


/**
 *
 * @author X00121581
 */
public class Creates {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");
    EntityManager em = emf.createEntityManager();
    
    List<Roster> rosterList = new ArrayList<>();
    List<Shift> shiftList = new ArrayList<>();
    List<EmployeeClass> empList = new ArrayList<>();
    List<AdminClass> adminList = new ArrayList<>();
    List<StaffClass> staffList = new ArrayList<>();;
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    //Admin Updates
    public void updateUsername(int userId, String usernameIn){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setUsername(usernameIn);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updatePassword(int userId, String passwordIn){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setPassword(passwordIn);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updateName(int userId, String nameIn){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setName(nameIn);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updateAddress1(int userId, String address1In){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setAddress1(address1In);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updateAddress2(int userId, String address2In){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setAddress2(address2In);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updateEmail(int userId, String emailIn){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setEmail(emailIn);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updatePnumber(int userId, String pNumberIn){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setPnumber(pNumberIn);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updateContract(int userId, String contractIn){
        em.getTransaction().begin();
        EmployeeClass employee = em.find(EmployeeClass.class, userId);
        employee.setContract(contractIn);
        em.merge(employee);
        em.getTransaction().commit();
    }
    
    public void updatePayrate(int userId, double payrateIn){
        em.getTransaction().begin();
        AdminClass admin = em.find(AdminClass.class, userId);
        admin.setPayrate(payrateIn);
        em.merge(admin);
        em.getTransaction().commit();
    }
    
    public void updateAvailability(int userId, List<Availability> availability){
        em.getTransaction().begin();
        StaffClass staff = em.find(StaffClass.class, userId);
        
    }
    
    
    public EmployeeClass createEmployee(int userId, String password, String username, String flag, String name, String address1, String address2, String email, String pnumber, String contract, double payrate){
        if(flag == "M"){
            em.getTransaction().begin();
            EmployeeClass admin = new EmployeeClass();
            admin.setUserId(userId);
            admin.setPassword(password);
            admin.setUsername(username);
            admin.setFlag(flag);
            admin.setName(name);
            admin.setAddress1(address1);
            admin.setAddress2(address2);
            admin.setEmail(email);
            admin.setPnumber(pnumber);
            admin.setPayrate(payrate);
            empList.add(admin);
            em.persist(admin);
            em.getTransaction().commit();
            return admin;
        }
        else{
            em.getTransaction().begin();
            EmployeeClass staff = new EmployeeClass();
            staff.setUserId(userId);
            staff.setPassword(password);
            staff.setUsername(username);
            staff.setFlag(flag);
            staff.setName(name);
            staff.setAddress1(address1);
            staff.setAddress2(address2);
            staff.setEmail(email);
            staff.setPnumber(pnumber);
            staff.setPayrate(payrate);
            //List<Availability> availability=staff.createAvailability();
            //staff.setAvailability(availability);
            empList.add(staff);
            em.persist(staff);
            em.getTransaction().commit();
            return staff;
        }
    }
    
    public List<EmployeeClass> findAllStaff() {
        Query query = em.createQuery("SELECT s FROM Staff s");
        List<EmployeeClass> allStaff = (List<EmployeeClass>) query.getResultList();
        return allStaff;
    }
    
    public Roster createRoster(int rosterId,int weekNum, int staffNeeded) {
        em.getTransaction().begin();
        Roster roster = new Roster();
        roster.setRosterId(rosterId);
        roster.setWeekNum(weekNum);
        roster.setStaffNeeded(staffNeeded);
        rosterList.add(roster);
        em.persist(roster);
        em.getTransaction().commit();
        return roster;
    }

    public Shift createShift(int id,int shiftTime, String shiftType) {
        em.getTransaction().begin();
        Shift shift = new Shift();
        shift.setShiftID(id);
        shift.setShiftTime(shiftTime);
        shift.setShiftType(shiftType);
        shiftList.add(shift);
        em.persist(shift);
        em.getTransaction().commit();
        return shift;
    }
    
    public String getNameNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT NAME FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    
    public String getEmailNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT EMAIL FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    public String getUserIDNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT USER_ID FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    public String getAddress1Now(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT ADDRESS1 FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    public String getAddress2Now(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT ADDRESS2 FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    public String getPhoneNoNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT PNUMBER FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    public String getPayrateNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT PAYRATE FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    public String getContractNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT CONTRACT FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    
     
    public String getPasswordNow(String username, Connection conn){
        this.conn=conn;
        String sql="SELECT PASSWORD FROM USERS WHERE USERNAME=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rs=pst.executeQuery();
            
            if(rs.next()){
                return rs.getString(1);
            }  
            else{
                return null;
            }
        }catch(Exception e){
             return null;
        }
    }
    
    public void deleteStaff(int userId){
        EmployeeClass emp = em.find(EmployeeClass.class, userId);
        
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
        
        Iterator<EmployeeClass> it = empList.iterator();
        while(it.hasNext()){
            EmployeeClass empDel= it.next();
            if (userId==empDel.getUserId()){
                it.remove();
            }
        }
            
    }
    
    public int nextID(Connection conn){
        this.conn=conn;
        String sql="SELECT USER_ID FROM USERS";
        int nextID=0;
        int test=0;
        int loop=1;
        
        try{
            
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                        System.out.println("Inside IF!!");
                while(rs.next()){
                        System.out.println("Inside While");
                    test = rs.getInt(loop);
                    if(test>nextID){
                        System.out.println(test+ " ----- "+nextID);
                        nextID=test;
                        System.out.println("if test>nextID");
                        System.out.println(test+ " ----- "+nextID);
                        loop++;
                    }
                    else{
                        loop++;
                        System.out.println("Else for test<nextID");
                    }
                }
                System.out.println("End Of If");
                return nextID++;
            }
               
            else{
                System.out.println("Before Else");
                return 0;
            }
            
        }catch(Exception e){
             return 0;
        }
    }
    
    public void createAvailability(Shift newShift){
        em.getTransaction().begin();
        Availability availability = new Availability();
        availability.setShifts(newShift);
        shiftList.add(newShift);
        em.persist(newShift);
        em.getTransaction().commit();
    }
}
