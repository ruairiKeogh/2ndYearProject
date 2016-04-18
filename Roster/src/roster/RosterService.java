package roster;

import java.io.*;
import java.util.*;
import javax.persistence.*;

public class RosterService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RosterPU");
    EntityManager em = emf.createEntityManager();

    List<Roster> rosterList = new ArrayList<>();

    // Create roster
    public Roster createRoster(int weekNum, int staffNeeded) {
        em.getTransaction().begin();
        Roster roster = new Roster();
        roster.setWeekNum(weekNum);
        roster.setStaffNeeded(staffNeeded);
        rosterList.add(roster);
        em.persist(roster);
        em.getTransaction().commit();
        return roster;
    }

    //Add staff to roster
    public void addStaffRoster(int empNum, int weekNum) {
        em.getTransaction().begin();
        Staff s = em.find(Staff.class, empNum);
        Roster r = em.find(Roster.class, weekNum);

        if (r.getStaffNeeded() > 0) {
            r.addStaff(s);
            System.out.println("Staff needed for this roster: " + r.getStaffNeeded());
        } else {
            System.out.println("No more staff needed for this roster!");
        }
        em.persist(r);
        em.getTransaction().commit();
    }

    //Update staff needed for different weeks
    public void updateStaffNeeded(int id, int newStaffNeeded) {
        em.getTransaction().begin();
        Roster r = em.find(Roster.class, id);
        r.setStaffNeeded(newStaffNeeded);
        em.getTransaction().commit();

    }

    //Delete staff member from roster
    public void removeStaffFromRoster(int empNum, int weekNum) {
        em.getTransaction().begin();
        Roster r = em.find(Roster.class, weekNum);
        r.removeStaff(empNum);

//        if (r.getStaffNeeded()
//                == 1) {
//            System.out.println("One staff member is needed to fill this roster!");
//        } else {
//            System.out.println("More staff member are needed to fill this roster!");
//        }

        em.remove(r);
        em.getTransaction().commit();

    }

}
