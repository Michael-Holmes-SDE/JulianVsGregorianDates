public class JulianDate extends Date{
    public JulianDate(int year, int month, int day) {
        super(year, month, day);
    }
    JulianDate(){
        super(1, 1, 1);
        addDays(719164);
        long currentMs = System.currentTimeMillis();
        long offsetMs = java.util.TimeZone.getDefault().getRawOffset();
        long ms = currentMs + offsetMs;
        int days = (int) (ms / 86400000);
        addDays(days);
    }
    public boolean isLeapYear(int year){
        return year % 4 == 0;
    }
}
