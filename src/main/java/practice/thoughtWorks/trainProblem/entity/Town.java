package practice.thoughtWorks.trainProblem.entity;

/**
 *一个城镇实体 包含
 * @visited  是否访问过
 * @name 自己的名字
 */
public class Town {
    private final String  name;
    private Boolean visited;

    public String getName() {
        return name;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }


    public Town(String name) {
        this.name = name;
        this.visited = Boolean.FALSE;
    }
    public Town(String name, Boolean visited) {
        this.name = name;
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Town town = (Town) o;

        if (!name.equals(town.name)) return false;
        return visited.equals(town.visited);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + visited.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                ", visited=" + visited +
                '}';
    }
}
