package com.ross.feehan.commentsdvldemoapp.Features.PostComments;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentLogicImpl implements PostCommentLogicInterface {

    private PostCommentDataInterface postCommentData;
    private PostCommentViewInterface view;
    private static final int CHARACTERCOUNT = 140;

    //Constructor
    public PostCommentLogicImpl(PostCommentDataInterface postComment, PostCommentViewInterface view){
        this.postCommentData = postComment;
        this.view = view;
    }

    /*Method to check that the comment is structured correctly and can be sent on to the
     *Data module to be posted or notify the calling view listener that the structure is wrong
     *@Params Comment comment - The comment to be checked
     */
    @Override
    public void checkComment(Comment comment) {

        //if the comment is null or blank notify the post comment view listener
        if(comment.getComment() == null || comment.getComment().isEmpty()){
            this.view.commentStructuredIncorrectlyBlank();
        }
        else if(comment.getComment().length() > CHARACTERCOUNT){
            this.view.commentStructuredIncorrectlyCharacterCount();
        }
        //else if the comment is ok, create the comment date and send to the Data module
        else{
            this.view.displayLoadingProgress();
            //create comment data
            comment.setCommentDate(DateFormat.getDateTimeInstance().format(new Date()));

            //send the comment to the Data module
            postCommentData.postComment(comment, this);
        }

    }

    /*Method that is called when the comment has been posted, will notiify the post comment view listener
     *@Params boolean commentPostedSuccessfully - If the comment was successfully posted or not
     */
    @Override
    public void commentPosted(boolean commentPostedSuccessfully) {
        //if the comment was successfully posted
        if(commentPostedSuccessfully){
            view.commentPostedSuccessfully();
        }
        //else something went wrong and the comment wasent posted
        else{
            view.commentUnsuccessfullyPosted();
        }

        view.hideLoadingProgress();
    }
}