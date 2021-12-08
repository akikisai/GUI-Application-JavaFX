// Listing 3-7: Interface implemented by simple lambda expression

public class MyFuncTest6 {

    public static void main(String[] args) {
        MyFunc mf = (price, rate) -> (int) (price * (1 + 0.01 * rate));

        int p = 1000;
        int r = 8;
        System.out.printf("Test6 税抜:%d円, 税込:%d円\n", p, mf.addTax(p, r));
    }
}
