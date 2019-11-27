package io.github.shubhkotnala.walkthrough.transformer;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.github.shubhkotnala.walkthrough.R;

public class SwipeTransform implements ViewPager.PageTransformer {
    private TextView item_title, item_desc;
    private CardView foregroundCardParent;
    private FloatingActionButton arrow;

    @Override
    public void transformPage(View page, float position) {
        item_title = page.findViewById(R.id.item_title);
        item_desc = page.findViewById(R.id.item_desc);
        foregroundCardParent = page.findViewById(R.id.foregroundCardParent);
        arrow = page.findViewById(R.id.arrow);

        if (position <= 1) {
            foregroundCardParent.setTranslationX(-position * -0.8f * page.getWidth());
            item_title.setTranslationX(-position * -0.4f * page.getWidth());
            arrow.setTranslationX(-position * -0.4f * page.getWidth());
            item_desc.setTranslationX(-position * -0.2f * page.getWidth());
        }
    }
}