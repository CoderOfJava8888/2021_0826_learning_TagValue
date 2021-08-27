package Version98501_IBKR_Implement;

import com.ib.client.Bar;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Processor_HistoricalData {

    private static final DecimalFormat df5 = new DecimalFormat("#.#####");
    private static final DecimalFormat df6 = new DecimalFormat("+#.#####%;-#");
    private static final DecimalFormat df7 = new DecimalFormat("+#.##");

    String decision = "";
    String message_confirmation = "";

    int sizeSimpleBar;
    double simpleOPEN, simpleHIGH, simpleLOW, simpleCLOSE;
    double pivotpoint_0, pivotpoint_1, pivotpoint_2;
    double slope;
    double slope_0, slope_1, slope_2;
    double pctChange_0 = 0.0;
    double pctChange, LastTick;
    double momentum_1, momentum_2, momentum_3;
    double momentum_0 = 1.0;
    double momentum = 1.0;
    double message_calc, confirm_calc;
    int message_value, confirm_value;

    int bar1;
    int bar2;
    double Tick;

    TimeDifference TD = new TimeDifference();

//   public static LiveBar myFunction(String strResult,double doubleResult){
//    return new LiveBar(strResult,doubleResult);
//}
    public String simpleDecisionDeterminer_UsingTick(ArrayList<Bar> barInput, double Tick) {  // throws InterruptedException {

        System.out.println("===================  simple-DecisionDeterminer_NoTick =============================================>  ");
        System.out.println("============          Here's ArrayList<Bar> barInput         ======================================>  " + barInput);
        System.out.println("===================================================================================================>  ");

        System.out.println("===================  simple-DecisionDeterminer_NoTick =============================================>  ");
        System.out.println("===Bar size:  =>  " + barInput.size());

        sizeSimpleBar = barInput.size();

        if (barInput.size() == 2) {
            bar1 = 0;
            bar2 = 1;
        };
        if (barInput.size() == 3) {
            bar1 = 1;
            bar2 = 2;
        };

        /*
        Bar size must be equal to 2.  Because we are only working with two bars.
         */
        //  if (sizeSimpleBar == 2) {         
        System.out.println(" sizeSimpleBar===>  " + sizeSimpleBar);

        System.out.println();
        System.out.println();
        System.out.println();


        pivotpoint_0 = (barInput.get(bar1).low() + barInput.get(bar1).high() + barInput.get(bar1).close()) / 3;
        pivotpoint_1 = (barInput.get(bar2).low() + barInput.get(bar2).high() + barInput.get(bar2).close()) / 3;

        System.out.println("pivotpoint_0  = " + pivotpoint_0);
        System.out.println("pivotpoint_1  = " + pivotpoint_1);


        //slope = barInput.get(bar1).close() - pivotpoint_0;
        slope = Tick - pivotpoint_1;

        System.out.println(" ");
        System.out.println("Slope                   :  " + slope);
        System.out.println(" ");
        System.out.println(" ");

        if (slope > 0.0) {
            decision = "BUY";
        }
        if (slope < 0.0) {
            decision = "SELL";
        }

        System.out.println();
        System.out.println();

        return decision;

    }


    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }

    LiveBar getLiveBar() {
        String strResult = getDecision();
        double doubleResult = getMomentum();
        return new LiveBar(strResult, doubleResult);
    }

}
