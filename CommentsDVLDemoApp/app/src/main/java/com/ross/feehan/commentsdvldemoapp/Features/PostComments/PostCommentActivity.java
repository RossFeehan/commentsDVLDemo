package com.ross.feehan.commentsdvldemoapp.Features.PostComments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.R;
import com.ross.feehan.commentsdvldemoapp.Shared.CommentsDVLDemoAppApplication;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentActivity extends AppCompatActivity implements PostCommentViewInterface {

    @Inject PostCommentLogicInterface postComment;

    @Bind(R.id.commentET) protected EditText commentET;
    @Bind(R.id.progressBar) protected RelativeLayout progressBarLayout;
    @Bind(R.id.toolbar) protected Toolbar toolbar;
    @Bind(R.id.postCommentFAB) FloatingActionButton postCommentFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUi();
        setupDependencies();
    }

    private void setupUi() {
        setContentView(R.layout.post_comment_view);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.postComment));
        postCommentFAB.setVisibility(View.VISIBLE);
    }

    //FOR DEPENDENCY INJECTION
    private void setupDependencies() {
        ((CommentsDVLDemoAppApplication)getApplication()).getObjectGraph().plus(new PostCommentDIModule(this)).inject(this);
    }

    @OnClick(R.id.postCommentFAB)
    protected void onPostCommentFABClicked(){
        Comment comment = new Comment();
        comment.setComment(commentET.getText().toString());

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(commentET.getWindowToken(), 0);

        postComment.checkComment(comment);
    }

    //PostCommentViewInterface METHODS
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

    @Override
    public void commentPostedSuccessfully() {
        Toast.makeText(this, "Comment Posted Successfully", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void commentUnsuccessfullyPosted() {
        Toast.makeText(this, "Comment Unsuccessfully Posted, please try again", Toast.LENGTH_LONG).show();
    }

    @Override
    public void commentStructuredIncorrectlyBlank() {
        Toast.makeText(this, "Comment Blank, please try again", Toast.LENGTH_LONG).show();
    }

    @Override
    public void commentStructuredIncorrectlyCharacterCount() {
        Toast.makeText(this, "Comment Over Word Count, please try again", Toast.LENGTH_LONG).show();
    }
}