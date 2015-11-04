package com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces;

import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public interface GetCommentsInterface {

    public void getComments();

    public void registerGetCommentsListener(GetCommentsLogicInterface getCommentsListener);
}
