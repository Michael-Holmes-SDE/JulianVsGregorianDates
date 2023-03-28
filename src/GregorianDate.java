public class GregorianDate extends Date{
    public GregorianDate(int year, int month, int day) {
        super(year, month, day);
    }
    GregorianDate(){
        super(1970, 1, 1);
        long currentMs = System.currentTimeMillis();
        long offsetMs = java.util.TimeZone.getDefault().getRawOffset();
        long ms = currentMs + offsetMs;
        int days = (int) (ms / 86400000);
        addDays(days);
    }
    public boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}
