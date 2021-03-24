package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(12);
        modelClasses.add(player.wellnesssolutions.database.model.download.DownloadedFile.class);
        modelClasses.add(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
        modelClasses.add(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
        modelClasses.add(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
        modelClasses.add(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.RealmDVideo.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.RealmLanguage.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.RealmSubtitle.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.TinyOptionRealm.class);
        modelClasses.add(player.wellnesssolutions.database.model.video.VideoEntity.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(12);
        infoMap.put(player.wellnesssolutions.database.model.download.DownloadedFile.class, io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class, io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.search_preview.BrandRealm.class, io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class, io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class, io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.RealmDVideo.class, io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.RealmLanguage.class, io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.RealmSubtitle.class, io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class, io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class, io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.TinyOptionRealm.class, io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(player.wellnesssolutions.database.model.video.VideoEntity.class, io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            return io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            return io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            return io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            return io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            return io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            return io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            return "DownloadedFile";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            return "AnswerRealm";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            return "BrandRealm";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            return "SPOptionRealm";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            return "SPTinyOptionRealm";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            return "RealmDVideo";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            return "RealmLanguage";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            return "RealmSubtitle";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            return "RealmVideoSchedule";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            return "TinyCollectionRealm";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            return "TinyOptionRealm";
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            return "VideoEntity";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy());
            }
            if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
                return clazz.cast(new io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.DownloadedFileColumnInfo columnInfo = (player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.DownloadedFileColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.download.DownloadedFile.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.download.DownloadedFile) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.AnswerRealmColumnInfo columnInfo = (player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.AnswerRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.BrandRealmColumnInfo columnInfo = (player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.BrandRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.BrandRealm.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.search_preview.BrandRealm) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.SPOptionRealmColumnInfo columnInfo = (player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.SPOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo columnInfo = (player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.SPTinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.RealmDVideoColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.RealmDVideoColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmDVideo.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.RealmDVideo) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.RealmLanguageColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.RealmLanguageColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmLanguage.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.RealmLanguage) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.RealmSubtitleColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.RealmSubtitleColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmSubtitle.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.RealmSubtitle) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.RealmVideoScheduleColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.RealmVideoScheduleColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.RealmVideoSchedule) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.TinyCollectionRealmColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.TinyCollectionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.TinyCollectionRealm) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.TinyOptionRealmColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.TinyOptionRealmColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.TinyOptionRealm.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.TinyOptionRealm) obj, update, cache, flags));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.VideoEntityColumnInfo columnInfo = (player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.VideoEntityColumnInfo) realm.getSchema().getColumnInfo(player.wellnesssolutions.database.model.video.VideoEntity.class);
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.copyOrUpdate(realm, columnInfo, (player.wellnesssolutions.database.model.video.VideoEntity) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.insert(realm, (player.wellnesssolutions.database.model.download.DownloadedFile) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.search_preview.BrandRealm) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmDVideo) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmLanguage) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmSubtitle) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmVideoSchedule) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.TinyCollectionRealm) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.TinyOptionRealm) object, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.VideoEntity) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
                io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.insert(realm, (player.wellnesssolutions.database.model.download.DownloadedFile) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.search_preview.BrandRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmDVideo) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmLanguage) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmSubtitle) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.RealmVideoSchedule) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.TinyCollectionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.TinyOptionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
                io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.insert(realm, (player.wellnesssolutions.database.model.video.VideoEntity) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
                    io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.download.DownloadedFile) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.search_preview.BrandRealm) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmDVideo) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmLanguage) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmSubtitle) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmVideoSchedule) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.TinyCollectionRealm) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.TinyOptionRealm) obj, cache);
        } else if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.VideoEntity) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
                io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.download.DownloadedFile) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.search_preview.BrandRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.search_preview.SPOptionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmDVideo) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmLanguage) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmSubtitle) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
                io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.RealmVideoSchedule) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.TinyCollectionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
                io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.TinyOptionRealm) object, cache);
            } else if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
                io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.insertOrUpdate(realm, (player.wellnesssolutions.database.model.video.VideoEntity) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
                    io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
                    io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(player.wellnesssolutions.database.model.download.DownloadedFile.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_download_DownloadedFileRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.download.DownloadedFile) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.help_me_choose.AnswerRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_help_me_choose_AnswerRealmRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.help_me_choose.AnswerRealm) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.BrandRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_BrandRealmRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.search_preview.BrandRealm) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPOptionRealmRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.search_preview.SPOptionRealm) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_search_preview_SPTinyOptionRealmRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmDVideo.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmDVideoRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.RealmDVideo) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmLanguage.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmLanguageRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.RealmLanguage) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmSubtitle.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmSubtitleRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.RealmSubtitle) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.RealmVideoSchedule.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_RealmVideoScheduleRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.RealmVideoSchedule) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyCollectionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyCollectionRealmRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.TinyCollectionRealm) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.TinyOptionRealm.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_TinyOptionRealmRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.TinyOptionRealm) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(player.wellnesssolutions.database.model.video.VideoEntity.class)) {
            return clazz.cast(io.realm.player_wellnesssolutions_database_model_video_VideoEntityRealmProxy.createDetachedCopy((player.wellnesssolutions.database.model.video.VideoEntity) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
