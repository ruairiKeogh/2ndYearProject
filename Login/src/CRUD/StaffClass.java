/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.util.List;

/**
 *
 * @author X00121581
 */
class StaffClass extends EmployeeClass{
    List<Availability> availability;

    public StaffClass(){
        
    }
    
    public StaffClass(int userId, String password, String username, String flag, String name, String address1, String address2, String email, String pnumber, String contract, List<Availability> availability) {
        super(userId,username,password,flag,name,address1,address2,email,pnumber,contract);
        this.availability = availability;
    }


    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }
    
    
}
