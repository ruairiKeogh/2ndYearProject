/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

/**
 *
 * @author Ruairí
 */
@Entity
public class Shift {
    @Id
    @Column(name = "shift_id")        
    int shiftID;
    @Column(name="shift_time")
    int shiftTime;
    @Column(name="shift_type")
    String shiftType;
    
    @ManyToOne
    EmployeeClass staff;
    @ManyToOne
    Roster rosterJoin;

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public int getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(int shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }
    
    
}
