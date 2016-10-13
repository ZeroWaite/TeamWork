package com.example.administrator.teamwork.MyInfo;

import java.util.List;

/**
 * Created by anzhuo on 2016/9/19.
 */
public class InterShareInfo {

    /**
     * pin_id : 883579690
     * user_id : 6414593
     * board_id : 18706747
     * file_id : 116608541
     * file : {"id":116608541,"farm":"farm1","bucket":"hbimg","key":"b9718acb4bb22b247df01af5ced665ec733b8197159aa-bhUyJa","type":"image/jpeg","height":"809","width":"580","frames":"1"}
     * media_type : 0
     * source : tieba.baidu.com
     * link : http://tieba.baidu.com/p/3584437910?see_lz=1&pn=16
     * raw_text : 凉薯地瓜   精品收藏
     * text_meta : {}
     * via : 883545929
     * via_user_id : 18497027
     * original : 875706846
     * created_at : 1476328453
     * like_count : 0
     * comment_count : 0
     * repin_count : 0
     * is_private : 0
     * orig_source : null
     * user : {"user_id":6414593,"username":"凉薯地瓜","urlname":"yue51240","created_at":1359785549,"avatar":{"id":10803475,"farm":"farm1","bucket":"hbimg","key":"449cdab46986c841811078283b892c3a4422f03a24f4-pAohhL","type":"image/jpeg","width":160,"height":126,"frames":1},"extra":null}
     * board : {"board_id":18706747,"user_id":6414593,"title":"不露诱惑","description":"","category_id":"beauty","seq":7,"pin_count":126,"follow_count":1157,"like_count":18,"created_at":1417693006,"updated_at":1476328453,"deleting":0,"is_private":0,"extra":null}
     * via_user : {"user_id":18497027,"username":"薛晓蕾","urlname":"xuexiaolei","created_at":1458025806,"avatar":{"id":96373498,"farm":"farm1","bucket":"hbimg","key":"b15e1cd87df2fd8e3653eb0740d49b70af2c1d9de69-48pIKZ","type":"image/jpeg","height":"99","frames":"1","width":"100"},"extra":null}
     */

    private List<PinsBean> pins;
    /**
     * keyword_id : 606
     * name : 超模
     * urlname : supermodel
     * cover : {"farm":"farm1","bucket":"hbimg","key":"ab04055c67aa1892eab6b212deb73759f538687e34f46-Ha0qF3","type":"image/jpeg","width":800,"height":1208,"frames":1,"file_id":43405615}
     * description : 超模是时尚界的女王，让我们跟着超模学穿搭。
     * recommended_users : null
     * creator_id : null
     * created_at : 1418718824
     * is_hidden : 0
     * tags : {"must":["超模"],"should":[]}
     * theme : 080808
     */

    private List<ExploresBean> explores;

    public List<PinsBean> getPins() {
        return pins;
    }

    public void setPins(List<PinsBean> pins) {
        this.pins = pins;
    }

    public List<ExploresBean> getExplores() {
        return explores;
    }

    public void setExplores(List<ExploresBean> explores) {
        this.explores = explores;
    }

    public static class PinsBean {
        private int pin_id;
        private int user_id;
        private int board_id;
        private int file_id;
        /**
         * id : 116608541
         * farm : farm1
         * bucket : hbimg
         * key : b9718acb4bb22b247df01af5ced665ec733b8197159aa-bhUyJa
         * type : image/jpeg
         * height : 809
         * width : 580
         * frames : 1
         */

        private FileBean file;
        private int media_type;
        private String source;
        private String link;
        private String raw_text;
        private int via;
        private int via_user_id;
        private int original;
        private int created_at;
        private int like_count;
        private int comment_count;
        private int repin_count;
        private int is_private;
        private Object orig_source;
        /**
         * user_id : 6414593
         * username : 凉薯地瓜
         * urlname : yue51240
         * created_at : 1359785549
         * avatar : {"id":10803475,"farm":"farm1","bucket":"hbimg","key":"449cdab46986c841811078283b892c3a4422f03a24f4-pAohhL","type":"image/jpeg","width":160,"height":126,"frames":1}
         * extra : null
         */

        private UserBean user;
        /**
         * board_id : 18706747
         * user_id : 6414593
         * title : 不露诱惑
         * description :
         * category_id : beauty
         * seq : 7
         * pin_count : 126
         * follow_count : 1157
         * like_count : 18
         * created_at : 1417693006
         * updated_at : 1476328453
         * deleting : 0
         * is_private : 0
         * extra : null
         */

        private BoardBean board;
        /**
         * user_id : 18497027
         * username : 薛晓蕾
         * urlname : xuexiaolei
         * created_at : 1458025806
         * avatar : {"id":96373498,"farm":"farm1","bucket":"hbimg","key":"b15e1cd87df2fd8e3653eb0740d49b70af2c1d9de69-48pIKZ","type":"image/jpeg","height":"99","frames":"1","width":"100"}
         * extra : null
         */

        private ViaUserBean via_user;

        public int getPin_id() {
            return pin_id;
        }

        public void setPin_id(int pin_id) {
            this.pin_id = pin_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getBoard_id() {
            return board_id;
        }

        public void setBoard_id(int board_id) {
            this.board_id = board_id;
        }

        public int getFile_id() {
            return file_id;
        }

        public void setFile_id(int file_id) {
            this.file_id = file_id;
        }

        public FileBean getFile() {
            return file;
        }

        public void setFile(FileBean file) {
            this.file = file;
        }

        public int getMedia_type() {
            return media_type;
        }

        public void setMedia_type(int media_type) {
            this.media_type = media_type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getRaw_text() {
            return raw_text;
        }

        public void setRaw_text(String raw_text) {
            this.raw_text = raw_text;
        }

        public int getVia() {
            return via;
        }

        public void setVia(int via) {
            this.via = via;
        }

        public int getVia_user_id() {
            return via_user_id;
        }

        public void setVia_user_id(int via_user_id) {
            this.via_user_id = via_user_id;
        }

        public int getOriginal() {
            return original;
        }

        public void setOriginal(int original) {
            this.original = original;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getRepin_count() {
            return repin_count;
        }

        public void setRepin_count(int repin_count) {
            this.repin_count = repin_count;
        }

        public int getIs_private() {
            return is_private;
        }

        public void setIs_private(int is_private) {
            this.is_private = is_private;
        }

        public Object getOrig_source() {
            return orig_source;
        }

        public void setOrig_source(Object orig_source) {
            this.orig_source = orig_source;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public BoardBean getBoard() {
            return board;
        }

        public void setBoard(BoardBean board) {
            this.board = board;
        }

        public ViaUserBean getVia_user() {
            return via_user;
        }

        public void setVia_user(ViaUserBean via_user) {
            this.via_user = via_user;
        }

        public static class FileBean {
            private int id;
            private String farm;
            private String bucket;
            private String key;
            private String type;
            private String height;
            private String width;
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

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getFrames() {
                return frames;
            }

            public void setFrames(String frames) {
                this.frames = frames;
            }
        }

        public static class UserBean {
            private int user_id;
            private String username;
            private String urlname;
            private int created_at;
            /**
             * id : 10803475
             * farm : farm1
             * bucket : hbimg
             * key : 449cdab46986c841811078283b892c3a4422f03a24f4-pAohhL
             * type : image/jpeg
             * width : 160
             * height : 126
             * frames : 1
             */

            private AvatarBean avatar;
            private Object extra;

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

            public Object getExtra() {
                return extra;
            }

            public void setExtra(Object extra) {
                this.extra = extra;
            }

            public static class AvatarBean {
                private int id;
                private String farm;
                private String bucket;
                private String key;
                private String type;
                private int width;
                private int height;
                private int frames;

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

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getFrames() {
                    return frames;
                }

                public void setFrames(int frames) {
                    this.frames = frames;
                }
            }
        }

        public static class BoardBean {
            private int board_id;
            private int user_id;
            private String title;
            private String description;
            private String category_id;
            private int seq;
            private int pin_count;
            private int follow_count;
            private int like_count;
            private int created_at;
            private int updated_at;
            private int deleting;
            private int is_private;
            private Object extra;

            public int getBoard_id() {
                return board_id;
            }

            public void setBoard_id(int board_id) {
                this.board_id = board_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public int getDeleting() {
                return deleting;
            }

            public void setDeleting(int deleting) {
                this.deleting = deleting;
            }

            public int getIs_private() {
                return is_private;
            }

            public void setIs_private(int is_private) {
                this.is_private = is_private;
            }

            public Object getExtra() {
                return extra;
            }

            public void setExtra(Object extra) {
                this.extra = extra;
            }
        }

        public static class ViaUserBean {
            private int user_id;
            private String username;
            private String urlname;
            private int created_at;
            /**
             * id : 96373498
             * farm : farm1
             * bucket : hbimg
             * key : b15e1cd87df2fd8e3653eb0740d49b70af2c1d9de69-48pIKZ
             * type : image/jpeg
             * height : 99
             * frames : 1
             * width : 100
             */

            private AvatarBean avatar;

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

            public static class AvatarBean {
                private int id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }
    }

    public static class ExploresBean {
        private int keyword_id;
        private String name;
        private String urlname;
        /**
         * farm : farm1
         * bucket : hbimg
         * key : ab04055c67aa1892eab6b212deb73759f538687e34f46-Ha0qF3
         * type : image/jpeg
         * width : 800
         * height : 1208
         * frames : 1
         * file_id : 43405615
         */

        private CoverBean cover;
        private String description;
        private Object recommended_users;
        private Object creator_id;
        private int created_at;
        private int is_hidden;
        private TagsBean tags;
        private String theme;

        public int getKeyword_id() {
            return keyword_id;
        }

        public void setKeyword_id(int keyword_id) {
            this.keyword_id = keyword_id;
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

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getRecommended_users() {
            return recommended_users;
        }

        public void setRecommended_users(Object recommended_users) {
            this.recommended_users = recommended_users;
        }

        public Object getCreator_id() {
            return creator_id;
        }

        public void setCreator_id(Object creator_id) {
            this.creator_id = creator_id;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getIs_hidden() {
            return is_hidden;
        }

        public void setIs_hidden(int is_hidden) {
            this.is_hidden = is_hidden;
        }

        public TagsBean getTags() {
            return tags;
        }

        public void setTags(TagsBean tags) {
            this.tags = tags;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public static class CoverBean {
            private String farm;
            private String bucket;
            private String key;
            private String type;
            private int width;
            private int height;
            private int frames;
            private int file_id;

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

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getFrames() {
                return frames;
            }

            public void setFrames(int frames) {
                this.frames = frames;
            }

            public int getFile_id() {
                return file_id;
            }

            public void setFile_id(int file_id) {
                this.file_id = file_id;
            }
        }

        public static class TagsBean {
            private List<String> must;
            private List<?> should;

            public List<String> getMust() {
                return must;
            }

            public void setMust(List<String> must) {
                this.must = must;
            }

            public List<?> getShould() {
                return should;
            }

            public void setShould(List<?> should) {
                this.should = should;
            }
        }
    }
}