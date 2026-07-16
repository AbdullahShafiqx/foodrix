/*package com.example.foodrix;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrix.Domain.Foods;
import com.example.midexam.databinding.ActivityListFoodsBinding;
import com.google.firebase.firestore.core.Query;

import java.util.ArrayList;

public class ListFoodsActivity extends AppCompatActivity {

   ActivityListFoodsBinding binding;
   private RecyclerView.Adapter adapterListFood;
   private int categoryId;
   private String categoryName;
   private String searchText;
   private boolean isSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_foods);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        binding = ActivityListFoodsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();

        initList();

    }


    //2:5:00 time of YT Video
    private void initList()
    {
       DatabaseReference myref=database.getReference("Foods");
        binding.progressBar2.setVisibility(View.VISIBLE);
        ArrayList<Foods> list = new ArrayList<>();

        Query query;
        if(isSearch){

        }
        else {

         }

    }



    private void getIntentExtra() {
     categoryId = getIntent().getIntExtra("CategoryId",0);
     categoryName = getIntent().getStringExtra("Category");
     searchText = getIntent().getStringExtra("text");
     isSearch = getIntent().getBooleanExtra("isSearch",false);

     binding.titletxt.setText(categoryName);
     binding.backbtn.setOnClickListener(v -> finish());
    }
}*/