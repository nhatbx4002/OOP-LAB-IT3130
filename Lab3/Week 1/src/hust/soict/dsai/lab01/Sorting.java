
public class Sorting {
   public static void main(String[] args) {
     int a[] = {101,123,99,22,4,1000};

    for(int i = 0 ; i < a.length; ++i) {
        for(int  j = i + 1 ; j < a.length ; j++){
            if(a[i] > a[j]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
    for(int i = 0 ; i < a.length ; i++) {
        System.out.print(a[i] + " ");
    }
    System.exit(0);
   }
}
