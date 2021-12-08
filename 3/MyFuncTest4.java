// Listing 3-5: Interface implemented by annonymous class

public class MyFuncTest4 {

    public static void main(String[] args) {
        MyFunc mf = new MyFunc() {
            @Override
            public int addTax(int price, int rate) {
                return (int) (price * (1 + 0.01 * rate));
            }
        };

        int p = 1000;
        int r = 8;
        System.out.printf("Test4 税抜:%d円, 税込:%d円\n", p, mf.addTax(p, r));
    }
}
