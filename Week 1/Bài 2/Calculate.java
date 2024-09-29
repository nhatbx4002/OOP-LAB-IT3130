import java.util.Scanner;
public class Calculate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //doc vao du lieu nguoi dung nhap 
        String strNum1 , strNum2 ; 
        System.out.print("Nhap vao so thu nhat : ");
        strNum1 = scanner.nextLine();
        System.out.print("Nhap vao so thu hai : ");
        strNum2 = scanner.nextLine();
        //chuyen doi tu string sang double
        double num1 = Double.parseDouble(strNum1); 
        double num2 = Double.parseDouble(strNum2);
        //thuc hien cac phep toan tong hieu tich thuong
        double sum = num1 + num2 ; 
        double difference = num1 - num2 ;
        double product = num1 * num2 ; 
        System.out.print("Tong cua hai so la : " + sum + "\n");
        System.out.print("Hieu cua hai so la : " + difference + "\n");
        System.out.print("Tich cua hai so la : " + product + "\n");
        if(num2 != 0 ){
            double quotient = num1 / num2 ; 
            System.out.print("Thuong cua hai so la : " + quotient + "\n");
        }
        else {
            System.out.print("Khong the chia cho 0.");
        }
        System.exit(0);
    }
}