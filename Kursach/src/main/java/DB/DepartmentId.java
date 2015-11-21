package DB;

/**
 * Created by Oleksandr on 12/15/2014.
 */
public class DepartmentId {
    private int departmentId;
    private String departmentName;
    private int telephone;
    private String dean;

    public DepartmentId(){

    }

    public DepartmentId(int departmentId, String departmentName, int telephone, String dean) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.telephone = telephone;
        this.dean = dean;
    }

    public DepartmentId(String departmentName, int telephone, String dean) {
        this.departmentName = departmentName;
        this.telephone = telephone;
        this.dean = dean;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }
}
