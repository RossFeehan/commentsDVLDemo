package com.ross.feehan.commentsdvldemoapp.View.ViewImplementations;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.R;
import com.ross.feehan.commentsdvldemoapp.Utils.CommentsDVLDemoAppApplication;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.PostCommentViewInterface;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentActivity extends Activity implements PostCommentViewInterface {

    @Bind(R.id.commentET) protected EditText commentET;
    @Bind(R.id.progressBar) protected RelativeLayout progressBarLayout;
    @Bind(R.id.postCommentFAB) FloatingActionButton postCommentFAB;
    @Inject PostCommentsLogicInterface postComment;
    @Inject Comment comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comment_view);

        //FOR DEPENDENCY INJECTION
        ((CommentsDVLDemoAppApplication)getApplication()).getObjectGraph().inject(this);
        //FOR BUTTERKNIFE
        ButterKnife.bind(this);

        postCommentFAB.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.postCommentFAB)
    protected void onPostCommentFABClicked(){
        comment.setComment(commentET.getText().toString());

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(commentET.getWindowToken(), 0);

        postComment.checkComment(comment, this);
    }

    //PostCommentViewInterface METHODS
    @Override
    public void displayLoadingProgress() {
        progressBarLayout.setVisibility(View.VISIBLE);
        postCommentFAB.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideDisplayProgress() {
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
