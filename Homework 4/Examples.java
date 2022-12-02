import org.junit.Test;
import static org.junit.Assert.*;

public class Examples
{
    //Heap Checker:
    HeapChecker HT = new HeapChecker();
    // IHeaps:
    IHeap heap1 = new DataHeap(2, new DataHeap(3, new MtHeap(), new MtHeap()), new DataHeap(4, new MtHeap(), new MtHeap()));
    IHeap heap2 = new DataHeap(2, new DataHeap(3, new DataHeap(5, new MtHeap(), new MtHeap()), new DataHeap(6, new MtHeap(), new MtHeap())), new DataHeap(4, new DataHeap(7, new MtHeap(), new MtHeap()), new DataHeap(8, new MtHeap(), new MtHeap())));
    // IBinTrees:
    IBinTree binTree1 = new DataHeap(2, new DataHeap(3, new MtHeap(), new MtHeap()), new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()));
    IBinTree binTree2 = new DataHeap(3, new DataHeap(5, new DataHeap(6, new MtHeap(), new MtHeap()), new MtHeap()), new DataHeap(4, new DataHeap(7, new MtHeap(), new MtHeap()), new DataHeap(8, new MtHeap(), new MtHeap())));

    // Specific Trees:
    // A basic heap.
    IHeap myHeap = new DataHeap(2, new DataHeap(3,
            new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());

    // A non-heap, with a higher root than its nodes.
    IHeap notAHeap = new DataHeap(9,
            new DataHeap(2,
                    new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()),
                            new MtHeap()), new MtHeap()), new MtHeap());

    // A basic heap, to compare against myHeap with an element added.
    IHeap noAdded = new DataHeap(2, new DataHeap(3,
            new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());

    // myHeap, missing one element (three).
    IBinTree threeGone = new DataHeap(2,
            new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap());

    // myHeap with an element added.
    IBinTree extraneousStuff = new DataHeap(2, new DataHeap(3,
            new DataHeap(4, new DataHeap(7, new MtHeap(), new MtHeap()), new MtHeap()),
            new MtHeap()), new MtHeap());


    // A basic heap, just to use different numbers for the removers.
    IHeap removerMyHeap = new DataHeap(81, new DataHeap(110,
            new DataHeap(120, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());


    // A non-heap, with a higher root than its nodes.
    IHeap removerNotAHeap = new DataHeap(965, new DataHeap(110,
            new DataHeap(120, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());

    // A basic heap, to compare against myHeap with an element added.
    IHeap removerNoTaken = new DataHeap(81, new DataHeap(110,
            new DataHeap(120, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());


    // myHeap, with one element added (155).

    IBinTree removerStuffAdded = new DataHeap(81, new DataHeap(110,
            new DataHeap(120, new DataHeap(155, new MtHeap(), new MtHeap()),
                    new MtHeap()), new MtHeap()), new MtHeap());


    // myHeap with an element added.

    IBinTree removerExtraStuff = new DataHeap(81, new DataHeap(110,
            new DataHeap(120, new DataHeap(944, new MtHeap(), new MtHeap()),
                    new MtHeap()), new MtHeap()), new MtHeap());

    @Test
    public void addEltValidatorCheck1()
    {
        assertTrue(HT.addEltValidator(heap1, 5, binTree1));
    }
    @Test
    public void remMinEltValidatorCheck1()
    {
        assertTrue(HT.remMinEltValidator(heap2, binTree2));
    }


    // confirms the function works with a proper heap.
    @Test
    public void heapThatWorks()
    {
        assertTrue(HT.addEltValidator(myHeap, 5, myHeap.addElt(5)));
    }

    // confirms the program fails when given a non-heap.
    @Test
    public void heapRootTooBig()
    {
        assertFalse(HT.addEltValidator(myHeap, 5, notAHeap));
    }

    // confirms the program fails when trying to compare a heap with an added element to the heap's original form.
    @Test
    public void addNotThere()
    {
        assertFalse(HT.addEltValidator(myHeap, 5, noAdded));
    }

    // confirms the program fails when a heap is compared to a heap with one of the first heap's elements missing.
    @Test
    public void elementMissing()
    {
        assertFalse(HT.addEltValidator(myHeap, 5, threeGone));
    }

    // confirms the program fails when a heap is compared to a heap with an extra element added.
    @Test
    public void extraElement()
    {
        assertFalse(HT.addEltValidator(myHeap, 1, extraneousStuff));
    }

    // confirms the function works with a proper heap.
    @Test
    public void removerHeapThatWorks()
    {
        assertTrue(HT.remMinEltValidator(removerMyHeap,  removerMyHeap.remMinElt()));
    }

    // confirms the program fails when given a non-heap.
    @Test
    public void removerHeapRootTooBig()
    {
        assertFalse(HT.remMinEltValidator(removerMyHeap, removerNotAHeap));
    }

    // confirms the program fails when given a non-heap.
    @Test
    public void removerNotThere()
    {
        assertFalse(HT.remMinEltValidator(removerMyHeap, removerNoTaken));
    }

    // confirms the program fails when a heap is compared to a heap with one of the first heap's elements added.
    @Test
    public void removerElementMissing()
    {
        assertFalse(HT.remMinEltValidator(removerMyHeap,  removerStuffAdded));
    }

    // confirms the program fails when a heap is compared to a heap with an extra element added.
    @Test
    public void removerExtraElement()
    {
        assertFalse(HT.remMinEltValidator(myHeap,  removerExtraStuff));
    }
}