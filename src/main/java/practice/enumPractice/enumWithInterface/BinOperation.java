package practice.enumPractice.enumWithInterface;

public enum BinOperation implements Operation {
    LEFT_MOVE("<<") {
        @Override
        public double apply(double x, double y) {
             return (int)x << (int)y;
        }
    },
    RIGHT_MOVE(">>") {
        @Override
        public double apply(double x, double y) {
            return (int)x << (int)y;
        }
    };

    private final String symbol;

    BinOperation (String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "BinOperation { " +
                "symbol='" + symbol + "\' }" ;
    }
}
