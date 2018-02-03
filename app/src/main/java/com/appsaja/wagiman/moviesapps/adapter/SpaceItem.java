package com.appsaja.wagiman.moviesapps.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Wagiman on 1/24/2018.
 */

public class SpaceItem extends RecyclerView.ItemDecoration {

    private final int mSpace;

    public SpaceItem(int mSpace) {
        this.mSpace = mSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
        outRect.top = mSpace;
    }
}
