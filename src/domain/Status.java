package domain;

/**
 * Author:  andy.xwt
 * Date:    2020/11/14 15:29
 * Description:
 */


public class Status implements Comparable<Status> {

    public int val;
    public ListNode ptr;

    public Status(int val, ListNode ptr) {
        this.val = val;
        this.ptr = ptr;
    }

    @Override
    public int compareTo(Status o) {
        return this.val - o.val;
    }
}
