package br.com.faru.a99challenge.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import br.com.faru.a99challenge.di.Injector;
import br.com.faru.a99challenge.di.component.DaggerChallengeComponent;

public class ChallengeApplication extends Application {

    public static ChallengeApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .setDownsampleEnabled(true)
                .build();

        Fresco.initialize(this, config);

        Injector.initialize(DaggerChallengeComponent.builder().build());
    }

    public static ChallengeApplication getApplication() {
        return application;
    }

}
