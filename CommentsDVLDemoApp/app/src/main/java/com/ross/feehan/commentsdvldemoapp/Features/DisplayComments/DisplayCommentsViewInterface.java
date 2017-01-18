package com.ross.feehan.commentsdvldemoapp.Features.DisplayComments;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.Shared.Interfaces.ViewInterface;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public interface DisplayCommentsViewInterface extends ViewInterface {

    public void displayComments(List<Comment> comments);

    public void noCommentsYet();

    public void getCommentsFailed();


}
