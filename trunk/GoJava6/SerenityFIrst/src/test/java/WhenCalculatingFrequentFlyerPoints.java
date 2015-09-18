import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenity.Status;
import serenity.TravellerStatusSteps;

/**
 * Created by Oleksandra_Dmytrenko on 9/18/2015.
 */
public class WhenCalculatingFrequentFlyerPoints {
    @RunWith(SerenityRunner.class)
    public class WhenEarningFrequentFlyerStatus {
        @Steps
        TravellerStatusSteps travellerSteps;

        @Test
        public void membersShouldStartWithBronzeStatus() {
            // GIVEN
            travellerSteps.a_traveller_joins_the_frequent_flyer_program();
            // THEN
            travellerSteps.traveller_should_have_a_status_of(Status.Bronze);
        }

        @Test
        public void earnSilverAfter1000Points() {
            // GIVEN
            travellerSteps.a_traveller_joins_the_frequent_flyer_program();
// WHEN
            travellerSteps.the_traveller_flies(10000);
            // THEN
            travellerSteps.traveller_should_have_a_status_of(Status.Silver);
        }
    }
}
