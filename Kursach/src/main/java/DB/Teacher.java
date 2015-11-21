package DB;

/**
 * Created by Oleksandr on 12/15/2014.
 */
public class Teacher {
    private int teacherId;
    private String name;
    private String surname;
    private String subjectName;
    public Teacher(){

    }
    public Teacher(String name, String surname, String subjectName, String stupen) {
        this.name = name;
        this.surname = surname;
        this.subjectName = subjectName;
        this.stupen = stupen;
    }

    public Teacher(int teacherId, String name, String surname, String subjectName, String stupen) {
        this.teacherId = teacherId;
        this.name = name;
        this.surname = surname;
        this.subjectName = subjectName;
        this.stupen = stupen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStupen() {
        return stupen;
    }

    public void setStupen(String stupen) {
        this.stupen = stupen;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    private String stupen;

}
