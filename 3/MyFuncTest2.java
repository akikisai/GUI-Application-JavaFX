// Listing 3-3: Interface implemented by myself

public class MyFuncTest2 implements MyFunc {

    @Override
    public int addTax(int price, int rate) {
        return (int) (price * (1 + 0.01 * rate));
    }

    public static void main(String[] args) {
        int p = 1000;
        int r = 8;
        MyFunc mf = new MyFuncTest2();
        System.out.printf("Test2 税抜:%d円, 税込:%d円\n", p, mf.addTax(p, r));
    }
}
