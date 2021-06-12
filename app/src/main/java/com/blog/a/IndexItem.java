package com.blog.a;

import com.blog.a.activitytransition.IndexActivity;
import com.blog.a.anim.LottieActivity;
import com.blog.a.anim.VectorAnimActivity;
import com.blog.a.drag.ViewDragActivity;
import com.blog.a.nested.NestedScrollActivity;

public class IndexItem {

    static final String[] ITEMS = new String[] {
            "嵌套滑动栗子",
            "可拖拽ViewDragHelper",
            "回弹效果RecyclerView",
            "矢量可绘制对象",
            "Activity过渡动画",
            "Lottie动画"
    };

    static final Class[] CLASS = new Class[] {
            NestedScrollActivity.class,
            ViewDragActivity.class,
            null,
            VectorAnimActivity.class,
            IndexActivity.class,
            LottieActivity.class
    };

    static final String[] TOAST = new String[] {
            "",
            "",
            "当前页带回弹效果!",
            "",
            "",
            ""
    };

}
