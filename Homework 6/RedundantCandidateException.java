public class RedundantCandidateException extends Exception
{
    private String candidate;
    public RedundantCandidateException (String candidate)
    {
        this.candidate = candidate;
    }

    public String getName()
    {
        return this.candidate;
    }
}
