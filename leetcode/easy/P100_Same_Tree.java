class P100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty())
        {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if( (node1 != null && node2 == null) || (node1 == null && node2 != null) )
                return false;

            if(node1 == null && node2 == null)
                continue;

            if(node1.val != node2.val)
                return false;

            if( (node1.left != null && node2.left == null) || (node1.left == null && node2.left != null) )
                return false;

            if( (node1.right != null && node2.right == null) || (node1.right == null && node2.right != null) )
                return false;

            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }

        return true;
    }
}