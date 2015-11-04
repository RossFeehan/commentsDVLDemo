package com.ross.feehan.commentsdvldemoapp.Data.Objects;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class Comments {

    String comment, commentDate;

    public Comments(String comment, String commentDate){
        setComment(comment);
        setCommentDate(commentDate);
    }

    //Setters
    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    //Getters
    public String getComment() {
        return comment;
    }
    public String getCommentDate() {
        return commentDate;
    }

}
