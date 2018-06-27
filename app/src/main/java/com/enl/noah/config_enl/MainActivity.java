package com.enl.noah.config_enl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    @BindView(R.id.tv_move_everywhere)
    TextView tvMoveEverywhere;
    @BindView(R.id.rl_father)
    RelativeLayout rlFather;
    private ViewGroup rl_father;
    private TextView tv_move_everywhere;


    // 获取屏幕的宽高
    private DisplayMetrics dm;
    private int screenWith;
    private int screenHeight;
    private int lastX;
    private int lastY;
    private boolean isDraging = false;
    private String TAG = "组态";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rl_father = findViewById(R.id.rl_father);
        tv_move_everywhere = findViewById(R.id.tv_move_everywhere);
        dm = getResources().getDisplayMetrics();
        screenWith = dm.widthPixels;
        screenHeight = dm.heightPixels;
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.leftMargin = 250;
        layoutParams.topMargin = 650;

        tv_move_everywhere.setLayoutParams(layoutParams);
        tv_move_everywhere.setOnTouchListener(this);
    }


    private boolean isIntercept = false;
    /**
     * 按下时的位置控件相对屏幕左上角的位置X
     */
    private int startDownX;
    /**
     * 按下时的位置控件距离屏幕左上角的位置Y
     */
    private int startDownY;
    /**
     * 控件相对屏幕左上角移动的位置X
     */
    private int lastMoveX;

    /**
     * 控件相对屏幕左上角移动的位置Y
     */
    private int lastMoveY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int ee = event.getAction();
        switch (ee) {
            case MotionEvent.ACTION_DOWN:
                startDownX = lastMoveX = (int) event.getRawX();
                startDownY = lastMoveY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getRawX() - lastMoveX;
                int dy = (int) event.getRawY() - lastMoveY;

                int left = v.getLeft() + dx;
                int top = v.getTop() + dy;
                int right = v.getRight() + dx;
                int bottom = v.getBottom() + dy;
                if (left < 0) {
                    left = 0;
                    right = left + v.getWidth();
                }
                if (right > screenWith) {
                    right = screenWith;
                    left = right - v.getWidth();
                }
                if (top < 0) {
                    top = 0;
                    bottom = top + v.getHeight();
                }
                if (bottom > screenHeight - 300) {
                    bottom = screenHeight - 300;
                    top = bottom - v.getHeight();
                }
                v.layout(left, top, right, bottom);
                lastMoveX = (int) event.getRawX();
                lastMoveY = (int) event.getRawY();
                break;

            case MotionEvent.ACTION_UP:
                // 每次移动都要设置其layout，不然当父布局发生改变冲毁（添加控件）则移动的view会回到原来的位置
                RelativeLayout.LayoutParams lpFeedback = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                lpFeedback.leftMargin = v.getLeft();
                lpFeedback.topMargin = v.getTop();
                showLog("设置位置" + v.getLeft() + "----" + v.getTop());
                lpFeedback.setMargins(v.getLeft(), v.getTop(), 0, 0);
                v.setLayoutParams(lpFeedback);
                break;
            default:
                break;
        }
        return true;
    }

    int i = 0;

    @OnClick({R.id.tv_add_textView, R.id.tv_add_button, R.id.tv_add_imageView, R.id.tv_add_other})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add_textView:
                showLog("添加文本");
                TextView textView = new TextView(this);
                i++;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                textView.setText("文本" + i);
                textView.setTextSize(30);
                textView.setOnTouchListener(this);
                rl_father.addView(textView, layoutParams);
                break;
            case R.id.tv_add_button:
                showLog("添加按钮");
                Button button = new Button(this);
                i++;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams2.topMargin = 0;
                layoutParams2.leftMargin = 0;
                button.setText("按钮" + i);
                button.setTextSize(25);
                button.setOnTouchListener(this);
                rl_father.addView(button, layoutParams2);
                break;
            case R.id.tv_add_imageView:
                break;
            case R.id.tv_add_other:
                break;
        }
    }

    private void showLog(String s) {
        Log.i(TAG, s);
    }
}
