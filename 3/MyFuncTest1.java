// Listing 3-2: Interface implemented by another class

class MyFuncT implements MyFunc {

    @Override
    public int addTax(int price, int rate) {
        return (int) (price * (1 + 0.01 * rate));
    }
}

public class MyFuncTest1 {

    public static void main(String[] args) {
        int p = 1000;
        int r = 8;
        MyFunc mf = new MyFuncT();
        System.out.printf("Test1 税抜:%d円, 税込:%d円\n", p, mf.addTax(p, r));
    }
}
