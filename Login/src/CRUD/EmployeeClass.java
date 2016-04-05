/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ruairí
 */
@Entity
public class EmployeeClass {
    @Id
    @Column(name="user_id")        
    int userId;
    String password,username,flag,name,address1,address2,email,pnumber,contract;
    @ManyToOne
    @JoinColumn(name="shift_id")
    Shift shift;
    @ManyToMany(mappedBy="staffList")
    List<Roster> rosterList;
    
    public EmployeeClass(){
        
    }
    
    public EmployeeClass(int userId, String password, String username, String flag, String name, String address1, String address2, String email, String pnumber, String contract) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.flag = flag;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.email = email;
        this.pnumber = pnumber;
        this.contract = contract;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
    public Shift getShift(){
        return shift;
    }
    
    public void setShift(Shift shift){
        this.shift=shift;
    }
    
    public List<Roster> getRosterList(){
        return rosterList;
    }
    
    public void addRoster(Roster r){
        rosterList.add(r);
        r.getStaffList().add(this);
    }
    
    public void removeRoster(Roster r){
        rosterList.remove(r);
        r.getStaffList().remove(this);
    }
    
    
}
