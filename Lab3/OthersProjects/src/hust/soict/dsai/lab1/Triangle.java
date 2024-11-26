package hust.soict.dsai.lab1;
import java.util.Scanner;

public class Triangle {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao chieu cao n ban mong muon : ");
        int n  = scanner.nextInt();
        for(int i = 1 ; i <= n ; i++){
           int j = 1 ; 
           while(j <= n-i) {
                System.out.print(" ");
                j++;
           }
           int star = 1 ; 
           while(star <= i*2 - 1){
                System.out.print("*");
                star++;
           }
           if(i < n ) System.out.print("\n");
        }
    }
}
