public class Runner {
    public static void main(String[] args) {
        SimpleEloEngine engine = new SimpleEloEngine();
        int elo1 = -1;
        int elo2 = 1951;
        int[] results = engine.getUpdatedRatings(elo1, elo2, 1);
        for (int i : results) {
            System.out.println(i);
        }
    }
}
