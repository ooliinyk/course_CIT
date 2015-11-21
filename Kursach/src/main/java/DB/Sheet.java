package DB;

/**
 * Created by Oleksandr on 12/15/2014.
 */
public class Sheet {
    private int sheetId;
    private int studentId;
    private String lastName;
    private String subjectName;
    private int mark;
    private int subjectID;
    private int departmentID;
    private String departmentName;
    private int groupId;
    private int groupNum;
    private int teacherId;
    private  String teacherName;

    public Sheet(){

    }

    public Sheet(int sheetId, int studentId, String lastName, String subjectName, int mark, int subjectID, int departmentID, String departmentName, int groupId, int groupNum, int teacherId, String teacherName) {
        this.sheetId = sheetId;
        this.studentId = studentId;
        this.lastName = lastName;
        this.subjectName = subjectName;
        this.mark = mark;
        this.subjectID = subjectID;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.groupId = groupId;
        this.groupNum = groupNum;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Sheet(int studentId, String lastName, String subjectName, int mark, int subjectID, int departmentID, String departmentName, int groupId, int groupNum, int teacherId, String teacherName) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.subjectName = subjectName;
        this.mark = mark;
        this.subjectID = subjectID;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.groupId = groupId;
        this.groupNum = groupNum;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public int getSheetId() {
        return sheetId;
    }

    public void setSheetId(int sheetId) {
        this.sheetId = sheetId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
