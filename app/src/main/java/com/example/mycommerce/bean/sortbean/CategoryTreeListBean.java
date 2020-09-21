package com.example.mycommerce.bean.sortbean;

import java.util.List;

public class CategoryTreeListBean {

    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":1,"parentId":0,"name":"服装","level":0,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":1,"keywords":"服装","children":[{"id":7,"parentId":1,"name":"外套","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"icon":"","keywords":"外套","children":[]},{"id":8,"parentId":1,"name":"T恤","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"icon":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png","keywords":"T恤","children":[]},{"id":9,"parentId":1,"name":"休闲裤","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"keywords":"休闲裤","children":[]},{"id":10,"parentId":1,"name":"牛仔裤","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"keywords":"牛仔裤","children":[]},{"id":11,"parentId":1,"name":"衬衫","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"keywords":"衬衫","children":[]},{"id":29,"parentId":1,"name":"男鞋","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]}]},{"id":2,"parentId":0,"name":"手机数码","level":0,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":1,"keywords":"手机数码","children":[{"id":19,"parentId":2,"name":"手机通讯","level":1,"productCount":0,"productUnit":"件","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"手机通讯","children":[]},{"id":30,"parentId":2,"name":"手机配件","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"手机配件","children":[]},{"id":31,"parentId":2,"name":"摄影摄像","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":32,"parentId":2,"name":"影音娱乐","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":33,"parentId":2,"name":"数码配件","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":34,"parentId":2,"name":"智能设备","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]}]},{"id":3,"parentId":0,"name":"家用电器","level":0,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":1,"keywords":"家用电器","children":[{"id":35,"parentId":3,"name":"电视","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":36,"parentId":3,"name":"空调","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":37,"parentId":3,"name":"洗衣机","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":38,"parentId":3,"name":"冰箱","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":39,"parentId":3,"name":"厨卫大电","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":40,"parentId":3,"name":"厨房小电","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":41,"parentId":3,"name":"生活电器","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":42,"parentId":3,"name":"个护健康","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]}]},{"id":4,"parentId":0,"name":"家具家装","level":0,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":1,"keywords":"家具家装","children":[{"id":43,"parentId":4,"name":"厨房卫浴","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":44,"parentId":4,"name":"灯饰照明","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":45,"parentId":4,"name":"五金工具","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":46,"parentId":4,"name":"卧室家具","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":47,"parentId":4,"name":"客厅家具","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]}]},{"id":5,"parentId":0,"name":"汽车用品","level":0,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":1,"keywords":"汽车用品","children":[{"id":48,"parentId":5,"name":"全新整车","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":49,"parentId":5,"name":"车载电器","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":50,"parentId":5,"name":"维修保养","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]},{"id":51,"parentId":5,"name":"汽车装饰","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]}]}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * parentId : 0
         * name : 服装
         * level : 0
         * productCount : 100
         * productUnit : 件
         * navStatus : 1
         * showStatus : 1
         * sort : 1
         * keywords : 服装
         * children : [{"id":7,"parentId":1,"name":"外套","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"icon":"","keywords":"外套","children":[]},{"id":8,"parentId":1,"name":"T恤","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"icon":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png","keywords":"T恤","children":[]},{"id":9,"parentId":1,"name":"休闲裤","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"keywords":"休闲裤","children":[]},{"id":10,"parentId":1,"name":"牛仔裤","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"keywords":"牛仔裤","children":[]},{"id":11,"parentId":1,"name":"衬衫","level":1,"productCount":100,"productUnit":"件","navStatus":1,"showStatus":1,"sort":0,"keywords":"衬衫","children":[]},{"id":29,"parentId":1,"name":"男鞋","level":1,"productCount":0,"productUnit":"","navStatus":0,"showStatus":0,"sort":0,"icon":"","keywords":"","children":[]}]
         */

        private int id;
        private int parentId;
        private String name;
        private int level;
        private int productCount;
        private String productUnit;
        private int navStatus;
        private int showStatus;
        private int sort;
        private String keywords;
        private List<ChildrenBean> children;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getProductCount() {
            return productCount;
        }

        public void setProductCount(int productCount) {
            this.productCount = productCount;
        }

        public String getProductUnit() {
            return productUnit;
        }

        public void setProductUnit(String productUnit) {
            this.productUnit = productUnit;
        }

        public int getNavStatus() {
            return navStatus;
        }

        public void setNavStatus(int navStatus) {
            this.navStatus = navStatus;
        }

        public int getShowStatus() {
            return showStatus;
        }

        public void setShowStatus(int showStatus) {
            this.showStatus = showStatus;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 7
             * parentId : 1
             * name : 外套
             * level : 1
             * productCount : 100
             * productUnit : 件
             * navStatus : 1
             * showStatus : 1
             * sort : 0
             * icon :
             * keywords : 外套
             * children : []
             */

            private int id;
            private int parentId;
            private String name;
            private int level;
            private int productCount;
            private String productUnit;
            private int navStatus;
            private int showStatus;
            private int sort;
            private String icon;
            private String keywords;
            private List<?> children;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getProductCount() {
                return productCount;
            }

            public void setProductCount(int productCount) {
                this.productCount = productCount;
            }

            public String getProductUnit() {
                return productUnit;
            }

            public void setProductUnit(String productUnit) {
                this.productUnit = productUnit;
            }

            public int getNavStatus() {
                return navStatus;
            }

            public void setNavStatus(int navStatus) {
                this.navStatus = navStatus;
            }

            public int getShowStatus() {
                return showStatus;
            }

            public void setShowStatus(int showStatus) {
                this.showStatus = showStatus;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }
    }
}
