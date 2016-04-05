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
public class Roster {
    @Id
    @Column(name="roster_id")
    int rosterId;
    @Column(name="staff_needed")
    int staffNeeded;
    @ManyToMany(mappedBy="shift_id")
    int shiftId;
    @Column(name="week_num")
    int weekNum;
    @ManyToMany(mappedBy="user_id")
    int userId;
    
    List<EmployeeClass> staffList;
    
    public Roster(){
        
    }

    public int getRosterId() {
        return rosterId;
    }

    public void setRosterId(int rosterId) {
        this.rosterId = rosterId;
    }

    public int getStaffNeeded() {
        return staffNeeded;
    }

    public void setStaffNeeded(int staffNeeded) {
        this.staffNeeded = staffNeeded;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<EmployeeClass> getStaffList(){
        return staffList;
    }
    
    public void getStaff() {
        for (EmployeeClass s : staffList){
            System.out.printf("Name: %s",s.getName());
        }
    }

    public void removeStaff(int empNum) {
        EmployeeClass emp = new EmployeeClass();
        for (int i = 0; i < staffList.size(); i++) {
            if(staffList.get(i).getUserId()==empNum){
                emp=(EmployeeClass)staffList.get(i);
                staffList.remove(i);
            }
            staffNeeded++;
        }
    }
    
    public void addStaff(EmployeeClass emp){
        staffList.add(emp);
        staffNeeded--;
    }
    
    public String toString(){
        return "Roster Week Number: "+weekNum+"\nStaff Needed: "+staffNeeded+"\n";
    }
}
