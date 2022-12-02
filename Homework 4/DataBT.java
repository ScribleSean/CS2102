import java.util.LinkedList;

class DataBT implements IBinTree
{
    int data;
    IBinTree left;
    IBinTree right;
    DataBT(int data, IBinTree left, IBinTree right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    // an alternate constructor for when both subtrees are empty
    DataBT(int data)
    {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }
    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e)
    {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }
    // adds 1 to the number of nodes in the left and right subtrees
    public int size()
    {
        return 1 + this.left.size() + this.right.size();
    }
    // adds 1 to the height of the taller subtree
    public int height()
    {
        return 1 + Math.max(this.left.height(), this.right.height());
    }
    //Checks if given tree is empty or not
    public boolean isEmpty()
    {
        return false;
    }

    //Checks if given tree follows the rules of a heap
    public boolean isHeap()
    {

        return ((this.left.isHeap() && this.left.isRootSmallest(this.data))
                &&(this.right.isHeap() && this.right.isRootSmallest(this.data)));
    }

    //Determines if the root of the tree is the smallest element and continues this for subtrees
    public boolean isRootSmallest(int root)
    {
        return (this.data >= root);
    }

    //Makes a tree into a list
    public LinkedList<Integer> makeList()
    {

        LinkedList<Integer> result = new LinkedList<>();

        result.add(this.data);
        result.addAll(this.left.makeList());
        result.addAll(this.right.makeList());

        return result;
    }
}