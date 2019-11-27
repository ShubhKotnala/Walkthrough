package io.github.shubhkotnala.walkthrough;

import android.animation.ArgbEvaluator;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import io.github.shubhkotnala.walkthrough.adapter.WalkthroughViewPagerAdapter;
import io.github.shubhkotnala.walkthrough.model.WalkthroughItem;
import io.github.shubhkotnala.walkthrough.transformer.SwipeTransform;
import io.github.shubhkotnala.walkthrough.viewholder.WalkthroughItemView;

import java.util.ArrayList;

public abstract class WalkthroughActivity extends AppCompatActivity implements WalkthroughItemView.ItemArrowInterface {
    private ViewPager viewPager;
    private WalkthroughViewPagerAdapter adapter;
    private ArrayList<WalkthroughItem> arrayList;
    private RelativeLayout parent;
    private Boolean isLastPageSwiped = false;
    private int counterPageScroll;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        viewPager = findViewById(R.id.viewPager);
        parent = findViewById(R.id.parent);
        initData();
    }

    private void initData() {
        arrayList = new ArrayList<>();
    }

    public void startWalkthrough(){
        changeBackground(arrayList.get(0).getAccentColor());
        adapter = new WalkthroughViewPagerAdapter(this, arrayList, WalkthroughActivity.this);
        viewPager.setPageTransformer(true, new SwipeTransform());

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position < (adapter.getCount() -1) && position < (arrayList.size() - 1)) {
                    Integer bgColor = (Integer) argbEvaluator.evaluate(positionOffset, Color.parseColor(arrayList.get(position).getAccentColor()), Color.parseColor(arrayList.get(position+1).getAccentColor()));
                    parent.setBackgroundColor(bgColor);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(bgColor);
                        window.setNavigationBarColor(bgColor);
                    }

                }if (position == (arrayList.size() - 1) && positionOffset == 0 && !isLastPageSwiped){
                    if(counterPageScroll != 0){
                        isLastPageSwiped=true;
                        onFinish();
                        finish();
                    }
                    counterPageScroll++;
                } else {
                    counterPageScroll = 0;
                    isLastPageSwiped=false;
                }
            }

            @Override
            public void onPageSelected(int position) {
                //  changeBackground(arrayList.get(position).getAccentColor());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setPageTitle(String pageTitle){
        TextView featured_text = findViewById(R.id.featured_text);
        featured_text.setText(pageTitle);
    }

    public void addWalkthroughItem(WalkthroughItem item){
        arrayList.add(item);
    }

    private void changeBackground(String color) {
        parent.setBackgroundColor(Color.parseColor(color));
        changeStatusBarColor(color);
    }

    private void changeStatusBarColor(String color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

    @Override
    public void scrollNextPosition(int position) {
        viewPager.setCurrentItem(position, true);
    }

    @Override
    public void onDoneFinishWalkthrough() {
        onFinish();
        finish();
    }

    public void onFinish(){
        //Override this method to perform some action after last slide is finished
    }

}
