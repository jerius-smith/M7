package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;

/**
 * The type Welcome activity.
 */
public class WelcomeActivity extends AppCompatActivity {

    /**
     * The Stars animation.
     */
    AnimationDrawable starsAnimation;
    /**
     * The Welcome text.
     */
    TextView welcomeText;
    ImageButton continueBttn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_welcome);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.content_welcome);

        starsAnimation = (AnimationDrawable) relativeLayout.getBackground();
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        continueBttn = findViewById(R.id.continue_button);

        String welcomeMessage = String.format(
                "\"Welcome %s! \n We're excited you have " + "decided to begin your \n"
                + " journey through the Space " + "Trader Universe!\"",
                playerName);
        welcomeText.setText(welcomeMessage);

        starsAnimation.start();

        continueBttn.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeActivity.this, PlanetActivity.class);
            startActivity(intent);
        });
    }
}
