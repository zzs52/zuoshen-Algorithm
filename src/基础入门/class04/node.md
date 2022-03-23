### 1.排序算法稳定性
定义：即相同的值排序后还是按照原有的次序
#### 三个时间复杂度为O(N ^ 2)的排序：
冒泡算法：可以实现稳定性，大数字往后冒泡的时候遇到相等的数不交换

选择排序：做不到稳定性

插入排序：可以实现稳定性，理由同冒泡，遇到相等的数不交换即可
#### 三个时间复杂度为O(N * logN)的排序：
归并排序：可以实现稳定性，两边排好序merge时，遇到相等的数先拷贝左边的，再拷贝右边的

快速排序：做不到稳定性，partition（<，=，>）做不到稳定性（有论文方法可以，但会使空间复杂度变成O(N)）

堆排序：做不到稳定性
#### 排序问题补充
- 归并排序的额外空间复杂度可以做到O(1)，但不需要掌握(会让时间复杂度变为O(N ^ 2)，那还不如用插入排序)，可以搜"归并排序 内部缓存法"
- "原地归并排序"不可信，虽然会让空间复杂度做到O(1)，但时间复杂度就变成了O(N ^ 2)，那还不如用插入排序  
- 快排也可以做到稳定性，很难，不要掌握(会让空间复杂度变为O(N)，那还不如用归并排序)，可以搜"01 stable sort"
- 目前还没找到时间复杂度为O(N * logN)，空间复杂度为O(1)，且具有稳定性的排序  
- 一道题，奇数放数组左边，偶数放右边，还要求原始相对次序不变，这个问题有点坑
#### 工程排序算法
- 数组长度很长（数组长度大于60）：
    - 基础类型：快速排序，因为基础类型不用区分值
    - 自己定义的类：归并排序，自定义的class某关键字相同其他关键字可能不同
- 数组长度很短（数组长度小于60）：插入排序，因为插入排序常数项极低，小样本排序很快

O(N * logN)：利用了它的调度快

O(N * N)：利用了它的常数项极低
### 2.哈希表和有序表
#### 哈希表的简单介绍
- 哈希表在使用层面上可以理解为一种集合结构
- 如果只有key，没有伴随数据value，可以使用HashSet结构(C++中叫UnOrderedSet)
- 如果既有key，又有伴随数据value，可以使用HashMap结构(C++中叫UnOrderedMap)）有无伴随数据，是HashMap和HashSet唯一的区别，底层的实际结构是一回事
- 使用哈希表增(put)、删(remove)、改(put)和查(get)的操作，可以认为时间复杂度为O(1)，但是常数时间比较大
- 放入哈希表的东西，如果是基础类型，内部按值传递，内存占用就是这个key的大小
- 放入哈希表的东西，如果不是基础类型，内部按引用传递，内存占用是这个实例内存地址的大小(8字节)
#### 有序表的简单介绍
- 有序表在使用层面上可以理解为一种集合结构
- 如果只有key，没有伴随数据value，可以使用TreeSet结构(C++中叫OrderedSet)）
- 如果既有key，又有伴随数据value，可以使用TreeMap结构(C++中叫OrderedMap)）
- 有无伴随数据，是TreeSet和TreeMap唯一的区别，底层的实际结构是一回事
- 有序表和哈希表的区别是，有序表把key按照顺序组织起来，而哈希表完全不组织
- 红黑树、AVL树、size-balance-tree和跳表等都属于有序表结构，只是底层具体实现不同
- 放入有序表的东西，如果是基础类型，内部按值传递，内存占用就是这个key的大小
- 放入有序表的东西，如果不是基础类型，必须提供比较器，内部按引用传递，内存占用是这个实例内存地址的大小(8字节)
- 不管是什么底层具体实现，只要是有序表，都有以下固定的基本功能和固定的时间复杂度(O(logN))
```text
public static void main(String[] args) {
	TreeMap<Integer, String> treeMap = new TreeMap<>();
	// 1）void put(K key, V value): 将一个（key，value）记录加入到表中，或者根据key将记录更新成value。
	treeMap.put(2, "我是2");
	treeMap.put(5, "我是5");
	treeMap.put(1, "我是1");
	treeMap.put(4, "我是4");
	
	// 2）V get(K key): 根据给定的key，查询value并返回。
	System.out.println(treeMap.get(1)); // 我是1
	
	// 3）void remove(K key): 移除key的记录。
	treeMap.remove(1);
	System.out.println(treeMap.get(1)); // null
	
	// 4）boolean containsKey(K key): 判断是否有关于key的记录。
	System.out.println(treeMap.containsKey(2)); // true
	
	// 5）K firstKey(): 返回所有键值的排序结果中，最左（最小）的那个。
	System.out.println("最小：" + treeMap.firstKey()); // 2
	
	// 6）K lastKey(): 返回所有键值的排序结果中，最右（最大）的那个。
	System.out.println("最大：" + treeMap.lastKey()); // 5
	
	// 7）K floorKey(K key): 如果表中存入过key，返回key；否则返回所有键值的排序结果中，key的前一个。
	System.out.println(treeMap.floorKey(3)); // 在表中所有<=3的数中，离3最近的数：2
	System.out.println(treeMap.floorKey(4)); // 在表中所有<=4的数中，离4最近的数：4
	
	// 8）K ceilingKey(K key): 如果表中存入过key，返回key；否则返回所有键值的排序结果中，key的后一个。
	System.out.println("" + treeMap.ceilingKey(3)); // 在表中所有>=3的数中，离3最近的数：4
	System.out.println("" + treeMap.ceilingKey(4)); // 在表中所有>=4的数中，离4最近的数：4
}
```
### 3.链表
单链表节点结构：
```java
class Node<V> {
    
      V value;
      Node next;
  }
```
双向链表节点结构：
```java
class Node<V> {
    
    V value;
    Node last;
    Node next;
}
```
注意：链表的题在笔试和面试过程中，考虑的重点不同。链表问题的最优解往往都在额外空间复杂度上下功夫，时间复杂度一般都为O(N)

笔试中，考虑时间复杂度就行，空间复杂度无所谓

面试中，时间复杂度还是第一位，但也要考虑空间复杂度了
