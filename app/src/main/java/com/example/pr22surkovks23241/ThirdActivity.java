package com.example.pr22surkovks23241;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Свайп вправо -> возврат на второй экран
        findViewById(R.id.third_layout).setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {
                finish();
            }

            @Override
            public void onSwipeLeft() {
                Toast.makeText(ThirdActivity.this,
                        "Это последний экран", Toast.LENGTH_SHORT).show();
            }
        });
    }
}