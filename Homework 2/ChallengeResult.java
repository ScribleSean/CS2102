package Homework2;


public class ChallengeResult
{
    ReadingResult readResult;
    WritingResult writeResult;

    public ChallengeResult(ReadingResult rr, WritingResult wr)
    {
        this.readResult = rr;
        this.writeResult = wr;
    }

  // No JavaDocs required.
    public double howClose()
    {
        return ((readResult.differenceFromGoal() * 10000) + writeResult.differenceFromGoal());
    }
}
