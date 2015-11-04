package com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public interface GetCommentsLogicInterface {

    public void getComments();

    public void receiveComments(List<Comment> comments);

    public void getCommentsFailed();
}
