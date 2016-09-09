package com.reckontech.cicnp.cicnp.UIFunctions;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * Created by Dell on 9/4/2016.
 */
public class UIFunctions {

    public void ToggleLoading(View view, ProgressBar progressBar)
    {
        if(progressBar.getVisibility() == View.GONE)
        {
            progressBar.setVisibility(View.VISIBLE);
            view.setAlpha(0.7f);
        }
        else
        {
            progressBar.setVisibility(View.GONE);
            view.setAlpha(1.0f);
        }
    }

    public ProgressBar GetProgressBar(CoordinatorLayout parent)
    {
        ProgressBar progressBar = new ProgressBar(parent.getContext());

        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        progressBar.setLayoutParams(layoutParams);

        parent.addView(progressBar);

        return progressBar;
    }
}
