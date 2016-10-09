package com.example.administrator.teamwork.MyInfo;

import java.util.List;

/**
 * Created by anzhuo on 2016/9/27.
 */
public class InternetSearchInfo {

    /**
     * recommendation_id : 3581
     * status : 1
     * type : users
     * seq : 3629
     * user_id : 17202953
     * username : 达令☞
     * urlname : tdlpukwogz
     * created_at : 1430961383
     * avatar : {"id":115899206,"farm":"farm1","bucket":"hbimg","key":"d3f55f059672954ba017831ffb00f0551ef4ed962863a-wSdZyT","type":"image/jpeg","width":"510","height":"510","frames":"1"}
     * pin_count : 29415
     * follow_count : 6230
     * target_id : 17202953
     * title : 达令☞
     * url : http://huaban.com/tdlpukwogz/
     * cover : {}
     */

    private List<RecommendsBean> recommends;
    /**
     * cover : {"bucket":"hbimg","key":"3922dc8a00b56bde008235ca618f21e02d2cc0eb28756-kKzIMU"}
     * explore_id : 209
     * name : SD娃娃
     * urlname : sdwawa
     * start_at : 1473489300
     * end_at : 1505284500
     * theme : 201B19
     */

    private List<ExploresBean> explores;
    /**
     * start_at : 1472089500
     * end_at : 1503884700
     * name : 匠人匠心
     * url : http://huaban.com/boards/31031480/
     */

    private List<HotWordsBean> hot_words;
    /**
     * cover : {"bucket":"hbfile","key":"7ce49aba05e5092800c9abe58856b08b99b45038a52b2","path":"/img/home/banner/"}
     * user : {"username":"BabyMocmoc","user_id":460373,"urlname":"babymocmoc"}
     * pin_id : 838367077
     * user_id : 460373
     * start_at : 1473147540
     * end_at : 1504942740
     */

    private List<BannersBean> banners;

    public List<RecommendsBean> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<RecommendsBean> recommends) {
        this.recommends = recommends;
    }

    public List<ExploresBean> getExplores() {
        return explores;
    }

    public void setExplores(List<ExploresBean> explores) {
        this.explores = explores;
    }

    public List<HotWordsBean> getHot_words() {
        return hot_words;
    }

    public void setHot_words(List<HotWordsBean> hot_words) {
        this.hot_words = hot_words;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public static class RecommendsBean {
        private int recommendation_id;
        private int status;
        private String type;
        private int seq;
        private int user_id;
        private String username;
        private String urlname;
        private int created_at;
        /**
         * id : 115899206
         * farm : farm1
         * bucket : hbimg
         * key : d3f55f059672954ba017831ffb00f0551ef4ed962863a-wSdZyT
         * type : image/jpeg
         * width : 510
         * height : 510
         * frames : 1
         */

        private AvatarBean avatar;
        private int pin_count;
        private int follow_count;
        private int target_id;
        private String title;
        private String url;

        public int getRecommendation_id() {
            return recommendation_id;
        }

        public void setRecommendation_id(int recommendation_id) {
            this.recommendation_id = recommendation_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUrlname() {
            return urlname;
        }

        public void setUrlname(String urlname) {
            this.urlname = urlname;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public AvatarBean getAvatar() {
            return avatar;
        }

        public void setAvatar(AvatarBean avatar) {
            this.avatar = avatar;
        }

        public int getPin_count() {
            return pin_count;
        }

        public void setPin_count(int pin_count) {
            this.pin_count = pin_count;
        }

        public int getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(int follow_count) {
            this.follow_count = follow_count;
        }

        public int getTarget_id() {
            return target_id;
        }

        public void setTarget_id(int target_id) {
            this.target_id = target_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class AvatarBean {
            private int id;
            private String farm;
            private String bucket;
            private String key;
            private String type;
            private String width;
            private String height;
            private String frames;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFarm() {
                return farm;
            }

            public void setFarm(String farm) {
                this.farm = farm;
            }

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getFrames() {
                return frames;
            }

            public void setFrames(String frames) {
                this.frames = frames;
            }
        }
    }

    public static class ExploresBean {
        /**
         * bucket : hbimg
         * key : 3922dc8a00b56bde008235ca618f21e02d2cc0eb28756-kKzIMU
         */

        private CoverBean cover;
        private int explore_id;
        private String name;
        private String urlname;
        private int start_at;
        private int end_at;
        private String theme;

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public int getExplore_id() {
            return explore_id;
        }

        public void setExplore_id(int explore_id) {
            this.explore_id = explore_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrlname() {
            return urlname;
        }

        public void setUrlname(String urlname) {
            this.urlname = urlname;
        }

        public int getStart_at() {
            return start_at;
        }

        public void setStart_at(int start_at) {
            this.start_at = start_at;
        }

        public int getEnd_at() {
            return end_at;
        }

        public void setEnd_at(int end_at) {
            this.end_at = end_at;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public static class CoverBean {
            private String bucket;
            private String key;

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }

    public static class HotWordsBean {
        private int start_at;
        private int end_at;
        private String name;
        private String url;

        public int getStart_at() {
            return start_at;
        }

        public void setStart_at(int start_at) {
            this.start_at = start_at;
        }

        public int getEnd_at() {
            return end_at;
        }

        public void setEnd_at(int end_at) {
            this.end_at = end_at;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class BannersBean {
        /**
         * bucket : hbfile
         * key : 7ce49aba05e5092800c9abe58856b08b99b45038a52b2
         * path : /img/home/banner/
         */

        private CoverBean cover;
        /**
         * username : BabyMocmoc
         * user_id : 460373
         * urlname : babymocmoc
         */

        private UserBean user;
        private String pin_id;
        private int user_id;
        private int start_at;
        private int end_at;

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getPin_id() {
            return pin_id;
        }

        public void setPin_id(String pin_id) {
            this.pin_id = pin_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getStart_at() {
            return start_at;
        }

        public void setStart_at(int start_at) {
            this.start_at = start_at;
        }

        public int getEnd_at() {
            return end_at;
        }

        public void setEnd_at(int end_at) {
            this.end_at = end_at;
        }

        public static class CoverBean {
            private String bucket;
            private String key;
            private String path;

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }

        public static class UserBean {
            private String username;
            private int user_id;
            private String urlname;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUrlname() {
                return urlname;
            }

            public void setUrlname(String urlname) {
                this.urlname = urlname;
            }
        }
    }
}
