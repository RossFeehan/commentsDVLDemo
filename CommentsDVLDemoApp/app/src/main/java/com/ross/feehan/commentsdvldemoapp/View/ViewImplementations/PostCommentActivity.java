package com.ross.feehan.commentsdvldemoapp.View.ViewImplementations;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.R;
import com.ross.feehan.commentsdvldemoapp.Utils.CommentsDVLDemoAppApplication;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.PostCommentViewInterface;

import javax.inject.Inject;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentActivity extends Activity implements PostCommentViewInterface {

    @Inject PostCommentsLogicInterface postComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comment_view);

        //FOR DEPENDENCY INJECTION
        ((CommentsDVLDemoAppApplication)getApplication()).getObjectGraph().inject(this);

        
    }

    //PostCommentViewInterface METHODS
    @Override
    public void displayLoadingProgress() {
        Toast.makeText(this, "Display Progress", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideDisplayProgress() {
        Toast.makeText(this, "Hide Progress", Toast.LENGTH_LONG).show();
    }

    @Override
    public void commentPostedSuccessfully() {
        Toast.makeText(this, "Comment Posted Successfully", Toast.LENGTH_LONG).show();
    }

    @Override
    public void commentUnsuccessfullyPosted() {
        Toast.makeText(this, "Comment Unsuccessfully Posted", Toast.LENGTH_LONG).show();
    }

    @Override
    public void commentStructuredIncorrectlyBlank() {
        Toast.makeText(this, "Comment Blank", Toast.LENGTH_LONG).show();
    }

    @Override
    public void commentStructuredIncorrectlyCharacterCount() {
        Toast.makeText(this, "Comment Over Word Count", Toast.LENGTH_LONG).show();
    }
}