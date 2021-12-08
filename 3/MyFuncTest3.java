// Listing 3-4: Interface implemented by inner class

public class MyFuncTest3 {

    public class MyFuncT implements MyFunc {

        @Override
        public int addTax(int price, int rate) {
            return (int) (price * (1 + 0.01 * rate));
        }
    }

    public static void main(String[] args) {
        int p = 1000;
        int r = 8;
        MyFuncTest3 mt3 = new MyFuncTest3();
        MyFunc mf = mt3.new MyFuncT();
        System.out.printf("Test3 税抜:%d円, 税込:%d円\n", p, mf.addTax(p, r));
    }
}
