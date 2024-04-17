package com.example.test0417;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button systemButton = findViewById(R.id.button);
        systemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showMultiChoiceDialog();
            }
        });
    }

    private void showMultiChoiceDialog() {
        final String[] items = new String[]{getString(R.string.yummy), getString(R.string.sausage), getString(R.string.fruit), getString(R.string.banana), getString(R.string.chicken)};
        final boolean[] checkedItems = {false, false, false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selected_items); // 使用新的字符串資源
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle the selected items
            }
        });
        builder.setNegativeButton("離開", null);
        builder.show();
    }
}