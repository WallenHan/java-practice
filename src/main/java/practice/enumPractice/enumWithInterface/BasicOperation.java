package practice.enumPractice.enumWithInterface;


/*
    基于接口的 enum 便于扩展 不影响原有的代码设计
 */
public enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply (double x, double y){ return x + y; }
    },

    MINUS("-") {
        public double apply (double x, double y) { return  x + y;}
    },

    TIMES("*") {
        public  double apply (double x, double y) { return x * y;}
    },
    DIVIDE("/") {
        public double apply (double x, double y) { return x / y;}
    };

    private  final  String symbol;

    BasicOperation(String symbol){ this.symbol = symbol;}

    @Override
    public String toString() {
        return "BasicOperation{ " + "symbol='" + symbol + "\' }";

    }
}
