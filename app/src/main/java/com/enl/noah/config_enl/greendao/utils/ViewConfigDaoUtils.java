package com.enl.noah.config_enl.greendao.utils;

import android.content.Context;
import android.util.Log;

import com.enl.noah.config_enl.entity.greendao.ViewConfig;
import com.enl.noah.config_enl.greendao.DaoManager;
import com.enl.noah.config_enl.greendao.ViewConfigDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * author   Noah
 * time     2018/6/27:15:15
 * desc     控件配置表操作工具类
 */
public class ViewConfigDaoUtils {
    private static final String TAG = ViewConfigDaoUtils.class.getSimpleName();
    private DaoManager mManager;

    public ViewConfigDaoUtils(Context context) {
        mManager = DaoManager.getInstance();
        mManager.init(context);
    }

    /**
     * 完成ViewConfig记录的插入，如果表未创建，先创建ViewConfig表
     *
     * @param viewConfig
     * @return
     */
    public boolean insertViewConfig(ViewConfig viewConfig) {
        boolean flag = false;
        flag = mManager.getDaoSession().getViewConfigDao().insert(viewConfig) == -1 ? false : true;
        Log.i(TAG, "insert ViewConfig :" + flag + "-->" + viewConfig.toString());
        return flag;
    }

    /**
     * 插入多条数据，在子线程操作
     *
     * @param ViewConfigList
     * @return
     */
    public boolean insertMultViewConfig(final List<ViewConfig> ViewConfigList) {
        boolean flag = false;
        try {
            mManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (ViewConfig viewConfig : ViewConfigList) {
                        mManager.getDaoSession().insertOrReplace(viewConfig);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 修改一条数据
     *
     * @param viewConfig
     * @return
     */
    public boolean updateViewConfig(ViewConfig viewConfig) {
        boolean flag = false;
        try {
            mManager.getDaoSession().update(viewConfig);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除单条记录
     *
     * @param viewConfig
     * @return
     */
    public boolean deleteViewConfig(ViewConfig viewConfig) {
        boolean flag = false;
        try {
            //按照id删除
            mManager.getDaoSession().delete(viewConfig);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除所有记录
     *
     * @return
     */
    public boolean deleteAll() {
        boolean flag = false;
        try {
            //按照id删除
            mManager.getDaoSession().deleteAll(ViewConfig.class);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<ViewConfig> queryAllViewConfig() {
        return mManager.getDaoSession().loadAll(ViewConfig.class);
    }

    /**
     * 根据主键id查询记录
     *
     * @param key
     * @return
     */
    public ViewConfig queryViewConfigById(long key) {
        return mManager.getDaoSession().load(ViewConfig.class, key);
    }

    /**
     * 使用native sql进行查询操作
     */
    public List<ViewConfig> queryViewConfigByNativeSql(String sql, String[] conditions) {
        return mManager.getDaoSession().queryRaw(ViewConfig.class, sql, conditions);
    }

    /**
     * 使用queryBuilder进行查询
     *
     * @return
     */
    public List<ViewConfig> queryViewConfigByQueryBuilder(long id) {
        QueryBuilder<ViewConfig> queryBuilder = mManager.getDaoSession().queryBuilder(ViewConfig.class);
        return queryBuilder.where(ViewConfigDao.Properties.Id.eq(id)).list();
    }
}
