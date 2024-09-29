import java.util.Scanner;
import java.lang.Integer;
public class DaysInMonth {

    static int checkYear (String s){
        if(s.length() != 4) return 0 ;
        return Integer.parseInt(s) ; 
    }
    static int checkMonth(String s) {
        if (s.equalsIgnoreCase("January") || s.equalsIgnoreCase("Jan") || s.equalsIgnoreCase("Jan.") || s.equals("1")) return 1;
        else if (s.equalsIgnoreCase("February") || s.equalsIgnoreCase("Feb") || s.equalsIgnoreCase("Feb.") || s.equals("2")) return 2;
        else if (s.equalsIgnoreCase("March") || s.equalsIgnoreCase("Mar") || s.equalsIgnoreCase("Mar.") || s.equals("3")) return 3;
        else if (s.equalsIgnoreCase("April") || s.equalsIgnoreCase("Apr") || s.equalsIgnoreCase("Apr.") || s.equals("4")) return 4;
        else if (s.equalsIgnoreCase("May") || s.equals("5")) return 5;
        else if (s.equalsIgnoreCase("June") || s.equalsIgnoreCase("Jun") || s.equalsIgnoreCase("Jun.") || s.equals("6")) return 6;
        else if (s.equalsIgnoreCase("July") || s.equalsIgnoreCase("Jul") || s.equalsIgnoreCase("Jul.") || s.equals("7")) return 7;
        else if (s.equalsIgnoreCase("August") || s.equalsIgnoreCase("Aug") || s.equalsIgnoreCase("Aug.") || s.equals("8")) return 8;
        else if (s.equalsIgnoreCase("September") || s.equalsIgnoreCase("Sep") || s.equalsIgnoreCase("Sep.") || s.equals("9")) return 9;
        else if (s.equalsIgnoreCase("October") || s.equalsIgnoreCase("Oct") || s.equalsIgnoreCase("Oct.") || s.equals("10")) return 10;
        else if (s.equalsIgnoreCase("November") || s.equalsIgnoreCase("Nov") || s.equalsIgnoreCase("Nov.") || s.equals("11")) return 11;
        else if (s.equalsIgnoreCase("December") || s.equalsIgnoreCase("Dec") || s.equalsIgnoreCase("Dec.") || s.equals("12")) return 12;
        return 0;
    }

    static int getDays (boolean leap , int month ){ 
        if(month == 2) {
            if(leap == true) return 29 ;
            else return 28 ; 
        }else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) return 31;
        else return 30 ; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String strYear, strMonth; 
        boolean check = false ;
        while(!check) {
            System.out.print("Nhap vao day du nam va thang ban muon hien thi so ngay (dinh dang dung la nam/thang) : ");    
            String inputString = scanner.nextLine();
            String[] parts = inputString.split("/");
            int year , month ;
            if(parts.length == 2) {
                if(checkYear(parts[0].trim()) != 0  && checkMonth(parts[1].trim()) != 0 ){
                    year = checkYear(parts[0].trim()) ;
                    month = checkMonth(parts[1]);
                    check = true ; 
                    boolean leap = false; 
                    if(year % 4 == 0 && year % 100 != 0){
                        leap = true; 
                    }else if(year % 4 != 0 && year % 100 == 0 ){
                        leap = true ;
                    }
                    System.out.print("Thang " + month + " cua nam " + year + " co so ngay la: " + getDays(leap, month));
                    
                }else{
                    System.out.print("Dinh dang nam hoac thang khong dung!\n");
                }
            }else{
                System.out.print("Vui long nhap lai dung dinh dang yeu cau!");
            }
        }
        System.exit(0);
    }
}
