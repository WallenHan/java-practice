package practice.thoughtWorks.trainProblem.query;

import practice.thoughtWorks.trainProblem.entity.Route;
import practice.thoughtWorks.trainProblem.entity.Town;
import practice.thoughtWorks.trainProblem.util.Travels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxStopQuery  implements Query {
    private Integer maxStop;

    public MaxStopQuery(Integer maxStop) {
        this.maxStop = maxStop;
    }

    public Integer getMaxStop() {
        return maxStop;
    }


    public List<List<Route>> getPaths(Map<Town, List<Route>> townMap, Town fromTown, Town toTown) {
        List<List<Route>> result = new ArrayList<>();
        List<Route> routeList = new ArrayList<>();
        Travels.searchPathByStop(townMap, fromTown, toTown, routeList, 0, 1, maxStop, result);
        return result;
    }
}
