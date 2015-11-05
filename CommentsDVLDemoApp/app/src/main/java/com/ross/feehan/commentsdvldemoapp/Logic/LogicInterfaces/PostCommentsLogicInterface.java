package com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public interface PostCommentsLogicInterface {

    public void checkComment(Comment comment);

    public void commentPosted(boolean commentPostedSuccessfully);
}
