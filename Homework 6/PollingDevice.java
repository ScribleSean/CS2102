import java.util.Scanner;
public class PollingDevice
{
    private Scanner keyboard = new Scanner(System.in);
    private VotingData VD = new VotingData();

    PollingDevice() {}

    /*
     * This method exists to prompt a user for their candidate choices and then add said candidate choices to the hashmap
     * keeping track of how many times they were voted for.
     *  This function has no parameters.
     *  @return   void    		Adds a user’s votes to the overall vote hashmap.
     */
    public void screen()
    {
        VD.printBallot();
        System.out.println("Enter your first choice of vote:");
        String firstCandidate = keyboard.next();
        System.out.println("Enter your second choice of vote:");
        String secondCandidate = keyboard.next();
        System.out.println("Enter your third choice of vote:");
        String thirdCandidate = keyboard.next();

        try {
            VD.submitVote(firstCandidate, secondCandidate, thirdCandidate);
            System.out.println("Vote submitted!");
            return;
        }
        catch (CandidateNotFoundException e){
            System.out.println("The entered candidate does not appear to be on the ballot. Would you like to add a candidate's name to the ballot? Enter y if yes.");
            String answer = keyboard.next();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.println("What name do you want to add in?");
                String writeInCand = keyboard.next();
                this.addWriteIn(writeInCand);
        }
    }
        catch (CandidateChosenMoreThanOnceException e) {
            System.out.println("You can't vote for the same person twice.");
            screen();
        }
    }

    /*
     * This method exists to add a written-in candidate (that is, a candidate who is not yet on the ballot) to the ballot.
     *  @param    candidate		A string representing a candidate’s name.
     *  @return   void    		Adds a candidate to the ballot.
     */
    public void addWriteIn(String candidate)
    {
        try {
            VD.nominateCandidate(candidate);
            System.out.println("Added " + candidate + " to the ballot successfully");
        } catch (RedundantCandidateException e) {
            System.out.println("That candidate is already on the ballot");
        }
    }

}
