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
public class player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy extends player.wellnesssolutions.database.model.search_preview.SPOptionRealm
    implements RealmObjectProxy, player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface {

    static final class SPOptionRealmColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long tagIndex;
        long brandIndex;
        long searchByDataIndex;
        long collectionsIndex;
        long durationsIndex;
        long levelsIndex;
        long presentersIndex;

        SPOptionRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("SPOptionRealm");
            this.tagIndex = addColumnDetails("tag", "tag", objectSchemaInfo);
            this.brandIndex = addColumnDetails("brand", "brand", objectSchemaInfo);
            this.searchByDataIndex = addColumnDetails("searchByData", "searchByData", objectSchemaInfo);
            this.collectionsIndex = addColumnDetails("collections", "collections", objectSchemaInfo);
            this.durationsIndex = addColumnDetails("durations", "durations", objectSchemaInfo);
            this.levelsIndex = addColumnDetails("levels", "levels", objectSchemaInfo);
            this.presentersIndex = addColumnDetails("presenters", "presenters", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        SPOptionRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SPOptionRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SPOptionRealmColumnInfo src = (SPOptionRealmColumnInfo) rawSrc;
            final SPOptionRealmColumnInfo dst = (SPOptionRealmColumnInfo) rawDst;
            dst.tagIndex = src.tagIndex;
            dst.brandIndex = src.brandIndex;
            dst.searchByDataIndex = src.searchByDataIndex;
            dst.collectionsIndex = src.collectionsIndex;
            dst.durationsIndex = src.durationsIndex;
            dst.levelsIndex = src.levelsIndex;
            dst.presentersIndex = src.presentersIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private SPOptionRealmColumnInfo columnInfo;
    private ProxyState<player.wellnesssolutions.database.model.search_preview.SPOptionRealm> proxyState;
    private RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsRealmList;
    private RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsRealmList;
    private RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsRealmList;
    private RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersRealmList;

    player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SPOptionRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<player.wellnesssolutions.database.model.search_preview.SPOptionRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public player.wellnesssolutions.database.model.search_preview.BrandRealm realmGet$brand() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.brandIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(player.wellnesssolutions.database.model.search_preview.BrandRealm.class, proxyState.getRow$realm().getLink(columnInfo.brandIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$brand(player.wellnesssolutions.database.model.search_preview.BrandRealm value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("brand")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.brandIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.brandIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.brandIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.brandIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm realmGet$searchByData() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.searchByDataIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class, proxyState.getRow$realm().getLink(columnInfo.searchByDataIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$searchByData(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("searchByData")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.searchByDataIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.searchByDataIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.searchByDataIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.searchByDataIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> realmGet$collections() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (collectionsRealmList != null) {
            return collectionsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.collectionsIndex);
            collectionsRealmList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class, osList, proxyState.getRealm$realm());
            return collectionsRealmList;
        }
    }

    @Override
    public void realmSet$collections(RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("collections")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.collectionsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> realmGet$durations() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (durationsRealmList != null) {
            return durationsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.durationsIndex);
            durationsRealmList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class, osList, proxyState.getRealm$realm());
            return durationsRealmList;
        }
    }

    @Override
    public void realmSet$durations(RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("durations")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.durationsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> realmGet$levels() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (levelsRealmList != null) {
            return levelsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.levelsIndex);
            levelsRealmList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class, osList, proxyState.getRealm$realm());
            return levelsRealmList;
        }
    }

    @Override
    public void realmSet$levels(RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("levels")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.levelsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> realmGet$presenters() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (presentersRealmList != null) {
            return presentersRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.presentersIndex);
            presentersRealmList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class, osList, proxyState.getRealm$realm());
            return presentersRealmList;
        }
    }

    @Override
    public void realmSet$presenters(RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("presenters")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.presentersIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("SPOptionRealm", 7, 0);
        builder.addPersistedProperty("tag", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("brand", RealmFieldType.OBJECT, "BrandRealm");
        builder.addPersistedLinkProperty("searchByData", RealmFieldType.OBJECT, "SPTinyOptionRealm");
        builder.addPersistedLinkProperty("collections", RealmFieldType.LIST, "SPTinyOptionRealm");
        builder.addPersistedLinkProperty("durations", RealmFieldType.LIST, "SPTinyOptionRealm");
        builder.addPersistedLinkProperty("levels", RealmFieldType.LIST, "SPTinyOptionRealm");
        builder.addPersistedLinkProperty("presenters", RealmFieldType.LIST, "SPTinyOptionRealm");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SPOptionRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SPOptionRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "SPOptionRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "SPOptionRealm";
    }

    @SuppressWarnings("cast")
    public static player.wellnesssolutions.database.model.search_preview.SPOptionRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(6);
        if (json.has("brand")) {
            excludeFields.add("brand");
        }
        if (json.has("searchByData")) {
            excludeFields.add("searchByData");
        }
        if (json.has("collections")) {
            excludeFields.add("collections");
        }
        if (json.has("durations")) {
            excludeFields.add("durations");
        }
        if (json.has("levels")) {
            excludeFields.add("levels");
        }
        if (json.has("presenters")) {
            excludeFields.add("presenters");
        }
        player.wellnesssolutions.database.model.search_preview.SPOptionRealm obj = realm.createObjectInternal(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class, true, excludeFields);

        final player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) obj;
        if (json.has("tag")) {
            if (json.isNull("tag")) {
                objProxy.realmSet$tag(null);
            } else {
                objProxy.realmSet$tag((String) json.getString("tag"));
            }
        }
        if (json.has("brand")) {
            if (json.isNull("brand")) {
                objProxy.realmSet$brand(null);
            } else {
                player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("brand"), update);
                objProxy.realmSet$brand(brandObj);
            }
        }
        if (json.has("searchByData")) {
            if (json.isNull("searchByData")) {
                objProxy.realmSet$searchByData(null);
            } else {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("searchByData"), update);
                objProxy.realmSet$searchByData(searchByDataObj);
            }
        }
        if (json.has("collections")) {
            if (json.isNull("collections")) {
                objProxy.realmSet$collections(null);
            } else {
                objProxy.realmGet$collections().clear();
                JSONArray array = json.getJSONArray("collections");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$collections().add(item);
                }
            }
        }
        if (json.has("durations")) {
            if (json.isNull("durations")) {
                objProxy.realmSet$durations(null);
            } else {
                objProxy.realmGet$durations().clear();
                JSONArray array = json.getJSONArray("durations");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$durations().add(item);
                }
            }
        }
        if (json.has("levels")) {
            if (json.isNull("levels")) {
                objProxy.realmSet$levels(null);
            } else {
                objProxy.realmGet$levels().clear();
                JSONArray array = json.getJSONArray("levels");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$levels().add(item);
                }
            }
        }
        if (json.has("presenters")) {
            if (json.isNull("presenters")) {
                objProxy.realmSet$presenters(null);
            } else {
                objProxy.realmGet$presenters().clear();
                JSONArray array = json.getJSONArray("presenters");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$presenters().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static player.wellnesssolutions.database.model.search_preview.SPOptionRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final player.wellnesssolutions.database.model.search_preview.SPOptionRealm obj = new player.wellnesssolutions.database.model.search_preview.SPOptionRealm();
        final player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("tag")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tag((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tag(null);
                }
            } else if (name.equals("brand")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$brand(null);
                } else {
                    player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$brand(brandObj);
                }
            } else if (name.equals("searchByData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$searchByData(null);
                } else {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$searchByData(searchByDataObj);
                }
            } else if (name.equals("collections")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$collections(null);
                } else {
                    objProxy.realmSet$collections(new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$collections().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("durations")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$durations(null);
                } else {
                    objProxy.realmSet$durations(new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$durations().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("levels")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$levels(null);
                } else {
                    objProxy.realmSet$levels(new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$levels().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("presenters")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$presenters(null);
                } else {
                    objProxy.realmSet$presenters(new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$presenters().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class), false, Collections.<String>emptyList());
        io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy obj = new io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static player.wellnesssolutions.database.model.search_preview.SPOptionRealm copyOrUpdate(Realm realm, SPOptionRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.search_preview.SPOptionRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static player.wellnesssolutions.database.model.search_preview.SPOptionRealm copy(Realm realm, SPOptionRealmColumnInfo columnInfo, player.wellnesssolutions.database.model.search_preview.SPOptionRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) cachedRealmObject;
        }

        player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface realmObjectSource = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.tagIndex, realmObjectSource.realmGet$tag());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = realmObjectSource.realmGet$brand();
        if (brandObj == null) {
            realmObjectCopy.realmSet$brand(null);
        } else {
            player.wellnesssolutions.database.model.search_preview.BrandRealm cachebrand = (player.wellnesssolutions.database.model.search_preview.BrandRealm) cache.get(brandObj);
            if (cachebrand != null) {
                realmObjectCopy.realmSet$brand(cachebrand);
            } else {
                realmObjectCopy.realmSet$brand(player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.BrandRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class), brandObj, update, cache, flags));
            }
        }

        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = realmObjectSource.realmGet$searchByData();
        if (searchByDataObj == null) {
            realmObjectCopy.realmSet$searchByData(null);
        } else {
            player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm cachesearchByData = (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) cache.get(searchByDataObj);
            if (cachesearchByData != null) {
                realmObjectCopy.realmSet$searchByData(cachesearchByData);
            } else {
                realmObjectCopy.realmSet$searchByData(player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class), searchByDataObj, update, cache, flags));
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsList = realmObjectSource.realmGet$collections();
        if (collectionsList != null) {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsRealmList = realmObjectCopy.realmGet$collections();
            collectionsRealmList.clear();
            for (int i = 0; i < collectionsList.size(); i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem = collectionsList.get(i);
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm cachecollections = (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) cache.get(collectionsItem);
                if (cachecollections != null) {
                    collectionsRealmList.add(cachecollections);
                } else {
                    collectionsRealmList.add(player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class), collectionsItem, update, cache, flags));
                }
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsList = realmObjectSource.realmGet$durations();
        if (durationsList != null) {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsRealmList = realmObjectCopy.realmGet$durations();
            durationsRealmList.clear();
            for (int i = 0; i < durationsList.size(); i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem = durationsList.get(i);
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm cachedurations = (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) cache.get(durationsItem);
                if (cachedurations != null) {
                    durationsRealmList.add(cachedurations);
                } else {
                    durationsRealmList.add(player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class), durationsItem, update, cache, flags));
                }
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsList = realmObjectSource.realmGet$levels();
        if (levelsList != null) {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsRealmList = realmObjectCopy.realmGet$levels();
            levelsRealmList.clear();
            for (int i = 0; i < levelsList.size(); i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem = levelsList.get(i);
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm cachelevels = (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) cache.get(levelsItem);
                if (cachelevels != null) {
                    levelsRealmList.add(cachelevels);
                } else {
                    levelsRealmList.add(player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class), levelsItem, update, cache, flags));
                }
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersList = realmObjectSource.realmGet$presenters();
        if (presentersList != null) {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersRealmList = realmObjectCopy.realmGet$presenters();
            presentersRealmList.clear();
            for (int i = 0; i < presentersList.size(); i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem = presentersList.get(i);
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm cachepresenters = (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) cache.get(presentersItem);
                if (cachepresenters != null) {
                    presentersRealmList.add(cachepresenters);
                } else {
                    presentersRealmList.add(player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class), presentersItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, player.wellnesssolutions.database.model.search_preview.SPOptionRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        long tableNativePtr = table.getNativePtr();
        SPOptionRealmColumnInfo columnInfo = (SPOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$tag = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        }

        player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$brand();
        if (brandObj != null) {
            Long cachebrand = cache.get(brandObj);
            if (cachebrand == null) {
                cachebrand = player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insert(realm, brandObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.brandIndex, rowIndex, cachebrand, false);
        }

        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$searchByData();
        if (searchByDataObj != null) {
            Long cachesearchByData = cache.get(searchByDataObj);
            if (cachesearchByData == null) {
                cachesearchByData = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, searchByDataObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.searchByDataIndex, rowIndex, cachesearchByData, false);
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$collections();
        if (collectionsList != null) {
            OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
            for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem : collectionsList) {
                Long cacheItemIndexcollections = cache.get(collectionsItem);
                if (cacheItemIndexcollections == null) {
                    cacheItemIndexcollections = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, collectionsItem, cache);
                }
                collectionsOsList.addRow(cacheItemIndexcollections);
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$durations();
        if (durationsList != null) {
            OsList durationsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.durationsIndex);
            for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem : durationsList) {
                Long cacheItemIndexdurations = cache.get(durationsItem);
                if (cacheItemIndexdurations == null) {
                    cacheItemIndexdurations = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, durationsItem, cache);
                }
                durationsOsList.addRow(cacheItemIndexdurations);
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$levels();
        if (levelsList != null) {
            OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
            for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem : levelsList) {
                Long cacheItemIndexlevels = cache.get(levelsItem);
                if (cacheItemIndexlevels == null) {
                    cacheItemIndexlevels = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, levelsItem, cache);
                }
                levelsOsList.addRow(cacheItemIndexlevels);
            }
        }

        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$presenters();
        if (presentersList != null) {
            OsList presentersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.presentersIndex);
            for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem : presentersList) {
                Long cacheItemIndexpresenters = cache.get(presentersItem);
                if (cacheItemIndexpresenters == null) {
                    cacheItemIndexpresenters = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, presentersItem, cache);
                }
                presentersOsList.addRow(cacheItemIndexpresenters);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        long tableNativePtr = table.getNativePtr();
        SPOptionRealmColumnInfo columnInfo = (SPOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        player.wellnesssolutions.database.model.search_preview.SPOptionRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$tag = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            }

            player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$brand();
            if (brandObj != null) {
                Long cachebrand = cache.get(brandObj);
                if (cachebrand == null) {
                    cachebrand = player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insert(realm, brandObj, cache);
                }
                table.setLink(columnInfo.brandIndex, rowIndex, cachebrand, false);
            }

            player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$searchByData();
            if (searchByDataObj != null) {
                Long cachesearchByData = cache.get(searchByDataObj);
                if (cachesearchByData == null) {
                    cachesearchByData = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, searchByDataObj, cache);
                }
                table.setLink(columnInfo.searchByDataIndex, rowIndex, cachesearchByData, false);
            }

            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$collections();
            if (collectionsList != null) {
                OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem : collectionsList) {
                    Long cacheItemIndexcollections = cache.get(collectionsItem);
                    if (cacheItemIndexcollections == null) {
                        cacheItemIndexcollections = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, collectionsItem, cache);
                    }
                    collectionsOsList.addRow(cacheItemIndexcollections);
                }
            }

            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$durations();
            if (durationsList != null) {
                OsList durationsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.durationsIndex);
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem : durationsList) {
                    Long cacheItemIndexdurations = cache.get(durationsItem);
                    if (cacheItemIndexdurations == null) {
                        cacheItemIndexdurations = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, durationsItem, cache);
                    }
                    durationsOsList.addRow(cacheItemIndexdurations);
                }
            }

            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$levels();
            if (levelsList != null) {
                OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem : levelsList) {
                    Long cacheItemIndexlevels = cache.get(levelsItem);
                    if (cacheItemIndexlevels == null) {
                        cacheItemIndexlevels = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, levelsItem, cache);
                    }
                    levelsOsList.addRow(cacheItemIndexlevels);
                }
            }

            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$presenters();
            if (presentersList != null) {
                OsList presentersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.presentersIndex);
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem : presentersList) {
                    Long cacheItemIndexpresenters = cache.get(presentersItem);
                    if (cacheItemIndexpresenters == null) {
                        cacheItemIndexpresenters = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, presentersItem, cache);
                    }
                    presentersOsList.addRow(cacheItemIndexpresenters);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, player.wellnesssolutions.database.model.search_preview.SPOptionRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        long tableNativePtr = table.getNativePtr();
        SPOptionRealmColumnInfo columnInfo = (SPOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$tag = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
        }

        player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$brand();
        if (brandObj != null) {
            Long cachebrand = cache.get(brandObj);
            if (cachebrand == null) {
                cachebrand = player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insertOrUpdate(realm, brandObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.brandIndex, rowIndex, cachebrand, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.brandIndex, rowIndex);
        }

        player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$searchByData();
        if (searchByDataObj != null) {
            Long cachesearchByData = cache.get(searchByDataObj);
            if (cachesearchByData == null) {
                cachesearchByData = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, searchByDataObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.searchByDataIndex, rowIndex, cachesearchByData, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.searchByDataIndex, rowIndex);
        }

        OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$collections();
        if (collectionsList != null && collectionsList.size() == collectionsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = collectionsList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem = collectionsList.get(i);
                Long cacheItemIndexcollections = cache.get(collectionsItem);
                if (cacheItemIndexcollections == null) {
                    cacheItemIndexcollections = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                }
                collectionsOsList.setRow(i, cacheItemIndexcollections);
            }
        } else {
            collectionsOsList.removeAll();
            if (collectionsList != null) {
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem : collectionsList) {
                    Long cacheItemIndexcollections = cache.get(collectionsItem);
                    if (cacheItemIndexcollections == null) {
                        cacheItemIndexcollections = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                    }
                    collectionsOsList.addRow(cacheItemIndexcollections);
                }
            }
        }


        OsList durationsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.durationsIndex);
        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$durations();
        if (durationsList != null && durationsList.size() == durationsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = durationsList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem = durationsList.get(i);
                Long cacheItemIndexdurations = cache.get(durationsItem);
                if (cacheItemIndexdurations == null) {
                    cacheItemIndexdurations = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, durationsItem, cache);
                }
                durationsOsList.setRow(i, cacheItemIndexdurations);
            }
        } else {
            durationsOsList.removeAll();
            if (durationsList != null) {
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem : durationsList) {
                    Long cacheItemIndexdurations = cache.get(durationsItem);
                    if (cacheItemIndexdurations == null) {
                        cacheItemIndexdurations = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, durationsItem, cache);
                    }
                    durationsOsList.addRow(cacheItemIndexdurations);
                }
            }
        }


        OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$levels();
        if (levelsList != null && levelsList.size() == levelsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = levelsList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem = levelsList.get(i);
                Long cacheItemIndexlevels = cache.get(levelsItem);
                if (cacheItemIndexlevels == null) {
                    cacheItemIndexlevels = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                }
                levelsOsList.setRow(i, cacheItemIndexlevels);
            }
        } else {
            levelsOsList.removeAll();
            if (levelsList != null) {
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem : levelsList) {
                    Long cacheItemIndexlevels = cache.get(levelsItem);
                    if (cacheItemIndexlevels == null) {
                        cacheItemIndexlevels = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                    }
                    levelsOsList.addRow(cacheItemIndexlevels);
                }
            }
        }


        OsList presentersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.presentersIndex);
        RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$presenters();
        if (presentersList != null && presentersList.size() == presentersOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = presentersList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem = presentersList.get(i);
                Long cacheItemIndexpresenters = cache.get(presentersItem);
                if (cacheItemIndexpresenters == null) {
                    cacheItemIndexpresenters = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, presentersItem, cache);
                }
                presentersOsList.setRow(i, cacheItemIndexpresenters);
            }
        } else {
            presentersOsList.removeAll();
            if (presentersList != null) {
                for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem : presentersList) {
                    Long cacheItemIndexpresenters = cache.get(presentersItem);
                    if (cacheItemIndexpresenters == null) {
                        cacheItemIndexpresenters = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, presentersItem, cache);
                    }
                    presentersOsList.addRow(cacheItemIndexpresenters);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        long tableNativePtr = table.getNativePtr();
        SPOptionRealmColumnInfo columnInfo = (SPOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        player.wellnesssolutions.database.model.search_preview.SPOptionRealm object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$tag = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
            }

            player.wellnesssolutions.database.model.search_preview.BrandRealm brandObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$brand();
            if (brandObj != null) {
                Long cachebrand = cache.get(brandObj);
                if (cachebrand == null) {
                    cachebrand = player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insertOrUpdate(realm, brandObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.brandIndex, rowIndex, cachebrand, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.brandIndex, rowIndex);
            }

            player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm searchByDataObj = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$searchByData();
            if (searchByDataObj != null) {
                Long cachesearchByData = cache.get(searchByDataObj);
                if (cachesearchByData == null) {
                    cachesearchByData = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, searchByDataObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.searchByDataIndex, rowIndex, cachesearchByData, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.searchByDataIndex, rowIndex);
            }

            OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> collectionsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$collections();
            if (collectionsList != null && collectionsList.size() == collectionsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = collectionsList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem = collectionsList.get(i);
                    Long cacheItemIndexcollections = cache.get(collectionsItem);
                    if (cacheItemIndexcollections == null) {
                        cacheItemIndexcollections = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                    }
                    collectionsOsList.setRow(i, cacheItemIndexcollections);
                }
            } else {
                collectionsOsList.removeAll();
                if (collectionsList != null) {
                    for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm collectionsItem : collectionsList) {
                        Long cacheItemIndexcollections = cache.get(collectionsItem);
                        if (cacheItemIndexcollections == null) {
                            cacheItemIndexcollections = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                        }
                        collectionsOsList.addRow(cacheItemIndexcollections);
                    }
                }
            }


            OsList durationsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.durationsIndex);
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> durationsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$durations();
            if (durationsList != null && durationsList.size() == durationsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = durationsList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem = durationsList.get(i);
                    Long cacheItemIndexdurations = cache.get(durationsItem);
                    if (cacheItemIndexdurations == null) {
                        cacheItemIndexdurations = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, durationsItem, cache);
                    }
                    durationsOsList.setRow(i, cacheItemIndexdurations);
                }
            } else {
                durationsOsList.removeAll();
                if (durationsList != null) {
                    for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm durationsItem : durationsList) {
                        Long cacheItemIndexdurations = cache.get(durationsItem);
                        if (cacheItemIndexdurations == null) {
                            cacheItemIndexdurations = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, durationsItem, cache);
                        }
                        durationsOsList.addRow(cacheItemIndexdurations);
                    }
                }
            }


            OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$levels();
            if (levelsList != null && levelsList.size() == levelsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = levelsList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem = levelsList.get(i);
                    Long cacheItemIndexlevels = cache.get(levelsItem);
                    if (cacheItemIndexlevels == null) {
                        cacheItemIndexlevels = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                    }
                    levelsOsList.setRow(i, cacheItemIndexlevels);
                }
            } else {
                levelsOsList.removeAll();
                if (levelsList != null) {
                    for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm levelsItem : levelsList) {
                        Long cacheItemIndexlevels = cache.get(levelsItem);
                        if (cacheItemIndexlevels == null) {
                            cacheItemIndexlevels = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                        }
                        levelsOsList.addRow(cacheItemIndexlevels);
                    }
                }
            }


            OsList presentersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.presentersIndex);
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> presentersList = ((player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) object).realmGet$presenters();
            if (presentersList != null && presentersList.size() == presentersOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = presentersList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem = presentersList.get(i);
                    Long cacheItemIndexpresenters = cache.get(presentersItem);
                    if (cacheItemIndexpresenters == null) {
                        cacheItemIndexpresenters = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, presentersItem, cache);
                    }
                    presentersOsList.setRow(i, cacheItemIndexpresenters);
                }
            } else {
                presentersOsList.removeAll();
                if (presentersList != null) {
                    for (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm presentersItem : presentersList) {
                        Long cacheItemIndexpresenters = cache.get(presentersItem);
                        if (cacheItemIndexpresenters == null) {
                            cacheItemIndexpresenters = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, presentersItem, cache);
                        }
                        presentersOsList.addRow(cacheItemIndexpresenters);
                    }
                }
            }

        }
    }

    public static player.wellnesssolutions.database.model.search_preview.SPOptionRealm createDetachedCopy(player.wellnesssolutions.database.model.search_preview.SPOptionRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        player.wellnesssolutions.database.model.search_preview.SPOptionRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new player.wellnesssolutions.database.model.search_preview.SPOptionRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) cachedObject.object;
            }
            unmanagedObject = (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface unmanagedCopy = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) unmanagedObject;
        player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface realmSource = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$tag(realmSource.realmGet$tag());

        // Deep copy of brand
        unmanagedCopy.realmSet$brand(player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createDetachedCopy(realmSource.realmGet$brand(), currentDepth + 1, maxDepth, cache));

        // Deep copy of searchByData
        unmanagedCopy.realmSet$searchByData(player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createDetachedCopy(realmSource.realmGet$searchByData(), currentDepth + 1, maxDepth, cache));

        // Deep copy of collections
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$collections(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> managedcollectionsList = realmSource.realmGet$collections();
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> unmanagedcollectionsList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
            unmanagedCopy.realmSet$collections(unmanagedcollectionsList);
            int nextDepth = currentDepth + 1;
            int size = managedcollectionsList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createDetachedCopy(managedcollectionsList.get(i), nextDepth, maxDepth, cache);
                unmanagedcollectionsList.add(item);
            }
        }

        // Deep copy of durations
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$durations(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> manageddurationsList = realmSource.realmGet$durations();
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> unmanageddurationsList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
            unmanagedCopy.realmSet$durations(unmanageddurationsList);
            int nextDepth = currentDepth + 1;
            int size = manageddurationsList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createDetachedCopy(manageddurationsList.get(i), nextDepth, maxDepth, cache);
                unmanageddurationsList.add(item);
            }
        }

        // Deep copy of levels
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$levels(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> managedlevelsList = realmSource.realmGet$levels();
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> unmanagedlevelsList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
            unmanagedCopy.realmSet$levels(unmanagedlevelsList);
            int nextDepth = currentDepth + 1;
            int size = managedlevelsList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createDetachedCopy(managedlevelsList.get(i), nextDepth, maxDepth, cache);
                unmanagedlevelsList.add(item);
            }
        }

        // Deep copy of presenters
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$presenters(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> managedpresentersList = realmSource.realmGet$presenters();
            RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm> unmanagedpresentersList = new RealmList<player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm>();
            unmanagedCopy.realmSet$presenters(unmanagedpresentersList);
            int nextDepth = currentDepth + 1;
            int size = managedpresentersList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm item = player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createDetachedCopy(managedpresentersList.get(i), nextDepth, maxDepth, cache);
                unmanagedpresentersList.add(item);
            }
        }

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SPOptionRealm = proxy[");
        stringBuilder.append("{tag:");
        stringBuilder.append(realmGet$tag() != null ? realmGet$tag() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{brand:");
        stringBuilder.append(realmGet$brand() != null ? "BrandRealm" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{searchByData:");
        stringBuilder.append(realmGet$searchByData() != null ? "SPTinyOptionRealm" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{collections:");
        stringBuilder.append("RealmList<SPTinyOptionRealm>[").append(realmGet$collections().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{durations:");
        stringBuilder.append("RealmList<SPTinyOptionRealm>[").append(realmGet$durations().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{levels:");
        stringBuilder.append("RealmList<SPTinyOptionRealm>[").append(realmGet$levels().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{presenters:");
        stringBuilder.append("RealmList<SPTinyOptionRealm>[").append(realmGet$presenters().size()).append("]");
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
        player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy aSPOptionRealm = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSPOptionRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSPOptionRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSPOptionRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
