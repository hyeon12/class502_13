package chapter05.exercise;

import java.time.LocalDateTime;

public class MyDate {
    private int day;
    private int month;
    private int year;
    private boolean isValid = true;

    public MyDate(int day, int month, int year){
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay(){
        return day;
    }


    //말일이 31일인 달 | 말일이 30인 달 | 말일이 29일인 달 로 구분하여 switch ~ case 구문 사용
    //달력에 존재하지 않은 날짜의 경우 isValid = false, 존재하는 날짜의 경우 입력한 날짜 대입할 수 있도록!
    public void setDay(int day){
        switch(month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(day <0 || day> 31){
                    isValid = false;
                }else {
                    this.day = day;
                }
                break;
            case 4: case 6: case 9: case 11:
                if(day <0 || day > 30){
                    isValid = false;
                } else {
                    this.day = day;
                }
                break;
            case 2 :
                if(day < 0 || day > 29){
                    isValid = false;
                }else{
                    this.day = day;
                }
                break;
            default:
                isValid = false;
        }
    }

    public int getMonth(){
        return month;
    }

    //12달 중에서 입력 가능하도록 if문 사용
    public void setMonth(int month){
        if(month < 1 || month > 12){
            isValid = false;
        }else{
            this.month = month;
        }
    }

    public int getYear(){
        return year;
    }

    //현재까지의 햇수 중에서 입력하는 경우 그대로, 아직 오지 않은 날짜의 경우 isValid=false;
    public void setYear(int year){
        if(year > LocalDateTime.now().getYear()){
            isValid = false;
        }else{
            this.year = year;
        }
    }

    //달력에 존재하는 날짜인지 아닌지!
    public String isValid(){
        if(!isValid){
            return "유효하지 않은 날짜입니다.";
        }else{
            return "유효한 날짜입니다.";
        }
    }
}
