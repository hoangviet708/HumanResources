public abstract class Staff {
    private  String id; // mã nhân viên
    private String name; //tên nhân viên
    private int age; // tuổi nhân viên
    private double  rateSalary; // hệ số lương
    private String startDay;
    private String dept; // bộ phận
    private int leave; // số ngày nghỉ phép

    public Staff(String id, String name, int age, double rateSalary, String startDay, String dept, int leave) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rateSalary = rateSalary;
        this.startDay = startDay;
        this.dept = dept;
        this.leave = leave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public double getRateSalary() {
        return rateSalary;
    }

    public void setRateSalary(double rateSalary) {
        this.rateSalary = rateSalary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public abstract void displayInformation();
}



