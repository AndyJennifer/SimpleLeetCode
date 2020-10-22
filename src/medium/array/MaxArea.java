package medium.array;

/**
 * Author:  andy.xwt
 * Date:    2020/10/16 17:37
 * Description: 11-盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */


public class MaxArea {

    /**
     * 思路：
     * 考虑第一步：假设当前左指针和右指针指向的数分别为x和y,不失一般性，我们假设x<=y,同时两个指针之间的距离为t,那么，
     * 他们组成的容器的容量为
     *
     * min(x,y) * t = x *t
     *
     * 我们可以断定，如果我们保持左指针的位置不变，无论右指针在哪里，这个容器的容量都不会超过 x * t,注意这里右指针
     * 只能向左移动，因为我们考虑的第一步，也就是指针还指向数组的左右边界的时候，
     *
     * 我们任意向左移动右指针，指向的数为 y1, 两个指针之间的距离为 t1 ,那么显然有 t1<t,并且 min(x,y1)<= min(x,y)
     *     - 如果y1<y，那么 min(x,y1)<= min(x,y);
     *     - 如果y1>y ，那么 min(x,y1) = x = min(x,y)
     *
     * 因此有：
     *      min(x,y1)*t1 <min(x,y) *t
     *
     * 即无论我们怎么移动右指针，得到的容器都小于移动前容器的容量，也就是说，这个左指针对应的数不会作为容器的边界了，
     * 那么我们可以丢弃这个位置，将左指针向右移动一个位置，此时新的左指针与原先的右指针之间的左右位置，才可能作为容器
     * 的边界。
     *
     *
     * 时间复杂度O(n)
     * 空间复杂度O(1)常数个变量
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            //对应数字较小的指针，就可以丢弃掉了
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
