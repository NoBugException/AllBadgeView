package com.zyc.allbadgeview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.zyc.badgeview.AllBadge;
import com.zyc.badgeview.AllBadgeView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = findViewById(R.id.imageview);

        final AllBadgeView allBadgeView = new AllBadgeView(this);
        allBadgeView.bindTarget(imageview)//绑定一个view
                .setBadgeNumber(100)//设置角标数字
                //.setExactMode(true)//设置精准模式，true：如果角标数字是100，则显示100 false：如果角标数字是100，则显示99+
                //.setBadgeBackgroundColor(Color.parseColor("#fff000"))//设置背景颜色
                //.setBadgeBackground(getResources().getDrawable(R.drawable.shape_round_rect))//设置背景
                //.setBadgeText("中国")//设置角标文字，设置文字之后就不会显示数字了
                //.setBadgeTextColor(Color.BLACK)//设置角标文字的颜色
                //.setShowShadow(true)//阴影效果开关
                .setBadgeBackground(getResources().getDrawable(R.drawable.shape_round_rect), true)//设置角标背景色，默认为红色，clip：是否对drawable进行修剪
                //.stroke(Color.parseColor("#fff000"), 10, false)//添加描边 color：描边颜色 width：描边宽度 isDpValue：宽度单位是否是db
                //.setBadgeTextSize(30, false)//设置字体大小 isSpValue：字体大小单位是否是sp
                //.setBadgePadding(10, false)//设置padding
                .setBadgeGravity(Gravity.CENTER | Gravity.END)//设置角标的位置，默认为Gravity.END | Gravity.TOP
                .setGravityOffset(100 , true)//设置角标的偏移量 offset：x、y轴方向偏移量  isDpValue：是否是dp单位
                .setOnDragStateChangedListener(new AllBadge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, AllBadge badge, View targetView) {
                        switch (dragState){
                            case AllBadge.OnDragStateChangedListener.STATE_START:
                                Log.d("aaa", "开始拖拽");
                                break;
                            case AllBadge.OnDragStateChangedListener.STATE_DRAGGING:
                                Log.d("aaa", "拖拽中...");
                                break;
                            case AllBadge.OnDragStateChangedListener.STATE_DRAGGING_OUT_OF_RANGE:
                                Log.d("aaa", "拖拽出view范围");
                                break;
                            case AllBadge.OnDragStateChangedListener.STATE_CANCELED:
                                Log.d("aaa", "取消拖拽");
                                break;
                            case AllBadge.OnDragStateChangedListener.STATE_SUCCEED:
                                Log.d("aaa", "成功拖拽");
                                break;
                        }
                    }
                });


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allBadgeView.hide(true);
            }
        });
    }
}
