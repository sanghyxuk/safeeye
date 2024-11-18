package com.android.safeeye;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GuideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // 돌아가기 버튼 초기화 및 클릭 이벤트 처리
        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> {
            // 메인 화면으로 돌아가기
            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
