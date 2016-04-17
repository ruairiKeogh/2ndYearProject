/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author X00121581
 */
class Availability {
    List<Shift> shifts = new ArrayList<>();

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(Shift shifts) {
        this.shifts.add(shifts);
    }

    @Override
    public String toString() {
        return "Availability{" + "shifts=" + shifts + '}';
    }
    
    
}
