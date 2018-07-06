package com.xyze.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcview;
    private RecyclerAdpter recyclerAdpter;
    private ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcview = findViewById(R.id.rc);
        rcview.setLayoutManager(new LinearLayoutManager(this));
        rcview.setHasFixedSize(true);
        rcview.setAdapter(recyclerAdpter);
        dataModelArrayList = new ArrayList<>();
        recyclerAdpter = new RecyclerAdpter(dataModelArrayList, this, this);
      /*  LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcview.setLayoutManager(layoutManager);*/

        GetData();

        /*DataModel dataModel = new DataModel();
        dataModel.setText("Shreyansh");
        dataModel.setImage(R.mipmap.ic_launcher_round);
        dataModelArrayList.add(dataModel);

        DataModel datamodell = new DataModel();
        datamodell.setText("Arpit");
        datamodell.setImage(R.mipmap.ic_launcher_round);
        dataModelArrayList.add(datamodell);

        rcview.setAdapter(recyclerAdpter);
        recyclerAdpter.notifyDataSetChanged();*/
    }

    private void GetData() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
           /* JSONObject object = new JSONObject();
            object.put("token", "qwertyuiop");
            object.put("date", Date);
            object.put("unique_id", "1");
            object.put("latitude", "");
            object.put("longitude", "");
            object.put("promoter_name", ProName);
            object.put("agency_name", AgencyName);
            object.put("distributor_name", DisName);
            object.put("distributor_mobile", MobileNum);
            object.put("contact_person", ContactPerson);
            object.put("locality", Town);
            object.put("city", City);
            object.put("state", State);
            object.put("sr_name", SRName);
            object.put("so_name", SOName);
            object.put("consumer_name", ConName);
            object.put("consumer_address", Address);
            object.put("consumer_mobile", PhoneNum);
            object.put("prod_sold_1", Powder1);
            object.put("prod_sold_2", Powder2);
            object.put("prod_sample_1", Powder3);
            object.put("prod_sample_2", Powder4);

            Log.i("conformdatajson", "" + object);*/
        // final String requestBody = object.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,     "https://hacker-news.firebaseio.com/v0/item/2921983.json?print=pretty", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEYRESPONCE", response);

                try {

                    JSONObject jsonObject=new JSONObject(response);
                    String By=jsonObject.getString("by");
                    String Id=jsonObject.getString("id");
                    String kids=jsonObject.getString("kids");
                    String parent=jsonObject.getString("parent");
                    String text=jsonObject.getString("text");
                    String time=jsonObject.getString("time");
                    String type=jsonObject.getString("type");

                    System.out.println(""+By+""+Id+""+kids);


                }catch (Exception ex){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEYERROR", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
               /* try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }*/
                return null;
            }


        };

        requestQueue.add(stringRequest);

    }
}
