package com.google.firebase.example.fireeats;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.example.fireeats.adapter.ClassAdapter;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherClassFragment extends Fragment implements
        ClassAdapter.OnClassSelectedListener{

    private static final String TAG = "TeacherClassFragment";

    @BindView(R.id.recycler_classes)
    RecyclerView mClassesRecycler;

    @BindView(R.id.class_view_empty)
    ViewGroup mClassesEmptyView;

    private FirebaseFirestore mFirestore;
    private Query mQuery;

    private ClassAdapter mAdapter;

    public TeacherClassFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        initFirestore();
        initRecyclerView();


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_class, container, false);
    }

    private void initFirestore() {

        mFirestore = FirebaseFirestore.getInstance();

        //Get the 50 highest rated restaurants
        mQuery = mFirestore.collection("classes")
                .orderBy("seats", Query.Direction.DESCENDING);
    }

    private void initRecyclerView() {
        if (mQuery == null) {
            Log.w(TAG, "No query, not initializing RecyclerView");
        }

        mAdapter = new ClassAdapter(mQuery, this) {

            @Override
            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
                if (getItemCount() == 0) {
                    mClassesRecycler.setVisibility(View.GONE);
                    mClassesEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mClassesRecycler.setVisibility(View.VISIBLE);
                    mClassesEmptyView.setVisibility(View.GONE);
                }
            }

            @Override
            protected void onError(FirebaseFirestoreException e) {
                // Show a snackbar on errors
                Snackbar.make(getActivity().findViewById(android.R.id.content),
                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show();
            }
        };

        mClassesRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClassesRecycler.setAdapter(mAdapter);
    }


    @Override
    public void onStart(){
        super.onStart();

        // Start listening for Firestore updates
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }
    @Override
    public void onClassSelected(DocumentSnapshot classes) {
        // Go to the details page for the selected restaurant
    }
}
