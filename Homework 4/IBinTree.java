import java.lang.Math;
import java.util.LinkedList;
public interface IBinTree
{
    // determines whether element is in the tree
    boolean hasElt(int e);
    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();
    // returns depth of longest branch in the tree
    int height();

    //Returns whether a tree is empty or not
    public boolean isEmpty();

    //Returns whether a tree is a heap
    public boolean isHeap();

    //Determines if the root of the tree is the smallest element
    //by checking if the child's are bigger than the root
    public boolean isRootSmallest(int root);
    //Creates a list from the tree
    public LinkedList<Integer> makeList();
}
