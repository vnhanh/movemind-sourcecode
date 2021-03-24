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
public class player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy extends player.wellnesssolutions.database.model.search_preview.BrandRealm
    implements RealmObjectProxy, player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface {

    static final class BrandRealmColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long nameIndex;
        long descriptionIndex;
        long hasLevelIndex;
        long helperTextIndex;
        long imageIndex;
        long logoIndex;

        BrandRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("BrandRealm");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.hasLevelIndex = addColumnDetails("hasLevel", "hasLevel", objectSchemaInfo);
            this.helperTextIndex = addColumnDetails("helperText", "helperText", objectSchemaInfo);
            this.imageIndex = addColumnDetails("image", "image", objectSchemaInfo);
            this.logoIndex = addColumnDetails("logo", "logo", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        BrandRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BrandRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BrandRealmColumnInfo src = (BrandRealmColumnInfo) rawSrc;
            final BrandRealmColumnInfo dst = (BrandRealmColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.hasLevelIndex = src.hasLevelIndex;
            dst.helperTextIndex = src.helperTextIndex;
            dst.imageIndex = src.imageIndex;
            dst.logoIndex = src.logoIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private BrandRealmColumnInfo columnInfo;
    private ProxyState<player.wellnesssolutions.database.model.search_preview.BrandRealm> proxyState;

    player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BrandRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<player.wellnesssolutions.database.model.search_preview.BrandRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
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
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$hasLevel() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.hasLevelIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.hasLevelIndex);
    }

    @Override
    public void realmSet$hasLevel(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.hasLevelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.hasLevelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.hasLevelIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.hasLevelIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$helperText() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.helperTextIndex);
    }

    @Override
    public void realmSet$helperText(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.helperTextIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.helperTextIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.helperTextIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.helperTextIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageIndex);
    }

    @Override
    public void realmSet$image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$logo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.logoIndex);
    }

    @Override
    public void realmSet$logo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.logoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.logoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.logoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.logoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("BrandRealm", 7, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("hasLevel", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("helperText", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("logo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BrandRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BrandRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "BrandRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "BrandRealm";
    }

    @SuppressWarnings("cast")
    public static player.wellnesssolutions.database.model.search_preview.BrandRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        player.wellnesssolutions.database.model.search_preview.BrandRealm obj = realm.createObjectInternal(player.wellnesssolutions.database.model.search_preview.BrandRealm.class, true, excludeFields);

        final player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("hasLevel")) {
            if (json.isNull("hasLevel")) {
                objProxy.realmSet$hasLevel(null);
            } else {
                objProxy.realmSet$hasLevel((int) json.getInt("hasLevel"));
            }
        }
        if (json.has("helperText")) {
            if (json.isNull("helperText")) {
                objProxy.realmSet$helperText(null);
            } else {
                objProxy.realmSet$helperText((String) json.getString("helperText"));
            }
        }
        if (json.has("image")) {
            if (json.isNull("image")) {
                objProxy.realmSet$image(null);
            } else {
                objProxy.realmSet$image((String) json.getString("image"));
            }
        }
        if (json.has("logo")) {
            if (json.isNull("logo")) {
                objProxy.realmSet$logo(null);
            } else {
                objProxy.realmSet$logo((String) json.getString("logo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static player.wellnesssolutions.database.model.search_preview.BrandRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final player.wellnesssolutions.database.model.search_preview.BrandRealm obj = new player.wellnesssolutions.database.model.search_preview.BrandRealm();
        final player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("hasLevel")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hasLevel((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$hasLevel(null);
                }
            } else if (name.equals("helperText")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$helperText((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$helperText(null);
                }
            } else if (name.equals("image")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$image((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$image(null);
                }
            } else if (name.equals("logo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$logo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$logo(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class), false, Collections.<String>emptyList());
        io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy obj = new io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static player.wellnesssolutions.database.model.search_preview.BrandRealm copyOrUpdate(Realm realm, BrandRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.search_preview.BrandRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (player.wellnesssolutions.database.model.search_preview.BrandRealm) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static player.wellnesssolutions.database.model.search_preview.BrandRealm copy(Realm realm, BrandRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.search_preview.BrandRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.search_preview.BrandRealm) cachedRealmObject;
        }

        player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface realmObjectSource = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.descriptionIndex, realmObjectSource.realmGet$description());
        builder.addInteger(columnInfo.hasLevelIndex, realmObjectSource.realmGet$hasLevel());
        builder.addString(columnInfo.helperTextIndex, realmObjectSource.realmGet$helperText());
        builder.addString(columnInfo.imageIndex, realmObjectSource.realmGet$image());
        builder.addString(columnInfo.logoIndex, realmObjectSource.realmGet$logo());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, player.wellnesssolutions.database.model.search_preview.BrandRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        long tableNativePtr = table.getNativePtr();
        BrandRealmColumnInfo columnInfo = (BrandRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        }
        String realmGet$name = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$description = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        Number realmGet$hasLevel = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$hasLevel();
        if (realmGet$hasLevel != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.hasLevelIndex, rowIndex, realmGet$hasLevel.longValue(), false);
        }
        String realmGet$helperText = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$helperText();
        if (realmGet$helperText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.helperTextIndex, rowIndex, realmGet$helperText, false);
        }
        String realmGet$image = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        }
        String realmGet$logo = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$logo();
        if (realmGet$logo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.logoIndex, rowIndex, realmGet$logo, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        long tableNativePtr = table.getNativePtr();
        BrandRealmColumnInfo columnInfo = (BrandRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        player.wellnesssolutions.database.model.search_preview.BrandRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.search_preview.BrandRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$id = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
            }
            String realmGet$name = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$description = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            Number realmGet$hasLevel = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$hasLevel();
            if (realmGet$hasLevel != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.hasLevelIndex, rowIndex, realmGet$hasLevel.longValue(), false);
            }
            String realmGet$helperText = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$helperText();
            if (realmGet$helperText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.helperTextIndex, rowIndex, realmGet$helperText, false);
            }
            String realmGet$image = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
            }
            String realmGet$logo = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$logo();
            if (realmGet$logo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.logoIndex, rowIndex, realmGet$logo, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, player.wellnesssolutions.database.model.search_preview.BrandRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        long tableNativePtr = table.getNativePtr();
        BrandRealmColumnInfo columnInfo = (BrandRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$name = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$description = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        Number realmGet$hasLevel = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$hasLevel();
        if (realmGet$hasLevel != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.hasLevelIndex, rowIndex, realmGet$hasLevel.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.hasLevelIndex, rowIndex, false);
        }
        String realmGet$helperText = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$helperText();
        if (realmGet$helperText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.helperTextIndex, rowIndex, realmGet$helperText, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.helperTextIndex, rowIndex, false);
        }
        String realmGet$image = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
        }
        String realmGet$logo = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$logo();
        if (realmGet$logo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.logoIndex, rowIndex, realmGet$logo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.logoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        long tableNativePtr = table.getNativePtr();
        BrandRealmColumnInfo columnInfo = (BrandRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        player.wellnesssolutions.database.model.search_preview.BrandRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.search_preview.BrandRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$id = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$name = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$description = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            Number realmGet$hasLevel = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$hasLevel();
            if (realmGet$hasLevel != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.hasLevelIndex, rowIndex, realmGet$hasLevel.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.hasLevelIndex, rowIndex, false);
            }
            String realmGet$helperText = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$helperText();
            if (realmGet$helperText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.helperTextIndex, rowIndex, realmGet$helperText, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.helperTextIndex, rowIndex, false);
            }
            String realmGet$image = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
            }
            String realmGet$logo = ((player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) object).realmGet$logo();
            if (realmGet$logo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.logoIndex, rowIndex, realmGet$logo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.logoIndex, rowIndex, false);
            }
        }
    }

    public static player.wellnesssolutions.database.model.search_preview.BrandRealm createDetachedCopy(player.wellnesssolutions.database.model.search_preview.BrandRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        player.wellnesssolutions.database.model.search_preview.BrandRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new player.wellnesssolutions.database.model.search_preview.BrandRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (player.wellnesssolutions.database.model.search_preview.BrandRealm) cachedObject.object;
            }
            unmanagedObject = (player.wellnesssolutions.database.model.search_preview.BrandRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface unmanagedCopy = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) unmanagedObject;
        player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface realmSource = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$hasLevel(realmSource.realmGet$hasLevel());
        unmanagedCopy.realmSet$helperText(realmSource.realmGet$helperText());
        unmanagedCopy.realmSet$image(realmSource.realmGet$image());
        unmanagedCopy.realmSet$logo(realmSource.realmGet$logo());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BrandRealm = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hasLevel:");
        stringBuilder.append(realmGet$hasLevel() != null ? realmGet$hasLevel() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{helperText:");
        stringBuilder.append(realmGet$helperText() != null ? realmGet$helperText() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{logo:");
        stringBuilder.append(realmGet$logo() != null ? realmGet$logo() : "null");
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
        player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy aBrandRealm = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBrandRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBrandRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBrandRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
