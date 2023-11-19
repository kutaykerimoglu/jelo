import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EloEngineTest {
    @InjectMocks
    SimpleEloEngine simpleEloEngine;

    @Test
    void getUpdatedRatings_shouldThrowException_whenWinnerIsInvalid() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> this.simpleEloEngine.getUpdatedRatings(1, 1, 3)
        );
        Assertions.assertEquals(exception.getClass(), IllegalArgumentException.class);
        Assertions.assertEquals(exception.getMessage(), "Invalid winner!");
    }

    @Test
    void getUpdatedRatings_shouldThrowException_whenOneEloIsBelow0() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> this.simpleEloEngine.getUpdatedRatings(-12, 1, 2)
        );
        Assertions.assertEquals(exception.getClass(), IllegalArgumentException.class);
        Assertions.assertEquals(exception.getMessage(), "Elo must be greater than 0");
    }

    @Test
    void getUpdatedRatings_shouldUpdateEloRatings() {
        int[] actualResult = this.simpleEloEngine.getUpdatedRatings(1200, 1200, 2);
        Assertions.assertTrue(actualResult[1] > actualResult[0]);
        Assertions.assertTrue(actualResult[0] < 1200);
        Assertions.assertTrue(actualResult[1] > 1200);
    }
}