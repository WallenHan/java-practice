package practice.enumPractice.enumWithCellection;

import java.util.*;
import java.util.stream.Stream;

public class Plant {

    enum  LifeCycle { ANNUAL , PERENNIAL, BIENNIAL }


    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return this.name;
    }


    // 对一组植物按生长周期归类
    public static void sort(String[] args) {
        Map<Plant.LifeCycle, Set<Plant>> plantsGroupByLifeCycle = new EnumMap<>(LifeCycle.class);
        // 根据现有类型分组
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsGroupByLifeCycle.put(lc, new HashSet<Plant>());
        }
        Set<Plant> garden = new HashSet<>();
        // 将花园里的植物分类
        for (Plant p : garden) {
            plantsGroupByLifeCycle.get(p.lifeCycle).add(p);
        }

    }

    // 采用流的方式处理
    public static void sortUseStream(String[] args) {
        Set<Plant> garden = new HashSet<>();


    }

}
