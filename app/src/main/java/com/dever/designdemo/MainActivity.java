package com.dever.designdemo;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener {

    private TextView textView;
    private CoordinatorLayout coordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.main_text);
        coordinator = (CoordinatorLayout) findViewById(R.id.coodr);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) textView.getLayoutParams();
        SwipeDismissBehavior behavior = new SwipeDismissBehavior();
        behavior.setListener(this);
        params.setBehavior(behavior);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//把toolbar当做actionbar使用,前提是当前activity没有actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onDismiss(final View view) {
        ViewGroup parent = (ViewGroup) view.getParent();
        parent.removeView(view);
        ViewCompat.setAlpha(view, 1);
        ViewCompat.setTranslationX(view, 0);
        //Toast.makeText(this, "删除了一个textView", Toast.LENGTH_SHORT).show();
        Snackbar.make(coordinator,"删除了一个tv",Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        coordinator.addView(view);
                    }
                })
                .show();//如果这个view是协调者布局，snackbar自带滑动删除
    }

    @Override
    public void onDragStateChanged(int state) {

    }
}
