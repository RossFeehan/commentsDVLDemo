package com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comments;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public interface GetCommentsLogicInterface {

    public void getComments();

    public void receiveComments(List<Comments> comments);

    public void noCommentsYet();

    public void getCommentsFailed();
}
