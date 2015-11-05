package com.ross.feehan.commentsdvldemoapp.Utils;

import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.GetCommentsImpl;
import com.ross.feehan.commentsdvldemoapp.Data.DataImplementations.PostCommentImpl;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations.GetCommentsLogicImpl;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations.PostCommentLogicImpl;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.View.ViewImplementations.DisplayCommentsActivity;
import com.ross.feehan.commentsdvldemoapp.View.ViewImplementations.PostCommentActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */

@Module(injects =  {CommentsDVLDemoAppApplication.class, DisplayCommentsActivity.class,
        PostCommentActivity.class},
        complete = false,
        library = true)
public class LogicDIModules {

    private GetCommentsLogicImpl getCommentsLogic;
    private PostCommentLogicImpl postCommentLogic;

    @Provides @Singleton
    public GetCommentsLogicInterface provideGetCommentsLogic(GetCommentsImpl getComments){
        if(getCommentsLogic == null){
            getCommentsLogic = new GetCommentsLogicImpl(getComments);
        }
        return getCommentsLogic;
    }

    @Provides @Singleton
    public PostCommentsLogicInterface providePostCommentLogicImpl(PostCommentImpl postComment){
        if(postCommentLogic == null){
            postCommentLogic = new PostCommentLogicImpl(postComment);
        }
        return postCommentLogic;
    }
}
