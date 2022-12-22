import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class HumanResources {
    public static void main(String[] args) {
        ArrayList<Staff> listStaff = new ArrayList<Staff>(); // Mảng chứa các nhân viên và quản lý
        ArrayList<Department> deptList = new ArrayList<Department>(); // mảng chứa các bộ phận

        Employee nv1 = new Employee("101", "Viet", 23, 1.3, "23/01/2020", "HanhChinh", 2, 2);
        Employee nv2 = new Employee("102", "Nam", 24, 1.1, "22/01/2021", "HanhChinh", 2, 2);
        Manager manager1 = new Manager("201","Trung",27,1.5,"22/01/2019","Project 1",2,"Project Leader");
        listStaff.add(nv1);
        listStaff.add(nv2);
        listStaff.add(manager1);
        deptList.add(new Department("HC","HanhChinh",2));
        deptList.add(new Department("PJ1","Project 1",1));

        Scanner sc = new Scanner(System.in);
        int chose = 0 ;
        do {
            System.out.println("MENU--------------------------");
            System.out.println("Vui lòng chọn chức năng: ");
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("0. Thoát chương trình");
            chose = sc.nextInt();

           switch (chose) {
               case 1:
                   //Hiển thị danh sách nhân viên hiện có trong công ty
                   for (Staff st: listStaff) {
                       st.displayInformation();
                   }
                   break;
               case 2:
                   //Hiển thị các bộ phận trong công ty
                   for (Department de: deptList) {
                       System.out.println(de.toString());
                   }
                   break;
               case 3:
                   //Hiển thị các nhân viên theo từng bộ phận
                   for (Department de: deptList) {
                       System.out.println(de.getDepartmentName()+": ");
                       for (Staff st: listStaff) {
                           if( de.getDepartmentName().equals(st.getDept()))
                               st.displayInformation();
                       }
                   }
                   break;
               case 4:
                   System.out.println("Nhập '1' để thêm nhân viên \nNhập '2' để thêm quản lý");
                   String str = sc.next();

                   System.out.println("Mã nhân viên: ");
                   String id = sc.next();

                   sc.nextLine();
                   System.out.println("Tên nhân viên: ");
                   String name = sc.nextLine();

                   System.out.println("Tuổi: ");
                   int age = sc.nextInt();

                   System.out.println("Hệ số lương: ");
                   double rateSalary = sc.nextDouble();

                   sc.nextLine();
                   System.out.println("Ngày vào làm: ");
                   String startDay = sc.nextLine();

                   System.out.println( "Tên bộ phận: ");
                   String dept = sc.nextLine();
                   // Kiểm tra  bộ phận đã TỒN TẠI ở deptList hay chưa
                   int check = 0; //
                   for (Department s: deptList) {
                       if(s.getDepartmentName().equals(dept)){
                           check = 1; // bộ phân đã tồn tại - tăng nhân viên lên 1
                           s.setDepartmentNum(s.getDepartmentNum() + 1 ); //
                           break;
                       }
                   }
                   if ( check == 0) { // thêm bộ phận mới
                       System.out.println("Nhập mã bộ phận: ");
                       String deptID = sc.next();
                       deptList.add(new Department(deptID,dept,1));
                   }

                   System.out.println("Số ngày nghỉ phép: ");
                   int leave = sc.nextInt();

                   System.out.println("Số giờ làm thêm: ");
                   int overTime = sc.nextInt();

                    // str = 2 -> thêm quản lý, str = 1 -> thêm nhân viên
                   if ( str.equals("2") == true) {
                       sc.nextLine();
                       //// Thêm quản lý vào danh sách
                       System.out.println("Chức danh quản lý: \n(Business Leader/Project Leader/Technical Leader)");
                       String position = sc.nextLine();
                       Manager manager = new Manager(id,name,age,rateSalary,startDay,dept,leave,position);
                       listStaff.add(manager);
                   } else {
                       // Thêm nhân viên vào danh sách
                       Employee nv = new Employee(id, name, age, rateSalary, startDay, dept, leave, overTime);
                       listStaff.add(nv);
                   }
                   break;

               case 5:
                   //Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
                   System.out.println("Nhap ma nhan vien hoac ten nhan vien: ");
                   String search = sc.next();
                   int kt = 0 ;
                   for (Staff emp: listStaff) {
                       if ( search.equals(emp.getName()) == true || search.equals(emp.getId()) == true ) {
                           emp.displayInformation();
                           kt = 1;
                       }
                   }
                   if (kt == 0) {
                       System.out.println("Ko tim thay nhan vien");
                   }
                   break;
               case 6:
                   // Sắp xếp thứ tự giảm dần
                   Collections.sort(listStaff, new Comparator<Staff>() {
                       @Override
                       public int compare(Staff o1, Staff o2) {
                           return ((ICalculator)o1).calculateSalary() > ((ICalculator)o2).calculateSalary() ? -1 : 1;
                       }
                   });
                   for(Staff emp: listStaff) {
                       emp.displayInformation();
                       System.out.printf("Lương %.0f\n" ,((ICalculator)emp).calculateSalary());
                   }
                   break;
               case 7:
                   // Sắp xếp thứ tự tăng dần
                   Collections.sort(listStaff, new Comparator<Staff>() {
                       @Override
                       public int compare(Staff o1, Staff o2) {
                           return ((ICalculator)o1).calculateSalary() < ((ICalculator)o2).calculateSalary() ? -1 : 1;
                       }
                   });
                   for(Staff emp: listStaff) {
                       emp.displayInformation();
                       System.out.printf("Lương %.0f\n" ,((ICalculator)emp).calculateSalary());
                   }
                   break;
               case 0:
                   break;
           }
           if (chose == 0 )
               break;
        } while(1==1);

    }
}