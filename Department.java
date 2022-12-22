import java.util.ArrayList;

public class Department {
    private String departmentId; // mã bộ phận
    private String departmentName; // tên bộ phận
    private int departmentNum ; // số lượng nhân viên



    public Department(String departmentId, String departmentName,int departmentNum) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentNum = departmentNum;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentNum(int departmentNum) {
        this.departmentNum = departmentNum;
    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    @Override
    public String toString() {
        String s = "";
        s = departmentId + " - " + departmentName + ": " + departmentNum + " nhân viên ";
        return s ;
    }

}
