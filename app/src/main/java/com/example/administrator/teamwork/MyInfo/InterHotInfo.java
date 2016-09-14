package com.example.administrator.teamwork.MyInfo;

import java.util.List;

/**
 * Created by anzhuo on 2016/9/14.
 */
public class InterHotInfo {

    /**
     * pin_id : 853876673
     * user_id : 15018060
     * board_id : 18983479
     * file_id : 66694389
     * file : {"id":66694389,"farm":"farm1","bucket":"hbimg","key":"2a011381a1f2d8fc4ae1bf5174d360bfd3079ba977154-Yp3WNp","type":"image/jpeg","width":818,"height":1200,"frames":1,"theme":"EAE7E8"}
     * media_type : 0
     * source : armedskeeter.tumblr.com
     * link : http://armedskeeter.tumblr.com/
     * raw_text : Armed Skeeter
     * text_meta : {}
     * via : 382398599
     * via_user_id : 7015509
     * original : 312092193
     * created_at : 1473820303
     * like_count : 1
     * comment_count : 0
     * repin_count : 2
     * is_private : 0
     * orig_source : null
     * user : {"user_id":15018060,"username":"爱是一切的答案","urlname":"blrsnf98uo","created_at":1408696774,"avatar":{"id":40436447,"farm":"farm1","bucket":"hbimg","key":"5024b543b3bcaeae373484beb0c6c07daab3b6fb229e-cSRo0B","type":"image/gif","width":100,"height":100,"frames":1},"extra":null}
     * board : {"board_id":18983479,"user_id":15018060,"title":"美好心情","description":"心旷神怡的感觉","category_id":"travel_places","seq":3,"pin_count":1042,"follow_count":86,"like_count":2,"created_at":1420444814,"updated_at":1473820591,"deleting":0,"is_private":0,"extra":{"cover":{"pin_id":"311889011"}}}
     * via_user : {"user_id":7015509,"username":"妤儿+-+","urlname":"yuer0429","created_at":1364395850,"avatar":{"id":91020224,"farm":"farm1","bucket":"hbimg","key":"899c50ad53429e7b995a353df14f049ac7da35a516f18-tVwop5","type":"image/jpeg","height":"987","frames":"1","width":"658"},"extra":null}
     */

    private List<PinsBean> pins;
    private List<?> explores;

    public List<PinsBean> getPins() {
        return pins;
    }

    public void setPins(List<PinsBean> pins) {
        this.pins = pins;
    }

    public List<?> getExplores() {
        return explores;
    }

    public void setExplores(List<?> explores) {
        this.explores = explores;
    }

    public static class PinsBean {
        private int pin_id;
        private int user_id;
        private int board_id;
        private int file_id;
        /**
         * id : 66694389
         * farm : farm1
         * bucket : hbimg
         * key : 2a011381a1f2d8fc4ae1bf5174d360bfd3079ba977154-Yp3WNp
         * type : image/jpeg
         * width : 818
         * height : 1200
         * frames : 1
         * theme : EAE7E8
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
         * user_id : 15018060
         * username : 爱是一切的答案
         * urlname : blrsnf98uo
         * created_at : 1408696774
         * avatar : {"id":40436447,"farm":"farm1","bucket":"hbimg","key":"5024b543b3bcaeae373484beb0c6c07daab3b6fb229e-cSRo0B","type":"image/gif","width":100,"height":100,"frames":1}
         * extra : null
         */

        private UserBean user;
        /**
         * board_id : 18983479
         * user_id : 15018060
         * title : 美好心情
         * description : 心旷神怡的感觉
         * category_id : travel_places
         * seq : 3
         * pin_count : 1042
         * follow_count : 86
         * like_count : 2
         * created_at : 1420444814
         * updated_at : 1473820591
         * deleting : 0
         * is_private : 0
         * extra : {"cover":{"pin_id":"311889011"}}
         */

        private BoardBean board;
        /**
         * user_id : 7015509
         * username : 妤儿+-+
         * urlname : yuer0429
         * created_at : 1364395850
         * avatar : {"id":91020224,"farm":"farm1","bucket":"hbimg","key":"899c50ad53429e7b995a353df14f049ac7da35a516f18-tVwop5","type":"image/jpeg","height":"987","frames":"1","width":"658"}
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
            private int width;
            private int height;
            private int frames;
            private String theme;

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

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }
        }

        public static class UserBean {
            private int user_id;
            private String username;
            private String urlname;
            private int created_at;
            /**
             * id : 40436447
             * farm : farm1
             * bucket : hbimg
             * key : 5024b543b3bcaeae373484beb0c6c07daab3b6fb229e-cSRo0B
             * type : image/gif
             * width : 100
             * height : 100
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
            /**
             * cover : {"pin_id":"311889011"}
             */

            private ExtraBean extra;

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

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public static class ExtraBean {
                /**
                 * pin_id : 311889011
                 */

                private CoverBean cover;

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public static class CoverBean {
                    private String pin_id;

                    public String getPin_id() {
                        return pin_id;
                    }

                    public void setPin_id(String pin_id) {
                        this.pin_id = pin_id;
                    }
                }
            }
        }

        public static class ViaUserBean {
            private int user_id;
            private String username;
            private String urlname;
            private int created_at;
            /**
             * id : 91020224
             * farm : farm1
             * bucket : hbimg
             * key : 899c50ad53429e7b995a353df14f049ac7da35a516f18-tVwop5
             * type : image/jpeg
             * height : 987
             * frames : 1
             * width : 658
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
                private String height;
                private String frames;
                private String width;

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

                public String getFrames() {
                    return frames;
                }

                public void setFrames(String frames) {
                    this.frames = frames;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }
    }
}
