package io.github.shubhkotnala.walkthrough.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.github.shubhkotnala.walkthrough.R;
import io.github.shubhkotnala.walkthrough.model.WalkthroughItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.BlurTransformation;

public class WalkthroughItemView {
    private Context context;
    private int position;
    private ArrayList<WalkthroughItem> arrayList;
    private ImageView backgrounImage;
    private ImageView foregroundImage;
    private TextView item_title;
    private TextView item_desc;
    private RelativeLayout item_parent;
    private FloatingActionButton arrow;
    private FloatingActionButton done;
    private ItemArrowInterface itemArrowInterface;

    public WalkthroughItemView(Context context, View view, int position, ArrayList<WalkthroughItem> arrayList, ItemArrowInterface itemArrowInterface) {
        this.context = context;
        this.position = position;
        this.arrayList = arrayList;
        this.itemArrowInterface = itemArrowInterface;
        setType(view);
        apply();
    }

    private void apply() {
        arrowShow();
        loadBackgroundImage();
        loadForegroundImage();
        loadTitle();
        loadDesc();
        itemOnClick();
        changeArrowColor();
        arrowOnClick();
        doneOnClick();
    }

    private void setType(View view) {
        backgrounImage = view.findViewById(R.id.backgrounImage);
        foregroundImage = view.findViewById(R.id.foregroundImage);
        item_title = view.findViewById(R.id.item_title);
        item_desc = view.findViewById(R.id.item_desc);
        item_parent = view.findViewById(R.id.item_parent);
        arrow = view.findViewById(R.id.arrow);
        done = view.findViewById(R.id.check);
    }

    private void arrowShow() {
        if (position != arrayList.size() - 1) {
            arrow.show();
            done.hide();
        } else {
            arrow.hide();
            done.show();
        }
    }

    private void changeArrowColor() {
        arrow.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(arrayList.get(position).getAccentColor())));
        done.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(arrayList.get(position).getAccentColor())));
    }

    private void itemOnClick() {
        item_parent.setOnClickListener((v) ->{
               //TODO: handle view click here
        });
    }

    private void loadTitle() {
        item_title.setText(arrayList.get(position).getTitle());
    }

    private void loadDesc() {
        item_desc.setText(arrayList.get(position).getDescription() + "\n\n\n");
    }

    private void loadForegroundImage() {

        if(arrayList.get(position).getImageURL() == null){
            Picasso.with(context)
                    .load(arrayList.get(position).getDrawableResource())
                    .fit().centerCrop().into(foregroundImage);
        }else{
            Picasso.with(context)
                    .load(arrayList.get(position).getImageURL())
                    .fit().centerCrop().into(foregroundImage);
        }
    }

    private void loadBackgroundImage() {
        if(arrayList.get(position).getImageURL() == null){
            Picasso.with(context)
                    .load(arrayList.get(position).getDrawableResource())
                    .transform(new BlurTransformation(context, 30, 1))
                    .fit().centerCrop().into(backgrounImage);
        } else{
            Picasso.with(context)
                    .load(arrayList.get(position).getImageURL())
                    .transform(new BlurTransformation(context, 30, 1))
                    .fit().centerCrop().into(backgrounImage);
        }
    }

    private void arrowOnClick(){
        arrow.setOnClickListener((v) -> {
                itemArrowInterface.scrollNextPosition(position+1);
        });
    }

    private void doneOnClick(){
        done.setOnClickListener((v) -> {
            itemArrowInterface.onDoneFinishWalkthrough();
        });
    }

    public interface ItemArrowInterface{
        void scrollNextPosition(int position);
        void onDoneFinishWalkthrough();
    }
}