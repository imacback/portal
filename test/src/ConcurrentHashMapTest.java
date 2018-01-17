import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        // ConcurrentHashMap hashEntry数组大小 = 初始容量 / 16（并发级别）的商，例：33/16 = 2 则hashEntry数组大小为 2的2次方: = 4;
        ConcurrentHashMap map = new ConcurrentHashMap(33);

        for (int i = 0; i < 16; i++) {
            map.put("a", "test");
        }
    }

    static class Persion{
        @Override
        public int hashCode() {
            return 1;
        }
    }
}
