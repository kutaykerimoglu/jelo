public class SimpleEloEnginePreconditions {
    public static void winnerMustBeValid(int winner) {
        if (winner != 1 && winner != 2) {
            throw new IllegalArgumentException("Invalid winner!");
        }
    }

    public static void mustBeValidElo(int elo) {
        if (elo < 0) {
            throw new IllegalArgumentException("Elo must be greater than 0");
        }
    }

    public static void mustBeValidInputs(int elo1, int elo2, int winner) {
        winnerMustBeValid(winner);
        mustBeValidElo(elo1);
        mustBeValidElo(elo2);
    }
}
