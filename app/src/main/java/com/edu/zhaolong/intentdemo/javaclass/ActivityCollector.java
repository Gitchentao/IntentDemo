package com.edu.zhaolong.intentdemo.javaclass;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动管理器
 * Created by CHEN on 2017/5/13.
 */

public class ActivityCollector {

    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityList) {

            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
