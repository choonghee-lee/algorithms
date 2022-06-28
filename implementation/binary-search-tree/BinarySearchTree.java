public class BinarySearchTree {
    Node root;

    public BinarySearchTree insert(int value)
    {
        Node newNode = new Node(value);
        if(this.root == null)
        {
            this.root = newNode;
            return this;
        }
        else
        {
            Node current = this.root;
            while(true)
            {
                if(value < current.getValue())
                {
                    if(current.getLeft() == null)
                    {
                        current.setLeft(current);
                        return this;
                    }
                    else
                    {
                        current = current.getLeft();
                    }
                }
                else if(value > current.getValue())
                {
                    if(current.getRight() == null)
                    {
                        current.setRight(current);
                        return this;
                    }
                    else
                    {
                        current = current.getRight();
                    }
                }
                else
                {
                    return this;
                }
            }
        }
    }

    public Node find(int value) {
        if(this.root == null) return null;

        Node current = this.root;
        boolean found = false;

        while(current != null && !found) {
            if(value < current.getValue())
            {
                current = current.getLeft();
            }
            else if(value > current.getValue())
            {
                current = current.getRight();
            }
            else
            {
                found = true;
            }
        }
        return current;
    }
}
