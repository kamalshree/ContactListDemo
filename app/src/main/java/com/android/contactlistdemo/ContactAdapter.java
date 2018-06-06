package com.android.contactlistdemo;

import android.content.Context;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kamalshree on 6/5/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private static final String TAG = "ContactAdapter";

    ArrayList<String> ContactName=new ArrayList<>();
    ArrayList<String> ContactNumber=new ArrayList<>();
    Context mContext;

    public ContactAdapter( Context mContext, ArrayList<String> contactName,ArrayList<String> contactNumber) {
        ContactName = contactName;
        ContactNumber = contactNumber;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_listitems,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: OnBindViewHolder");
        String fChar = String.valueOf(ContactName.get(position).charAt(0));

        Drawable background = holder.contactImage.getBackground();

        if (background instanceof GradientDrawable) {
            // cast to 'GradientDrawable'
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setColor(ContextCompat.getColor(mContext, getRandomColor()));
        }

        holder.contactName.setText(ContactName.get(position));
        holder.contactNumber.setText(ContactNumber.get(position));
        holder.contactInitial.setText(fChar);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, ContactName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //random color generator
    private int getRandomColor() {
            Random r = new Random();
            int randNumber = r.nextInt(10 - 1) + 1;
            int color_val=0;
            switch (randNumber){

                case 1:{
                    color_val= R.color.color1;
                    break;
                }
                case 2:{
                    color_val= R.color.color2;
                    break;
                }
                case 3:{
                    color_val= R.color.color3;
                    break;
                }
                case 4:{
                    color_val= R.color.color4;
                    break;
                }
                case 5:{
                    color_val= R.color.color5;
                    break;
                }
                case 6:{
                    color_val= R.color.color6;
                    break;
                }
                case 7:{
                    color_val= R.color.color7;
                    break;
                }
                case 8:{
                    color_val= R.color.color8;
                    break;
                }
                case 9:{
                    color_val= R.color.color9;
                    break;
                }
                case 10:{
                    color_val= R.color.color10;
                    break;
                }

            }
        return color_val;
    }

    @Override
    public int getItemCount() {
        return ContactName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView contactImage;
        TextView contactName,contactNumber,contactInitial;
        ConstraintLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            parentLayout=itemView.findViewById(R.id.rl_constraintlayout);
            contactImage=itemView.findViewById(R.id.im_image);
            contactInitial=itemView.findViewById(R.id.tv_initial);
            contactName=itemView.findViewById(R.id.tv_name);
            contactNumber=itemView.findViewById(R.id.tv_contact);
        }
    }
}
