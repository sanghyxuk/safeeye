package com.android.safeeye;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 카메라 버튼 클릭 이벤트
        RelativeLayout btnCamera = findViewById(R.id.btn_camera);
        btnCamera.setOnClickListener(view -> {
            // 카메라 버튼 동작
            Toast.makeText(MainActivity.this, "카메라 버튼 클릭됨!", Toast.LENGTH_SHORT).show();
            // 카메라 기능을 호출하는 코드 추가 (예: 새로운 액티비티 실행)
        });

        // 설정 버튼 클릭 이벤트
        RelativeLayout btnSettings = findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(view -> {
            // 설정 화면 이동
            Toast.makeText(MainActivity.this, "설정 버튼 클릭됨!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // 가이드 버튼 클릭 이벤트
        RelativeLayout btnGuide = findViewById(R.id.btn_guide);
        btnGuide.setOnClickListener(view -> {
            // 가이드 화면 이동
            Toast.makeText(MainActivity.this, "가이드 버튼 클릭됨!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, GuideActivity.class);
            startActivity(intent);
        });

        // 긴급 호출 버튼 클릭 이벤트
        RelativeLayout btnEmergencyCall = findViewById(R.id.btn_emergency_call);
        btnEmergencyCall.setOnClickListener(view -> openDialerWithEmergencyNumber());
    }

    /**
     * 긴급 호출 다이얼 화면 열기
     */
    private void openDialerWithEmergencyNumber() {
        String emergencyNumber = "119";
        Intent dialIntent = new Intent(Intent.ACTION_DIAL); // 다이얼 화면 열기
        dialIntent.setData(Uri.parse("tel:" + emergencyNumber));
        try {
            startActivity(dialIntent);
        } catch (Exception e) {
            Toast.makeText(this, "다이얼 화면을 열 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
