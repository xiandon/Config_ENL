package com.enl.noah.config_enl.entity.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author   Noah
 * time     2018/6/27:15:06
 * desc     控件配置类
 */
@Entity
public class ViewConfig {
    @Id(autoincrement = true)
    private long id;

    private String controlsId;      // 控件ID
    private String controlsName;    // 名称
    private String controlsType;    // 类别（字符串，button，ImageView，其他View）
    private int localX;             // X轴位置
    private int localY;             // Y轴位置
    private String sensorData;      // 传感器值


    @Generated(hash = 1371702080)
    public ViewConfig(long id, String controlsName, String controlsType, int localX,
                      int localY) {
        this.id = id;
        this.controlsName = controlsName;
        this.controlsType = controlsType;
        this.localX = localX;
        this.localY = localY;
    }

    @Generated(hash = 308832131)
    public ViewConfig() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getControlsName() {
        return this.controlsName;
    }

    public void setControlsName(String controlsName) {
        this.controlsName = controlsName;
    }

    public String getControlsType() {
        return this.controlsType;
    }

    public void setControlsType(String controlsType) {
        this.controlsType = controlsType;
    }

    public int getLocalX() {
        return this.localX;
    }

    public void setLocalX(int localX) {
        this.localX = localX;
    }

    public int getLocalY() {
        return this.localY;
    }

    public void setLocalY(int localY) {
        this.localY = localY;
    }
}
