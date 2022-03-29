package 基础提升.class01;

import java.util.HashMap;

/**
 * Desc:
 * 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个 key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。
 * getRandom()：等概率随机返回结构中的任何一个key。
 * 因为如果使用一个哈希表则绝对不能保证getRandom()方法中的严格等概率，
 * 因为输入值经过哈希函数之后的输出值仅仅是大致等概率均匀分布（均匀性只是在大样本情况下的近似均匀），
 * 因此需要使用两个哈希表。
 * @author zzs
 * @date 2022/3/29 11:06
 */
public class Code01_RandomPool {

    public static class Pool<K> {

        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size++, key);
            }
        }

        // 删除的时候如果是中间的，不要删除以免出现空缺，将最后一个移动到删除的地方覆盖，然后修改长度就可以
        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return indexKeyMap.get(randomIndex);
        }
    }
}
