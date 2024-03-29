### 并查集结构
并查集是一种树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。有一个联合-查找算法（union-find algorithm）定义了两个用于此数据结构的操作：
- Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。
- Union：将两个子集合并成同一个集合。

首先并查集本身是一个结构，我们在构造它的时候需要将所有要操作的数据扔进去，初始时每个数据自成一个结点，且每个结点都有一个父指针（初始时指向自己）。

因此前提就是所有集合中的数据必须是一次性提前给定的，不能以流的方式动态的加入数据到集合中。

#### （一）功能作用
- 查询两个元素是否属于同一个集合：isSameSet(A,B)，本质上是判断元素 A 和元素 B 所属的集合是否为同一个集合。
- 两个元素各自所在的所有集合进行合并：union(A,B)；

#### （二）前提
所有集合中的数据必须是一次性提前给定的，不能以流的方式动态的加入数据到集合中。

#### （三）实现步骤
- 首先给定数据集合，这里以 int 类型为例 {1,2,3,4,5}

- 初始时并查集中的每个结点都算是一个子集，我们可以对任意两个元素进行合并操作。值得注意的是，union(nodeA,nodeB)并不是将结点nodeA和nodeB合并成一个集合，而是将nodeA所在的集合和nodeB所在的集合合并成一个新的子集；

- 元素所属集合：集合（一般为多叉树结构）中元素一直向上查找，一直找到一个结点的上一个结点指向自己，则该结点称为代表节点（并查集初始化时，每个结点都是各自集合的代表结点），同时该节点代表整个集合。

- find操作：查找两个结点是否所属同一个集合。我们只需判断两个结点所在集合的代表结点是否是同一个就可以了；

- 集合合并：合并两个集合就是将结点个数较少的那个集合的代表结点的父指针指向另一个集合的代表结点。

- 查找优化：查询到代表结点之后，将查询过程中经历的所有结点进行打平。

#### （四）岛问题进阶
如果矩阵非常大，并且可以使用多个 CPU 进行多任务并行计算，可以使用分治思想来切分开矩阵分别计算每个小矩阵中岛的数量，然后进行合并。（合并是难点）

矩阵分割成两部分，每个部分岛的数量进行单独计算然后进行合并，在单独计算时候，以左边为例，首先是从左上角第一个元素开始判断，第一个位置为 1 ，其他位置的 1 均由该位置感染，因此该位置称为感染中心，记为 A，由该位置感染的所有其它位置元素的感染中心均为 A，其它岛的感染中心类似。

在合并阶段：分开求得岛的数量为 4 个，合并只是针对边界上的部分进行去重。

以第一行边界两个元素为例，他们所对应的感染中心分别为 A，B，并且 A， B 不在一个集合中（默认四个感染中心属于各自集合），则首先将岛的数量减一，然后将 A，B 放入一个集合中。

第二行：对应的感染中心为 A，B，但是 A ，B 在一个集合中，所有总的岛的数量不减一；

第三行：没有边界不是两个一，无需考虑；

第四行：感染中心分别为 C，B，不在一个集合中，则岛的数量减一，然后将两个放入集合中，现在集合中有 A， B，C 。

第五行同样不需要判断。

最终结果：4 - 1 -1 = 2