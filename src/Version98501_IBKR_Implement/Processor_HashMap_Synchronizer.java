package Version98501_IBKR_Implement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Processor_HashMap_Synchronizer {

    HashMap<String, Double> portfolioMap = new HashMap<>();


    public TreeMap<String, Double> synchMethod(Map<String, Double> unsortedIncomingMap) {
        unsortedIncomingMap.size();
        System.out.println("unsortedIncomingMap.size= " + unsortedIncomingMap.size());
        System.out.println();
        System.out.println("unsortedIncomingMap HashMap= " + unsortedIncomingMap.size());
        System.out.println();


        portfolioMap.put("NZD", 0.0);
        portfolioMap.put("RUR", 0.0);
        portfolioMap.put("ZAR", 0.0);
        portfolioMap.put("MXP", 0.0);
        portfolioMap.put("AUD", 0.0);
        portfolioMap.put("CAD", 0.0);
        portfolioMap.put("CHF", 0.0);
        portfolioMap.put("EUR", 0.0);
        portfolioMap.put("GBP", 0.0);
        portfolioMap.put("JPY", 0.0);
        


        

        Set<Map.Entry<String, Double>> entrySet = unsortedIncomingMap.entrySet();
        for (Map.Entry<String, Double> e : entrySet) {
            if (unsortedIncomingMap.containsKey(e.getKey())) {
                portfolioMap.put(e.getKey(), e.getValue());
            } else {
                portfolioMap.put(e.getKey(), e.getValue());
            }
        }

        System.out.println("Before Sorting:");
        Set set = portfolioMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        TreeMap<String, Double> map = new TreeMap<>(portfolioMap);
        System.out.println("After Sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator2.next();
            System.out.print(me2.getKey() + ": ");
            System.out.println(me2.getValue());
        }


        System.out.println();
        System.out.println();
        System.out.println("Here's Merged map = :" + map);
        System.out.println();
        System.out.println();

        System.out.println("Here's AFTER -- Taking out 0.0 positions:");
        System.out.println();
        System.out.println();

        Map<String, Double> result = map.entrySet()
                .stream()
                .filter(e -> Math.abs(e.getValue()) != 0.0)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        TreeMap<String, Double> treeMapDONE = new TreeMap<>();
//        // Pass the hashMap to putAll() method
        treeMapDONE.putAll(result);

        return treeMapDONE;

    }

}
