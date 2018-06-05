package com.android.contactlistdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kamalshree on 6/5/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private static final String TAG = "ContactAdapter";
    ArrayList<String> ContactImage=new ArrayList<>();
    ArrayList<String> ContactName=new ArrayList<>();
    ArrayList<String> ContactNumber=new ArrayList<>();
    Context mContext;

    public ContactAdapter( Context mContext,ArrayList<String> contactImage, ArrayList<String> contactName,ArrayList<String> contactNumber) {
        ContactImage = contactImage;
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

        Glide.with(mContext)
                .asBitmap()
                .load(ContactImage.get(position))
                .into(holder.contactImage);

        holder.contactName.setText(ContactName.get(position));
        holder.contactNumber.setText(ContactNumber.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, ContactName.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ContactImage.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView contactImage;
        TextView contactName,contactNumber;
        ConstraintLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            parentLayout=itemView.findViewById(R.id.rl_constraintlayout);
            contactImage=itemView.findViewById(R.id.im_image);
            contactName=itemView.findViewById(R.id.tv_name);
            contactNumber=itemView.findViewById(R.id.tv_contact);
        }
    }

}
