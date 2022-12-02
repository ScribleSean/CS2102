import java.util.LinkedList;

class MtBT implements IBinTree
{
    MtBT()
    {
    }
    // returns false since empty tree has no elements
    public boolean hasElt(int e)
    {
        return false;
    }
    // returns 0 since empty tree has no elements
    public int size() {
        return 0;
    }
    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }
    //Returns true because it is a empty binary tree
    public boolean isEmpty()
    {
        return true;
    }

    //Returns true since a heap can be a empty binary tree
    public boolean isHeap()
    {
        return true;
    }

    //Returns true since it is an empty list
    public boolean isRootSmallest(int root)
    {
        return true;
    }

    public LinkedList<Integer> makeList()
    {
        return new LinkedList<>();
    }
}