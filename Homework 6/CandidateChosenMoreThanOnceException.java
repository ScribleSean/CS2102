public class CandidateChosenMoreThanOnceException extends Exception
{
    private String candidate;
    public CandidateChosenMoreThanOnceException (String candidate)
    {
        this.candidate = candidate;
    }
    public String getName()
    {
        return this.candidate;
    }
}
