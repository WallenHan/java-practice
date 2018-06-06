package practice.thoughtWorks.trainProblem.enums;

/**
 *一个结果集的枚举方便使用提示信息；
 */
public enum ResultInfo {
    SUCCESS ("SUCCESS"),
    FAILURE ("NO SUCH ROUTE");

    private  final  String symbol;

    ResultInfo(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return  symbol ;
    }
}
