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
public class player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy extends player.wellnesssolutions.database.model.help_me_choose.AnswerRealm
    implements RealmObjectProxy, player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface {

    static final class AnswerRealmColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long tagIndex;
        long questionIdIndex;
        long answerIndex;

        AnswerRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("AnswerRealm");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.tagIndex = addColumnDetails("tag", "tag", objectSchemaInfo);
            this.questionIdIndex = addColumnDetails("questionId", "questionId", objectSchemaInfo);
            this.answerIndex = addColumnDetails("answer", "answer", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        AnswerRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AnswerRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AnswerRealmColumnInfo src = (AnswerRealmColumnInfo) rawSrc;
            final AnswerRealmColumnInfo dst = (AnswerRealmColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.tagIndex = src.tagIndex;
            dst.questionIdIndex = src.questionIdIndex;
            dst.answerIndex = src.answerIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AnswerRealmColumnInfo columnInfo;
    private ProxyState<player.wellnesssolutions.database.model.help_me_choose.AnswerRealm> proxyState;

    player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AnswerRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<player.wellnesssolutions.database.model.help_me_choose.AnswerRealm>(this);
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
    public String realmGet$tag() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tagIndex);
    }

    @Override
    public void realmSet$tag(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tagIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tagIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tagIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tagIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$questionId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.questionIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.questionIdIndex);
    }

    @Override
    public void realmSet$questionId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.questionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.questionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.questionIdIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.questionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$answer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.answerIndex);
    }

    @Override
    public void realmSet$answer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.answerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.answerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.answerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.answerIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("AnswerRealm", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("tag", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("questionId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("answer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AnswerRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AnswerRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "AnswerRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "AnswerRealm";
    }

    @SuppressWarnings("cast")
    public static player.wellnesssolutions.database.model.help_me_choose.AnswerRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        player.wellnesssolutions.database.model.help_me_choose.AnswerRealm obj = realm.createObjectInternal(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class, true, excludeFields);

        final player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("tag")) {
            if (json.isNull("tag")) {
                objProxy.realmSet$tag(null);
            } else {
                objProxy.realmSet$tag((String) json.getString("tag"));
            }
        }
        if (json.has("questionId")) {
            if (json.isNull("questionId")) {
                objProxy.realmSet$questionId(null);
            } else {
                objProxy.realmSet$questionId((int) json.getInt("questionId"));
            }
        }
        if (json.has("answer")) {
            if (json.isNull("answer")) {
                objProxy.realmSet$answer(null);
            } else {
                objProxy.realmSet$answer((String) json.getString("answer"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static player.wellnesssolutions.database.model.help_me_choose.AnswerRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final player.wellnesssolutions.database.model.help_me_choose.AnswerRealm obj = new player.wellnesssolutions.database.model.help_me_choose.AnswerRealm();
        final player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) obj;
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
            } else if (name.equals("tag")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tag((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tag(null);
                }
            } else if (name.equals("questionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$questionId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$questionId(null);
                }
            } else if (name.equals("answer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$answer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$answer(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class), false, Collections.<String>emptyList());
        io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy obj = new io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static player.wellnesssolutions.database.model.help_me_choose.AnswerRealm copyOrUpdate(Realm realm, AnswerRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.help_me_choose.AnswerRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static player.wellnesssolutions.database.model.help_me_choose.AnswerRealm copy(Realm realm, AnswerRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.help_me_choose.AnswerRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) cachedRealmObject;
        }

        player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface realmObjectSource = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.tagIndex, realmObjectSource.realmGet$tag());
        builder.addInteger(columnInfo.questionIdIndex, realmObjectSource.realmGet$questionId());
        builder.addString(columnInfo.answerIndex, realmObjectSource.realmGet$answer());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, player.wellnesssolutions.database.model.help_me_choose.AnswerRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        long tableNativePtr = table.getNativePtr();
        AnswerRealmColumnInfo columnInfo = (AnswerRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        }
        String realmGet$tag = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        }
        Number realmGet$questionId = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$questionId();
        if (realmGet$questionId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId.longValue(), false);
        }
        String realmGet$answer = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$answer();
        if (realmGet$answer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        long tableNativePtr = table.getNativePtr();
        AnswerRealmColumnInfo columnInfo = (AnswerRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        player.wellnesssolutions.database.model.help_me_choose.AnswerRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$id = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
            }
            String realmGet$tag = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            }
            Number realmGet$questionId = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$questionId();
            if (realmGet$questionId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId.longValue(), false);
            }
            String realmGet$answer = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$answer();
            if (realmGet$answer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, player.wellnesssolutions.database.model.help_me_choose.AnswerRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        long tableNativePtr = table.getNativePtr();
        AnswerRealmColumnInfo columnInfo = (AnswerRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$tag = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
        }
        Number realmGet$questionId = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$questionId();
        if (realmGet$questionId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.questionIdIndex, rowIndex, false);
        }
        String realmGet$answer = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$answer();
        if (realmGet$answer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.answerIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        long tableNativePtr = table.getNativePtr();
        AnswerRealmColumnInfo columnInfo = (AnswerRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        player.wellnesssolutions.database.model.help_me_choose.AnswerRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$id = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$tag = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
            }
            Number realmGet$questionId = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$questionId();
            if (realmGet$questionId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.questionIdIndex, rowIndex, realmGet$questionId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.questionIdIndex, rowIndex, false);
            }
            String realmGet$answer = ((player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) object).realmGet$answer();
            if (realmGet$answer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.answerIndex, rowIndex, false);
            }
        }
    }

    public static player.wellnesssolutions.database.model.help_me_choose.AnswerRealm createDetachedCopy(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        player.wellnesssolutions.database.model.help_me_choose.AnswerRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new player.wellnesssolutions.database.model.help_me_choose.AnswerRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) cachedObject.object;
            }
            unmanagedObject = (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface unmanagedCopy = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) unmanagedObject;
        player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface realmSource = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$tag(realmSource.realmGet$tag());
        unmanagedCopy.realmSet$questionId(realmSource.realmGet$questionId());
        unmanagedCopy.realmSet$answer(realmSource.realmGet$answer());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("AnswerRealm = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tag:");
        stringBuilder.append(realmGet$tag() != null ? realmGet$tag() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{questionId:");
        stringBuilder.append(realmGet$questionId() != null ? realmGet$questionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{answer:");
        stringBuilder.append(realmGet$answer() != null ? realmGet$answer() : "null");
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
        player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy aAnswerRealm = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAnswerRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAnswerRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAnswerRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
