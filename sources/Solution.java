class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[1];
        lists[0] = new ListNode(1);

        ListNode resNode = solution.mergeKLists(lists);
        while (resNode != null) {
            System.out.print(resNode.val);
            resNode = resNode.next;
            if (resNode != null)
                System.out.print("->");
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resNode = new ListNode(Integer.MAX_VALUE);
        ListNode tempNode = new ListNode(Integer.MAX_VALUE);

        int minIndex = 0;
        boolean hasNode = false;

        // ini
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < resNode.val) {
                resNode = new ListNode(lists[i].val);
                minIndex = i;
                hasNode = true;
            }
        }
        if (hasNode) {
            lists[minIndex] = lists[minIndex].next;
            for (ListNode list : lists) {
                if (list != null) {
                    resNode.next = tempNode;
                    break;
                }
            }
        }else{
            return null;
        }


        while (true) {
            hasNode = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < tempNode.val) {
                        tempNode.val = lists[i].val;
                        minIndex = i;
                        hasNode = true;
                    }
                }
            }
            boolean hasNextNode = false;

            if (hasNode) {
                lists[minIndex] = lists[minIndex].next;
                for (ListNode list : lists) {
                    if (list != null) {
                        hasNextNode = true;
                        break;
                    }
                }
            }
            if (hasNextNode) {
                tempNode.next = new ListNode(Integer.MAX_VALUE);
                tempNode = tempNode.next;
            } else {
                break;
            }
        }

        return resNode;
    }
}