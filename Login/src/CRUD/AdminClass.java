package CRUD;

/**
 *
 * @author X00121581
 */
public class AdminClass extends EmployeeClass{
    
    String position;

    public AdminClass(){
        super();
    }
    
    public AdminClass(int userId, String password, String username, String flag, String name, String address1, String address2, String email, String pnumber, String contract, String position,double payrate) {
        super(userId,password,username,flag,name,address1,address2,email,pnumber,contract,payrate);
        this.position = position;
    }
    
}

