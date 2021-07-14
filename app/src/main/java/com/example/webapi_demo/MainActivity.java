package com.example.webapi_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.webapi_demo.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    AdapterProduct adapterProduct;
    List<Product> productList = new ArrayList<>();

    String jsonArray="[{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null},{\"id\":\"111\",\"publisher_id\":\"113\",\"content_type\":\"113\",\"tab\":\"110\",\"title\":\"Series Phim\",\"avatar\":\"----------\"}]";
    String jsonStr = "{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        getJson();
        getListJson();


    }
    private  void getJson(){
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);

            int id=jsonObject.getInt("id");
            String title = jsonObject.getString("title");

            binding.tvView.setText(title);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getListJson(){
        try {
            JSONArray array = new JSONArray(jsonArray);
            for(int i=0;i<array.length();i++){
                JSONObject jsonObject = array.getJSONObject(i);
                int id=jsonObject.getInt("id");
                int publisher_id = jsonObject.getInt("publisher_id");
                String title = jsonObject.getString("title");
                Product s = new Product(id,publisher_id,title);
                productList.add(s);
//                binding.tvView.setText(id+" - "+publisher_id+" - "+title);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        adapterProduct = new AdapterProduct(productList);
        binding.lvProduct.setAdapter(adapterProduct);

    }
}