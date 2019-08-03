package 删除链表操作;

public class NodeDelete {
    public static void main(String[] args) {
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(2);
        ListNode list3=new ListNode(2);
        ListNode list4=new ListNode(3);
        ListNode list5=new ListNode(3);
        ListNode list6=new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=list6;
        list6.next=null;
        //System.out.println(deleteNode(list1,list3).val);
        ListNode node=deleteDuplication(list1);
        while (node.next!=null){
            System.out.println(node.val);
            node=node.next;
        }
        System.out.println(node.val);


    }
    /**
     * 删除链表中的一个节点
     * */
    public static ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            if (head == tobeDelete)
                // 只有一个节点
                head = null;
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
    /**
     * 删除重复节点
     * */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                // next.val=next.next.val;
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
