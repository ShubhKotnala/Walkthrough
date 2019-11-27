package io.github.shubhkotnala.walkthrough;

import android.os.Bundle;
import io.github.shubhkotnala.walkthrough.model.WalkthroughItem;

public class WalkthroughDemo extends WalkthroughActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPageTitle("Testing");
        addWalkthroughItem(new WalkthroughItem(R.drawable._follow, "#7BC8C0","Walkthrough","A library that will generate the Walkthrough of your app without any pain.\n Supports links in the description, long text.\nNow you can focus on your main app development rather than the Introduction.\nA small and simple library which is all you need"));
        addWalkthroughItem(new WalkthroughItem(R.drawable.lorem, "#967ADC","Supports Long Description",getResources().getString(R.string.lorem).toString()));
        addWalkthroughItem(new WalkthroughItem(R.drawable.github_octocat, "#000000","Download","Download this project on Github http://github.com/ShubhKotnala"));
        addWalkthroughItem(new WalkthroughItem(R.drawable.success, "#4CAF50","You're all set!","Slide more to get this finished or press the button at the bottom of this card to finish the Walkthrough and enter your amazing app."));

        startWalkthrough();
    }

    @Override
    public void onFinish() {
        super.onFinish();
       //TODO: manage the state when the last page is scrolled
    }
}
