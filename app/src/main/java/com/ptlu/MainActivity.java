package com.ptlu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private SliderLayout mSliderLayout;
    HashMap<String,Integer> files;
    Button btmembership,btwhatsnew,btcontributions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSliderLayout = (SliderLayout)findViewById(R.id.slider);
        btmembership =  (Button)findViewById(R.id.bt_membership);
        btwhatsnew = (Button)findViewById(R.id.bt_whats_new);
        btcontributions = (Button)findViewById(R.id.bt_contributions);

        btcontributions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Contributions.class));
            }
        });

        btwhatsnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WhatsNew.class));
            }
        });

        btmembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Registration_Form.class));
            }
        });


        files = new HashMap<String, Integer>();
        files.put("BigBang",R.drawable.bigbang);
        files.put("House",R.drawable.house);
        files.put("Game Of Thrones",R.drawable.game_of_thrones);
        files.put("Hannibal",R.drawable.hannibal);


        for (String name:files.keySet()){
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(files.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
            ;

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("Extra",name);

            mSliderLayout.addSlider(textSliderView);
            mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
            mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mSliderLayout.setCustomAnimation(new DescriptionAnimation());
            mSliderLayout.setDuration(2000);

        }



    }



}
