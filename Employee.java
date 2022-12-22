public  class Employee extends  Staff implements ICalculator{
    private int overTime; // số giờ làm thêm

    public Employee(String id, String name, int age, double rateSalary, String startDay, String dept, int leave, int overTime) {
        super(id, name, age, rateSalary, startDay, dept, leave);
        this.overTime = overTime;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public double calculateSalary() {
        double salary;
        salary = super.getRateSalary() * 3000000 + overTime * 200000;
        return salary;
    }

    public void displayInformation() {
        String s = "";
        s = "Nhân viên[id:" + super.getId() + " - " +"tên:" + super.getName() + " - " + "tuổi:" + super.getAge() + " - " + "ngày vào làm:" + super.getStartDay() + " - " + "bộ phận:" + super.getDept()+"]";
        System.out.println(s);
    }


}