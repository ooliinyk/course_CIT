package DB;

/**
 * Created by Oleksandr on 12/15/2014.
 */
public class Group {
    private int groupId;
    private int groupNum;

    public Group(){

    }

    public Group(int groupId, int groupNum) {
        this.groupId = groupId;
        this.groupNum = groupNum;
    }

    public Group(int groupNum) {
        this.groupNum = groupNum;
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
}
