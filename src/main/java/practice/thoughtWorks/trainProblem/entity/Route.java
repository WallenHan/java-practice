package practice.thoughtWorks.trainProblem.entity;

import java.util.Objects;

/**
 *一段相连的两个 town 的关系实体
 * @startTown 直接出发站
 * @endTown 直接到达站
 * @distance 两站间距离
 */
public class Route {

    private final Town startTown;
    private final Town endTown;
    private final Integer distance;

    public Route(Town startTown, Town endTown, Integer distance) {

        this.startTown = startTown;
        this.endTown = endTown;
        this.distance = distance;
    }

    public Town getStartTown() {
        return startTown;
    }

    public Town getEndTown() {
        return endTown;
    }

    public Integer getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(startTown, route.startTown) &&
                Objects.equals(endTown, route.endTown) &&
                Objects.equals(distance, route.distance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startTown, endTown, distance);
    }

    @Override
    public String toString() {
        return "Route{" +
                "startTown=" + startTown +
                ", endTown=" + endTown +
                ", distance=" + distance +
                '}';
    }
}
