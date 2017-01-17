package winning.myviewflippertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //控件
    private ViewFlipper vf;
    //页面的集合
    private ArrayList<View> viewArr = new ArrayList<>();
    //广告的集合
    private ArrayList<String> adsArr = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        vf = (ViewFlipper) findViewById(R.id.vf);
        for (int i = 0; i < 5; i++) {
            adsArr.add("小米" + i);
        }

        for (final String temp : adsArr) {
            View view = View.inflate(this, R.layout.ads_layout, null);
            TextView tv_content = (TextView) view.findViewById(R.id.ads_content);
            tv_content.setText(temp);

            tv_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                }
            });
            viewArr.add(view);
        }

        for (View tempView : viewArr) {
            vf.addView(tempView);
        }
    }
}
