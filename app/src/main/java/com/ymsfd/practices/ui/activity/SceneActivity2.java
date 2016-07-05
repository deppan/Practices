package com.ymsfd.practices.ui.activity;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.ymsfd.practices.R;
import com.ymsfd.practices.infrastructure.util.Preconditions;

/**
 * Created by WoodenTea.
 * User: ymsfd
 * Date: 5/25/15
 * Time: 10:27
 */
public class SceneActivity2 extends BaseActivity {

    @Override
    protected boolean _onCreate(Bundle savedInstanceState) {
        if (!super._onCreate(savedInstanceState)) {
            return false;
        }

        setContentView(R.layout.scene2_activity);
        setUpActionBar(true);
        View view = findViewById(R.id.cartoon);
        Preconditions.checkNotNull(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAfterTransition(SceneActivity2.this);
            }
        });

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCompat.finishAfterTransition(this);
    }
}
