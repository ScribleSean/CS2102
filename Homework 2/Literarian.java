package Homework2;


public class Literarian
{
    String penName;
    ChallengeResult challResult;


    public Literarian(String penName, ChallengeResult challResult) {
        this.penName = penName;
        this.challResult=challResult;
    }

    // No JavaDocs required.
    public boolean betterBookworm( Literarian lit) {
        if ((this.challResult.readResult.differenceFromGoal()) > (lit.challResult.readResult.differenceFromGoal())) {
            return false;
        }
        else {
            return true;
        }
    }

    // No JavaDocs required.
    public boolean wittierWordsmith( Literarian lit) {
        if ((this.challResult.writeResult.differenceFromGoal()) > (lit.challResult.writeResult.differenceFromGoal())) {
            return true;
        }
        else {
            return false;
        }
    }

    // No JavaDocs required.
    public boolean successfulScholar( Literarian lit) {
        if( this.wittierWordsmith(lit) || this.betterBookworm(lit)) {
            return true;
        }
        else {
            return false;
        }
    }
}

