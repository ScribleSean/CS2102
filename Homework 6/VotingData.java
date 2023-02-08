import java.util.LinkedList;
import java.util.HashMap;
public class VotingData
{
    private LinkedList<String> ballot = new LinkedList<String>();
    private HashMap<String, Integer> firstPlaceVotes = new HashMap<String, Integer>(); // first place
    private HashMap<String, Integer> secondPlaceVotes = new HashMap<String, Integer>(); // second place
    private HashMap<String, Integer> thirdPlaceVotes = new HashMap<String, Integer>(); // third place


    public VotingData() {}

    /*
     * This method exists to print a list of candidates.
     *  @This function has no parameters.
     *  @return   void    	Prints out a list of candidates.
     */
    public void printBallot()
    {
        System.out.println("The candidates are ");
        for (String s : ballot) {
            System.out.print(s+", ");
        }
    }

    /*
     * This method exists to
     *  @param    candidate		A given candidate.
     *  @throws   RedundantCandidateException	Thrown when a candidate is already on the ballot.
     *  @return   void    		Nominates a given candidate.
     */
    public void nominateCandidate(String candidate) throws RedundantCandidateException
    {
        if (ballot.contains(candidate))
        {
            throw new RedundantCandidateException(candidate);
        }
        else
        {
            ballot.add(candidate);
            firstPlaceVotes.put(candidate, 0);
            secondPlaceVotes.put(candidate, 0);
            thirdPlaceVotes.put(candidate, 0);
        }
    }


    /*
     * This method exists to
     *  @param    first		The user’s first choice of candidate.
     *  @param    second		The user’s second choice of candidate.
     *  @param    third		The user’s third choice of candidate.
     *  @throws   CandidateNotFoundException Thrown when a candidate is not present on the ballot.
     *  @throws   CandidateChosenMoreThanOnceException Thrown when a candidate is chosen more than one time.
     *  @return   void    	Uploads a user’s ballot to the hashmap.
     */
    public void submitVote(String first, String second, String third) throws CandidateNotFoundException, CandidateChosenMoreThanOnceException
    {
        if(ballot.contains(first)&& ballot.contains(second)&& ballot.contains(third)
                &&!(first.equals(second))&& !(second.equals(third))&& !(first.equals(third)))
        {
            for(String key : firstPlaceVotes.keySet())
            {
                if(key.equals(first))
                {
                    firstPlaceVotes.put(key, firstPlaceVotes.get(key) + 1 );
                }
            }
            for(String key : secondPlaceVotes.keySet())
            {
                if(key.equals(second))
                {
                    secondPlaceVotes.put(key, secondPlaceVotes.get(key) + 1 );
                }
            }
            for(String key : thirdPlaceVotes.keySet())
            {
                if(key.equals(third))
                {
                    thirdPlaceVotes.put(key, thirdPlaceVotes.get(key) + 1 );
                }
            }
        }
        else if(!(ballot.contains(first)))
            throw new CandidateNotFoundException(first);

        else if(!(ballot.contains(second)))
            throw new CandidateNotFoundException(second);

        else if(!(ballot.contains(third)))
            throw new CandidateNotFoundException(third);

        else if(first.equals(second))
            throw new CandidateChosenMoreThanOnceException(first);

         else if(second.equals(third))
            throw new CandidateChosenMoreThanOnceException(second);

        else
             throw new CandidateChosenMoreThanOnceException(third);
    }

    /*
     * This method exists to pick the winner by who was given as a first choice more than 50% of all the first choice votes.
     *  This function has no parameters.
     *  @return   String    		Returns the winner’s name.
     */
    public String pickWinnerMostFirstChoice()
    {
        double percentage=0;
        double totalSum=0;
        for (String candidate : ballot)
        {
            totalSum += firstPlaceVotes.get(candidate);
        }

        for(String candidate : ballot)
        {
            percentage = firstPlaceVotes.get(candidate) / totalSum;

            if(percentage > (0.5))
            {
                return candidate;
            }

        }
        return "*Requires Runoff Poll*";
    }

    /*
     * This method exists to produce  the highest number of votes of the three choices
     *  @param    candidate		A given candidate
     *  @return   int    		Returns the highest number of votes per choice received by the given candidate.
     */
    public int highestVote(String candidate)
    {
        return Math.max(firstPlaceVotes.get(candidate),Math.max((secondPlaceVotes.get(candidate)),(thirdPlaceVotes.get(candidate))));
    }


    /*
     * This method exists to pick the candidate based on who has the most votes (found by picking the largest number out of first=place, second-place, and third-place votes.)
     *  This function has no parameters.
     *  @return   String    		Returns the winner’s name.
     */
    public String pickWinnerMostAgreeable()
    {
        String winner=ballot.getFirst();
        int i=highestVote(winner);
        for(String candidate: ballot)
        {
            if(highestVote(candidate)>i)
            {
                i=highestVote(candidate);
                winner=candidate;
            }
        }
        return winner;
    }

    /*
    int i = -1;
        int j = 0;
        String winner = ballot.getFirst();
        for(String candidate : ballot)
        {
            j = (firstPlaceVotes.get(candidate) * 3) + (secondPlaceVotes.get(candidate) * 2) + (thirdPlaceVotes.get(candidate));

            if(j > i)
            {
                i=j;
                winner = candidate;
            }
        }
     */
}
