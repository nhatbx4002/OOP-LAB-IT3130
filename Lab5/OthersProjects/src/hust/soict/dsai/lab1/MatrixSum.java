package hust.soict.dsai.lab1;
import java.util.Scanner;
public class MatrixSum {
    public static final int N = 100 ; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int[][] sum = new int[N][N];
        int n , m ; 
        System.out.print("Nhap vao kich thuoc ma tran A va B (n*m): \n" + "So hang n : " );
        n = scanner.nextInt();
        System.out.print("\nSo cot : ");
        m = scanner.nextInt();
        System.out.println("Nhap vao ma tran A : ");
        for(int i = 1; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++){
                A[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Nhap vao ma tran B : ");
        for(int i = 1; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++){
                B[i][j] = scanner.nextInt();
            }
        }
        
        for(int i = 1; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++){
                sum[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("\nMa tran tong cua A va B: ");
        for(int i = 1; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++){
                sum[i][j] = A[i][j] + B[i][j];
            }
        }
        for(int i = 1; i <= n ; i++) {
            for(int j = 1 ; j <= m ; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.exit(0);
    }
}

