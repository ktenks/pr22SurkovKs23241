package com.example.pr22surkovks23241;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvStatus = findViewById(R.id.tvStatus);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioButton radioButton = findViewById(R.id.radioButton);
        Switch switchBtn = findViewById(R.id.switchBtn);

        // Функционал чекбокса
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) ->
                tvStatus.setText("Чекбокс: " + (isChecked ? "включён" : "выключен")));

        // Функционал радиокнопки
        radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) tvStatus.setText("Радиокнопка выбрана");
        });

        // Функционал переключателя
        switchBtn.setOnCheckedChangeListener((buttonView, isChecked) ->
                tvStatus.setText("Переключатель: " + (isChecked ? "ON" : "OFF")));

        // Свайпы: влево -> на 3-й экран, вправо -> назад на 1-й
        findViewById(R.id.second_layout).setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }

            @Override
            public void onSwipeRight() {
                finish(); // возврат на MainActivity
            }
        });

        Toast.makeText(this, "Свайп влево — далее, вправо — назад", Toast.LENGTH_SHORT).show();
    }
}