package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

import java.util.Calendar;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testAddingTweetToTheList(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet");
        solo.clickOnButton("Save");

        solo.enterText((EditText) solo.getView(R.id.body), "");

        assertTrue(solo.searchText("Test tweet"));

        solo.clickOnButton("Clear");
        assertFalse(solo.searchText("Test tweet"));


    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),"Tweet test");
        solo.clickOnButton("Save");
        solo.waitForText("Tweet test");

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals(tweet.getMessage(),"Tweet test");

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong activity", EditTweetActivity.class);
        assertTrue(solo.searchText("Tweet test"));


        // test that current year is displayed in date
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearInString = String.valueOf(year);

        assertTrue(solo.searchText(yearInString));

        solo.goBack();
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);

    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}