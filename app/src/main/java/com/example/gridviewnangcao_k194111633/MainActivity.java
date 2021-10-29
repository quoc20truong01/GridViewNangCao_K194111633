package com.example.gridviewnangcao_k194111633;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.BeerAdapter;
import com.example.model.Beer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvBeer;
    ArrayList<Beer> beer;
    BeerAdapter adapter;
    Button btnBack;
    TextView txtName, txtNamee;
    ImageView imvThumb, imvThumbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        initData();
        initAdapter();
        addEvents();
    }

    private void soLo(Beer beers1) {
        setContentView(R.layout.item_deltail);
        TextView txtNameL = (TextView) findViewById(R.id.txtNamee);
        ImageView imvThumbL = (ImageView) findViewById(R.id.imvThumbb);
        Button btnBack =(Button) findViewById(R.id.btnBack);
        imvThumbL.setImageResource(beers1.getProductThumb());
        txtNameL.setText(beers1.getProductName());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                linkViews();
                initData();
                initAdapter();
                addEvents();

            }
        });

    }

    private void addEvents() {
        gvBeer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Beer beers1 = adapter.getItem(i);
                soLo(beers1);
            }
        });
    }

    private void initData() {
        beer = new ArrayList<Beer>();
        beer.add(new Beer(R.drawable.saigon, "Saigon"));
        beer.add(new Beer(R.drawable.hanoi, "Hanoi"));
        beer.add(new Beer(R.drawable.tiger, "Tiger"));
        beer.add(new Beer(R.drawable.heineken, "Heineken"));
        beer.add(new Beer(R.drawable.beer333, "333"));
        beer.add(new Beer(R.drawable.sapporo, "Sapporo"));
        beer.add(new Beer(R.drawable.larue, "Larue"));

    }

    private void initAdapter() {
        adapter = new BeerAdapter(MainActivity.this, R.layout.item_layout, beer);
        gvBeer.setAdapter(adapter);
    }

    private void linkViews() {
        gvBeer=findViewById(R.id.gvBeers);
    }


}