package com.ross.feehan.commentsdvldemoapp.View.ViewImplementations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.R;
import com.ross.feehan.commentsdvldemoapp.Utils.CommentsDVLDemoAppApplication;
import com.ross.feehan.commentsdvldemoapp.View.Adapters.CommentsRecyclerViewAdapter;
import com.ross.feehan.commentsdvldemoapp.View.Utils.RecyclerViewItemTouchCallback;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.DisplayCommentsViewInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisplayCommentsActivity extends AppCompatActivity implements DisplayCommentsViewInterface {

    private Context ctx;
    @Bind(R.id.progressBar) protected RelativeLayout progressBarLayout;
    @Bind(R.id.toolbar) protected Toolbar toolbar;
    @Bind(R.id.commentsRV) protected RecyclerView commentsRV;
    @Bind(R.id.postCommentFAB) protected FloatingActionButton postCommentFAB;
    //DI INJECT
    @Inject  GetCommentsLogicInterface getCommentsLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_comments_view);

        this.ctx = this;

        //FOR BUTTERKNIFE
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.allComments));
    }

    //CLASS METHODS
    @OnClick(R.id.postCommentFAB)
    protected void onPostCommentFABClicked(){
        Intent postCommentIntent = new Intent(this, PostCommentActivity.class);
        startActivity(postCommentIntent);
    }

    //DisplayCommentsViewInterface INTERFACE METHODS
    @Override
    public void displayLoadingProgress() {
        progressBarLayout.setVisibility(View.VISIBLE);
        postCommentFAB.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideLoadingProgress() {
        progressBarLayout.setVisibility(View.INVISIBLE);
        postCommentFAB.setVisibility(View.VISIBLE);
    }

    /*Method that handles displaying the list of comments
     *@Params List<Comment> comments - The list of comments to display
     */
    @Override
    public void displayComments(List<Comment> comments) {

        //Creating the layout of the recycler view (linearlayout creates a list view like recycler view)
        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(ctx);
        commentsRV.setLayoutManager(recyclerViewLayoutManager);

        //Creating the adapter for the recycler view, with the comments
        CommentsRecyclerViewAdapter commentsAdapter = new CommentsRecyclerViewAdapter(comments);
        commentsRV.setAdapter(commentsAdapter);

        ItemTouchHelper.Callback recyclerViewTouchCallback = new RecyclerViewItemTouchCallback(commentsAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(recyclerViewTouchCallback);
        touchHelper.attachToRecyclerView(commentsRV);
    }

    @Override
    public void noCommentsYet() {
        Toast.makeText(this, "No Comments Yet", Toast.LENGTH_LONG).show();
    }

    @Override
    public void getCommentsFailed() {
        Toast.makeText(this, "Getting Comments Failed", Toast.LENGTH_LONG).show();
    }

    //ACTIVITY LIFECYCLE METHODS
    @Override
    public void onStart(){
        super.onStart();

        //FOR DEPENDENCY INJECTION
        ((CommentsDVLDemoAppApplication)getApplication()).getObjectGraph().inject(this);
        getCommentsLogic.getComments(this);
    }
}
