package com.ross.feehan.commentsdvldemoapp.Data.Objects;

import java.io.Serializable;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class Comment implements Serializable {

    String comment, commentDate;

    //constructors
    public Comment(){

    }

    public Comment(String comment, String commentDate){
        setComment(comment);
        setCommentDate(commentDate);
    }

    public Comment(String comment){
        setComment(comment);
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
