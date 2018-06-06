package practice.thoughtWorks.trainProblem.query;

import practice.thoughtWorks.trainProblem.entity.Route;
import practice.thoughtWorks.trainProblem.entity.Town;

import java.util.List;
import java.util.Map;

public interface Query {
    public List<List<Route>> getPaths(Map<Town, List<Route>> townMap, Town fromTown, Town toTown);
}
