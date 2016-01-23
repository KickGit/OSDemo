package net.oschinademo.app.osdemo.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

import net.oschinademo.app.osdemo.BuildConfig;
import net.oschinademo.app.osdemo.api.ApiHttpClient;
import net.oschinademo.app.osdemo.base.BaseApplication;

import org.kymjs.kjframe.http.HttpConfig;
import org.kymjs.kjframe.utils.KJLoger;

/**
 * 全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 *
 * @author 火蚁 (http://my.oschina.net/LittleDY)
 * @version 1.0
 * @created 2014-04-22
 */
public class AppContext extends BaseApplication {
    public static final int PAGE_SIZE = 20;// 默认分页大小

    private static AppContext instance;

    private int loginUid;

    private boolean login;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
        initLogin();
    }

    private void initLogin() {

    }

    private void init() {
        //初始化网络请求：
        AsyncHttpClient client = new AsyncHttpClient();
        PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
        client.setCookieStore(myCookieStore);
        ApiHttpClient.setHttpClient(client);
        ApiHttpClient.setCookie(ApiHttpClient.getCookie(this));

        //Log控制器
        KJLoger.openDebutLog(true);
        TLog.DEBUG = BuildConfig.DEBUG;

        //Bitmap 缓存地址
        HttpConfig.CACHEPATH = "OSChina/myimagecache";
    }
}
