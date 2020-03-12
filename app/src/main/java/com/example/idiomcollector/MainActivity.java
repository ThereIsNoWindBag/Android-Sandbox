package com.example.idiomcollector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idiomcollector.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Systems
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ActivityMainBinding binding;

    //Data Structure
    ArrayList<String> lst;

    //Views
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();

        recyclerView = findViewById(R.id.list_layout);

        ArrayList<String> lst = new ArrayList();

        Map<String, ?> totalValue = sharedPreferences.getAll();

        for(Map.Entry<String, ?> entry : totalValue.entrySet())
        {
            lst.add(entry.getValue().toString());
        }

        for(String str : lst)
        {
            TextView textView = new TextView(this);

            textView.setText(str);
            recyclerView.addView(textView);
        }
    }

    public void onAddButtonClick(View view) {
        EditText editText = findViewById(R.id.edit_text);

        TextView textView = new TextView(this);

        String str = editText.getText().toString();

        if(!str.isEmpty())
        {
            editor.putString(str, str);
            textView.setText(str);

            recyclerView.addView(textView);
        }
        else
        {
            Toast.makeText(this, "??", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRemoveButtonClick(View view)
    {
        recyclerView.removeAllViews();
    }
}
