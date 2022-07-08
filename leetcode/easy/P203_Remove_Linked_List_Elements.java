class P203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode node, int val) {
        if (node == null) return null;
        node.next = removeElements(node.next, val);
        return node.val == val ? node.next : node;
    }
}