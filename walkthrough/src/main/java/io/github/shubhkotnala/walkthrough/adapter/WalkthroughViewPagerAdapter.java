package io.github.shubhkotnala.walkthrough.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import io.github.shubhkotnala.walkthrough.R;
import io.github.shubhkotnala.walkthrough.model.WalkthroughItem;
import io.github.shubhkotnala.walkthrough.viewholder.WalkthroughItemView;
import java.util.ArrayList;

public class WalkthroughViewPagerAdapter extends PagerAdapter {

    private ArrayList<WalkthroughItem> arrayList;
    private Context context;
    private WalkthroughItemView.ItemArrowInterface itemArrowInterface;

    public WalkthroughViewPagerAdapter(Context context, ArrayList<WalkthroughItem> arrayList, WalkthroughItemView.ItemArrowInterface itemArrowInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.itemArrowInterface = itemArrowInterface;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_page_item, container, false);

        container.addView(view);

        new WalkthroughItemView(context, view, position, arrayList, itemArrowInterface);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
