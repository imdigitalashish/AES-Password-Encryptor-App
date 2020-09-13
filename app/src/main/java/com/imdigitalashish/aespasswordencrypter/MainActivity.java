package com.imdigitalashish.aespasswordencrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    EditText et_key;
    EditText et_value;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_key = findViewById(R.id.et_text_key);
        et_value = findViewById(R.id.et_value);
        message = findViewById(R.id.message);

    }

    public void encrypt(View view) throws GeneralSecurityException {

        String encrpyted = AESCrypt.encrypt(et_key.getText().toString(), et_value.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("lable", encrpyted);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this, "Your Message Was Copied to clip board", Toast.LENGTH_SHORT).show();
        et_value.setText("");
        et_key.setText("");
        message.setText(String.format("You Encrypted key is (Copied To Clipboard) : %s", encrpyted));

    }

    public void decrypt(View view) throws GeneralSecurityException {
        String encrpyted = AESCrypt.decrypt(et_key.getText().toString(), et_value.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("lable", encrpyted);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this, "Your Message Was Copied to clip board", Toast.LENGTH_SHORT).show();
        et_value.setText("");
        et_key.setText("");
        message.setText(String.format("You Decrypted key is (Copied To Clipboard) : %s", encrpyted));


    }
}