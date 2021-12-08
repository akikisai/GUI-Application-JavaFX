// Listing 2-1: Print ASCII code table

public class PrintASCII {

    public static void main(String[] args) {
        // ヘッダー出力
        System.out.print("   ");
        for (int j = 0; j < 16; j++) {
            System.out.printf(" .%X", j);
        }
        System.out.println(
                "\n    -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
        // 文字出力
        for (int i = 2; i < 8; i++) {
            System.out.print(i + ".|");
            for (int j = 0; j < 16; j++) {
                char c = (char) (i * 16 + j);
                System.out.print("  " + c);
            }
            System.out.println();
        }
    }
}
