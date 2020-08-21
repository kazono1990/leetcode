package jp.co.kazono.leetcode.LC0002_AddTwoNumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 結果格納用のListNodeを作成
        ListNode result = new ListNode(0);
        // 最終的にresult.nextとして結果を返したいので、currにresultを入れて位置をずらせるようにする
        ListNode p = l1, q = l2, curr = result;
        int carry = 0;

        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;

            // 値が10以上の場合、桁が繰り上がるのでその計算を実施
            carry = sum / 10;

            // 現在カーソルが合っているListNodeの次のNodeを作成
            curr.next = new ListNode(sum % 10);
            // カーソルを一つ後ろにずらす
            curr = curr.next;

            // pとqがnull出なければ1つずつ後ろにずらす
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        printListNode(s.addTwoNumbers(l1, l2));
    }
}
