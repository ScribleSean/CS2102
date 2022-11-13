package Homework2;

import java.util.LinkedList;
public class LitJam {
    int numOfUniqueGenres;
    LinkedList<Literarian> litList = new LinkedList<Literarian>();

    public LitJam(int numOfUniqueGenres, LinkedList<Literarian> aLiterarian) {
        this.numOfUniqueGenres = numOfUniqueGenres;
        this.litList = aLiterarian;
    }

    /*
     * This method exists to return a list of names of the Literarians in the overall competition
     * who's list of BooksRead contains less BooksRead than the
     * number of unique genres given in the LitJam.
     *  There are no parameters.
     *  @return   LinkedList<String>	 A list of literarian's names.
    */
    
    public LinkedList<String> readingDNF() {
        LinkedList<String> holder = new LinkedList<String>();
        for (Literarian lit : litList) {
            if (numOfUniqueGenres > lit.challResult.readResult.readList.size()) {
                holder.add(lit.penName);
            }

        }
        return holder;
    }

    /*
     * This method exists to give a score for a literarian based on their reading and writing results.
     *  @param	  litName				The literarian's name.
     *  @return   int	 				The literarian's final score.
    */

    public int finalScoreForLiterarian(String litName) {
        int finalScore = 0;
        for (Literarian n : litList) {
            if (n.penName == litName) {
                if (n.challResult.readResult.readList.size() >= numOfUniqueGenres) {
                    finalScore += 25;

                }
                for (BooksRead m : n.challResult.readResult.readList) {
                    if (m.skimmed == false) {
                        finalScore = finalScore + ((int) (5 * m.books));
                    }
                }
                if (n.challResult.readResult.booksPerDay <= n.challResult.readResult.averagePerDay()) {
                    finalScore += 5;
                }
                if (n.challResult.writeResult.getRunningSum() >= 50000) {
                    finalScore += 25;
                    finalScore = finalScore + (5 * (30 - n.challResult.writeResult.dayofNovLastUpdate));


                }

            }

        }
        return finalScore;
    }

    /*
     * This method exists to compare two LitJam's literarian's final scores.
     *  @param	  aLitJam				A LitJam.
     *  @return   boolean	 			Returns true if any literarian in this LitJam had 
     *  								a better finalscore than they did in the aLitJam parameter.
    */
    
    public boolean anyImprovement(LitJam aLitJam) {
        int originalBestFinalScore = 0;
        int newBestFinalScore = 0;
        for (Literarian n : this.litList) {
            if (originalBestFinalScore < this.finalScoreForLiterarian(n.penName))
                originalBestFinalScore = this.finalScoreForLiterarian(n.penName);

            for (Literarian m : aLitJam.litList) {
                if (originalBestFinalScore < aLitJam.finalScoreForLiterarian(m.penName))
                    newBestFinalScore = aLitJam.finalScoreForLiterarian(m.penName);

            }
        }
        if(newBestFinalScore>originalBestFinalScore)
            return true;
        else
            return false;
    }
}
// 13:
// We wrote runningSum, which allowed us to organize the code well and meant we did not have to add other helping methods. Thus, we are happy with our organization.
	

