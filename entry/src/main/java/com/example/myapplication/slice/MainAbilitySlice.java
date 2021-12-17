package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.Component;
import ohos.agp.components.Image;



public class MainAbilitySlice extends AbilitySlice {

    AnimatorProperty animatorProperty;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Image facebook = (Image) findComponentById(ResourceTable.Id_facebook);
        Image whatsapp = (Image) findComponentById(ResourceTable.Id_whatsapp);
        Image linkedin = (Image) findComponentById(ResourceTable.Id_linkedin);
        Image github = (Image) findComponentById(ResourceTable.Id_github);


        facebook.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                animatorProperty = facebook.createAnimatorProperty();
                animatorProperty.rotate(360).setDuration(500).setDelay(500).setLoopedCount(2);
                animatorProperty.start();
            }
        });
        whatsapp.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                animatorProperty = whatsapp.createAnimatorProperty();
                animatorProperty.rotate(360).setDuration(500).setDelay(500).setLoopedCount(2);
                animatorProperty.start();
            }
        });
        linkedin.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                animatorProperty = linkedin.createAnimatorProperty();
                animatorProperty.rotate(360).setDuration(500).setDelay(500).setLoopedCount(2);
                animatorProperty.start();
            }
        });
        github.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                animatorProperty = github.createAnimatorProperty();
                animatorProperty.rotate(360).setDuration(500).setDelay(500).setLoopedCount(2);
                animatorProperty.start();
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
