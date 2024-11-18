package com.android.safeeye;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1; // 이미지 선택 요청 코드
    private ImageView profileImageView;
    private EditText nameEditText, phoneEditText, ageEditText, addressEditText;
    private RadioGroup genderRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // UI 요소 초기화
        profileImageView = findViewById(R.id.profile_image);
        nameEditText = findViewById(R.id.edit_text_name);
        phoneEditText = findViewById(R.id.edit_text_phone);
        ageEditText = findViewById(R.id.edit_text_age);
        addressEditText = findViewById(R.id.edit_text_address);
        genderRadioGroup = findViewById(R.id.radio_group_gender);
        Button saveButton = findViewById(R.id.button_save);

        // 프로필 이미지 클릭 이벤트
        profileImageView.setOnClickListener(v -> openImagePicker());

        // 저장 버튼 클릭 이벤트
        saveButton.setOnClickListener(v -> saveUserProfile());
    }

    // 이미지 선택기 열기
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            profileImageView.setImageURI(imageUri); // 선택한 이미지 표시
        }
    }

    // 사용자 프로필 저장
    private void saveUserProfile() {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String address = addressEditText.getText().toString();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        String gender = selectedGenderId == R.id.radio_male ? "남성" : "여성";

        // 유효성 검사
        if (name.isEmpty() || phone.isEmpty() || age.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "모든 필드를 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 저장 로직 (예: SharedPreferences 또는 서버에 저장)
        Toast.makeText(this, "사용자 프로필이 저장되었습니다.", Toast.LENGTH_SHORT).show();
        finish(); // 액티비티 종료
    }
}
