import org.junit.Test;
import static org.junit.Assert.*;
public class Examples
{
    @Test
    public void Test()
    {
        assertEquals(1, 1);
    }
    
    VotingData ElectionCycle1() {
        VotingData VD = new VotingData();
        try {
            VD.nominateCandidate("gompei");
            VD.nominateCandidate("husky");
            VD.nominateCandidate("ziggy");

        } catch (Exception e) {
        }
        try {
            VD.submitVote("gompei", "husky", "ziggy");
            VD.submitVote("gompei", "ziggy", "husky");
            VD.submitVote("husky", "gompei", "ziggy");
        } catch (Exception e) {
        }
        return (VD);
    }
    @Test
    public void testMostFirstWinner() {
        assertEquals("gompei", this.ElectionCycle1().pickWinnerMostFirstChoice());
    }
    
    VotingData ElectionCycle2()
    {
        VotingData VD = new VotingData();
        try {
            VD.nominateCandidate("sean");
            VD.nominateCandidate("nicole");
            VD.nominateCandidate("brian");
            VD.nominateCandidate("abbey");
            VD.nominateCandidate("jimmy");
        } catch (Exception e) {
        }
        try {
            VD.submitVote("sean", "nicole", "jimmy");
            VD.submitVote("jimmy", "nicole", "abbey");
            VD.submitVote("jimmy", "nicole", "brian");
            VD.submitVote("jimmy", "nicole", "sean");
        } catch (Exception e) {
        }
        return VD;
    }
    @Test
    public void testPickWinnerMostFirstChoice()
    {
        assertEquals("jimmy", this.ElectionCycle2().pickWinnerMostFirstChoice());
    }
    @Test
    public void testPickWinnerMostAgreeable()
    {
        assertEquals("nicole", this.ElectionCycle2().pickWinnerMostAgreeable());
    }

    VotingData ElectionCycle3()
    {
        VotingData VD = new VotingData();
        try {
            VD.nominateCandidate("sean");
            VD.nominateCandidate("nicole");
            VD.nominateCandidate("brian");
            VD.nominateCandidate("abbey");
            VD.nominateCandidate("jimmy");
        } catch (Exception e) {
        }
        try {
            VD.submitVote("jimmy", "nicole", "abbey");
            VD.submitVote("jimmy", "nicole", "abbey");
            VD.submitVote("jimmy", "nicole", "brian");
            VD.submitVote("jimmy", "nicole", "sean");
        } catch (Exception e) {
        }
        return VD;
    }

    VotingData ElectionCycle4()
    {
        VotingData VD = new VotingData();
        try {
            VD.nominateCandidate("sean");
            VD.nominateCandidate("nicole");
            VD.nominateCandidate("brian");
            VD.nominateCandidate("abbey");
            VD.nominateCandidate("jimmy");
        } catch (Exception e) {
        }
        try {
            VD.submitVote("sean", "abbey", "jimmy");
            VD.submitVote("sean", "jimmy", "abbey");
            VD.submitVote("jimmy", "sean", "brian");
            VD.submitVote("jimmy", "brian", "sean");
        } catch (Exception e) {
        }
        return VD;
    }

    //When runoff required
    @Test
    public void testMostFirstChoice2()
    {
        assertEquals("*Requires Runoff Poll*", this.ElectionCycle4().pickWinnerMostFirstChoice());
    }

    //When tied
    @Test
    public void testMostAgreeable2()
    {
        assertTrue(this.ElectionCycle4().pickWinnerMostAgreeable().equals("jimmy") || this.ElectionCycle4().pickWinnerMostAgreeable().equals("sean"));
    }

    VotingData ElectionCycle5()
    {
        VotingData VD = new VotingData();
        try {
            VD.nominateCandidate("sean");
            VD.nominateCandidate("nicole");
            VD.nominateCandidate("brian");
            VD.nominateCandidate("abbey");
            VD.nominateCandidate("jimmy");
            VD.nominateCandidate("via");
        } catch (Exception e) {
        }
        try {
            VD.submitVote("jimmy", "abbey", "sean");
            VD.submitVote("sean", "jimmy", "brian");
            VD.submitVote("brian", "sean", "jimmy");
            VD.submitVote("nicole", "sean", "jimmy");
            VD.submitVote("abbey", "nicole", "via");
        } catch (Exception e) {
        }
        return VD;
    }

    @Test
    public void testPickWinnerMostFirstChoice3 ()
    {
        assertEquals("jimmy", this.ElectionCycle3().pickWinnerMostFirstChoice());
    }

    //Third Place Tie
    @Test
    public void testPickWinnerMostAgreeable1()
    {
        assertTrue(this.ElectionCycle5().pickWinnerMostAgreeable().equals("jimmy") || this.ElectionCycle4().pickWinnerMostAgreeable().equals("sean"));
    }

    //runoff cause repeat
    @Test
    public void testPickWinnerMostAgreeable2()
    {
        assertEquals("*Requires Runoff Poll*", this.ElectionCycle5().pickWinnerMostFirstChoice());
    }

    
    
    @Test(expected=RedundantCandidateException.class)
    public void testForMethod() throws RedundantCandidateException
    {
        VotingData VD = new VotingData();
        try {
            VD.nominateCandidate("sean");
            VD.nominateCandidate("nicole");
            VD.nominateCandidate("brian");
            VD.nominateCandidate("abbey");
            VD.nominateCandidate("jimmy");
        } catch (Exception e) {
        }
        try {
            VD.submitVote("sean", "nicole", "jimmy");
            VD.submitVote("jimmy", "nicole", "abbey");
            VD.submitVote("jimmy", "nicole", "brian");
            VD.submitVote("jimmy", "nicole", "sean");
        } catch (Exception e) {
        }
        VD.nominateCandidate("sean");
    }
    
    @Test(expected=RedundantCandidateException.class)
    public void testForRedundantCandidateException() throws RedundantCandidateException
    {
        ElectionCycle2().nominateCandidate("sean");
    }
    @Test(expected=RedundantCandidateException.class)
    public void testForRedundantCandidateException2() throws RedundantCandidateException
    {
        ElectionCycle2().nominateCandidate("jimmy");
    }
    @Test(expected=RedundantCandidateException.class)
    public void testForRedundantCandidateException3() throws RedundantCandidateException
    {
        ElectionCycle1().nominateCandidate("gompei");
    }

    //1 and 2 same
    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void testSubmit1() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("sean", "sean", "nicole");
    }

    //2 and 3 same
    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void testSubmit2() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("sean", "nicole", "nicole");
    }

    //1 and 3 same
    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void testSubmit3() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("sean", "nicole", "sean");
    }

    @Test(expected=CandidateNotFoundException.class)
    public void testSubmit4() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("shank", "sean", "jimmy");
    }
    @Test(expected=CandidateNotFoundException.class)
    public void testSubmit5() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("sean", "shank", "jimmy");
    }
    @Test(expected=CandidateNotFoundException.class)
    public void testSubmit6() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("jimmy", "sean", "shank");
    }
    @Test(expected=CandidateNotFoundException.class)
    public void testSubmit7() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("shank", "kaush", "jimmy");
    }
    @Test(expected=CandidateNotFoundException.class)
    public void testSubmit8() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException
    {
        ElectionCycle2().submitVote("shank", "kaush", "ash");
    }
}
