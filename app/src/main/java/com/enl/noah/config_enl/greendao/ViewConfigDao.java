package com.enl.noah.config_enl.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.enl.noah.config_enl.entity.greendao.ViewConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VIEW_CONFIG".
*/
public class ViewConfigDao extends AbstractDao<ViewConfig, Long> {

    public static final String TABLENAME = "VIEW_CONFIG";

    /**
     * Properties of entity ViewConfig.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property ControlsName = new Property(1, String.class, "controlsName", false, "CONTROLS_NAME");
        public final static Property ControlsType = new Property(2, String.class, "controlsType", false, "CONTROLS_TYPE");
        public final static Property LocalX = new Property(3, int.class, "localX", false, "LOCAL_X");
        public final static Property LocalY = new Property(4, int.class, "localY", false, "LOCAL_Y");
    }


    public ViewConfigDao(DaoConfig config) {
        super(config);
    }
    
    public ViewConfigDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VIEW_CONFIG\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"CONTROLS_NAME\" TEXT," + // 1: controlsName
                "\"CONTROLS_TYPE\" TEXT," + // 2: controlsType
                "\"LOCAL_X\" INTEGER NOT NULL ," + // 3: localX
                "\"LOCAL_Y\" INTEGER NOT NULL );"); // 4: localY
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VIEW_CONFIG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ViewConfig entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String controlsName = entity.getControlsName();
        if (controlsName != null) {
            stmt.bindString(2, controlsName);
        }
 
        String controlsType = entity.getControlsType();
        if (controlsType != null) {
            stmt.bindString(3, controlsType);
        }
        stmt.bindLong(4, entity.getLocalX());
        stmt.bindLong(5, entity.getLocalY());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ViewConfig entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String controlsName = entity.getControlsName();
        if (controlsName != null) {
            stmt.bindString(2, controlsName);
        }
 
        String controlsType = entity.getControlsType();
        if (controlsType != null) {
            stmt.bindString(3, controlsType);
        }
        stmt.bindLong(4, entity.getLocalX());
        stmt.bindLong(5, entity.getLocalY());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public ViewConfig readEntity(Cursor cursor, int offset) {
        ViewConfig entity = new ViewConfig( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // controlsName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // controlsType
            cursor.getInt(offset + 3), // localX
            cursor.getInt(offset + 4) // localY
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ViewConfig entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setControlsName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setControlsType(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLocalX(cursor.getInt(offset + 3));
        entity.setLocalY(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ViewConfig entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ViewConfig entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ViewConfig entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}