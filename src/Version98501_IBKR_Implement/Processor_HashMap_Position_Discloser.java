package Version98501_IBKR_Implement;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Processor_HashMap_Position_Discloser {

    double positionQtyToClose = 0.0;
    double absoluteOpenPositions = 0.0;

    public double Position_Discloser(TreeMap<String, Double> incomingTreeMap, String incomingSymbol) {
        positionQtyToClose = 0.0;

        Set<Map.Entry<String, Double>> entrySet = incomingTreeMap.entrySet();
        int index = 0;
        // For-each loop for iteration
        for (Map.Entry<String, Double> currentEntry : entrySet) {
            //        System.out.println("Key at   " + index + " :  " + currentEntry.getKey());
            // Get value using index
            //        System.out.println("Value at " + index + " :  " + currentEntry.getValue());

            if (currentEntry.getKey() == null ? incomingSymbol == null : currentEntry.getKey().equals(incomingSymbol)) {

                if (currentEntry.getValue() != 0.0) {
                    positionQtyToClose = currentEntry.getValue();
                }
                System.out.println("  ");
                System.out.println("Counter [index]     = " + index);
            }
        }

        return positionQtyToClose;
    }

    public double AbsolutePosition_Discloser(TreeMap<String, Double> incomingTreeMap) {
        absoluteOpenPositions = 0.0;

        Set<Map.Entry<String, Double>> entrySet = incomingTreeMap.entrySet();
        // For-each loop for iteration
        for (Map.Entry<String, Double> currentEntry : entrySet) {
            //        System.out.println("Key at   " + index + " :  " + currentEntry.getKey());
            // Get value using index
            //        System.out.println("Value at " + index + " :  " + currentEntry.getValue());

            if (currentEntry.getValue() != 0.0) {
                absoluteOpenPositions = Math.abs(currentEntry.getValue()) + absoluteOpenPositions;
            }
            System.out.println("  ");

        }

        return absoluteOpenPositions;
    }

    
        public double TotalAbsPositions_Discloser(TreeMap<String, Double> incomingTreeMap) {

            double TotalAbsPositions = incomingTreeMap.values().stream()
                         .mapToDouble(w -> Math.abs(w))
                         .sum();

        return TotalAbsPositions;
    }

    
    
}
