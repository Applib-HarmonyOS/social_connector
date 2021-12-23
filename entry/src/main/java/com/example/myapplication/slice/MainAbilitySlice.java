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

        SocailConnect s = (SocailConnect) findComponentById(ResourceTable.Id_image1);

        s.setContext(this);

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
