package practice.thoughtWorks.trainProblem.util;

import practice.thoughtWorks.trainProblem.entity.Route;
import practice.thoughtWorks.trainProblem.entity.Town;
import practice.thoughtWorks.trainProblem.enums.ResultInfo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 一个工具类
 */
public final class Travels {
    /**
     * 从文件中读取城镇路径图字符
     * @param fileName
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static String readTownMapFromFile(String fileName) throws IOException, FileNotFoundException {
        BufferedReader dataFile = new BufferedReader(new FileReader(fileName));
        String line, data;
        data = "";
        while ((line = dataFile.readLine()) != null) {
            data += line;
        }
        return data;
    }

    /**
     * 将城镇网字符串解析为 一个包含自己路径的Map
     * @param townMapString 城镇图字符
     * @return
     */
    public static Map<Town, List<Route>> parseTownMap(String townMapString){
        String[] routesString = townMapString.split(",");
        List<Route> routes = Arrays.stream(routesString).map(item ->
                new Route(
                        new Town(item.trim().substring(0,1)),
                        new Town(item.trim().substring(1, 2)),
                        Integer.parseInt(item.trim().substring(2), 10))
        ).collect(Collectors.toList());
        Map<Town, List<Route>> townMap = new HashMap<>();
        for (Route route : routes) {
            List<Route> routeList = new ArrayList<>();
            if (townMap.get(route.getStartTown()) != null){
                routeList.addAll(townMap.get(route.getStartTown()));
            }
            routeList.add(route);
            townMap.put(route.getStartTown(), routeList);
        }
        return townMap;
    }

    /**
     * 将 字符路径 根据已经存在的城镇网图解析为 RouteList
     * @param pathString 路径字符
     * @param townMap 已经建立的 城镇图
     * @return
     */
    public static List<Route> parsePath(String pathString, Map<Town, List<Route>> townMap) {
        String[] path = pathString.split("-");
        List<Route> pathList = new LinkedList<>();
        for (int i= 0; i < path.length -1 ; i++){
            Town  startTown  = new Town(path[i]);
            Town  endTown  = new Town(path[i+1]);
            try {
                Route route = townMap.get(startTown).stream().filter(item -> item.getEndTown().equals(endTown))
                        .collect(Collectors.toList())
                        .get(0);
                pathList.add(route);
            } catch (Exception e) {
                pathList.add(new Route(startTown, endTown, -1));
//                e.printStackTrace();
            }
        }

        return pathList;
    }

    /**
     * 计算 routeList 的距离之和
     * @param routeList
     * @return
     */
    public static Integer calcDistance (List<Route> routeList) {
        Integer distance = 0;
        for (Route route : routeList){
            if (route.getDistance() == -1){
                return - 1 ;  //包含距离为零的 即为不存在 的路径 直接返回总距离 为 -1
            }
        }
        distance = routeList.stream().mapToInt(Route::getDistance).sum();
        return distance;
    }

    /**
     * 根据跳数来搜寻路径
     * @param townMap
     * @param start
     * @param end
     * @param path
     * @param currStops
     * @param minStops
     * @param maxStops
     * @param result
     */
    public  static void  searchPathByStop(Map<Town, List<Route>> townMap, Town start, Town end, List<Route> path,
                                   int currStops, int minStops, int maxStops , List<List<Route>> result ) {

        if (currStops > maxStops) {
            return ;
        }
        if (start.equals(end) && currStops >= minStops)  {
            result.add(new ArrayList<Route>(path));
        }
        if (townMap.get(start) == null){
            return;
        }
        Iterator<Route>  routeIterator = townMap.get(start).listIterator();
        while (routeIterator.hasNext()){
            Route route = routeIterator.next();
            Town next  =  route.getEndTown();
            path.add(route);
            searchPathByStop(townMap, next, end, path, (currStops + 1), minStops, maxStops, result);
            path.remove(path.size() - 1);
        }

    }

    /**
     *  根据距离来搜寻路径
     * @param townMap
     * @param start
     * @param end
     * @param path
     * @param currDis
     * @param minDis
     * @param maxDis
     * @param result
     */
    public static void searchPathByDistance(Map<Town, List<Route>> townMap, Town start, Town end, List<Route> path,
                                      int currDis, int minDis, int maxDis , List<List<Route>> result) {
        if (currDis >= maxDis) {
            return;
        }
        if (start.equals(end) && currDis >= minDis) {
            result.add(new ArrayList<Route>(path));
        }
        if (townMap.get(start) == null){
            return;
        }
        Iterator<Route>  routeIterator = townMap.get(start).listIterator();
        while (routeIterator.hasNext()){
            Route route = routeIterator.next();
            Town next  =  route.getEndTown();
            path.add(route);
            searchPathByDistance(townMap, next, end, path,currDis + route.getDistance(), minDis, maxDis, result);
            path.remove(path.size() - 1);
        }
    }

     public static  void println(int nums){
        System.out.println( nums <= 0   ? ResultInfo.FAILURE :  nums);
    }
}
