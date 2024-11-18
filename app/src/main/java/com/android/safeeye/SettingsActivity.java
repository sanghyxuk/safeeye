package com.android.safeeye;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // SettingsFragment 추가
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);

            // 사용자 프로필 수정 Preference 클릭 이벤트 처리
            Preference userProfilePref = findPreference("user_profile");
            if (userProfilePref != null) {
                userProfilePref.setOnPreferenceClickListener(preference -> {
                    try {
                        // UserProfileActivity로 이동
                        Intent intent = new Intent(getActivity(), UserProfileActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "프로필 화면을 열 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                });
            }
        }
    }
}
