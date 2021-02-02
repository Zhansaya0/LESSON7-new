package com.e.recyclerview_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TortListAdapter tortListAdapter;
    ArrayList<Tort> tortList;
    private RecyclerView.LayoutManager linearLayoutManager,gridLayoutManager;
    Button buttonChange;
    boolean layoutType = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initRecyclerItemClick();
    }
    public void initRecyclerItemClick(){
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int pos) {
                        Intent intent = new Intent (MainActivity.this, TortActivity.class);
                        intent.putExtra("foodName", tortList.get(pos).getTitle());
                        intent.putExtra("foodPrice", tortList.get(pos).getPrice());
                        intent.putExtra("foodWeight", tortList.get(pos).getWeight());
                        intent.putExtra("foodTaste_rating", tortList.get(pos).getTaste_rating());
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onLongItemClick(View view, int position){
                        Toast.makeText(MainActivity.this, "onLongItemClick", Toast.LENGTH_SHORT).show();
                    }
                } )
        );
    }
    public void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        buttonChange = findViewById(R.id.buttonChange);
        tortList = new ArrayList<>();

        tortList.add(new Tort(R.drawable.tort1, "Красный бархат", "8/10", 9000,2));
        tortList.add(new Tort(R.drawable.tort2, "Молочная девочка", "10/10", 11000,2));
        tortList.add(new Tort(R.drawable.tort3, "Три шоколада", "8/10", 8500,1));
        tortList.add(new Tort(R.drawable.tort4, "Вупи-пай", "7/10", 8000,2));
        tortList.add(new Tort(R.drawable.tort5, "Фисташковый рулет", "10/10", 6500,1));
        tortList.add(new Tort(R.drawable.tort6, "Испанский чизкейк", "10/10", 7000,1));
        tortList.add(new Tort(R.drawable.tort7, "Слезы ангела", "8/10", 5000,1));
        tortList.add(new Tort(R.drawable.tort8, "Бисквит", "10/10", 8000,2));

        tortListAdapter = new TortListAdapter(this, tortList);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(tortListAdapter);

        buttonChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                layoutType = !layoutType;
                if(layoutType) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                }else {
                    recyclerView.setLayoutManager(linearLayoutManager);
                }
                tortListAdapter.notifyDataSetChanged();
            }
        });
    }
}