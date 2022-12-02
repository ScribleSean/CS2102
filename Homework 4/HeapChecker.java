import java.util.LinkedList;
public class HeapChecker
{
    // @param    hOrig   an original heap.
    // @param   elt     an element to be added to the heap.
    // @param   hAdded  the original heap with the elt added on.
    boolean addEltValidator(IHeap hOrig, int elt, IBinTree hAdded)
    {
        LinkedList<Integer> listOrig = hOrig.makeList();
        listOrig.add(elt);
        LinkedList<Integer> listAdded = hAdded.makeList();

        listOrig=sortInAscending(listOrig);
        listAdded=sortAndEdit(listAdded,listOrig,elt);

        return (hAdded.isHeap() && this.equals(listOrig,listAdded) && sizeAdd(hOrig, elt, hAdded));
    }
    // @param   hOrig   an original heap.
    // @param   hRemoved  the original heap with the smallest elt(root) taken out.
    boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved)
    {
        LinkedList<Integer> listOrig = hOrig.makeList();
        LinkedList<Integer> listRemoved = hRemoved.makeList();

        listOrig=sortInAscending(listOrig);
        listRemoved=sortAndEdit(listRemoved,listOrig,0);


        if (hOrig.isEmpty() && hRemoved.isEmpty())
        {
            return true;
        }
        else
        {
            return (hRemoved.isHeap() && this.equals(listOrig,listRemoved) && sizeRemove(hOrig, hRemoved));
        }
    }

    //Helper for size of trees when element is added
    public boolean sizeAdd(IHeap hOrig,int elt, IBinTree hAdded)
    {
        return hAdded.size() == (hOrig.size()+1);
    }

    //Helper for size of trees when element is removed
    public boolean sizeRemove(IHeap hOrig, IBinTree hRemoved)
    {
        return hRemoved.size() == hOrig.size()-1;
    }

    //Helper to sort a list of numbers using bubble sort
    public LinkedList<Integer> sortInAscending(LinkedList<Integer> listOrig)
    {
        for (int i = 0; i < listOrig.size(); i++)
        {

            for (int j = listOrig.size() - 1; j > i; j--)
            {
                if (listOrig.get(i) > listOrig.get(j))
                {

                    int tmp = listOrig.get(i);
                    listOrig.set(i,listOrig.get(j));
                    listOrig.set(j,tmp);

                }
            }
        }
        return listOrig;
    }

    // Helper to edit a list based on whether element was added or removed
    public LinkedList<Integer> sortAndEdit(LinkedList<Integer> aModifiedList,LinkedList<Integer> theOGList,int elt)
    {
        aModifiedList=sortInAscending(aModifiedList);
        if(aModifiedList.size()>theOGList.size())
        {
            return aModifiedList;
        }
        else if(aModifiedList.size()<theOGList.size())
        {
            int i =theOGList.get(0);
            aModifiedList.addFirst(i);
            return aModifiedList;
        }
        else
            return aModifiedList;
    }

    // equals function to check if two lists are equal after they are edited
    public boolean equals(LinkedList<Integer> a,LinkedList<Integer> b)
    {
        for(int i =0; i<a.size();i++)
        {
            int c = a.get(i);
            int d = b.get(i);
            if(a.size()==b.size() && c==d)
            {
            }
            else
                return false;
        }
        return true;
    }
}
