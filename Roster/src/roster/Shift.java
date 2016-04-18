package roster;

import java.util.*;
import javax.persistence.*;

@Entity
public class Shift {

    @Id
    @Column(name = "shift_id")
    private int shiftID;
    @Column(name = "shift_type")
    private String shiftType;

    @OneToMany(mappedBy = "shift")
    private List<Staff> staffList;

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

}
