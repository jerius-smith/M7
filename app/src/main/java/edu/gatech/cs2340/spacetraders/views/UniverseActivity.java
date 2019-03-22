package edu.gatech.cs2340.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Universe;
import edu.gatech.cs2340.spacetraders.viewmodel.UniverseViewModel;

public class UniverseActivity extends AppCompatActivity {

    private UniverseViewModel viewModel;

    private ImageButton sombero;
    private ImageButton cygnus;
    private ImageButton andromeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);;

        sombero = findViewById(R.id.solar1_button);
        cygnus = findViewById(R.id.solar2_button);
        andromeda = findViewById(R.id.solar3_button);

        viewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        Universe uni = viewModel.getCurrentUniverse();

        sombero.setOnClickListener(view -> {
            Intent intent = new Intent(UniverseActivity.this, SolarActivity.class);
            intent.putExtra("SOLAR_SYSTEM", "Sombrero");
            startActivity(intent);
        });

        cygnus.setOnClickListener(view -> {
            Intent intent = new Intent(UniverseActivity.this, SolarActivity.class);
            intent.putExtra("SOLAR_SYSTEM", "Cygnus");
            startActivity(intent);
        });

        andromeda.setOnClickListener(view -> {
            Intent intent = new Intent(UniverseActivity.this, SolarActivity.class);
            intent.putExtra("SOLAR_SYSTEM", "Andromeda");
            startActivity(intent);
        });

    }

}

