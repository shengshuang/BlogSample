package com.blog.a;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blog.a.nested.NestedScrollActivity;

import java.util.ArrayList;

public class IndexActivity extends BaseActivity {

    private static final int NESTED1_SCROLL = 0;

    public interface IClickItemListener {
        void onClick(int itemPosition);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_layout);
        RecyclerView recyclerView = findViewById(R.id.rv_list);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new SimpleAdapter((int itemPosition)
                -> clickItem(itemPosition), getExamples()));
    }

    private void clickItem(int itemPosition) {
        switch (itemPosition){
            case NESTED1_SCROLL:
                toIntent(NestedScrollActivity.class);
                break;
            default:
                break;
        }
    }

    private ArrayList<String> getExamples() {
        ArrayList<String> examples = new ArrayList<>();
        examples.add("嵌套滑动栗子");
        return examples;
    }

    private void toIntent(Class<? extends AppCompatActivity> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
