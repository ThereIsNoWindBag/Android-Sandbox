package com.example.idiomcollector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    LinearLayout linearLayout;
    SharedPreferences.Editor editor;

    ArrayList<String> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getPreferences(MODE_PRIVATE);
        editor = sp.edit();

        linearLayout = findViewById(R.id.list_layout);

        lst = loadPreference();
        initializeList();
    }

    public void AddText(View view) {
        EditText editText = findViewById(R.id.edit_text);

        TextView textView = new TextView(this);

        String str = editText.getText().toString();

        if(!str.isEmpty())
        {
            addPreference(str);
            updateList(str);

            editor.putString(str, str);
            textView.setText(str);

            linearLayout.addView(textView);
        }
        else
        {
            Toast.makeText(this, "??", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<String> loadPreference()
    {
        ArrayList<String> lst = new ArrayList();

        Map<String, ?> totalValue = sp.getAll();

        for(Map.Entry<String, ?> entry : totalValue.entrySet())
        {
            lst.add(entry.getValue().toString());
        }

        return lst;
    }

    public void addPreference(String str)
    {

    }

    public void initializeList()
    {
        for(String str : lst)
        {
            TextView textView = new TextView(this);

            textView.setText(str);
            linearLayout.addView(textView);
        }
    }

    public void updateList(String str)
    {

    }
}
