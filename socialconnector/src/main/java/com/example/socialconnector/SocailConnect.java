package com.example.socialconnector;

import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.Image;


public class SocailConnect {

    AnimatorProperty animatorProperty;


    public void onClick(Image img) {
        animatorProperty = img.createAnimatorProperty();
        animatorProperty.rotate(360).setDuration(500).setDelay(1500).setLoopedCount(2);
        animatorProperty.start();
    }
}
