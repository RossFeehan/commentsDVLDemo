package com.ross.feehan.commentsdvldemoapp.View.Adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public class CommentsRecyclerViewAdapter  extends RecyclerView.Adapter<CommentsRecyclerViewAdapter.CommentsViewHolder>{

    List<Comment> comments;

    //CONSTRUCTOR
    public CommentsRecyclerViewAdapter(List<Comment> comments){
        this.comments = comments;
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card_view, parent, false);
        CommentsViewHolder commentsViewHolder = new CommentsViewHolder(view);
        return commentsViewHolder;
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        holder.commentTV.setText(comments.get(position).getComment());
        holder.commentDateTV.setText(comments.get(position).getCommentDate());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class CommentsViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.commentCV) protected CardView commentCV;
        @Bind(R.id.commentTV) protected TextView commentTV;
        @Bind(R.id.commentDateTV) protected TextView commentDateTV;

        public CommentsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
