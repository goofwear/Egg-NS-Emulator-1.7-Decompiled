package s.h.e.l.l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import java.io.File;

@TargetApi(28)
public final class A extends AppComponentFactory {
    private AppComponentFactory acf = null;
    private AppComponentFactory orignACF = null;
    private String orignAppName = "io.switchdroid.NSApplication";
    private String orignName = "androidx.core.app.CoreComponentFactory";
    private String packageName = "com.xiaoji.gamesirnsemulator";
    private boolean supportInstantiateClassLoader = false;

    public static native ClassLoader al(ClassLoader classLoader, ApplicationInfo applicationInfo, String str, String str2);

    public synchronized AppComponentFactory getACF(ClassLoader classLoader) {
        if (this.acf == null && this.orignName != null && !this.orignName.equals("")) {
            try {
                this.acf = (AppComponentFactory) classLoader.loadClass(this.orignName).newInstance();
            } catch (Exception e) {
            }
        }
        return this.acf;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (S.l) {
            AppComponentFactory acf2 = getACF(classLoader);
            this.acf = acf2;
            if (acf2 != null) {
                return this.acf.instantiateActivity(classLoader, str, intent);
            }
        }
        return super.instantiateActivity(classLoader, str, intent);
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (this.supportInstantiateClassLoader && str.equals("s.h.e.l.l.S")) {
            str = this.orignAppName;
        } else if (S.l) {
            AppComponentFactory acf2 = getACF(classLoader);
            this.acf = acf2;
            if (acf2 != null) {
                return this.acf.instantiateApplication(classLoader, str);
            }
        }
        return super.instantiateApplication(classLoader, str);
    }

    @TargetApi(29)
    public ClassLoader instantiateClassLoader(ClassLoader classLoader, ApplicationInfo applicationInfo) {
        if (!this.supportInstantiateClassLoader) {
            File file = new File(applicationInfo.dataDir, "files");
            if (!file.exists()) {
                file.mkdirs();
            }
            S.p = file.getAbsolutePath();
            S.f = applicationInfo.sourceDir;
            S.l(null);
            classLoader = N.al(classLoader, applicationInfo, this.packageName, this.orignAppName);
            applicationInfo.className = this.orignAppName;
            this.supportInstantiateClassLoader = true;
        }
        if (S.l) {
            this.acf = getACF(classLoader);
            if (this.acf != null) {
                return this.acf.instantiateClassLoader(classLoader, applicationInfo);
            }
        }
        return super.instantiateClassLoader(classLoader, applicationInfo);
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader classLoader, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (S.l) {
            AppComponentFactory acf2 = getACF(classLoader);
            this.acf = acf2;
            if (acf2 != null) {
                return this.acf.instantiateProvider(classLoader, str);
            }
        }
        return super.instantiateProvider(classLoader, str);
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (S.l) {
            AppComponentFactory acf2 = getACF(classLoader);
            this.acf = acf2;
            if (acf2 != null) {
                return this.acf.instantiateReceiver(classLoader, str, intent);
            }
        }
        return super.instantiateReceiver(classLoader, str, intent);
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (S.l) {
            AppComponentFactory acf2 = getACF(classLoader);
            this.acf = acf2;
            if (acf2 != null) {
                return this.acf.instantiateService(classLoader, str, intent);
            }
        }
        return super.instantiateService(classLoader, str, intent);
    }
}
