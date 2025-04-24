package backtrack;

import java.util.*;

/**
 * @author leenadz
 * @since 2025-04-23 11:50
 */
public class FindItinerary {
    public static void main(String[] args) {
        FindItinerary findItinerary = new FindItinerary();

        List<List<String>> tickets1 = new ArrayList<>();
        tickets1.add(Arrays.asList("MUC", "LHR"));
        tickets1.add(Arrays.asList("JFK", "MUC"));
        tickets1.add(Arrays.asList("SFO", "SJC"));
        tickets1.add(Arrays.asList("LHR", "SFO"));
        System.out.println(findItinerary.findItinerary(tickets1));
        System.out.println();

        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(Arrays.asList("JFK", "SFO"));
        tickets2.add(Arrays.asList("JFK", "ATL"));
        tickets2.add(Arrays.asList("ATL", "JFK"));
        tickets2.add(Arrays.asList("ATL", "SFO"));
        tickets2.add(Arrays.asList("SFO", "ATL"));
        System.out.println(findItinerary.findItinerary(tickets2));
        System.out.println();

        List<List<String>> tickets3 = new ArrayList<>();
        tickets3.add(Arrays.asList("JFK", "KUL"));
        tickets3.add(Arrays.asList("JFK", "NRT"));
        tickets3.add(Arrays.asList("NRT", "JFK"));
        System.out.println(findItinerary.findItinerary(tickets3));
        System.out.println();

    }

    // 难，不难理解，难在自己写
    Map<String, Map<String, Integer>> targets;
    List<String> resList;

    public List<String> findItinerary(List<List<String>> tickets) {
        resList = new ArrayList<>();
        resList.add("JFK");
        targets = new HashMap<>();
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp; // 目的地-次数映射
            if (targets.containsKey(ticket.get(0))) {
                temp = targets.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(ticket.get(1), 1);
            }
            targets.put(ticket.get(0), temp);
        }
        System.out.println(targets);
        findBackTracking(tickets.size());
        return resList;
    }

    private boolean findBackTracking(int ticketNum) {
        if (resList.size() == ticketNum + 1) {
            return true;
        }
        String last = resList.getLast();
        if (targets.containsKey(last)) {
            for (Map.Entry<String, Integer> target : targets.get(last).entrySet()) {
                String targetStr = target.getKey();
                Integer num = target.getValue();
                if (num > 0) {
                    resList.add(targetStr);
                    target.setValue(num - 1);
                    if (findBackTracking(ticketNum)) {
                        return true;
                    }
                    resList.removeLast();
                    target.setValue(num);
                }
            }
        }
        return false;
    }
}
