/**
 * A simple implementation of the Elo rating system with customizable parameters for the K_FACTOR and DIFFERENCE_CONSTANT.
 * For more information about the Elo rating system, refer to: https://en.wikipedia.org/wiki/Elo_rating_system
 */
public class SimpleEloEngine {
    private final int K_FACTOR;
    private final int DIFFERENCE_CONSTANT;

    /**
     * Constructs an instance of the SimpleEloEngine with default parameters:
     * - K_FACTOR = 32
     * - DIFFERENCE_CONSTANT = 400
     */
    SimpleEloEngine() {
        this.K_FACTOR = 32;
        this.DIFFERENCE_CONSTANT = 400;
    }

    /**
     * Constructs a custom SimpleEloEngine with specified parameters.
     *
     * @param k                  the value for K_FACTOR
     * @param differenceConstant the value for DIFFERENCE_CONSTANT
     */
    SimpleEloEngine(int k, int differenceConstant) {
        this.K_FACTOR = k;
        this.DIFFERENCE_CONSTANT = differenceConstant;
    }

    /**
     * Calculates and returns the updated Elo ratings for two players after a match.
     *
     * @param elo1   the Elo rating of the first player
     * @param elo2   the Elo rating of the second player
     * @param winner the winner of the head-to-head match (1 or 2)
     * @return an array with updated Elo ratings for elo1 and elo2 respectively
     */
    public int[] getUpdatedRatings(int elo1, int elo2, int winner) {
        SimpleEloEnginePreconditions.mustBeValidInputs(elo1, elo2, winner);
        int elo1Outcome = winner == 1 ? 1 : 0;
        int elo2Outcome = winner == 2 ? 1 : 0;
        double evElo1 = calculateExpectedOutput(elo1, elo2);
        double evElo2 = calculateExpectedOutput(elo2, elo1);
        double updatedElo1 =  elo1 + K_FACTOR * (elo1Outcome - evElo1);
        assertEloGreaterThan0(updatedElo1);
        double updatedElo2 =  elo2 + K_FACTOR * (elo2Outcome - evElo2);
        assertEloGreaterThan0(updatedElo2);
        return new int[] {(int) updatedElo1, (int) updatedElo2};
    }

    /**
     * Calculates the expected probability of winning for a player based on their Elo rating and the opponent's rating.
     *
     * @param elo       the Elo rating of the player
     * @param otherElo  the Elo rating of the opponent
     * @return the expected probability of winning for the player
     */
    private double calculateExpectedOutput(int elo, int otherElo) {
        return (1 / (1 + Math.pow(10, (double) (otherElo - elo) / DIFFERENCE_CONSTANT)));
    }

    /**
     * Ensures that the Elo rating is greater than or equal to 0.
     *
     * @param elo the Elo rating to be validated
     */
    private void assertEloGreaterThan0(double elo) {
        if (elo < 0d) {
            elo = 0d;
        }
    }
}
