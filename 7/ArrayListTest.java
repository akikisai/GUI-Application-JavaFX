// Listing 7-1: ArrayList test

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListTest {

    public static void main(String[] args) {
        // ArrayListの作成
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        System.out.println("ArrayList: " + list);

        // 配列->ArrayListの追加
        String[] array1 = { "Three", "Four", "Five" };
        list.addAll(Arrays.asList(array1));
        System.out.println("ArrayList: " + list);

        // ArrayList->配列
        String[] array2 = (String[]) list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array2));

        // 要素の取得、変更、挿入、削除
        System.out.println("get(3): " + list.get(3));
        list.set(3, "四");
        list.add(3, "よん");
        list.remove(1);
        System.out.println("ArrayList: " + list);

        // ループ
        System.out.print("for1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.print("for2: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // イテレータ
        Iterator<String> iterator = list.iterator();
        System.out.print("Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}
