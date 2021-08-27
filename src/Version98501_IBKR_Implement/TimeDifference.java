package Version98501_IBKR_Implement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
    
public class TimeDifference  {

    public Double DaysLapsed_VALUE;
    public Double DaysElapsed;
    public Double LAPSE_days;
    
    public Double HoursLapsed_VALUE;
    public Double LAPSE_hours;
    public Double HoursElapsed;
    
    public Double LAPSE_minutes;
    public Double MinutesLapsed;
    public Double MinutesLapsed_VALUE;
    public Double MinutesElapsed;
    
    public String Answer;
    final public Double lengthOfMinutes = 35.0;
//  Learning source:
//  https://www.mkyong.com/java/how-to-calculate-date-time-difference-in-java/
    
    public String FindDifference(String dateStartLAST, String dateFinishNOW) throws NullPointerException {

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("dateStartLAST  ==>>   " + dateStartLAST);
        System.out.println("dateFinishNOW  ==>>   " + dateFinishNOW);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String dateStart = dateStartLAST; //  "01/08/2018 09:29:58";
        String dateStop  = dateFinishNOW; //  "05/26/2019 10:31:48";

        SimpleDateFormat format_LTrade = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        SimpleDateFormat format_NOW = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

        Date d1 = null;
        Date d2 = null;


        try {
            d1 = format_LTrade.parse(dateStart);
            d2 = format_NOW.parse(dateStop);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);

        
            System.out.println(Days.daysBetween(dt1, dt2).getDays() + " days, ");
            DaysLapsed_VALUE = Double.valueOf(Days.daysBetween(dt1, dt2).getDays());
            System.out.println(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
            HoursLapsed_VALUE = Double.valueOf(Hours.hoursBetween(dt1, dt2).getHours() % 12);  
            System.out.println(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
            MinutesLapsed_VALUE = Double.valueOf(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60);
            System.out.println(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

            DaysElapsed= Math.abs(DaysLapsed_VALUE);           
            HoursElapsed = Math.abs(HoursLapsed_VALUE);
            MinutesElapsed = Math.abs(MinutesLapsed_VALUE);
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("============Double_,_,_MinutesLapsed==============>>  " + MinutesElapsed+"     || Criteria against Length of Minutes=________"+lengthOfMinutes);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.LAPSE_days = DaysElapsed;
        this.LAPSE_hours = HoursElapsed;
        this.LAPSE_minutes = MinutesElapsed;
        

        if(LAPSE_minutes>=lengthOfMinutes){Answer="YES";}
        if(LAPSE_minutes<lengthOfMinutes){Answer="NO";}
        if(LAPSE_hours>=1){Answer="YES";}
        if(LAPSE_days>=1){Answer="YES";}        
        
        
        System.out.println("");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++ Answer from TimeDifference class:  --> "+Answer);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");
        
        return Answer;
    }

    
    
    public String FindDifference_Method_02(String dateStartLAST) throws NullPointerException {
        
        String dateStart = dateStartLAST; //  "01/08/2018 09:29:58";
        Date nowTimeDiff = new Date(); //Date and time at this moment
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowTimeDiff);
        cal.add(Calendar.HOUR, +1);
        Date TimeNow = cal.getTime();
        System.out.println("@@@@@ TimeNow @@@@@====>>   " + TimeNow);
        SimpleDateFormat formTBs = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateStop = formTBs.format(cal.getTime());
  //    String dateStop  = dateFinishNOW; //  "05/26/2019 10:31:48";

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("dateStartLAST  ==>>   " + dateStartLAST);
        System.out.println("dateFinishNOW  ==>>   " + dateStop);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
  
  
        SimpleDateFormat format_LTrade = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        SimpleDateFormat format_NOW = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format_LTrade.parse(dateStart);
            d2 = format_NOW.parse(dateStop);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);

        
            System.out.println(Days.daysBetween(dt1, dt2).getDays() + " days, ");
            DaysLapsed_VALUE = Double.valueOf(Days.daysBetween(dt1, dt2).getDays());
            System.out.println(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
            HoursLapsed_VALUE = Double.valueOf(Hours.hoursBetween(dt1, dt2).getHours() % 12);  
            System.out.println(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
            MinutesLapsed_VALUE = Double.valueOf(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60);
            System.out.println(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

            DaysElapsed= Math.abs(DaysLapsed_VALUE);           
            HoursElapsed = Math.abs(HoursLapsed_VALUE);
            MinutesElapsed = Math.abs(MinutesLapsed_VALUE);
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("============Double_,_,_MinutesLapsed==============>>  " + MinutesElapsed+"     || Criteria against Length of Minutes=________"+lengthOfMinutes);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.LAPSE_days = DaysElapsed;
        this.LAPSE_hours = HoursElapsed;
        this.LAPSE_minutes = MinutesElapsed;
        

        if(LAPSE_minutes>=lengthOfMinutes){Answer="YES";}
        if(LAPSE_minutes<lengthOfMinutes){Answer="NO";}
        if(LAPSE_hours>=1){Answer="YES";}
        if(LAPSE_days>=1){Answer="YES";}        
        
        
        System.out.println("");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++ Answer from TimeDifference class:  --> "+Answer);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");
        
        return Answer;
    }
    
     
    public double FindDifference__MethodYYYYMMDD(String dateStartLAST, String dateFinishNOW) throws NullPointerException {

        //20210503  17:00:00            YYYYMMDD  HH:MM:SS
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("dateStartLAST  ==>>   " + dateStartLAST);
        System.out.println("dateFinishNOW  ==>>   " + dateFinishNOW);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        String dateStart = dateStartLAST; //  "01/08/2018 09:29:58";
        String dateStop  = dateFinishNOW; //  "05/26/2019 10:31:48";

        SimpleDateFormat format_LTrade = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        SimpleDateFormat format_NOW = new SimpleDateFormat("yyyyMMdd hh:mm:ss");

        Date d1 = null;
        Date d2 = null;


        try {
            d1 = format_LTrade.parse(dateStart);
            d2 = format_NOW.parse(dateStop);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);

        
            System.out.println(Days.daysBetween(dt1, dt2).getDays() + " days, ");
            DaysLapsed_VALUE = Double.valueOf(Days.daysBetween(dt1, dt2).getDays());
            System.out.println(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
            HoursLapsed_VALUE = Double.valueOf(Hours.hoursBetween(dt1, dt2).getHours() % 12);  
            System.out.println(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
            MinutesLapsed_VALUE = Double.valueOf(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60);
            System.out.println(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

            DaysElapsed= Math.abs(DaysLapsed_VALUE);           
            HoursElapsed = Math.abs(HoursLapsed_VALUE);
            MinutesElapsed = Math.abs(MinutesLapsed_VALUE);
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("============Double_,_,_MinutesLapsed==============>>  " + MinutesElapsed+"     || Criteria against Length of Minutes=________"+lengthOfMinutes);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.LAPSE_days = DaysElapsed;
        this.LAPSE_hours = HoursElapsed;
        this.LAPSE_minutes = MinutesElapsed;
        

        if(LAPSE_minutes>=lengthOfMinutes){Answer="YES";}
        if(LAPSE_minutes<lengthOfMinutes){Answer="NO";}
        if(LAPSE_hours>=1){Answer="YES";}
        if(LAPSE_days>=1){Answer="YES";}        
        
        
        System.out.println("");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++ Answer from TimeDifference class:  --> "+Answer);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");
        
        return MinutesElapsed;
    }
 
     
     
    
    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    
    
    public Double getMinutesLapsed() {
        return MinutesLapsed;
    }

    public void setMinutesLapsed(Double MinutesLapsed) {
        this.MinutesLapsed = MinutesLapsed;
    }
    
    
    public Double getLAPSE_hours() {
        return LAPSE_hours;
    }

    public Double setLAPSE_hours(Double HoursElapsed) {
        this.LAPSE_hours = HoursElapsed;
        return this.LAPSE_hours;
    }

    public Double getLAPSE_minutes() {
        return LAPSE_minutes;
    }

    public void setLAPSE_minutes(Double MinutesLapsed) {
        this.LAPSE_minutes = MinutesLapsed;

    }

    public Double getLAPSE_days() {
        return LAPSE_days;
    }

    public void setLAPSE_days(Double DaysLapsed) {
        this.LAPSE_days = DaysLapsed;

    }

}
