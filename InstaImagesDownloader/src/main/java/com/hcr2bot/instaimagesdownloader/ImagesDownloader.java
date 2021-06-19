package com.hcr2bot.instaimagesdownloader;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ImagesDownloader {

    public static String getImageUrl(Context context, String imageUrl) {
        String image;
        String[] finalImageUrl = new String[1];

        finalImageUrl[0] = null;
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);

        if (imageUrl.contains("?utm_source=ig_web_copy_link")) {
            String partToRemove = "?utm_source=ig_web_copy_link";
            image = imageUrl.replace(partToRemove, "");
        } else if (imageUrl.contains("?utm_source=ig_web_button_share_sheet")) {
            String partToRemove = "?utm_source=ig_web_button_share_sheet";
            image = imageUrl.replace(partToRemove, "");
        } else {
            image = imageUrl;
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                image + "?__a=1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                JSONObject Obj1 = null;
                try {
                    Obj1 = response.getJSONObject("graphql");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject Obj2 = null;
                try {
                    Obj2 = Obj1.getJSONObject("shortcode_media");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                 finalImageUrl[0] = null;
                try {
                    finalImageUrl[0] = Obj2.getString("display_url");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("finalURL", finalImageUrl[0]);



            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Something went wrong" + error.getMessage());
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);

        return finalImageUrl[0];


    }


}