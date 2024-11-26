import java.util.Scanner;
import java.lang.Math;

public class EquationSolve {
    
    static void PTBac1(int a, int b) {
        if (a == 0 && b != 0) {
            System.out.println("Phuong trinh vo nghiem.");
        } else if (a == 0 && b == 0) {
            System.out.println("Phuong trinh vo so nghiem.");
        } else {
            double res = (double) -b / a;
            System.out.print("Ket qua cua phuong trinh bac nhat la : " + res + "\n");
        }
        return;
    }

    static void PTBac2(int a, int b, int c) {
        if (a == 0)
            PTBac1(b, c);
        else {
            double delta = (double) b * b - 4 * a * c;
            if (delta < 0)
                System.out.println("Phuong trinh vo nghiem");
            else if (delta == 0)
                System.out.print("Phuong trinh co nghiem kep la : " + (double) -b / 2 * a + "\n");
            else {
                double x1 = (double) (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (double) (-b - Math.sqrt(delta)) / (2 * a);
                System.out.print("Phuong trinh co 2 nghiem phan biet : " + "\n" + "gia tri x1 la :" + x1 + "\n"
                        + "gia tri x2 la : " + x2 + "\n");
            }
        }
        return;
    }

    static void HePT(int a11, int a12, int b1, int a21, int a22, int b2) {
        int D = a11 * a22 - a21 * a12;
        int Dx = b1 * a22 - b2 * a12;
        int Dy = a11 * b2 - a21 * b1;
        if (D == 0) {
            if (Dx == 0 && Dy == 0)
                System.out.println("He phuong trinh vo so nghiem.");
            else
                System.out.println("He phuong trinh vo nghiem");
        } else {
            double x = (double) Dx / D;
            double y = (double) Dy / D;
            System.out.print("Cap nghiem cua he phuong trinh (x,y) la : " + "(" + x + "," + y + ")" + "\n");
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("------------ Menu ------------  " + "\n" +
                "1.Giai phuong trinh bac nhat." + "\n" +
                "2.Giai phuong trinh he phuong trinh." + "\n" +
                "3.Giai phuong trinh bac hai." + "\n" +
                "4.Thoat chuong trinh." + "\n" +
                "(Nguoi dung nhap so tu 1 den 4 de chon chuc nang muon thuc hien.)" + "\n" +
                "Hay nhap vao chuc nanng muon thuc hien :");
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                int a, b;
                System.out.println("Hay nhap vao cac he so a , b , c ( ung voi ax + b = 0 ) : ");
                System.out.print("\nNhap vao he so a : ");
                a = scanner.nextInt();
                System.out.print("\nNhap vao he so b : ");
                b = scanner.nextInt();
                PTBac1(a, b);
                System.out.print("Nhap chuc nang ban muon thuc hien (tu 1 den 4) : ");
            } else if (choice == 2) {
                int a11, a12, b1, a21, a22, b2;
                // nhap vao cac he so cua he phuong trinh
                System.out.println("Hay nhap vao cac he so cua he phuong trinh : ");
                // phuong trinh 1
                System.out.print("\nNhap vao he so a11 : ");
                a11 = scanner.nextInt();
                System.out.print("\nNhap vao he so a12 : ");
                a12 = scanner.nextInt();
                System.out.print("\nNhap vao he so b1 : ");
                b1 = scanner.nextInt();
                // phuong trinh 2
                System.out.print("\nNhap vao he so a21 : ");
                a21 = scanner.nextInt();
                System.out.print("\nNhap vao he so a22 : ");
                a22 = scanner.nextInt();
                System.out.print("\nNhap vao he so b2 : ");
                b2 = scanner.nextInt();
                HePT(a11, a12, b1, a21, a22, b2);
                System.out.print("Nhap chuc nang ban muon thuc hien (tu 1 den 4) : ");
            } else if (choice == 3) {
                int a, b, c;
                System.out.println("Hay nhap vao cac he so a , b , c ( ung voi ax^2 + bx + c = 0 ) : ");
                System.out.print("\nNhap vao he so a : ");
                a = scanner.nextInt();
                System.out.print("\nNhap vao he so b : ");
                b = scanner.nextInt();
                System.out.print("\nNhap vao he so c : ");
                c = scanner.nextInt();
                PTBac2(a, b, c);
                System.out.print("Nhap chuc nang ban muon thuc hien (tu 1 den 4) : ");
            } else if (choice == 4)
                break;
            else {
                System.out.print("Lua chon khong hop le vui long ban nhap lai !");
                System.out.print("Nhap chuc nang ban muon thuc hien (tu 1 den 4) : ");
            }
        }
        System.exit(0);
    }
}