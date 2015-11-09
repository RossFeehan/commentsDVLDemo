package com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.PostCommentInterface;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.PostCommentViewInterface;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentLogicImpl implements PostCommentsLogicInterface {

    private PostCommentInterface postComment;
    private PostCommentViewInterface postCommentViewListener;
    private static final int CHARACTERCOUNT = 140;

    //Constructor
    public PostCommentLogicImpl(PostCommentInterface postComment){
        this.postComment = postComment;
    }

    /*Method to check that the comment is structured correctly and can be sent on to the
     *Data module to be posted or notify the calling view listener that the structure is wrong
     *@Params Comment comment - The comment to be checked
     */
    @Override
    public void checkComment(Comment comment, PostCommentViewInterface postCommentViewListener) {
        this.postCommentViewListener = postCommentViewListener;

        //if the comment is null or blank notify the post comment view listener
        if(comment.getComment() == null || comment.getComment().isEmpty()){
            this.postCommentViewListener.commentStructuredIncorrectlyBlank();
        }
        else if(comment.getComment().length() > CHARACTERCOUNT){
            this.postCommentViewListener.commentStructuredIncorrectlyCharacterCount();
        }
        //else if the comment is ok, create the comment date and send to the Data module
        else{
            this.postCommentViewListener.displayLoadingProgress();
            //create comment data
            comment.setCommentDate(DateFormat.getDateTimeInstance().format(new Date()));

            //send the comment to the Data module
            postComment.postComment(comment, this);
        }

    }

    /*Method that is called when the comment has been posted, will notiify the post comment view listener
     *@Params boolean commentPostedSuccessfully - If the comment was successfully posted or not
     */
    @Override
    public void commentPosted(boolean commentPostedSuccessfully) {
        //if the comment was successfully posted
        if(commentPostedSuccessfully){
            postCommentViewListener.commentPostedSuccessfully();
        }
        //else something went wrong and the comment wasent posted
        else{
            postCommentViewListener.commentUnsuccessfullyPosted();
        }

        postCommentViewListener.hideLoadingProgress();
    }
}
