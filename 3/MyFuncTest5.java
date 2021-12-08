// Listing 3-6: Interface implemented by basic lambda expression

public class MyFuncTest5 {

    public static void main(String[] args) {
        MyFunc mf = (int price, int rate) -> {
            return (int) (price * (1 + 0.01 * rate));
        };

        int p = 1000;
        int r = 8;
        System.out.printf("Test5 税抜:%d円, 税込:%d円\n", p, mf.addTax(p, r));
    }
}
