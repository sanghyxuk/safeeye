package com.android.safeeye;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    private boolean isNavigated = false; // 중복 이동 방지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // 텍스트 깜빡이기 효과
        TextView introText = findViewById(R.id.intro_text);
        Handler handler = new Handler();
        Runnable blinkRunnable = new Runnable() {
            private boolean isVisible = true;

            @Override
            public void run() {
                introText.setAlpha(isVisible ? 1f : 0f);
                isVisible = !isVisible;
                handler.postDelayed(this, 1500); // 깜빡이는 속도를 1500ms로 설정
            }
        };
        handler.post(blinkRunnable);

        // 음성 재생
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.intro_voice); // intro_voice.mp3
        mediaPlayer.start();

        // 화면 터치 이벤트
        findViewById(R.id.intro_layout).setOnTouchListener((v, event) -> {
            if (!isNavigated) {
                isNavigated = true; // 중복 이동 방지
                mediaPlayer.stop(); // 음성 중지
                mediaPlayer.release();
                navigateToMain();
            }
            return true;
        });
    }

    // MainActivity로 이동
    private void navigateToMain() {
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // IntroActivity 종료
    }
}
