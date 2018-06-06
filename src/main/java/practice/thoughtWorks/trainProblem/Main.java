package practice.thoughtWorks.trainProblem;


import practice.thoughtWorks.trainProblem.entity.*;
import practice.thoughtWorks.trainProblem.query.*;
import practice.thoughtWorks.trainProblem.util.Travels;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class Main {

    private static Map<Town, List<Route>> townMap = new HashMap<>();

    public static void main(String[] args) throws IOException {


        String townMapString  = Travels.readTownMapFromFile("/Users/Wallen/IdeaProjects/rxlearn/src/main/java/practice/trainProblem/trainRoute.txt");
        townMap = Travels.parseTownMap(townMapString);

        System.out.println("case 1: A-B-C");
        String case_one = "A-B-C";

        Travels.println(Travels.calcDistance(Travels.parsePath(case_one, townMap)).intValue());

        System.out.println("case 2: A-D");
        String case_two = "A-D";
        Travels.println(Travels.calcDistance(Travels.parsePath(case_two, townMap)));

        System.out.println("case 3: A-D-C");
        String case_three = "A-D-C";
        Travels.println(Travels.calcDistance(Travels.parsePath(case_three, townMap)));

        System.out.println("case 4: A-E-B-C-D");
        String case_four = "A-E-B-C-D";
        Travels.println(Travels.calcDistance(Travels.parsePath(case_four, townMap)));

        System.out.println("case 5: A-E-D");
        String case_five = "A-E-D";
        Travels.println(Travels.calcDistance(Travels.parsePath(case_five, townMap)));

        System.out.println("case 6: C C");
        int numOfCToC = new MaxStopQuery(3).getPaths(townMap, new Town("C"), new Town("C")).size();
        Travels.println(numOfCToC);

        System.out.println("case 7: A C");
        long numOfAToC = new MaxStopQuery(4).getPaths(townMap, new Town("A"), new Town("C")).stream().filter(item -> item.size() ==4).count();
        Travels.println((int)numOfAToC);

        System.out.println("case 8: A C");
        OptionalInt minLengthOfAToC = new MaxDistanceQuery(99).getPaths(townMap,new Town("A"), new Town("C")).stream()
                .mapToInt(item -> item.stream().mapToInt(Route::getDistance).sum()).min();
        Travels.println(minLengthOfAToC.getAsInt());

        System.out.println("case 9: B B");
        OptionalInt minLengthOfBToB = new MaxDistanceQuery(99).getPaths(townMap,new Town("B"), new Town("B")).stream()
                .mapToInt(item -> item.stream().mapToInt(Route::getDistance).sum()).min();
        Travels.println(minLengthOfBToB.getAsInt());

        System.out.println("case 10:C C");
        int numOfCtoC = new MaxDistanceQuery(30).getPaths(townMap, new Town("C"), new Town("C")).size();
        Travels.println(numOfCtoC);

    }


}
