// Listing 3-8: java.util.function and lambda expression

import java.util.function.IntBinaryOperator;

public class LambdaTest1 {

    public static void main(String[] args) {
        IntBinaryOperator mf = (price, rate) -> (int) (price * (1 + 0.01 * rate));

        int p = 1000;
        int r = 8;
        System.out.printf("Test6 税抜:%d円, 税込:%d円\n", p, mf.applyAsInt(p, r));
    }
}
