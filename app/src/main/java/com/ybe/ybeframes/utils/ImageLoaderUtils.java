package com.ybe.ybeframes.utils;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * Created by hp on 2017/11/13.
 */

public class ImageLoaderUtils {

    /**
     *  初始化 imageloader
     */
    public static void initConfig(Context context){
        ConstantUtils.cache = StorageUtils.getOwnCacheDirectory(context,"imageloader/Cache");
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(context)
                // max width, max height，即保存的每个缓存文件的最大长宽
                .memoryCacheExtraOptions(480,800)
                .diskCache(new UnlimitedDiskCache(ConstantUtils.cache))
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 *1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheExtraOptions(480,320,null)
                // 自定义 缓存路径
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                // connectTimeout连接超时（5s） ，readTimeout 加载超时时间 30s
                .imageDownloader(new BaseImageDownloader(context,5 * 1000,30 * 1000))
                .writeDebugLogs()
                // 开始构建
                .build();
        ImageLoader.getInstance().init(config);
    }

}
