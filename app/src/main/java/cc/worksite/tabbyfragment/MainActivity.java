package cc.worksite.tabbyfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private LinearLayout tabHome;
    private LinearLayout tabRelease;
    private LinearLayout tabInfo;
    private LinearLayout tabMine;

    private ImageButton imgHome;
    private ImageButton imgRelease;
    private ImageButton imgInfo;
    private ImageButton imgMine;

    private Fragment homeFragment;
    private Fragment releaseFragment;
    private Fragment infoFragment;
    private Fragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }


    /**
     * 初始化控件
     */
    private void initView() {
        tabHome = (LinearLayout) findViewById(R.id.home_ll);
        tabRelease = (LinearLayout) findViewById(R.id.release_ll);
        tabInfo = (LinearLayout) findViewById(R.id.info_ll);
        tabMine = (LinearLayout) findViewById(R.id.mine_ll);

        imgHome = (ImageButton) findViewById(R.id.home_imgb);
        imgRelease = (ImageButton) findViewById(R.id.release_imgb);
        imgInfo = (ImageButton) findViewById(R.id.info_imgb);
        imgMine = (ImageButton) findViewById(R.id.mine_imgb);

    }

    /**
     * 给控件添加事件
     */
    private void initEvent() {
        tabHome.setOnClickListener(this);
        tabRelease.setOnClickListener(this);
        tabInfo.setOnClickListener(this);
        tabMine.setOnClickListener(this);
    }

    /**
     * 将所有图片打回原形
     */

    private void resetImg() {
        imgHome.setImageResource(R.mipmap.home_nor);
        imgRelease.setImageResource(R.mipmap.release_nor);
        imgInfo.setImageResource(R.mipmap.info_nor);
        imgMine.setImageResource(R.mipmap.mine_nor);

    }

    private void setSelect(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                imgHome.setImageResource(R.mipmap.home_select);

                break;
            case 1:
                if (releaseFragment == null) {
                    releaseFragment = new ReleaseFragment();
                    transaction.add(R.id.content, releaseFragment);

                } else {
                    transaction.show(releaseFragment);
                }
                imgRelease.setImageResource(R.mipmap.release_select);

                break;
            case 2:
                if (infoFragment == null) {
                    infoFragment = new InfoFragment();
                    transaction.add(R.id.content, infoFragment);

                } else {
                    transaction.show(infoFragment);
                }
                imgInfo.setImageResource(R.mipmap.info_select);

                break;
            case 3:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content, mineFragment);

                } else {
                    transaction.show(mineFragment);
                }
                imgMine.setImageResource(R.mipmap.mine_select);

                break;
        }
        transaction.commit();

    }

    @Override
    public void onClick(View view) {
        resetImg();
        switch (view.getId()) {
            case R.id.home_ll:
                setSelect(0);
                break;
            case R.id.release_ll:
                setSelect(1);
                break;
            case R.id.info_ll:
                setSelect(2);
                break;
            case R.id.mine_ll:
                setSelect(3);
                break;
        }

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (releaseFragment != null) {
            transaction.hide(releaseFragment);
        }
        if (infoFragment != null) {
            transaction.hide(infoFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

}
