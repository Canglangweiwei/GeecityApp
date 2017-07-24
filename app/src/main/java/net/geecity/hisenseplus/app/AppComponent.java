package net.geecity.hisenseplus.app;

import net.geecity.hisenseplus.ui.DaggerApplication;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerApplication daggerApplication);
}
