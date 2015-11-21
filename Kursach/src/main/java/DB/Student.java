package DB;

/**
 * Created by Oleksandr on 12/13/2014.
 */
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private int groupNumber;
    private int age;
    private String departmentName;

   public Student(){

    }



    public Student(String departmentName, String firstName, String lastName, String email, String sex, int groupNumber, int age) {
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.groupNumber = groupNumber;
        this.age = age;
    }

    public Student(int studentId, String firstName, String lastName, String email, String sex, int groupNumber, int age, String departmentName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.groupNumber = groupNumber;
        this.age = age;
        this.departmentName = departmentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(id:"+ studentId+ ", username:" + firstName +", last:" + lastName + email+sex+groupNumber+age+departmentName + ")";
    }
}
