public class Manager extends Staff implements ICalculator {
    private String position; // chức danh

    public Manager(String id, String name, int age, double rateSalary, String startDay, String dept, int leave, String position) {
        super(id, name, age, rateSalary, startDay, dept, leave);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double calculateSalary() {
        double salary  = 0;
        if (position.equals("Business Leader") == true) {
            salary = super.getRateSalary() * 5000000 + 8000000;
        } else if (position.equals("Project Leader") == true) {
            salary =  super.getRateSalary() * 5000000 + 5000000;
        } else if (position.equals("Technical Leader") == true)
            salary = super.getRateSalary() * 5000000 + 6000000;

        return salary;
    }


    public void displayInformation() {
        String s = "";
        s = "Quản lý[id:" + super.getId() + " - " +"tên:" + super.getName() + " - " + "tuổi:" + super.getAge() + " - " + "ngày vào làm:" + super.getStartDay() + " - " + "bộ phận:" + super.getDept()+ " - " + "Chức vụ:" + this.position +"]";
        System.out.println(s);
    }

}
