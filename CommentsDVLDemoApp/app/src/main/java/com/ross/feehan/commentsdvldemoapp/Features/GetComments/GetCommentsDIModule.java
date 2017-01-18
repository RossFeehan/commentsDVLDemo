package com.ross.feehan.commentsdvldemoapp.Features.GetComments; /*
 * Created by Ross Feehan on 18/01/2017.
 */

import com.ross.feehan.commentsdvldemoapp.Features.DisplayComments.DisplayCommentsActivity;
import com.ross.feehan.commentsdvldemoapp.Features.DisplayComments.DisplayCommentsViewInterface;
import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = DisplayCommentsActivity.class, complete = false)
public class GetCommentsDIModule {

    private DisplayCommentsViewInterface view;

    //CONSTRUCTOR
    public GetCommentsDIModule(DisplayCommentsViewInterface view) {
        this.view = view;
    }

    @Provides @Singleton
    public GetCommentsDataInterface provideGetCommentsImpl(CommentsSharedPreferences commentsSP){
        return new GetCommentsDataImpl(commentsSP);
    }

    @Provides @Singleton
    public GetCommentsLogicInterface provideGetCommentsLogic(GetCommentsDataInterface getComments){
        return new GetCommentsLogicImpl(getComments, view);
    }
}