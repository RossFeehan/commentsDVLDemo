package com.ross.feehan.commentsdvldemoapp.Features.GetComments;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.Features.DisplayComments.DisplayCommentsViewInterface;

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
