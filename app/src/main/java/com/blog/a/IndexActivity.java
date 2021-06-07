package com.blog.a;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class IndexActivity extends BaseActivity implements SimpleAdapter.ViewHolderListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_layout);

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new SimpleAdapter(IndexItem.ITEMS, this));
    }

    @Override
    public void onItemClicked(View view, int adapterPosition) {
        final Class cls = IndexItem.CLASS[adapterPosition];
        if (null == cls) {
            Toast.makeText(this, IndexItem.TOAST[adapterPosition], Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, cls);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }
        }
    }
}
