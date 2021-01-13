package com.example.updatereps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnReset;
    TextView tvEmail;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        LinearLayout container = (LinearLayout)findViewById(R.id.ll_setting_checkbox);
        int count = container.getChildCount();
        for (int i=0; i<count; i++) {
            View v = container.getChildAt(i);
            if (v instanceof CheckBox) {
                CheckBox checkBox1 = (CheckBox) v;
                if (preferences.getBoolean("cbx" + checkBox1.getId(), false)) {
                    checkBox1.setChecked(true);
                } else {
                    checkBox1.setChecked(false);

                }
                checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(checkBox1.isChecked()) {
                            editor.putBoolean("cbx" + checkBox1.getId(), true);
                            editor.apply();
                        }else{
                            editor.putBoolean("cbx" + checkBox1.getId(), false);
                            editor.apply();
                        }
                    }
                });
            }
        }
        /*checkBox = (CheckBox)findViewById(R.id.cbx_workout,R.id.cbx_workout2,R.id.cbx_workout3,R.id.cbx_workout4,R.id.cbx_workout5,R.id.cbx_workout6,R.id.cbx_workout7,R.id.cbx_workout8,R.id.cbx_workout9,R.id.cbx_workout10,R.id.cbx_workout11,R.id.cbx_workout12,R.id.cbx_workout13,R.id.cbx_workout14,R.id.cbx_workout15,R.id.cbx_workout16,R.id.cbx_workout17,R.id.cbx_workout18, R.id.cbx_workout19,R.id.cbx_workout20,R.id.cbx_workout21,R.id.cbx_workout22, R.id.cbx_workout23,R.id.cbx_workout24);

        if(preferences.contains("checked") && preferences.getBoolean("checked",false) == true) {
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);

        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked()) {
                    editor.putBoolean("checked", true);
                    editor.apply();
                }else{
                    editor.putBoolean("checked", false);
                    editor.apply();
                }
            }
        });


         */
        btnReset = findViewById(R.id.btn_reset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ResetPassword.class);
                startActivity(intent);
            }
        });

    }

   /* private Object findViewById(int cbx_workout, int cbx_workout2, int cbx_workout3, int cbx_workout4, int cbx_workout5, int cbx_workout6,
                                int cbx_workout7, int cbx_workout8, int cbx_workout9, int cbx_workout10, int cbx_workout11, int cbx_workout12,
                                int cbx_workout13, int cbx_workout14, int cbx_workout15, int cbx_workout16, int cbx_workout17, int cbx_workout18,
                                int cbx_workout19, int cbx_workout20, int cbx_workout21, int cbx_workout22, int cbx_workout23, int cbx_workout24) {
        return ;
    }


    */

}