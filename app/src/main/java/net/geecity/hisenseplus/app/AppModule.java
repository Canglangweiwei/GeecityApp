package net.geecity.hisenseplus.app;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@SuppressWarnings("ALL")
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
