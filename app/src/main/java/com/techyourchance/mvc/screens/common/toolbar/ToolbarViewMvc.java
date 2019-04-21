package com.techyourchance.mvc.screens.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.screens.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {


    public interface NavigateUpClickListener {
        void onNavigateUpClicked();
    }

    public interface HamburgerClickListener {
        void onHamburgerClicked();
    }


    private final TextView mTxtTitle;
    private final ImageButton mBtnBack;
    private final ImageButton mBtnHamburger;

    private NavigateUpClickListener mNavigateUpClickListener;


    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
        mBtnHamburger = findViewById(R.id.btn_hamburger);

        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNavigateUpClickListener.onNavigateUpClicked();
            }
        });

        mBtnHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        mNavigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }


    public void enableHamburger() {
        mBtnHamburger.setVisibility(View.VISIBLE);

    }
}
