package com.example.socialconnector;

import ohos.aafwk.ability.AbilityForm;
import ohos.aafwk.ability.OnClickListener;
import ohos.aafwk.ability.ViewsStatus;
import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.AttrSet;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.agp.render.opengl.Utils;
import ohos.agp.render.render3d.Component;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.global.resource.Resource;
import ohos.global.resource.ResourceManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.media.image.PixelMap;

import java.io.IOException;
import java.util.Optional;


public class SocailConnect extends Image {

    private static final String TAG = SocailConnect.class.getSimpleName();

    private static final int DOMAIN = 0xD000100;

    private static final HiLogLabel LABEL = new HiLogLabel(
            HiLog.LOG_APP, DOMAIN, TAG);

    private static final String DEFAULT_SOCIAL = "facebook";

    private int imageType = 0;

    private Optional<PixelMap> pixelMapping;

    public SocailConnect(Context context) {
        super(context);
    }

    public SocailConnect(Context context, AttrSet attrSet) {
        super(context, attrSet);
        initAttr(attrSet);
    }

    private void initAttr(AttrSet attrSet) {
        checkImagetype();
    }

    private void checkImagetype() {
        switch (imageType) {
            case 0:
                pixelMapping = getPixelMapByResId(ResourceTable.Media_facebook);
                break;
            case 1:
                pixelMapping = getPixelMapByResId(ResourceTable.Media_whatsapp);
                break;
            case 2:
                pixelMapping = getPixelMapByResId(ResourceTable.Media_Twitter);
                break;
            case 3:
                pixelMapping = getPixelMapByResId(ResourceTable.Media_LinkedIN);
                break;
            default:
                pixelMapping = getPixelMapByResId(ResourceTable.Media_facebook);
        }
    }

    private Optional<PixelMap> getPixelMapByResId(final int resourceId) {
        final ResourceManager resourceManager = getContext().getResourceManager();
        Optional<PixelMap> pixelMappingOptional = Optional.empty();
        if (resourceManager == null) {
            return Optional.empty();
        }
        try (Resource resource = resourceManager.getResource(resourceId)) {
            if (resource == null) {
                HiLog.error(LABEL, "get pixelmap failed, get resource by id is null");
                return Optional.empty();
            }
            pixelMappingOptional = Util.preparePixelmap(resource);
        } catch (NotExistException e) {
            HiLog.error(LABEL, "close output failed NotExistException");
        } catch (IOException e) {
            HiLog.error(LABEL, "close output failed IOException");
        }
        return pixelMappingOptional;
    }


}
