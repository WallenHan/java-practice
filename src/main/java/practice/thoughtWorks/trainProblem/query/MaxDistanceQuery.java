package practice.thoughtWorks.trainProblem.query;

import practice.thoughtWorks.trainProblem.entity.Route;
import practice.thoughtWorks.trainProblem.entity.Town;
import practice.thoughtWorks.trainProblem.util.Travels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxDistanceQuery  implements  Query{
    private Integer maxDistance; // 最长距离；

    public MaxDistanceQuery(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public List<List<Route>> getPaths(Map<Town, List<Route>> townMap, Town fromTown, Town toTown) {

        List<List<Route>> result = new ArrayList<>();
        List<Route> routeList = new ArrayList<>();
        Travels.searchPathByDistance(townMap, fromTown, toTown, routeList, 0, 1, maxDistance, result);
        return result;
    }
}
