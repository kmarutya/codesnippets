package com.kmarutyan.interview.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MeshMessage {


    public static List<String> getShortestRoute(
                            Map<String, String[]> network,
                            Map<String, List<String>> routes,
                            String src,
                            String dst
    ){
        String key = key(src, dst);

        int routeCounts = routes.size();
        // updating routes
        for(String curDst: network.get(src)){
            String ckey = key(src, curDst);
            List<String> route = routes.getOrDefault(ckey, new ArrayList<String>());

            for( int i= 0; i < route.size(); i++){
                String rtSrc = route.get(i);
                String rsKey = key(rtSrc,curDst );
                int r1 = routes.getOrDefault(rsKey, new ArrayList<String>()).size();
                int r2 = route.size() - i;

                // found a shorter route
                if (r2 < r1){
                    routes.put(ckey,  Stream.of(rtSrc, curDst).collect(Collectors.toList()));
                }

            }
            routes.put(ckey, route);
        }

        if(routes.containsKey(key)){
            return routes.get(key);
        }
        return new ArrayList<String>();

    }

    public static String key(String src, String dst ){
        return String.format("%s-%s", src, dst);
    }

    public static String replaceSrc(String src, String key){
        String [] tokens = key.split("-");
        return String.format("%s-%s", src, tokens[1]);
    }

    public static String replaceDst(String dst, String key){
        String [] tokens = key.split("-");
        return String.format("%s-%s",tokens[0], dst);
    }

    public static void main(String... args){
        System.out.println("aha");
        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min",     new String[] { "William", "Jayden", "Omar" });
            put("William", new String[] { "Min", "Noam" });
            put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
            put("Ren",     new String[] { "Jayden", "Omar" });
            put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
            put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
            put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
            put("Noam",    new String[] { "Nathan", "Jayden", "William" });
            put("Omar",    new String[] { "Ren", "Min", "Scott" });
        }};
    }
}
