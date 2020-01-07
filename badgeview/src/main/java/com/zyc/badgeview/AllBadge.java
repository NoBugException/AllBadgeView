package com.zyc.badgeview;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;

public interface AllBadge {

    AllBadge setBadgeNumber(int badgeNum);//设置角标数字

    int getBadgeNumber();//获取角标数字

    AllBadge setBadgeText(String badgeText);//设置角标文字

    String getBadgeText();//获取角标文字

    AllBadge setExactMode(boolean isExact);//设置精准模式，true：如果角标数字是100，则显示100  false：如果角标数字是100，则显示99+

    boolean isExactMode();//获取精准模式，默认为false

    AllBadge setShowShadow(boolean showShadow);//设置阴影效果开关 true：打开阴影效果 false：关闭阴影效果  默认为false

    boolean isShowShadow();//获取阴影效果开关

    AllBadge setBadgeBackgroundColor(int color);//设置角标背景色，默认为红色

    int getBadgeBackgroundColor();//获取背景色

    AllBadge setBadgeBackground(Drawable drawable);//设置角标背景色，默认为红色

    AllBadge setBadgeBackground(Drawable drawable, boolean clip);//设置角标背景色，默认为红色，clip：是否对drawable进行修剪

    Drawable getBadgeBackground();//获取背景色

    AllBadge setBadgeTextColor(int color);//设置角标文字颜色，默认为白色

    int getBadgeTextColor();//获取角标文字颜色

    AllBadge stroke(int color, float width, boolean isDpValue);//添加描边 color：描边颜色 width：描边宽度 isDpValue：宽度单位是否是db

    AllBadge setBadgeTextSize(float size, boolean isSpValue);//设置字体大小 isSpValue：字体大小单位是否是sp

    float getBadgeTextSize(boolean isSpValue);//获取字体大小

    AllBadge setBadgePadding(float padding, boolean isDpValue);//设置padding

    float getBadgePadding(boolean isDpValue);//获取padding

    AllBadge setOnDragStateChangedListener(OnDragStateChangedListener l);//设置拖拽监听，默认拖拽无效，只有设置了监听拖拽功能才生效

    boolean isDraggable();//是否设置了拖拽监听，如果设置了setOnDragStateChangedListener监听方法，则默认可以拖拽

    AllBadge setBadgeGravity(int gravity);//设置角标的位置，默认为Gravity.END | Gravity.TOP

    int getBadgeGravity();//获取角标的位置

    AllBadge setGravityOffset(float offset, boolean isDpValue);//设置角标的偏移量 offset：x、y轴方向偏移量  isDpValue：是否是dp单位

    AllBadge setGravityOffset(float offsetX, float offsetY, boolean isDpValue);//设置角标的偏移量 offsetX：x轴方向偏移量 offsetY：y轴方向偏移量 isDpValue：是否是dp单位

    float getGravityOffsetX(boolean isDpValue);//获取x轴方向的偏移量

    float getGravityOffsetY(boolean isDpValue);//获取y轴方向的偏移量

    PointF getDragCenter();//获取拖拽事件的触摸位置

    AllBadge bindTarget(View view);//角标的存在必须依赖view，如果不设置bindTarget，则BadgeView无法使用

    View getTargetView();//获取角标依赖的view

    void hide(boolean animate);//将角标隐藏 animate：是否开启隐藏时动画

    /**
     * 拖拽状态
     */
    interface OnDragStateChangedListener {
        int STATE_START = 1;
        int STATE_DRAGGING = 2;
        int STATE_DRAGGING_OUT_OF_RANGE = 3;
        int STATE_CANCELED = 4;
        int STATE_SUCCEED = 5;

        void onDragStateChanged(int dragState, AllBadge badge, View targetView);
    }
}
