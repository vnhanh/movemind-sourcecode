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
public class player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy extends player.wellnesssolutions.database.model.download.DownloadedFile
    implements RealmObjectProxy, player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface {

    static final class DownloadedFileColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long videoIdIndex;

        DownloadedFileColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DownloadedFile");
            this.videoIdIndex = addColumnDetails("videoId", "videoId", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        DownloadedFileColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DownloadedFileColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DownloadedFileColumnInfo src = (DownloadedFileColumnInfo) rawSrc;
            final DownloadedFileColumnInfo dst = (DownloadedFileColumnInfo) rawDst;
            dst.videoIdIndex = src.videoIdIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DownloadedFileColumnInfo columnInfo;
    private ProxyState<player.wellnesssolutions.database.model.download.DownloadedFile> proxyState;

    player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DownloadedFileColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<player.wellnesssolutions.database.model.download.DownloadedFile>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$videoId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.videoIdIndex);
    }

    @Override
    public void realmSet$videoId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.videoIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.videoIdIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DownloadedFile", 1, 0);
        builder.addPersistedProperty("videoId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DownloadedFileColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DownloadedFileColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DownloadedFile";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "DownloadedFile";
    }

    @SuppressWarnings("cast")
    public static player.wellnesssolutions.database.model.download.DownloadedFile createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        player.wellnesssolutions.database.model.download.DownloadedFile obj = realm.createObjectInternal(player.wellnesssolutions.database.model.download.DownloadedFile.class, true, excludeFields);

        final player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) obj;
        if (json.has("videoId")) {
            if (json.isNull("videoId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'videoId' to null.");
            } else {
                objProxy.realmSet$videoId((int) json.getInt("videoId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static player.wellnesssolutions.database.model.download.DownloadedFile createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final player.wellnesssolutions.database.model.download.DownloadedFile obj = new player.wellnesssolutions.database.model.download.DownloadedFile();
        final player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("videoId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$videoId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'videoId' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.download.DownloadedFile.class), false, Collections.<String>emptyList());
        io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy obj = new io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static player.wellnesssolutions.database.model.download.DownloadedFile copyOrUpdate(Realm realm, DownloadedFileColumnInfo columnInfo, player.wellnesssolutions.database.model.download.DownloadedFile object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (player.wellnesssolutions.database.model.download.DownloadedFile) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static player.wellnesssolutions.database.model.download.DownloadedFile copy(Realm realm, DownloadedFileColumnInfo columnInfo, player.wellnesssolutions.database.model.download.DownloadedFile newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.download.DownloadedFile) cachedRealmObject;
        }

        player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface realmObjectSource = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) newObject;

        Table table = realm.getTable(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.videoIdIndex, realmObjectSource.realmGet$videoId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, player.wellnesssolutions.database.model.download.DownloadedFile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        long tableNativePtr = table.getNativePtr();
        DownloadedFileColumnInfo columnInfo = (DownloadedFileColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.videoIdIndex, rowIndex, ((player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) object).realmGet$videoId(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        long tableNativePtr = table.getNativePtr();
        DownloadedFileColumnInfo columnInfo = (DownloadedFileColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        player.wellnesssolutions.database.model.download.DownloadedFile object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.download.DownloadedFile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.videoIdIndex, rowIndex, ((player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) object).realmGet$videoId(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, player.wellnesssolutions.database.model.download.DownloadedFile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        long tableNativePtr = table.getNativePtr();
        DownloadedFileColumnInfo columnInfo = (DownloadedFileColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.videoIdIndex, rowIndex, ((player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) object).realmGet$videoId(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        long tableNativePtr = table.getNativePtr();
        DownloadedFileColumnInfo columnInfo = (DownloadedFileColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        player.wellnesssolutions.database.model.download.DownloadedFile object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.download.DownloadedFile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.videoIdIndex, rowIndex, ((player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) object).realmGet$videoId(), false);
        }
    }

    public static player.wellnesssolutions.database.model.download.DownloadedFile createDetachedCopy(player.wellnesssolutions.database.model.download.DownloadedFile realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        player.wellnesssolutions.database.model.download.DownloadedFile unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new player.wellnesssolutions.database.model.download.DownloadedFile();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (player.wellnesssolutions.database.model.download.DownloadedFile) cachedObject.object;
            }
            unmanagedObject = (player.wellnesssolutions.database.model.download.DownloadedFile) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface unmanagedCopy = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) unmanagedObject;
        player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface realmSource = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$videoId(realmSource.realmGet$videoId());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DownloadedFile = proxy[");
        stringBuilder.append("{videoId:");
        stringBuilder.append(realmGet$videoId());
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
        player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy aDownloadedFile = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDownloadedFile.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDownloadedFile.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDownloadedFile.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
