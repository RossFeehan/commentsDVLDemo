package com.ross.feehan.commentsdvldemoapp.Utils;

import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.GetCommentsImpl;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations.GetCommentsLogicImpl;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.View.ViewImplementations.DisplayCommentsActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */

@Module(injects =  {CommentsDVLDemoAppApplication.class, DisplayCommentsActivity.class},
        complete = false,
        library = true)
public class LogicDIModules {

    private GetCommentsLogicImpl getCommentsLogic;

    @Provides @Singleton
    public GetCommentsLogicInterface provideGetCommentsLogic(GetCommentsImpl getComments){
        if(getCommentsLogic == null){
            getCommentsLogic = new GetCommentsLogicImpl(getComments);
        }
        return getCommentsLogic;
    }
}
