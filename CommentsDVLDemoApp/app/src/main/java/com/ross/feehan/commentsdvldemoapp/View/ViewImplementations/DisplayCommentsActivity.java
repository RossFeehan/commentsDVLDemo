package com.ross.feehan.commentsdvldemoapp.View.ViewImplementations;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.R;
import com.ross.feehan.commentsdvldemoapp.Utils.CommentsDVLDemoAppApplication;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.DisplayCommentsViewInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisplayCommentsActivity extends AppCompatActivity implements DisplayCommentsViewInterface {

    @Bind(R.id.toolbar) Toolbar toolbar;
    //DI INJECT
    @Inject  GetCommentsLogicInterface getCommentsLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_comments_view);

        //FOR DEPENDENCY INJECTION
        ((CommentsDVLDemoAppApplication)getApplication()).getObjectGraph().inject(this);
        //FOR BUTTERKNIFE
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        //getCommentsLogic.getComments(this);
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
        Toast.makeText(this, "Display Progress", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoadingProgress() {
        Toast.makeText(this, "Hide Progress", Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayComments(List<Comment> comments) {
        Toast.makeText(this, "Display Comments", Toast.LENGTH_LONG).show();
    }

    @Override
    public void noCommentsYet() {
        Toast.makeText(this, "No Comments Yet", Toast.LENGTH_LONG).show();
    }

    @Override
    public void getCommentsFailed() {
        Toast.makeText(this, "Getting Comments Failed", Toast.LENGTH_LONG).show();
    }
}
