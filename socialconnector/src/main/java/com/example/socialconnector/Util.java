package com.example.socialconnector;

import ohos.global.resource.Resource;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.media.image.ImageSource;
import ohos.media.image.PixelMap;
import ohos.media.image.common.PixelFormat;
import ohos.media.image.common.Rect;
import ohos.media.image.common.Size;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

public class Util {

    private static final int BUFFER_SIZE = 1024;

    private static final int HILOG_TYPE = 3;

    private static final int HILOG_DOMAIN = 0xD000F00;

    private static final HiLogLabel LABEL = new HiLogLabel(HILOG_TYPE, HILOG_DOMAIN, "[Utils]");

    private Util() {
    }

    public static Optional<PixelMap> preparePixelmap(final Resource resource) {
        byte[] bytes = null;
        try {
            if (resource != null) {
                bytes = readBytes(resource);
                resource.close();
            }
        } catch (IOException e) {
            HiLog.error(LABEL, "get pixelmap failed, read resource bytes failed");
        }
        final ImageSource.SourceOptions srcOpts = new ImageSource.SourceOptions();
        final ImageSource imageSource = ImageSource.create(bytes, srcOpts);
        if (imageSource == null) {
            HiLog.error(LABEL, "get pixelmap failed, image source is null");
        }
        final ImageSource.DecodingOptions decodingOpts = new ImageSource.DecodingOptions();
        decodingOpts.desiredSize = new Size(0, 0);
        decodingOpts.desiredRegion = new Rect(0, 0, 0, 0);
        decodingOpts.desiredPixelFormat = PixelFormat.ARGB_8888;
        PixelMap decodePixelMap = null;
        if (imageSource != null) {
            decodePixelMap = imageSource.createPixelmap(decodingOpts);
        }
        return Optional.ofNullable(decodePixelMap);
    }

    private static byte[] readBytes(final Resource resource) {
        final int ioEnd = -1;

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        final byte[] bytes = new byte[BUFFER_SIZE];
        byte[] bytesArray;
        while (true) {
            try {
                final int readLen = resource.read(bytes, 0, BUFFER_SIZE);
                if (readLen == ioEnd) {
                    bytesArray = output.toByteArray();
                    break;
                }
                output.write(bytes, 0, readLen);
            } catch (IOException e) {
                HiLog.error(LABEL, "close output failed IOException");
            } finally {
                try {
                    output.close();
                } catch (IOException e) {
                    HiLog.error(LABEL, "close output failed");
                }
            }
        }
        return bytesArray;
    }
}
