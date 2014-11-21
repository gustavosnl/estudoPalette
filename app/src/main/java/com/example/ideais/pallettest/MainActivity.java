package com.example.ideais.pallettest;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {
    private ImageView mImageView;
    private ImageView mVibrant;
    private ImageView mLightVibrant;
    private ImageView mDarkVibrant;
    private ImageView mMuted;
    private ImageView mLightMuted;
    private ImageView mDarkMuted;
    private TextView mTextVibrantBgDark;
    private TextView mTextVibrantLightBgDark;
    private TextView mTextMutedBgDark;
    private TextView mTextMutedLightBgDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.image);
        mVibrant = (ImageView) findViewById(R.id.vibrant);
        mLightVibrant = (ImageView) findViewById(R.id.vibrant_light);
        mDarkVibrant = (ImageView) findViewById(R.id.vibrant_dark);
        mMuted = (ImageView) findViewById(R.id.muted);
        mLightMuted = (ImageView) findViewById(R.id.muted_light);
        mDarkMuted = (ImageView) findViewById(R.id.muted_dark);
        mTextVibrantBgDark = (TextView) findViewById(R.id.text_vibrant_vibrant_dark);
        mTextVibrantLightBgDark = (TextView) findViewById(R.id.text_vibrant_light_vibrant_dark);
        mTextMutedBgDark = (TextView) findViewById(R.id.text_muted_muted_dark);;
        mTextMutedLightBgDark = (TextView) findViewById(R.id.text_muted_light_muted_dark);


        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                mImageView.setImageBitmap(bitmap);
                int color ;

                Palette palette = Palette.generate(bitmap);
                color = palette.getVibrantColor(getResources().getColor(R.color.default_color));
                mVibrant.setBackgroundColor(color);
                mTextVibrantBgDark.setTextColor(color);

                color = palette.getLightVibrantColor(getResources().getColor(R.color.default_color));
                mLightVibrant.setBackgroundColor(color);
                mTextVibrantLightBgDark.setTextColor(color);

                color = palette.getDarkVibrantColor(getResources().getColor(R.color.default_color));
                mDarkVibrant.setBackgroundColor(color);

                mTextVibrantBgDark.setBackgroundColor(color);
                mTextVibrantLightBgDark.setBackgroundColor(color);


                color = palette.getMutedColor(getResources().getColor(R.color.default_color));
                mMuted.setBackgroundColor(color);
                mTextMutedBgDark.setTextColor(color);


                color = palette.getLightMutedColor(getResources().getColor(R.color.default_color));
                mLightMuted.setBackgroundColor(color);
                mTextMutedLightBgDark.setTextColor(color);


                color = palette.getDarkMutedColor(getResources().getColor(R.color.default_color));
                mDarkMuted.setBackgroundColor(color);



                mTextMutedBgDark.setBackgroundColor(color);
                mTextMutedLightBgDark.setBackgroundColor(color);



                mVibrant.setOnClickListener(onColorClick(0));
                mLightVibrant.setOnClickListener(onColorClick(1));
                mDarkVibrant.setOnClickListener(onColorClick(2));
                mMuted.setOnClickListener(onColorClick(3));
                mLightMuted.setOnClickListener(onColorClick(4));
                mDarkMuted.setOnClickListener(onColorClick(5));

            }


            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };


        Picasso.with(this)
                .load("http://mobile-sao-paulo.s3.amazonaws.com/9dc2a1382b5b291eb91803f8f93e7fdc.png")
                .into(target);
        mImageView.setVisibility(View.VISIBLE);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }








    public OnClickListener onColorClick(final int pos) {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (pos) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "VIBRANT", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "VIBRANT LIGHT", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "VIBRANT DARK", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "MUTED", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), "MUTED LIGHT", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "MUTED DARK", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        };



        }
}

