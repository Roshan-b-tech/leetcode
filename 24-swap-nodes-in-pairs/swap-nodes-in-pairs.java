class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    public static String serialize(ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;

            current = first;
        }

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String input = "[1,2,3,4]"; 
        ListNode head = ListNode.deserialize(input);
        ListNode swapped = solution.swapPairs(head);
        System.out.println(ListNode.serialize(swapped)); 
    }
}
