package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy extends player.wellnesssolutions.database.model.video.TinyCollectionRealm
    implements RealmObjectProxy, player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface {

    static final class TinyCollectionRealmColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long _idIndex;
        long nameIndex;
        long colorStrIndex;

        TinyCollectionRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("TinyCollectionRealm");
            this._idIndex = addColumnDetails("_id", "_id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.colorStrIndex = addColumnDetails("colorStr", "colorStr", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        TinyCollectionRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TinyCollectionRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TinyCollectionRealmColumnInfo src = (TinyCollectionRealmColumnInfo) rawSrc;
            final TinyCollectionRealmColumnInfo dst = (TinyCollectionRealmColumnInfo) rawDst;
            dst._idIndex = src._idIndex;
            dst.nameIndex = src.nameIndex;
            dst.colorStrIndex = src.colorStrIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TinyCollectionRealmColumnInfo columnInfo;
    private ProxyState<player.wellnesssolutions.database.model.video.TinyCollectionRealm> proxyState;

    player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TinyCollectionRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<player.wellnesssolutions.database.model.video.TinyCollectionRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$_id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo._idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo._idIndex);
    }

    @Override
    public void realmSet$_id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo._idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo._idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo._idIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo._idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$colorStr() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.colorStrIndex);
    }

    @Override
    public void realmSet$colorStr(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.colorStrIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.colorStrIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.colorStrIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.colorStrIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("TinyCollectionRealm", 3, 0);
        builder.addPersistedProperty("_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("colorStr", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TinyCollectionRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TinyCollectionRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "TinyCollectionRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "TinyCollectionRealm";
    }

    @SuppressWarnings("cast")
    public static player.wellnesssolutions.database.model.video.TinyCollectionRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        player.wellnesssolutions.database.model.video.TinyCollectionRealm obj = realm.createObjectInternal(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class, true, excludeFields);

        final player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) obj;
        if (json.has("_id")) {
            if (json.isNull("_id")) {
                objProxy.realmSet$_id(null);
            } else {
                objProxy.realmSet$_id((int) json.getInt("_id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("colorStr")) {
            if (json.isNull("colorStr")) {
                objProxy.realmSet$colorStr(null);
            } else {
                objProxy.realmSet$colorStr((String) json.getString("colorStr"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static player.wellnesssolutions.database.model.video.TinyCollectionRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final player.wellnesssolutions.database.model.video.TinyCollectionRealm obj = new player.wellnesssolutions.database.model.video.TinyCollectionRealm();
        final player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$_id(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("colorStr")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$colorStr((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$colorStr(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class), false, Collections.<String>emptyList());
        io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy obj = new io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static player.wellnesssolutions.database.model.video.TinyCollectionRealm copyOrUpdate(Realm realm, TinyCollectionRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.video.TinyCollectionRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.video.TinyCollectionRealm) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static player.wellnesssolutions.database.model.video.TinyCollectionRealm copy(Realm realm, TinyCollectionRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.video.TinyCollectionRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.video.TinyCollectionRealm) cachedRealmObject;
        }

        player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface realmObjectSource = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo._idIndex, realmObjectSource.realmGet$_id());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.colorStrIndex, realmObjectSource.realmGet$colorStr());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, player.wellnesssolutions.database.model.video.TinyCollectionRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        long tableNativePtr = table.getNativePtr();
        TinyCollectionRealmColumnInfo columnInfo = (TinyCollectionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$_id = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$_id();
        if (realmGet$_id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id.longValue(), false);
        }
        String realmGet$name = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$colorStr = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$colorStr();
        if (realmGet$colorStr != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.colorStrIndex, rowIndex, realmGet$colorStr, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        long tableNativePtr = table.getNativePtr();
        TinyCollectionRealmColumnInfo columnInfo = (TinyCollectionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        player.wellnesssolutions.database.model.video.TinyCollectionRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.video.TinyCollectionRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$_id = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$_id();
            if (realmGet$_id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id.longValue(), false);
            }
            String realmGet$name = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$colorStr = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$colorStr();
            if (realmGet$colorStr != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.colorStrIndex, rowIndex, realmGet$colorStr, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, player.wellnesssolutions.database.model.video.TinyCollectionRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        long tableNativePtr = table.getNativePtr();
        TinyCollectionRealmColumnInfo columnInfo = (TinyCollectionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$_id = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$_id();
        if (realmGet$_id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo._idIndex, rowIndex, false);
        }
        String realmGet$name = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$colorStr = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$colorStr();
        if (realmGet$colorStr != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.colorStrIndex, rowIndex, realmGet$colorStr, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.colorStrIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        long tableNativePtr = table.getNativePtr();
        TinyCollectionRealmColumnInfo columnInfo = (TinyCollectionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        player.wellnesssolutions.database.model.video.TinyCollectionRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.video.TinyCollectionRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$_id = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$_id();
            if (realmGet$_id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo._idIndex, rowIndex, realmGet$_id.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo._idIndex, rowIndex, false);
            }
            String realmGet$name = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$colorStr = ((player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) object).realmGet$colorStr();
            if (realmGet$colorStr != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.colorStrIndex, rowIndex, realmGet$colorStr, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.colorStrIndex, rowIndex, false);
            }
        }
    }

    public static player.wellnesssolutions.database.model.video.TinyCollectionRealm createDetachedCopy(player.wellnesssolutions.database.model.video.TinyCollectionRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        player.wellnesssolutions.database.model.video.TinyCollectionRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new player.wellnesssolutions.database.model.video.TinyCollectionRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (player.wellnesssolutions.database.model.video.TinyCollectionRealm) cachedObject.object;
            }
            unmanagedObject = (player.wellnesssolutions.database.model.video.TinyCollectionRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface unmanagedCopy = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) unmanagedObject;
        player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface realmSource = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$_id(realmSource.realmGet$_id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$colorStr(realmSource.realmGet$colorStr());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TinyCollectionRealm = proxy[");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{colorStr:");
        stringBuilder.append(realmGet$colorStr() != null ? realmGet$colorStr() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy aTinyCollectionRealm = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTinyCollectionRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTinyCollectionRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTinyCollectionRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
