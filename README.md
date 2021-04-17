## 嵌套滑动

CompNsViewGroup的XML内用法如下，NestedViewGroup内部包含顶部地图MapView和滑动布局LinearLayout，而LinearLayout布局的内部即我们常用的滑动控件RecyclerView，这里为何还要加层 LinearLayout呢？这样做的好处是，我们可以更好的适配不同滑动控件，而不仅仅是将CompNsViewGroup与RecyclerView耦合住。

```java
    <com.blog.a.nested.NestedViewGroup
        android:id="@+id/dd_view_group"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        didi:header_id="@+id/t_map_view"
        didi:target_id="@+id/target_layout"
        didi:inn_id="@+id/inner_rv"
        didi:header_init_top="0"
        didi:target_init_bottom="250">

        <com.tencent.tencentmap.mapsdk.maps.MapView
            android:id="@+id/t_map_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

        <LinearLayout
            android:id="@+id/target_layout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:background="#fff">

            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/inner_rv"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>

        </LinearLayout>

    </com.blog.a.nested.NestedViewGroup>
```

这是demo效果，[我的博客地址](https://juejin.cn/post/6951069336412880933)。

<p align="left">
  <img width="260" height="503" src="https://img-blog.csdnimg.cn/20210115193238444.gif">
</p>

## ViewDragHelper

这是demo实现效果，可自由拖拽的view，不需要自己再造轮子啦，使用系统androidx包（原v4）下的ViewDragHelper 几行代码即可搞定。
[我的博客地址](https://juejin.cn/post/6952062595767468039)。

<p align="left">
  <img width="260" height="231" src="https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e96c59a64544466aba3f8aa95605e6e4~tplv-k3u1fbpfcp-watermark.image">
</p>
