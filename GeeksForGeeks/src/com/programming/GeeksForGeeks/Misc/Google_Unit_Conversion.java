package com.programming.GeeksForGeeks.Misc;

import java.io.*;
import java.util.*;

public class Google_Unit_Conversion {

    Map<String, Map<String, Double>> data = new HashMap<>();
    private String csv_delimeter = ",";
    private final String outputFile = "/Users/rmodi/Data-Folder-Problems/output.csv";
    private final String queryFile = "/Users/rmodi/Data-Folder-Problems/queries.csv";
    private final String dataFile = "/Users/rmodi/Data-Folder-Problems/ratios.csv";

    Google_Unit_Conversion(){}

    Google_Unit_Conversion(String delimiter){
        this.csv_delimeter = delimiter;
    }

    public void populateInputData(Boolean isQueriesFile){
        if(isQueriesFile && data.isEmpty()) throw new RuntimeException("First populate the data....");
        String crt_line = null;
        List<String> inputs = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(isQueriesFile?queryFile:dataFile))){

            while((crt_line = br.readLine())!=null){
                Arrays.stream(crt_line.split(csv_delimeter))
                        .forEach(s->inputs.add(s.trim()));
                if(isQueriesFile){
                    populateQuery(inputs);
                }else{
                    populateRatioData(inputs);
                }
                inputs.clear();
            }
            printMap();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void writeToCSV(StringBuilder outputText){
        try(FileWriter wr = new FileWriter(new File(outputFile),true)){
            wr.write(outputText.append('\n').toString());
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //For Invalid...entries like USD, Meter query will return 1.0
    private Double query_output(String unitA, String unitB){
        //Check entries are present in the data
        if(data.keySet().contains(unitA) && data.keySet().contains(unitB)) {
            if(unitA.equalsIgnoreCase(unitB)) return new Double(1.0);
            Set<String> nodes = data.get(unitA).keySet();
            Set<String> visited = new HashSet<>();
            Stack<Double> pathVals = new Stack<>();
            visited.add(unitA);
            for (String edge_node : nodes) {
                Double crt_val = data.get(unitA).get(edge_node).doubleValue();
                pathVals.push(crt_val);
                if (edge_node.equalsIgnoreCase(unitB)) {
                    break;
                } else {
                    if(helper(edge_node, unitB, visited, pathVals)){
                        break;
                    } else{
                        pathVals.pop();
                    }
                }
            }
            return pathVals.stream().reduce(1.0,(total,i)->total*=i);
        }else{
            return Double.valueOf(0);
        }
    }

    private Boolean helper(String crt_edge, String targetUnit, Set<String> visited_nodes, Stack<Double> pathVals){

        if(visited_nodes.contains(crt_edge)) return false;
        else{
            Map<String, Double> val_map = data.get(crt_edge);
            visited_nodes.add(crt_edge);
            for(String unit : val_map.keySet()){
                if(visited_nodes.contains(unit)) continue;
                pathVals.push(val_map.get(unit));
                if(unit.equalsIgnoreCase(targetUnit)){
                    return true;
                }else{
                    if(helper(unit, targetUnit, visited_nodes,pathVals)){
                        return true;
                    }else{
                        pathVals.pop();
                    }
                }
            }
        }
        return false;
    }

    private void populateQuery(List<String> inputs){

        //List("USA","GBP") => conversionFactor = ?
        String unitA = inputs.get(0);
        String unitB = inputs.get(1);
        String ans = String.format( "%.2f", query_output(unitA,unitB));
        StringBuilder strBld_Result = new StringBuilder();
        strBld_Result.append(unitA);
        strBld_Result.append(",");
        strBld_Result.append(unitB);
        strBld_Result.append(",");
        strBld_Result.append(ans);
        writeToCSV(strBld_Result);

    }

    private void populateRatioData(List<String> inputs){

        //List("USA","GBP",0.69) => (unitA / unitB) = conversionFactor ~ unitA = (conversionFactor * unitB)
        String unitA = inputs.get(0);
        String unitB = inputs.get(1);
        Double conversionFactor = Double.parseDouble(inputs.get(2));
        Map<String,Double> valueMap;

        valueMap = data.getOrDefault(unitA, new HashMap<>());
        valueMap.putIfAbsent(unitB,conversionFactor);
        data.put(unitA, valueMap);

        valueMap = data.getOrDefault(unitB, new HashMap<>());
        valueMap.putIfAbsent(unitA, 1/conversionFactor);
        data.put(unitB, valueMap);

    }


    private void printMap(){
        data.forEach((k,v) -> {
            System.out.println(k+ " : [ ");
            v.forEach((k1,v1)->
                System.out.println("        "+k1+" : "+v1)
            );
            System.out.println( "       ]");
        });
    }

    public static void main(String[] args) {
        Google_Unit_Conversion obj = new Google_Unit_Conversion();
        obj.populateInputData(false);
        System.out.println("Data has been populated...Now you can try queries...");
        obj.populateInputData(true);
    }
}
