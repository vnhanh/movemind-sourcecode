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
public class player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy extends player.wellnesssolutions.database.model.video.RealmDVideo
    implements RealmObjectProxy, player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface {

    static final class RealmDVideoColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long tagIndex;
        long brandIdIndex;
        long brandTypeLogoIndex;
        long durationIdIndex;
        long durationNameIndex;
        long languageIdIndex;
        long videoNameIndex;
        long presenterIdIndex;
        long presenterNameIndex;
        long videoUrlIndex;
        long trailerUrlIndex;
        long thumbnailLargeUrlIndex;
        long thumbnailMediumUrlIndex;
        long thumbnailSmallUrlIndex;
        long videoLengthIndex;
        long videoSizeIndex;
        long playTimeIndex;
        long downloadUrlIndex;
        long languagesIndex;
        long subtitlesIndex;
        long collectionsIndex;
        long levelsIndex;
        long isDownloadedIndex;
        long isFailureDownloadIndex;

        RealmDVideoColumnInfo(OsSchemaInfo schemaInfo) {
            super(25);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmDVideo");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.tagIndex = addColumnDetails("tag", "tag", objectSchemaInfo);
            this.brandIdIndex = addColumnDetails("brandId", "brandId", objectSchemaInfo);
            this.brandTypeLogoIndex = addColumnDetails("brandTypeLogo", "brandTypeLogo", objectSchemaInfo);
            this.durationIdIndex = addColumnDetails("durationId", "durationId", objectSchemaInfo);
            this.durationNameIndex = addColumnDetails("durationName", "durationName", objectSchemaInfo);
            this.languageIdIndex = addColumnDetails("languageId", "languageId", objectSchemaInfo);
            this.videoNameIndex = addColumnDetails("videoName", "videoName", objectSchemaInfo);
            this.presenterIdIndex = addColumnDetails("presenterId", "presenterId", objectSchemaInfo);
            this.presenterNameIndex = addColumnDetails("presenterName", "presenterName", objectSchemaInfo);
            this.videoUrlIndex = addColumnDetails("videoUrl", "videoUrl", objectSchemaInfo);
            this.trailerUrlIndex = addColumnDetails("trailerUrl", "trailerUrl", objectSchemaInfo);
            this.thumbnailLargeUrlIndex = addColumnDetails("thumbnailLargeUrl", "thumbnailLargeUrl", objectSchemaInfo);
            this.thumbnailMediumUrlIndex = addColumnDetails("thumbnailMediumUrl", "thumbnailMediumUrl", objectSchemaInfo);
            this.thumbnailSmallUrlIndex = addColumnDetails("thumbnailSmallUrl", "thumbnailSmallUrl", objectSchemaInfo);
            this.videoLengthIndex = addColumnDetails("videoLength", "videoLength", objectSchemaInfo);
            this.videoSizeIndex = addColumnDetails("videoSize", "videoSize", objectSchemaInfo);
            this.playTimeIndex = addColumnDetails("playTime", "playTime", objectSchemaInfo);
            this.downloadUrlIndex = addColumnDetails("downloadUrl", "downloadUrl", objectSchemaInfo);
            this.languagesIndex = addColumnDetails("languages", "languages", objectSchemaInfo);
            this.subtitlesIndex = addColumnDetails("subtitles", "subtitles", objectSchemaInfo);
            this.collectionsIndex = addColumnDetails("collections", "collections", objectSchemaInfo);
            this.levelsIndex = addColumnDetails("levels", "levels", objectSchemaInfo);
            this.isDownloadedIndex = addColumnDetails("isDownloaded", "isDownloaded", objectSchemaInfo);
            this.isFailureDownloadIndex = addColumnDetails("isFailureDownload", "isFailureDownload", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        RealmDVideoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmDVideoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmDVideoColumnInfo src = (RealmDVideoColumnInfo) rawSrc;
            final RealmDVideoColumnInfo dst = (RealmDVideoColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.tagIndex = src.tagIndex;
            dst.brandIdIndex = src.brandIdIndex;
            dst.brandTypeLogoIndex = src.brandTypeLogoIndex;
            dst.durationIdIndex = src.durationIdIndex;
            dst.durationNameIndex = src.durationNameIndex;
            dst.languageIdIndex = src.languageIdIndex;
            dst.videoNameIndex = src.videoNameIndex;
            dst.presenterIdIndex = src.presenterIdIndex;
            dst.presenterNameIndex = src.presenterNameIndex;
            dst.videoUrlIndex = src.videoUrlIndex;
            dst.trailerUrlIndex = src.trailerUrlIndex;
            dst.thumbnailLargeUrlIndex = src.thumbnailLargeUrlIndex;
            dst.thumbnailMediumUrlIndex = src.thumbnailMediumUrlIndex;
            dst.thumbnailSmallUrlIndex = src.thumbnailSmallUrlIndex;
            dst.videoLengthIndex = src.videoLengthIndex;
            dst.videoSizeIndex = src.videoSizeIndex;
            dst.playTimeIndex = src.playTimeIndex;
            dst.downloadUrlIndex = src.downloadUrlIndex;
            dst.languagesIndex = src.languagesIndex;
            dst.subtitlesIndex = src.subtitlesIndex;
            dst.collectionsIndex = src.collectionsIndex;
            dst.levelsIndex = src.levelsIndex;
            dst.isDownloadedIndex = src.isDownloadedIndex;
            dst.isFailureDownloadIndex = src.isFailureDownloadIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RealmDVideoColumnInfo columnInfo;
    private ProxyState<player.wellnesssolutions.database.model.video.RealmDVideo> proxyState;
    private RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesRealmList;
    private RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesRealmList;
    private RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsRealmList;
    private RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsRealmList;

    player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmDVideoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<player.wellnesssolutions.database.model.video.RealmDVideo>(this);
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
    public Integer realmGet$brandId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.brandIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.brandIdIndex);
    }

    @Override
    public void realmSet$brandId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.brandIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.brandIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.brandIdIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.brandIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$brandTypeLogo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.brandTypeLogoIndex);
    }

    @Override
    public void realmSet$brandTypeLogo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.brandTypeLogoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.brandTypeLogoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.brandTypeLogoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.brandTypeLogoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$durationId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.durationIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.durationIdIndex);
    }

    @Override
    public void realmSet$durationId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.durationIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.durationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.durationIdIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.durationIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$durationName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.durationNameIndex);
    }

    @Override
    public void realmSet$durationName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.durationNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.durationNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.durationNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.durationNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$languageId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.languageIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.languageIdIndex);
    }

    @Override
    public void realmSet$languageId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.languageIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.languageIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.languageIdIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.languageIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$videoName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.videoNameIndex);
    }

    @Override
    public void realmSet$videoName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.videoNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.videoNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$presenterId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.presenterIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.presenterIdIndex);
    }

    @Override
    public void realmSet$presenterId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.presenterIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.presenterIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.presenterIdIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.presenterIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$presenterName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.presenterNameIndex);
    }

    @Override
    public void realmSet$presenterName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.presenterNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.presenterNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.presenterNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.presenterNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$videoUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.videoUrlIndex);
    }

    @Override
    public void realmSet$videoUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.videoUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.videoUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$trailerUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.trailerUrlIndex);
    }

    @Override
    public void realmSet$trailerUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.trailerUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.trailerUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.trailerUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.trailerUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbnailLargeUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbnailLargeUrlIndex);
    }

    @Override
    public void realmSet$thumbnailLargeUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbnailLargeUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbnailLargeUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbnailLargeUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbnailLargeUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbnailMediumUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbnailMediumUrlIndex);
    }

    @Override
    public void realmSet$thumbnailMediumUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbnailMediumUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbnailMediumUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbnailMediumUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbnailMediumUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbnailSmallUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbnailSmallUrlIndex);
    }

    @Override
    public void realmSet$thumbnailSmallUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbnailSmallUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbnailSmallUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbnailSmallUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbnailSmallUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Float realmGet$videoLength() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.videoLengthIndex)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.videoLengthIndex);
    }

    @Override
    public void realmSet$videoLength(Float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoLengthIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setFloat(columnInfo.videoLengthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoLengthIndex);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.videoLengthIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Long realmGet$videoSize() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.videoSizeIndex)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.videoSizeIndex);
    }

    @Override
    public void realmSet$videoSize(Long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoSizeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.videoSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoSizeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.videoSizeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$playTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.playTimeIndex);
    }

    @Override
    public void realmSet$playTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.playTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.playTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.playTimeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.playTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$downloadUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.downloadUrlIndex);
    }

    @Override
    public void realmSet$downloadUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.downloadUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.downloadUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.downloadUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.downloadUrlIndex, value);
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> realmGet$languages() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (languagesRealmList != null) {
            return languagesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.languagesIndex);
            languagesRealmList = new RealmList<player.wellnesssolutions.database.model.video.RealmLanguage>(player.wellnesssolutions.database.model.video.RealmLanguage.class, osList, proxyState.getRealm$realm());
            return languagesRealmList;
        }
    }

    @Override
    public void realmSet$languages(RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("languages")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.video.RealmLanguage>();
                for (player.wellnesssolutions.database.model.video.RealmLanguage item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.languagesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.video.RealmLanguage linkedObject = value.get(i);
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
                player.wellnesssolutions.database.model.video.RealmLanguage linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> realmGet$subtitles() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (subtitlesRealmList != null) {
            return subtitlesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.subtitlesIndex);
            subtitlesRealmList = new RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle>(player.wellnesssolutions.database.model.video.RealmSubtitle.class, osList, proxyState.getRealm$realm());
            return subtitlesRealmList;
        }
    }

    @Override
    public void realmSet$subtitles(RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("subtitles")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle>();
                for (player.wellnesssolutions.database.model.video.RealmSubtitle item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.subtitlesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.video.RealmSubtitle linkedObject = value.get(i);
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
                player.wellnesssolutions.database.model.video.RealmSubtitle linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> realmGet$collections() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (collectionsRealmList != null) {
            return collectionsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.collectionsIndex);
            collectionsRealmList = new RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm>(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class, osList, proxyState.getRealm$realm());
            return collectionsRealmList;
        }
    }

    @Override
    public void realmSet$collections(RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> value) {
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
                final RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm>();
                for (player.wellnesssolutions.database.model.video.TinyCollectionRealm item : original) {
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
                player.wellnesssolutions.database.model.video.TinyCollectionRealm linkedObject = value.get(i);
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
                player.wellnesssolutions.database.model.video.TinyCollectionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> realmGet$levels() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (levelsRealmList != null) {
            return levelsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.levelsIndex);
            levelsRealmList = new RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm>(player.wellnesssolutions.database.model.video.TinyOptionRealm.class, osList, proxyState.getRealm$realm());
            return levelsRealmList;
        }
    }

    @Override
    public void realmSet$levels(RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> value) {
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
                final RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> original = value;
                value = new RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm>();
                for (player.wellnesssolutions.database.model.video.TinyOptionRealm item : original) {
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
                player.wellnesssolutions.database.model.video.TinyOptionRealm linkedObject = value.get(i);
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
                player.wellnesssolutions.database.model.video.TinyOptionRealm linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isDownloaded() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isDownloadedIndex);
    }

    @Override
    public void realmSet$isDownloaded(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isDownloadedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isDownloadedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isFailureDownload() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isFailureDownloadIndex);
    }

    @Override
    public void realmSet$isFailureDownload(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isFailureDownloadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isFailureDownloadIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmDVideo", 25, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("tag", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("brandId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("brandTypeLogo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("durationId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("durationName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("languageId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("videoName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("presenterId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("presenterName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("videoUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("trailerUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumbnailLargeUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumbnailMediumUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumbnailSmallUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("videoLength", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("videoSize", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("playTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("downloadUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("languages", RealmFieldType.LIST, "RealmLanguage");
        builder.addPersistedLinkProperty("subtitles", RealmFieldType.LIST, "RealmSubtitle");
        builder.addPersistedLinkProperty("collections", RealmFieldType.LIST, "TinyCollectionRealm");
        builder.addPersistedLinkProperty("levels", RealmFieldType.LIST, "TinyOptionRealm");
        builder.addPersistedProperty("isDownloaded", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isFailureDownload", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmDVideoColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmDVideoColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmDVideo";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RealmDVideo";
    }

    @SuppressWarnings("cast")
    public static player.wellnesssolutions.database.model.video.RealmDVideo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(4);
        if (json.has("languages")) {
            excludeFields.add("languages");
        }
        if (json.has("subtitles")) {
            excludeFields.add("subtitles");
        }
        if (json.has("collections")) {
            excludeFields.add("collections");
        }
        if (json.has("levels")) {
            excludeFields.add("levels");
        }
        player.wellnesssolutions.database.model.video.RealmDVideo obj = realm.createObjectInternal(player.wellnesssolutions.database.model.video.RealmDVideo.class, true, excludeFields);

        final player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) obj;
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
        if (json.has("brandId")) {
            if (json.isNull("brandId")) {
                objProxy.realmSet$brandId(null);
            } else {
                objProxy.realmSet$brandId((int) json.getInt("brandId"));
            }
        }
        if (json.has("brandTypeLogo")) {
            if (json.isNull("brandTypeLogo")) {
                objProxy.realmSet$brandTypeLogo(null);
            } else {
                objProxy.realmSet$brandTypeLogo((String) json.getString("brandTypeLogo"));
            }
        }
        if (json.has("durationId")) {
            if (json.isNull("durationId")) {
                objProxy.realmSet$durationId(null);
            } else {
                objProxy.realmSet$durationId((int) json.getInt("durationId"));
            }
        }
        if (json.has("durationName")) {
            if (json.isNull("durationName")) {
                objProxy.realmSet$durationName(null);
            } else {
                objProxy.realmSet$durationName((String) json.getString("durationName"));
            }
        }
        if (json.has("languageId")) {
            if (json.isNull("languageId")) {
                objProxy.realmSet$languageId(null);
            } else {
                objProxy.realmSet$languageId((int) json.getInt("languageId"));
            }
        }
        if (json.has("videoName")) {
            if (json.isNull("videoName")) {
                objProxy.realmSet$videoName(null);
            } else {
                objProxy.realmSet$videoName((String) json.getString("videoName"));
            }
        }
        if (json.has("presenterId")) {
            if (json.isNull("presenterId")) {
                objProxy.realmSet$presenterId(null);
            } else {
                objProxy.realmSet$presenterId((int) json.getInt("presenterId"));
            }
        }
        if (json.has("presenterName")) {
            if (json.isNull("presenterName")) {
                objProxy.realmSet$presenterName(null);
            } else {
                objProxy.realmSet$presenterName((String) json.getString("presenterName"));
            }
        }
        if (json.has("videoUrl")) {
            if (json.isNull("videoUrl")) {
                objProxy.realmSet$videoUrl(null);
            } else {
                objProxy.realmSet$videoUrl((String) json.getString("videoUrl"));
            }
        }
        if (json.has("trailerUrl")) {
            if (json.isNull("trailerUrl")) {
                objProxy.realmSet$trailerUrl(null);
            } else {
                objProxy.realmSet$trailerUrl((String) json.getString("trailerUrl"));
            }
        }
        if (json.has("thumbnailLargeUrl")) {
            if (json.isNull("thumbnailLargeUrl")) {
                objProxy.realmSet$thumbnailLargeUrl(null);
            } else {
                objProxy.realmSet$thumbnailLargeUrl((String) json.getString("thumbnailLargeUrl"));
            }
        }
        if (json.has("thumbnailMediumUrl")) {
            if (json.isNull("thumbnailMediumUrl")) {
                objProxy.realmSet$thumbnailMediumUrl(null);
            } else {
                objProxy.realmSet$thumbnailMediumUrl((String) json.getString("thumbnailMediumUrl"));
            }
        }
        if (json.has("thumbnailSmallUrl")) {
            if (json.isNull("thumbnailSmallUrl")) {
                objProxy.realmSet$thumbnailSmallUrl(null);
            } else {
                objProxy.realmSet$thumbnailSmallUrl((String) json.getString("thumbnailSmallUrl"));
            }
        }
        if (json.has("videoLength")) {
            if (json.isNull("videoLength")) {
                objProxy.realmSet$videoLength(null);
            } else {
                objProxy.realmSet$videoLength((float) json.getDouble("videoLength"));
            }
        }
        if (json.has("videoSize")) {
            if (json.isNull("videoSize")) {
                objProxy.realmSet$videoSize(null);
            } else {
                objProxy.realmSet$videoSize((long) json.getLong("videoSize"));
            }
        }
        if (json.has("playTime")) {
            if (json.isNull("playTime")) {
                objProxy.realmSet$playTime(null);
            } else {
                objProxy.realmSet$playTime((String) json.getString("playTime"));
            }
        }
        if (json.has("downloadUrl")) {
            if (json.isNull("downloadUrl")) {
                objProxy.realmSet$downloadUrl(null);
            } else {
                objProxy.realmSet$downloadUrl((String) json.getString("downloadUrl"));
            }
        }
        if (json.has("languages")) {
            if (json.isNull("languages")) {
                objProxy.realmSet$languages(null);
            } else {
                objProxy.realmGet$languages().clear();
                JSONArray array = json.getJSONArray("languages");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.video.RealmLanguage item = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$languages().add(item);
                }
            }
        }
        if (json.has("subtitles")) {
            if (json.isNull("subtitles")) {
                objProxy.realmSet$subtitles(null);
            } else {
                objProxy.realmGet$subtitles().clear();
                JSONArray array = json.getJSONArray("subtitles");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.video.RealmSubtitle item = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$subtitles().add(item);
                }
            }
        }
        if (json.has("collections")) {
            if (json.isNull("collections")) {
                objProxy.realmSet$collections(null);
            } else {
                objProxy.realmGet$collections().clear();
                JSONArray array = json.getJSONArray("collections");
                for (int i = 0; i < array.length(); i++) {
                    player.wellnesssolutions.database.model.video.TinyCollectionRealm item = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$collections().add(item);
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
                    player.wellnesssolutions.database.model.video.TinyOptionRealm item = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$levels().add(item);
                }
            }
        }
        if (json.has("isDownloaded")) {
            if (json.isNull("isDownloaded")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isDownloaded' to null.");
            } else {
                objProxy.realmSet$isDownloaded((boolean) json.getBoolean("isDownloaded"));
            }
        }
        if (json.has("isFailureDownload")) {
            if (json.isNull("isFailureDownload")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isFailureDownload' to null.");
            } else {
                objProxy.realmSet$isFailureDownload((boolean) json.getBoolean("isFailureDownload"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static player.wellnesssolutions.database.model.video.RealmDVideo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final player.wellnesssolutions.database.model.video.RealmDVideo obj = new player.wellnesssolutions.database.model.video.RealmDVideo();
        final player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface objProxy = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) obj;
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
            } else if (name.equals("brandId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$brandId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$brandId(null);
                }
            } else if (name.equals("brandTypeLogo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$brandTypeLogo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$brandTypeLogo(null);
                }
            } else if (name.equals("durationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$durationId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$durationId(null);
                }
            } else if (name.equals("durationName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$durationName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$durationName(null);
                }
            } else if (name.equals("languageId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$languageId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$languageId(null);
                }
            } else if (name.equals("videoName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$videoName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$videoName(null);
                }
            } else if (name.equals("presenterId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$presenterId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$presenterId(null);
                }
            } else if (name.equals("presenterName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$presenterName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$presenterName(null);
                }
            } else if (name.equals("videoUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$videoUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$videoUrl(null);
                }
            } else if (name.equals("trailerUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$trailerUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$trailerUrl(null);
                }
            } else if (name.equals("thumbnailLargeUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbnailLargeUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbnailLargeUrl(null);
                }
            } else if (name.equals("thumbnailMediumUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbnailMediumUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbnailMediumUrl(null);
                }
            } else if (name.equals("thumbnailSmallUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbnailSmallUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbnailSmallUrl(null);
                }
            } else if (name.equals("videoLength")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$videoLength((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$videoLength(null);
                }
            } else if (name.equals("videoSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$videoSize((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$videoSize(null);
                }
            } else if (name.equals("playTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$playTime((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$playTime(null);
                }
            } else if (name.equals("downloadUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$downloadUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$downloadUrl(null);
                }
            } else if (name.equals("languages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$languages(null);
                } else {
                    objProxy.realmSet$languages(new RealmList<player.wellnesssolutions.database.model.video.RealmLanguage>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.video.RealmLanguage item = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$languages().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("subtitles")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$subtitles(null);
                } else {
                    objProxy.realmSet$subtitles(new RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.video.RealmSubtitle item = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$subtitles().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("collections")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$collections(null);
                } else {
                    objProxy.realmSet$collections(new RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.video.TinyCollectionRealm item = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$collections().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("levels")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$levels(null);
                } else {
                    objProxy.realmSet$levels(new RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        player.wellnesssolutions.database.model.video.TinyOptionRealm item = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$levels().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("isDownloaded")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isDownloaded((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isDownloaded' to null.");
                }
            } else if (name.equals("isFailureDownload")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isFailureDownload((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isFailureDownload' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmDVideo.class), false, Collections.<String>emptyList());
        io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy obj = new io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static player.wellnesssolutions.database.model.video.RealmDVideo copyOrUpdate(Realm realm, RealmDVideoColumnInfo columnInfo, player.wellnesssolutions.database.model.video.RealmDVideo object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (player.wellnesssolutions.database.model.video.RealmDVideo) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static player.wellnesssolutions.database.model.video.RealmDVideo copy(Realm realm, RealmDVideoColumnInfo columnInfo, player.wellnesssolutions.database.model.video.RealmDVideo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (player.wellnesssolutions.database.model.video.RealmDVideo) cachedRealmObject;
        }

        player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface realmObjectSource = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) newObject;

        Table table = realm.getTable(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.tagIndex, realmObjectSource.realmGet$tag());
        builder.addInteger(columnInfo.brandIdIndex, realmObjectSource.realmGet$brandId());
        builder.addString(columnInfo.brandTypeLogoIndex, realmObjectSource.realmGet$brandTypeLogo());
        builder.addInteger(columnInfo.durationIdIndex, realmObjectSource.realmGet$durationId());
        builder.addString(columnInfo.durationNameIndex, realmObjectSource.realmGet$durationName());
        builder.addInteger(columnInfo.languageIdIndex, realmObjectSource.realmGet$languageId());
        builder.addString(columnInfo.videoNameIndex, realmObjectSource.realmGet$videoName());
        builder.addInteger(columnInfo.presenterIdIndex, realmObjectSource.realmGet$presenterId());
        builder.addString(columnInfo.presenterNameIndex, realmObjectSource.realmGet$presenterName());
        builder.addString(columnInfo.videoUrlIndex, realmObjectSource.realmGet$videoUrl());
        builder.addString(columnInfo.trailerUrlIndex, realmObjectSource.realmGet$trailerUrl());
        builder.addString(columnInfo.thumbnailLargeUrlIndex, realmObjectSource.realmGet$thumbnailLargeUrl());
        builder.addString(columnInfo.thumbnailMediumUrlIndex, realmObjectSource.realmGet$thumbnailMediumUrl());
        builder.addString(columnInfo.thumbnailSmallUrlIndex, realmObjectSource.realmGet$thumbnailSmallUrl());
        builder.addFloat(columnInfo.videoLengthIndex, realmObjectSource.realmGet$videoLength());
        builder.addInteger(columnInfo.videoSizeIndex, realmObjectSource.realmGet$videoSize());
        builder.addString(columnInfo.playTimeIndex, realmObjectSource.realmGet$playTime());
        builder.addString(columnInfo.downloadUrlIndex, realmObjectSource.realmGet$downloadUrl());
        builder.addBoolean(columnInfo.isDownloadedIndex, realmObjectSource.realmGet$isDownloaded());
        builder.addBoolean(columnInfo.isFailureDownloadIndex, realmObjectSource.realmGet$isFailureDownload());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesList = realmObjectSource.realmGet$languages();
        if (languagesList != null) {
            RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesRealmList = realmObjectCopy.realmGet$languages();
            languagesRealmList.clear();
            for (int i = 0; i < languagesList.size(); i++) {
                player.wellnesssolutions.database.model.video.RealmLanguage languagesItem = languagesList.get(i);
                player.wellnesssolutions.database.model.video.RealmLanguage cachelanguages = (player.wellnesssolutions.database.model.video.RealmLanguage) cache.get(languagesItem);
                if (cachelanguages != null) {
                    languagesRealmList.add(cachelanguages);
                } else {
                    languagesRealmList.add(player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.RealmLanguageColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmLanguage.class), languagesItem, update, cache, flags));
                }
            }
        }

        RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesList = realmObjectSource.realmGet$subtitles();
        if (subtitlesList != null) {
            RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesRealmList = realmObjectCopy.realmGet$subtitles();
            subtitlesRealmList.clear();
            for (int i = 0; i < subtitlesList.size(); i++) {
                player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem = subtitlesList.get(i);
                player.wellnesssolutions.database.model.video.RealmSubtitle cachesubtitles = (player.wellnesssolutions.database.model.video.RealmSubtitle) cache.get(subtitlesItem);
                if (cachesubtitles != null) {
                    subtitlesRealmList.add(cachesubtitles);
                } else {
                    subtitlesRealmList.add(player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.RealmSubtitleColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmSubtitle.class), subtitlesItem, update, cache, flags));
                }
            }
        }

        RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsList = realmObjectSource.realmGet$collections();
        if (collectionsList != null) {
            RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsRealmList = realmObjectCopy.realmGet$collections();
            collectionsRealmList.clear();
            for (int i = 0; i < collectionsList.size(); i++) {
                player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem = collectionsList.get(i);
                player.wellnesssolutions.database.model.video.TinyCollectionRealm cachecollections = (player.wellnesssolutions.database.model.video.TinyCollectionRealm) cache.get(collectionsItem);
                if (cachecollections != null) {
                    collectionsRealmList.add(cachecollections);
                } else {
                    collectionsRealmList.add(player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.TinyCollectionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class), collectionsItem, update, cache, flags));
                }
            }
        }

        RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsList = realmObjectSource.realmGet$levels();
        if (levelsList != null) {
            RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsRealmList = realmObjectCopy.realmGet$levels();
            levelsRealmList.clear();
            for (int i = 0; i < levelsList.size(); i++) {
                player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem = levelsList.get(i);
                player.wellnesssolutions.database.model.video.TinyOptionRealm cachelevels = (player.wellnesssolutions.database.model.video.TinyOptionRealm) cache.get(levelsItem);
                if (cachelevels != null) {
                    levelsRealmList.add(cachelevels);
                } else {
                    levelsRealmList.add(player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.copyOrUpdate(realm, (player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.TinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyOptionRealm.class), levelsItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, player.wellnesssolutions.database.model.video.RealmDVideo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        long tableNativePtr = table.getNativePtr();
        RealmDVideoColumnInfo columnInfo = (RealmDVideoColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        }
        String realmGet$tag = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        }
        Number realmGet$brandId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandId();
        if (realmGet$brandId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.brandIdIndex, rowIndex, realmGet$brandId.longValue(), false);
        }
        String realmGet$brandTypeLogo = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandTypeLogo();
        if (realmGet$brandTypeLogo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.brandTypeLogoIndex, rowIndex, realmGet$brandTypeLogo, false);
        }
        Number realmGet$durationId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationId();
        if (realmGet$durationId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIdIndex, rowIndex, realmGet$durationId.longValue(), false);
        }
        String realmGet$durationName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationName();
        if (realmGet$durationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.durationNameIndex, rowIndex, realmGet$durationName, false);
        }
        Number realmGet$languageId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languageId();
        if (realmGet$languageId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.languageIdIndex, rowIndex, realmGet$languageId.longValue(), false);
        }
        String realmGet$videoName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoName();
        if (realmGet$videoName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoNameIndex, rowIndex, realmGet$videoName, false);
        }
        Number realmGet$presenterId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterId();
        if (realmGet$presenterId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.presenterIdIndex, rowIndex, realmGet$presenterId.longValue(), false);
        }
        String realmGet$presenterName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterName();
        if (realmGet$presenterName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.presenterNameIndex, rowIndex, realmGet$presenterName, false);
        }
        String realmGet$videoUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoUrl();
        if (realmGet$videoUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoUrlIndex, rowIndex, realmGet$videoUrl, false);
        }
        String realmGet$trailerUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$trailerUrl();
        if (realmGet$trailerUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.trailerUrlIndex, rowIndex, realmGet$trailerUrl, false);
        }
        String realmGet$thumbnailLargeUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailLargeUrl();
        if (realmGet$thumbnailLargeUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailLargeUrlIndex, rowIndex, realmGet$thumbnailLargeUrl, false);
        }
        String realmGet$thumbnailMediumUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailMediumUrl();
        if (realmGet$thumbnailMediumUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailMediumUrlIndex, rowIndex, realmGet$thumbnailMediumUrl, false);
        }
        String realmGet$thumbnailSmallUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailSmallUrl();
        if (realmGet$thumbnailSmallUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailSmallUrlIndex, rowIndex, realmGet$thumbnailSmallUrl, false);
        }
        Float realmGet$videoLength = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoLength();
        if (realmGet$videoLength != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.videoLengthIndex, rowIndex, realmGet$videoLength, false);
        }
        Number realmGet$videoSize = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoSize();
        if (realmGet$videoSize != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.videoSizeIndex, rowIndex, realmGet$videoSize.longValue(), false);
        }
        String realmGet$playTime = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$playTime();
        if (realmGet$playTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.playTimeIndex, rowIndex, realmGet$playTime, false);
        }
        String realmGet$downloadUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$downloadUrl();
        if (realmGet$downloadUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.downloadUrlIndex, rowIndex, realmGet$downloadUrl, false);
        }

        RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languages();
        if (languagesList != null) {
            OsList languagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.languagesIndex);
            for (player.wellnesssolutions.database.model.video.RealmLanguage languagesItem : languagesList) {
                Long cacheItemIndexlanguages = cache.get(languagesItem);
                if (cacheItemIndexlanguages == null) {
                    cacheItemIndexlanguages = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insert(realm, languagesItem, cache);
                }
                languagesOsList.addRow(cacheItemIndexlanguages);
            }
        }

        RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$subtitles();
        if (subtitlesList != null) {
            OsList subtitlesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subtitlesIndex);
            for (player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem : subtitlesList) {
                Long cacheItemIndexsubtitles = cache.get(subtitlesItem);
                if (cacheItemIndexsubtitles == null) {
                    cacheItemIndexsubtitles = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insert(realm, subtitlesItem, cache);
                }
                subtitlesOsList.addRow(cacheItemIndexsubtitles);
            }
        }

        RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$collections();
        if (collectionsList != null) {
            OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
            for (player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem : collectionsList) {
                Long cacheItemIndexcollections = cache.get(collectionsItem);
                if (cacheItemIndexcollections == null) {
                    cacheItemIndexcollections = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insert(realm, collectionsItem, cache);
                }
                collectionsOsList.addRow(cacheItemIndexcollections);
            }
        }

        RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$levels();
        if (levelsList != null) {
            OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
            for (player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem : levelsList) {
                Long cacheItemIndexlevels = cache.get(levelsItem);
                if (cacheItemIndexlevels == null) {
                    cacheItemIndexlevels = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insert(realm, levelsItem, cache);
                }
                levelsOsList.addRow(cacheItemIndexlevels);
            }
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isDownloadedIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isDownloaded(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isFailureDownloadIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isFailureDownload(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        long tableNativePtr = table.getNativePtr();
        RealmDVideoColumnInfo columnInfo = (RealmDVideoColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        player.wellnesssolutions.database.model.video.RealmDVideo object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.video.RealmDVideo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$id = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
            }
            String realmGet$tag = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            }
            Number realmGet$brandId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandId();
            if (realmGet$brandId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.brandIdIndex, rowIndex, realmGet$brandId.longValue(), false);
            }
            String realmGet$brandTypeLogo = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandTypeLogo();
            if (realmGet$brandTypeLogo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.brandTypeLogoIndex, rowIndex, realmGet$brandTypeLogo, false);
            }
            Number realmGet$durationId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationId();
            if (realmGet$durationId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.durationIdIndex, rowIndex, realmGet$durationId.longValue(), false);
            }
            String realmGet$durationName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationName();
            if (realmGet$durationName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.durationNameIndex, rowIndex, realmGet$durationName, false);
            }
            Number realmGet$languageId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languageId();
            if (realmGet$languageId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.languageIdIndex, rowIndex, realmGet$languageId.longValue(), false);
            }
            String realmGet$videoName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoName();
            if (realmGet$videoName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.videoNameIndex, rowIndex, realmGet$videoName, false);
            }
            Number realmGet$presenterId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterId();
            if (realmGet$presenterId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.presenterIdIndex, rowIndex, realmGet$presenterId.longValue(), false);
            }
            String realmGet$presenterName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterName();
            if (realmGet$presenterName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.presenterNameIndex, rowIndex, realmGet$presenterName, false);
            }
            String realmGet$videoUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoUrl();
            if (realmGet$videoUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.videoUrlIndex, rowIndex, realmGet$videoUrl, false);
            }
            String realmGet$trailerUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$trailerUrl();
            if (realmGet$trailerUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.trailerUrlIndex, rowIndex, realmGet$trailerUrl, false);
            }
            String realmGet$thumbnailLargeUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailLargeUrl();
            if (realmGet$thumbnailLargeUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailLargeUrlIndex, rowIndex, realmGet$thumbnailLargeUrl, false);
            }
            String realmGet$thumbnailMediumUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailMediumUrl();
            if (realmGet$thumbnailMediumUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailMediumUrlIndex, rowIndex, realmGet$thumbnailMediumUrl, false);
            }
            String realmGet$thumbnailSmallUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailSmallUrl();
            if (realmGet$thumbnailSmallUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailSmallUrlIndex, rowIndex, realmGet$thumbnailSmallUrl, false);
            }
            Float realmGet$videoLength = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoLength();
            if (realmGet$videoLength != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.videoLengthIndex, rowIndex, realmGet$videoLength, false);
            }
            Number realmGet$videoSize = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoSize();
            if (realmGet$videoSize != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.videoSizeIndex, rowIndex, realmGet$videoSize.longValue(), false);
            }
            String realmGet$playTime = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$playTime();
            if (realmGet$playTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.playTimeIndex, rowIndex, realmGet$playTime, false);
            }
            String realmGet$downloadUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$downloadUrl();
            if (realmGet$downloadUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.downloadUrlIndex, rowIndex, realmGet$downloadUrl, false);
            }

            RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languages();
            if (languagesList != null) {
                OsList languagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.languagesIndex);
                for (player.wellnesssolutions.database.model.video.RealmLanguage languagesItem : languagesList) {
                    Long cacheItemIndexlanguages = cache.get(languagesItem);
                    if (cacheItemIndexlanguages == null) {
                        cacheItemIndexlanguages = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insert(realm, languagesItem, cache);
                    }
                    languagesOsList.addRow(cacheItemIndexlanguages);
                }
            }

            RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$subtitles();
            if (subtitlesList != null) {
                OsList subtitlesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subtitlesIndex);
                for (player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem : subtitlesList) {
                    Long cacheItemIndexsubtitles = cache.get(subtitlesItem);
                    if (cacheItemIndexsubtitles == null) {
                        cacheItemIndexsubtitles = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insert(realm, subtitlesItem, cache);
                    }
                    subtitlesOsList.addRow(cacheItemIndexsubtitles);
                }
            }

            RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$collections();
            if (collectionsList != null) {
                OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
                for (player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem : collectionsList) {
                    Long cacheItemIndexcollections = cache.get(collectionsItem);
                    if (cacheItemIndexcollections == null) {
                        cacheItemIndexcollections = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insert(realm, collectionsItem, cache);
                    }
                    collectionsOsList.addRow(cacheItemIndexcollections);
                }
            }

            RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$levels();
            if (levelsList != null) {
                OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
                for (player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem : levelsList) {
                    Long cacheItemIndexlevels = cache.get(levelsItem);
                    if (cacheItemIndexlevels == null) {
                        cacheItemIndexlevels = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insert(realm, levelsItem, cache);
                    }
                    levelsOsList.addRow(cacheItemIndexlevels);
                }
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isDownloadedIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isDownloaded(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isFailureDownloadIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isFailureDownload(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, player.wellnesssolutions.database.model.video.RealmDVideo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        long tableNativePtr = table.getNativePtr();
        RealmDVideoColumnInfo columnInfo = (RealmDVideoColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$tag = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
        }
        Number realmGet$brandId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandId();
        if (realmGet$brandId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.brandIdIndex, rowIndex, realmGet$brandId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.brandIdIndex, rowIndex, false);
        }
        String realmGet$brandTypeLogo = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandTypeLogo();
        if (realmGet$brandTypeLogo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.brandTypeLogoIndex, rowIndex, realmGet$brandTypeLogo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.brandTypeLogoIndex, rowIndex, false);
        }
        Number realmGet$durationId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationId();
        if (realmGet$durationId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIdIndex, rowIndex, realmGet$durationId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.durationIdIndex, rowIndex, false);
        }
        String realmGet$durationName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationName();
        if (realmGet$durationName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.durationNameIndex, rowIndex, realmGet$durationName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.durationNameIndex, rowIndex, false);
        }
        Number realmGet$languageId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languageId();
        if (realmGet$languageId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.languageIdIndex, rowIndex, realmGet$languageId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.languageIdIndex, rowIndex, false);
        }
        String realmGet$videoName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoName();
        if (realmGet$videoName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoNameIndex, rowIndex, realmGet$videoName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoNameIndex, rowIndex, false);
        }
        Number realmGet$presenterId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterId();
        if (realmGet$presenterId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.presenterIdIndex, rowIndex, realmGet$presenterId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.presenterIdIndex, rowIndex, false);
        }
        String realmGet$presenterName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterName();
        if (realmGet$presenterName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.presenterNameIndex, rowIndex, realmGet$presenterName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.presenterNameIndex, rowIndex, false);
        }
        String realmGet$videoUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoUrl();
        if (realmGet$videoUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoUrlIndex, rowIndex, realmGet$videoUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoUrlIndex, rowIndex, false);
        }
        String realmGet$trailerUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$trailerUrl();
        if (realmGet$trailerUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.trailerUrlIndex, rowIndex, realmGet$trailerUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.trailerUrlIndex, rowIndex, false);
        }
        String realmGet$thumbnailLargeUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailLargeUrl();
        if (realmGet$thumbnailLargeUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailLargeUrlIndex, rowIndex, realmGet$thumbnailLargeUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailLargeUrlIndex, rowIndex, false);
        }
        String realmGet$thumbnailMediumUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailMediumUrl();
        if (realmGet$thumbnailMediumUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailMediumUrlIndex, rowIndex, realmGet$thumbnailMediumUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailMediumUrlIndex, rowIndex, false);
        }
        String realmGet$thumbnailSmallUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailSmallUrl();
        if (realmGet$thumbnailSmallUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailSmallUrlIndex, rowIndex, realmGet$thumbnailSmallUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailSmallUrlIndex, rowIndex, false);
        }
        Float realmGet$videoLength = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoLength();
        if (realmGet$videoLength != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.videoLengthIndex, rowIndex, realmGet$videoLength, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoLengthIndex, rowIndex, false);
        }
        Number realmGet$videoSize = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoSize();
        if (realmGet$videoSize != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.videoSizeIndex, rowIndex, realmGet$videoSize.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoSizeIndex, rowIndex, false);
        }
        String realmGet$playTime = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$playTime();
        if (realmGet$playTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.playTimeIndex, rowIndex, realmGet$playTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.playTimeIndex, rowIndex, false);
        }
        String realmGet$downloadUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$downloadUrl();
        if (realmGet$downloadUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.downloadUrlIndex, rowIndex, realmGet$downloadUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.downloadUrlIndex, rowIndex, false);
        }

        OsList languagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.languagesIndex);
        RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languages();
        if (languagesList != null && languagesList.size() == languagesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = languagesList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.video.RealmLanguage languagesItem = languagesList.get(i);
                Long cacheItemIndexlanguages = cache.get(languagesItem);
                if (cacheItemIndexlanguages == null) {
                    cacheItemIndexlanguages = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, languagesItem, cache);
                }
                languagesOsList.setRow(i, cacheItemIndexlanguages);
            }
        } else {
            languagesOsList.removeAll();
            if (languagesList != null) {
                for (player.wellnesssolutions.database.model.video.RealmLanguage languagesItem : languagesList) {
                    Long cacheItemIndexlanguages = cache.get(languagesItem);
                    if (cacheItemIndexlanguages == null) {
                        cacheItemIndexlanguages = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, languagesItem, cache);
                    }
                    languagesOsList.addRow(cacheItemIndexlanguages);
                }
            }
        }


        OsList subtitlesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subtitlesIndex);
        RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$subtitles();
        if (subtitlesList != null && subtitlesList.size() == subtitlesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = subtitlesList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem = subtitlesList.get(i);
                Long cacheItemIndexsubtitles = cache.get(subtitlesItem);
                if (cacheItemIndexsubtitles == null) {
                    cacheItemIndexsubtitles = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, subtitlesItem, cache);
                }
                subtitlesOsList.setRow(i, cacheItemIndexsubtitles);
            }
        } else {
            subtitlesOsList.removeAll();
            if (subtitlesList != null) {
                for (player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem : subtitlesList) {
                    Long cacheItemIndexsubtitles = cache.get(subtitlesItem);
                    if (cacheItemIndexsubtitles == null) {
                        cacheItemIndexsubtitles = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, subtitlesItem, cache);
                    }
                    subtitlesOsList.addRow(cacheItemIndexsubtitles);
                }
            }
        }


        OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
        RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$collections();
        if (collectionsList != null && collectionsList.size() == collectionsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = collectionsList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem = collectionsList.get(i);
                Long cacheItemIndexcollections = cache.get(collectionsItem);
                if (cacheItemIndexcollections == null) {
                    cacheItemIndexcollections = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                }
                collectionsOsList.setRow(i, cacheItemIndexcollections);
            }
        } else {
            collectionsOsList.removeAll();
            if (collectionsList != null) {
                for (player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem : collectionsList) {
                    Long cacheItemIndexcollections = cache.get(collectionsItem);
                    if (cacheItemIndexcollections == null) {
                        cacheItemIndexcollections = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                    }
                    collectionsOsList.addRow(cacheItemIndexcollections);
                }
            }
        }


        OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
        RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$levels();
        if (levelsList != null && levelsList.size() == levelsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = levelsList.size();
            for (int i = 0; i < objects; i++) {
                player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem = levelsList.get(i);
                Long cacheItemIndexlevels = cache.get(levelsItem);
                if (cacheItemIndexlevels == null) {
                    cacheItemIndexlevels = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                }
                levelsOsList.setRow(i, cacheItemIndexlevels);
            }
        } else {
            levelsOsList.removeAll();
            if (levelsList != null) {
                for (player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem : levelsList) {
                    Long cacheItemIndexlevels = cache.get(levelsItem);
                    if (cacheItemIndexlevels == null) {
                        cacheItemIndexlevels = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                    }
                    levelsOsList.addRow(cacheItemIndexlevels);
                }
            }
        }

        Table.nativeSetBoolean(tableNativePtr, columnInfo.isDownloadedIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isDownloaded(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isFailureDownloadIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isFailureDownload(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        long tableNativePtr = table.getNativePtr();
        RealmDVideoColumnInfo columnInfo = (RealmDVideoColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        player.wellnesssolutions.database.model.video.RealmDVideo object = null;
        while (objects.hasNext()) {
            object = (player.wellnesssolutions.database.model.video.RealmDVideo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$id = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$tag = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
            }
            Number realmGet$brandId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandId();
            if (realmGet$brandId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.brandIdIndex, rowIndex, realmGet$brandId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.brandIdIndex, rowIndex, false);
            }
            String realmGet$brandTypeLogo = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$brandTypeLogo();
            if (realmGet$brandTypeLogo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.brandTypeLogoIndex, rowIndex, realmGet$brandTypeLogo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.brandTypeLogoIndex, rowIndex, false);
            }
            Number realmGet$durationId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationId();
            if (realmGet$durationId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.durationIdIndex, rowIndex, realmGet$durationId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.durationIdIndex, rowIndex, false);
            }
            String realmGet$durationName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$durationName();
            if (realmGet$durationName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.durationNameIndex, rowIndex, realmGet$durationName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.durationNameIndex, rowIndex, false);
            }
            Number realmGet$languageId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languageId();
            if (realmGet$languageId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.languageIdIndex, rowIndex, realmGet$languageId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.languageIdIndex, rowIndex, false);
            }
            String realmGet$videoName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoName();
            if (realmGet$videoName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.videoNameIndex, rowIndex, realmGet$videoName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.videoNameIndex, rowIndex, false);
            }
            Number realmGet$presenterId = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterId();
            if (realmGet$presenterId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.presenterIdIndex, rowIndex, realmGet$presenterId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.presenterIdIndex, rowIndex, false);
            }
            String realmGet$presenterName = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$presenterName();
            if (realmGet$presenterName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.presenterNameIndex, rowIndex, realmGet$presenterName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.presenterNameIndex, rowIndex, false);
            }
            String realmGet$videoUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoUrl();
            if (realmGet$videoUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.videoUrlIndex, rowIndex, realmGet$videoUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.videoUrlIndex, rowIndex, false);
            }
            String realmGet$trailerUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$trailerUrl();
            if (realmGet$trailerUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.trailerUrlIndex, rowIndex, realmGet$trailerUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.trailerUrlIndex, rowIndex, false);
            }
            String realmGet$thumbnailLargeUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailLargeUrl();
            if (realmGet$thumbnailLargeUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailLargeUrlIndex, rowIndex, realmGet$thumbnailLargeUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailLargeUrlIndex, rowIndex, false);
            }
            String realmGet$thumbnailMediumUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailMediumUrl();
            if (realmGet$thumbnailMediumUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailMediumUrlIndex, rowIndex, realmGet$thumbnailMediumUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailMediumUrlIndex, rowIndex, false);
            }
            String realmGet$thumbnailSmallUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$thumbnailSmallUrl();
            if (realmGet$thumbnailSmallUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailSmallUrlIndex, rowIndex, realmGet$thumbnailSmallUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailSmallUrlIndex, rowIndex, false);
            }
            Float realmGet$videoLength = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoLength();
            if (realmGet$videoLength != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.videoLengthIndex, rowIndex, realmGet$videoLength, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.videoLengthIndex, rowIndex, false);
            }
            Number realmGet$videoSize = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$videoSize();
            if (realmGet$videoSize != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.videoSizeIndex, rowIndex, realmGet$videoSize.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.videoSizeIndex, rowIndex, false);
            }
            String realmGet$playTime = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$playTime();
            if (realmGet$playTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.playTimeIndex, rowIndex, realmGet$playTime, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.playTimeIndex, rowIndex, false);
            }
            String realmGet$downloadUrl = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$downloadUrl();
            if (realmGet$downloadUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.downloadUrlIndex, rowIndex, realmGet$downloadUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.downloadUrlIndex, rowIndex, false);
            }

            OsList languagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.languagesIndex);
            RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> languagesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$languages();
            if (languagesList != null && languagesList.size() == languagesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = languagesList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.video.RealmLanguage languagesItem = languagesList.get(i);
                    Long cacheItemIndexlanguages = cache.get(languagesItem);
                    if (cacheItemIndexlanguages == null) {
                        cacheItemIndexlanguages = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, languagesItem, cache);
                    }
                    languagesOsList.setRow(i, cacheItemIndexlanguages);
                }
            } else {
                languagesOsList.removeAll();
                if (languagesList != null) {
                    for (player.wellnesssolutions.database.model.video.RealmLanguage languagesItem : languagesList) {
                        Long cacheItemIndexlanguages = cache.get(languagesItem);
                        if (cacheItemIndexlanguages == null) {
                            cacheItemIndexlanguages = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, languagesItem, cache);
                        }
                        languagesOsList.addRow(cacheItemIndexlanguages);
                    }
                }
            }


            OsList subtitlesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subtitlesIndex);
            RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> subtitlesList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$subtitles();
            if (subtitlesList != null && subtitlesList.size() == subtitlesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = subtitlesList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem = subtitlesList.get(i);
                    Long cacheItemIndexsubtitles = cache.get(subtitlesItem);
                    if (cacheItemIndexsubtitles == null) {
                        cacheItemIndexsubtitles = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, subtitlesItem, cache);
                    }
                    subtitlesOsList.setRow(i, cacheItemIndexsubtitles);
                }
            } else {
                subtitlesOsList.removeAll();
                if (subtitlesList != null) {
                    for (player.wellnesssolutions.database.model.video.RealmSubtitle subtitlesItem : subtitlesList) {
                        Long cacheItemIndexsubtitles = cache.get(subtitlesItem);
                        if (cacheItemIndexsubtitles == null) {
                            cacheItemIndexsubtitles = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, subtitlesItem, cache);
                        }
                        subtitlesOsList.addRow(cacheItemIndexsubtitles);
                    }
                }
            }


            OsList collectionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.collectionsIndex);
            RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> collectionsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$collections();
            if (collectionsList != null && collectionsList.size() == collectionsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = collectionsList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem = collectionsList.get(i);
                    Long cacheItemIndexcollections = cache.get(collectionsItem);
                    if (cacheItemIndexcollections == null) {
                        cacheItemIndexcollections = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                    }
                    collectionsOsList.setRow(i, cacheItemIndexcollections);
                }
            } else {
                collectionsOsList.removeAll();
                if (collectionsList != null) {
                    for (player.wellnesssolutions.database.model.video.TinyCollectionRealm collectionsItem : collectionsList) {
                        Long cacheItemIndexcollections = cache.get(collectionsItem);
                        if (cacheItemIndexcollections == null) {
                            cacheItemIndexcollections = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, collectionsItem, cache);
                        }
                        collectionsOsList.addRow(cacheItemIndexcollections);
                    }
                }
            }


            OsList levelsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.levelsIndex);
            RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> levelsList = ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$levels();
            if (levelsList != null && levelsList.size() == levelsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = levelsList.size();
                for (int i = 0; i < objectCount; i++) {
                    player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem = levelsList.get(i);
                    Long cacheItemIndexlevels = cache.get(levelsItem);
                    if (cacheItemIndexlevels == null) {
                        cacheItemIndexlevels = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                    }
                    levelsOsList.setRow(i, cacheItemIndexlevels);
                }
            } else {
                levelsOsList.removeAll();
                if (levelsList != null) {
                    for (player.wellnesssolutions.database.model.video.TinyOptionRealm levelsItem : levelsList) {
                        Long cacheItemIndexlevels = cache.get(levelsItem);
                        if (cacheItemIndexlevels == null) {
                            cacheItemIndexlevels = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, levelsItem, cache);
                        }
                        levelsOsList.addRow(cacheItemIndexlevels);
                    }
                }
            }

            Table.nativeSetBoolean(tableNativePtr, columnInfo.isDownloadedIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isDownloaded(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isFailureDownloadIndex, rowIndex, ((player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) object).realmGet$isFailureDownload(), false);
        }
    }

    public static player.wellnesssolutions.database.model.video.RealmDVideo createDetachedCopy(player.wellnesssolutions.database.model.video.RealmDVideo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        player.wellnesssolutions.database.model.video.RealmDVideo unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new player.wellnesssolutions.database.model.video.RealmDVideo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (player.wellnesssolutions.database.model.video.RealmDVideo) cachedObject.object;
            }
            unmanagedObject = (player.wellnesssolutions.database.model.video.RealmDVideo) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface unmanagedCopy = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) unmanagedObject;
        player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface realmSource = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$tag(realmSource.realmGet$tag());
        unmanagedCopy.realmSet$brandId(realmSource.realmGet$brandId());
        unmanagedCopy.realmSet$brandTypeLogo(realmSource.realmGet$brandTypeLogo());
        unmanagedCopy.realmSet$durationId(realmSource.realmGet$durationId());
        unmanagedCopy.realmSet$durationName(realmSource.realmGet$durationName());
        unmanagedCopy.realmSet$languageId(realmSource.realmGet$languageId());
        unmanagedCopy.realmSet$videoName(realmSource.realmGet$videoName());
        unmanagedCopy.realmSet$presenterId(realmSource.realmGet$presenterId());
        unmanagedCopy.realmSet$presenterName(realmSource.realmGet$presenterName());
        unmanagedCopy.realmSet$videoUrl(realmSource.realmGet$videoUrl());
        unmanagedCopy.realmSet$trailerUrl(realmSource.realmGet$trailerUrl());
        unmanagedCopy.realmSet$thumbnailLargeUrl(realmSource.realmGet$thumbnailLargeUrl());
        unmanagedCopy.realmSet$thumbnailMediumUrl(realmSource.realmGet$thumbnailMediumUrl());
        unmanagedCopy.realmSet$thumbnailSmallUrl(realmSource.realmGet$thumbnailSmallUrl());
        unmanagedCopy.realmSet$videoLength(realmSource.realmGet$videoLength());
        unmanagedCopy.realmSet$videoSize(realmSource.realmGet$videoSize());
        unmanagedCopy.realmSet$playTime(realmSource.realmGet$playTime());
        unmanagedCopy.realmSet$downloadUrl(realmSource.realmGet$downloadUrl());

        // Deep copy of languages
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$languages(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> managedlanguagesList = realmSource.realmGet$languages();
            RealmList<player.wellnesssolutions.database.model.video.RealmLanguage> unmanagedlanguagesList = new RealmList<player.wellnesssolutions.database.model.video.RealmLanguage>();
            unmanagedCopy.realmSet$languages(unmanagedlanguagesList);
            int nextDepth = currentDepth + 1;
            int size = managedlanguagesList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.video.RealmLanguage item = player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createDetachedCopy(managedlanguagesList.get(i), nextDepth, maxDepth, cache);
                unmanagedlanguagesList.add(item);
            }
        }

        // Deep copy of subtitles
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$subtitles(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> managedsubtitlesList = realmSource.realmGet$subtitles();
            RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle> unmanagedsubtitlesList = new RealmList<player.wellnesssolutions.database.model.video.RealmSubtitle>();
            unmanagedCopy.realmSet$subtitles(unmanagedsubtitlesList);
            int nextDepth = currentDepth + 1;
            int size = managedsubtitlesList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.video.RealmSubtitle item = player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createDetachedCopy(managedsubtitlesList.get(i), nextDepth, maxDepth, cache);
                unmanagedsubtitlesList.add(item);
            }
        }

        // Deep copy of collections
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$collections(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> managedcollectionsList = realmSource.realmGet$collections();
            RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> unmanagedcollectionsList = new RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm>();
            unmanagedCopy.realmSet$collections(unmanagedcollectionsList);
            int nextDepth = currentDepth + 1;
            int size = managedcollectionsList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.video.TinyCollectionRealm item = player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createDetachedCopy(managedcollectionsList.get(i), nextDepth, maxDepth, cache);
                unmanagedcollectionsList.add(item);
            }
        }

        // Deep copy of levels
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$levels(null);
        } else {
            RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> managedlevelsList = realmSource.realmGet$levels();
            RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> unmanagedlevelsList = new RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm>();
            unmanagedCopy.realmSet$levels(unmanagedlevelsList);
            int nextDepth = currentDepth + 1;
            int size = managedlevelsList.size();
            for (int i = 0; i < size; i++) {
                player.wellnesssolutions.database.model.video.TinyOptionRealm item = player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createDetachedCopy(managedlevelsList.get(i), nextDepth, maxDepth, cache);
                unmanagedlevelsList.add(item);
            }
        }
        unmanagedCopy.realmSet$isDownloaded(realmSource.realmGet$isDownloaded());
        unmanagedCopy.realmSet$isFailureDownload(realmSource.realmGet$isFailureDownload());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmDVideo = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tag:");
        stringBuilder.append(realmGet$tag() != null ? realmGet$tag() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{brandId:");
        stringBuilder.append(realmGet$brandId() != null ? realmGet$brandId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{brandTypeLogo:");
        stringBuilder.append(realmGet$brandTypeLogo() != null ? realmGet$brandTypeLogo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{durationId:");
        stringBuilder.append(realmGet$durationId() != null ? realmGet$durationId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{durationName:");
        stringBuilder.append(realmGet$durationName() != null ? realmGet$durationName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{languageId:");
        stringBuilder.append(realmGet$languageId() != null ? realmGet$languageId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{videoName:");
        stringBuilder.append(realmGet$videoName() != null ? realmGet$videoName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{presenterId:");
        stringBuilder.append(realmGet$presenterId() != null ? realmGet$presenterId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{presenterName:");
        stringBuilder.append(realmGet$presenterName() != null ? realmGet$presenterName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{videoUrl:");
        stringBuilder.append(realmGet$videoUrl() != null ? realmGet$videoUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{trailerUrl:");
        stringBuilder.append(realmGet$trailerUrl() != null ? realmGet$trailerUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbnailLargeUrl:");
        stringBuilder.append(realmGet$thumbnailLargeUrl() != null ? realmGet$thumbnailLargeUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbnailMediumUrl:");
        stringBuilder.append(realmGet$thumbnailMediumUrl() != null ? realmGet$thumbnailMediumUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbnailSmallUrl:");
        stringBuilder.append(realmGet$thumbnailSmallUrl() != null ? realmGet$thumbnailSmallUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{videoLength:");
        stringBuilder.append(realmGet$videoLength() != null ? realmGet$videoLength() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{videoSize:");
        stringBuilder.append(realmGet$videoSize() != null ? realmGet$videoSize() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{playTime:");
        stringBuilder.append(realmGet$playTime() != null ? realmGet$playTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{downloadUrl:");
        stringBuilder.append(realmGet$downloadUrl() != null ? realmGet$downloadUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{languages:");
        stringBuilder.append("RealmList<RealmLanguage>[").append(realmGet$languages().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subtitles:");
        stringBuilder.append("RealmList<RealmSubtitle>[").append(realmGet$subtitles().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{collections:");
        stringBuilder.append("RealmList<TinyCollectionRealm>[").append(realmGet$collections().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{levels:");
        stringBuilder.append("RealmList<TinyOptionRealm>[").append(realmGet$levels().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isDownloaded:");
        stringBuilder.append(realmGet$isDownloaded());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isFailureDownload:");
        stringBuilder.append(realmGet$isFailureDownload());
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
        player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy aRealmDVideo = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmDVideo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmDVideo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmDVideo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
