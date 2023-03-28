public abstract class Date {
    protected int year;
    protected int month;
    protected int day;
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    String[] monthsNames = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int[] monthsLength = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public void addDays(int days){
        int i = 0;
        while (i < days){
            day++;
            int daysInMonth = getNumberOfDaysInMonth(year, month);
            if(day > daysInMonth) {
                day = 1;
                month++;
                if (month == 13) {
                    month = 1;
                    year++;
                }
            }
            i++;
        }
    }
    public void subtractDays(int days){
        while(days > 0){
            days--;
            day--;
            if(day == 0){
                month--;
                if(month == 0){
                    month = 12;
                    year--;
                }
                day = getNumberOfDaysInMonth(year, month);
            }
        }
    }
    public void printShortDate(){
        System.out.printf("%-1s/%1s/%4s", month, day, year);
    }
    public void printLongDate(){
        String monthName = getMonthName(month);
        System.out.printf("%5s %1s, %4s", monthName, day, year);
    }
    public String getMonthName(){ return monthsNames[month - 1]; }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int getDayOfMonth(){
        return day;
    }
    private String getMonthName(int month){
        return monthsNames[month-1];
    }
    private int getNumberOfDaysInMonth(int year, int month){
        if(month != 2) return monthsLength[month - 1];
        else if(!isLeapYear(year)) return 28;
        else return 29;
    }
    private int getNumberOfDaysInYear(int year){
        if(isLeapYear(year)) return 366;
        else return 365;
    }
    //Abstract method telling Superclass that all Subclasses have a proper method defined like the one below
    public abstract boolean isLeapYear(int year);
    public boolean isLeapYear(){
        return isLeapYear(year);
    }
}
