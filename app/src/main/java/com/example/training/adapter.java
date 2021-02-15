package com.example.training;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<holder> {

    Context c;
    ArrayList<Model> models;

    public adapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int i) {

        View view= LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.row1, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder holder, int i) {
        holder.mTitle.setText(models.get(i).getTitle());
        holder.mImaeView.setImageResource(models.get(i).getImg());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String gTitle = models.get(position).getTitle();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.mImaeView.getDrawable();


                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(c, smart.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);


            }



        });

holder.setItemClickListener(new ItemClickListener() {
    @Override

    public void onItemClickListener(View v, int position) {
        switch (models.get(position).getTitle()) {
            case "الذكاء العاطفي":
// Open New Activity
                Intent your = new Intent(c, your.class);
                c.startActivity(your);
                break;
            case "قدر ذاتك":
// Open New Activity
                Intent smart = new Intent(c, smart.class);
                c.startActivity(smart);
                break;
            case "تدريب المدربين":
// Open New Activity
                Intent tot = new Intent(c, tot.class);
                c.startActivity(tot);
                break;

            case "التصوير الفوتوغرافي":
// Open New Activity
                Intent photo = new Intent(c, photo.class);
                c.startActivity(photo);
                break;

            case "الصحة و السلامة":
// Open New Activity
                Intent safety = new Intent(c, safety.class);
                c.startActivity(safety);
                break;

            case "مهارات الاكسل المتقدمة":
// Open New Activity
                Intent excel = new Intent(c, excel.class);
                c.startActivity(excel);
                break;

            case "صياغة العقود":
// Open New Activity
                Intent law = new Intent(c, law.class);
                c.startActivity(law);
                break;
        }



    }
});
    }




    @Override
    public int getItemCount() {
        return models.size();
    }
}

