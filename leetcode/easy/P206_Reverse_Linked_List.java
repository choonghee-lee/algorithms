class P206_Reverse_Linked_List {
    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newNode = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }
}