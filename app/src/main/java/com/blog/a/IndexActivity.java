package com.blog.a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blog.a.nested.NestedScrollActivity;
import com.blog.a.drag.ViewDragActivity;

import java.util.ArrayList;

public class IndexActivity extends BaseActivity {

    private static final int NESTED1_SCROLL = 0;
    private static final int DRAG_HELPER = 1;
    private static final int OVER_SCROLL_RECYCLER = 2;

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
        recyclerView.setAdapter(new SimpleAdapter(this::clickItem, getExamples()));
    }

    private void clickItem(int itemPosition) {
        switch (itemPosition){
            case NESTED1_SCROLL:
                toIntent(NestedScrollActivity.class);
                break;
            case DRAG_HELPER:
                toIntent(ViewDragActivity.class);
                break;
            case OVER_SCROLL_RECYCLER:
                Toast.makeText(this, "当前页带回弹效果!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private ArrayList<String> getExamples() {
        ArrayList<String> examples = new ArrayList<>();
        examples.add("嵌套滑动栗子");
        examples.add("ViewDragHelper栗子");
        examples.add("回弹效果RecyclerView");
        return examples;
    }

    private void toIntent(Class<? extends AppCompatActivity> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
