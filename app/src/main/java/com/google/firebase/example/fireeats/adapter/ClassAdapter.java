package com.google.firebase.example.fireeats.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.example.fireeats.R;
import com.google.firebase.example.fireeats.model.ClassSection;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by tp0986611 on 1/19/2018.
 */

public class ClassAdapter extends FirestoreAdapter<ClassAdapter.ClassViewHolder> {

    public interface OnClassSelectedListener {

        void onClassSelected(DocumentSnapshot classes);

    }

    private OnClassSelectedListener mListener;

    public ClassAdapter(Query query, OnClassSelectedListener listener) {
        super(query);
        mListener = listener;
    }


    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ClassViewHolder(inflater.inflate(R.layout.item_class, parent, false));
    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ClassViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.class_item_name)
        TextView className;

        @BindView(R.id.class_item_teachername)
        TextView teacherName;

        @BindView(R.id.class_time)
        TextView classTime;

        @BindView(R.id.room_number)
        TextView roomNumber;

        @BindView(R.id.class_item_seats)
        TextView classSeats;


        public ClassViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot,
                         final OnClassSelectedListener listener) {

            ClassSection classSection = snapshot.toObject(ClassSection.class);
            Resources resources = itemView.getResources();


            className.setText(classSection.getName());

            teacherName.setText(classSection.getTeacherName());
            classTime.setText(classSection.getTime());

            roomNumber.setText(classSection.getRoomNumber());
            classSeats.setText(classSection.getSeats());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onClassSelected(snapshot);
                    }
                }
            });
        }
    }

}
