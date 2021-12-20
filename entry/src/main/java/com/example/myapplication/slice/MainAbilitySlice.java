package com.example.myapplication.slice;

import com.example.myapplication.ResourceTable;
import com.example.socialconnector.SocailConnect;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.IntentAbility;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.animation.Animator;
import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.utils.net.Uri;
import java.util.Set;


public class MainAbilitySlice extends AbilitySlice {

    AnimatorProperty animatorProperty;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Image facebook = (Image) findComponentById(ResourceTable.Id_facebook);
        Image whatsapp = (Image) findComponentById(ResourceTable.Id_whatsapp);
        Image linkedin = (Image) findComponentById(ResourceTable.Id_linkedin);
        Image github   = (Image) findComponentById(ResourceTable.Id_github);

        SocailConnect ob= new SocailConnect();


        facebook.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                ob.onClick(facebook);
            }
        });
        whatsapp.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                ob.onClick(whatsapp);
            }
        });
        linkedin.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                ob.onClick(linkedin);
            }
        });
        github.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                ob.onClick(github);
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
