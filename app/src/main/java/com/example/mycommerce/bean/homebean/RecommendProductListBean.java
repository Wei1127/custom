package com.example.mycommerce.bean.homebean;

import java.util.List;

public class RecommendProductListBean {

    /**
     * code : 200
     * message : 操作成功
     * data : [{"id":26,"brandId":3,"productCategoryId":19,"feightTemplateId":0,"productAttributeCategoryId":3,"name":"华为 HUAWEI P20 ","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg","productSn":"6946605","deleteStatus":0,"publishStatus":1,"newStatus":1,"recommandStatus":1,"verifyStatus":0,"sort":100,"sale":0,"price":3788,"giftGrowth":3788,"giftPoint":3788,"usePointLimit":0,"subTitle":"AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待","originalPrice":4288,"stock":1000,"lowStock":0,"unit":"件","weight":0,"previewStatus":1,"serviceIds":"2,3,1","keywords":"","note":"","albumPics":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg","detailTitle":"","promotionPerLimit":0,"promotionType":1,"brandName":"华为","productCategoryName":"手机通讯"},{"id":27,"brandId":6,"productCategoryId":19,"feightTemplateId":0,"productAttributeCategoryId":3,"name":"小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg","productSn":"7437788","deleteStatus":0,"publishStatus":1,"newStatus":1,"recommandStatus":1,"verifyStatus":0,"sort":0,"sale":0,"price":2699,"giftGrowth":2699,"giftPoint":2699,"usePointLimit":0,"subTitle":"骁龙845处理器，红外人脸解锁，AI变焦双摄，AI语音助手小米6X低至1299，点击抢购","originalPrice":2699,"stock":100,"lowStock":0,"unit":"","weight":0,"previewStatus":0,"serviceIds":"","keywords":"","note":"","albumPics":"","detailTitle":"","promotionPerLimit":0,"promotionType":3,"brandName":"小米","productCategoryName":"手机数码"},{"id":28,"brandId":6,"productCategoryId":19,"feightTemplateId":0,"productAttributeCategoryId":3,"name":"小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg","productSn":"7437789","deleteStatus":0,"publishStatus":1,"newStatus":1,"recommandStatus":1,"verifyStatus":0,"sort":0,"sale":0,"price":649,"giftGrowth":649,"giftPoint":649,"usePointLimit":0,"subTitle":"8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购","originalPrice":649,"stock":100,"lowStock":0,"unit":"","weight":0,"previewStatus":0,"serviceIds":"","keywords":"","note":"","albumPics":"","detailTitle":"","promotionPerLimit":0,"promotionType":4,"brandName":"小米","productCategoryName":"手机数码"},{"id":29,"brandId":51,"productCategoryId":19,"feightTemplateId":0,"productAttributeCategoryId":3,"name":"Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机","pic":"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg","productSn":"7437799","deleteStatus":0,"publishStatus":1,"newStatus":1,"recommandStatus":1,"verifyStatus":0,"sort":0,"sale":0,"price":5499,"giftGrowth":5499,"giftPoint":5499,"usePointLimit":0,"subTitle":"【限时限量抢购】Apple产品年中狂欢节，好物尽享，美在智慧！速来 >> 勾选[保障服务][原厂保2年]，获得AppleCare+全方位服务计划，原厂延保售后无忧。","originalPrice":5499,"stock":100,"lowStock":0,"unit":"","weight":0,"previewStatus":0,"serviceIds":"","keywords":"","note":"","albumPics":"","detailTitle":"","promotionPerLimit":0,"promotionType":0,"brandName":"苹果","productCategoryName":"手机数码"}]
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
         * id : 26
         * brandId : 3
         * productCategoryId : 19
         * feightTemplateId : 0
         * productAttributeCategoryId : 3
         * name : 华为 HUAWEI P20
         * pic : http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg
         * productSn : 6946605
         * deleteStatus : 0
         * publishStatus : 1
         * newStatus : 1
         * recommandStatus : 1
         * verifyStatus : 0
         * sort : 100
         * sale : 0
         * price : 3788
         * giftGrowth : 3788
         * giftPoint : 3788
         * usePointLimit : 0
         * subTitle : AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待
         * originalPrice : 4288
         * stock : 1000
         * lowStock : 0
         * unit : 件
         * weight : 0
         * previewStatus : 1
         * serviceIds : 2,3,1
         * keywords :
         * note :
         * albumPics : http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg
         * detailTitle :
         * promotionPerLimit : 0
         * promotionType : 1
         * brandName : 华为
         * productCategoryName : 手机通讯
         */

        private int id;
        private int brandId;
        private int productCategoryId;
        private int feightTemplateId;
        private int productAttributeCategoryId;
        private String name;
        private String pic;
        private String productSn;
        private int deleteStatus;
        private int publishStatus;
        private int newStatus;
        private int recommandStatus;
        private int verifyStatus;
        private int sort;
        private int sale;
        private int price;
        private int giftGrowth;
        private int giftPoint;
        private int usePointLimit;
        private String subTitle;
        private int originalPrice;
        private int stock;
        private int lowStock;
        private String unit;
        private int weight;
        private int previewStatus;
        private String serviceIds;
        private String keywords;
        private String note;
        private String albumPics;
        private String detailTitle;
        private int promotionPerLimit;
        private int promotionType;
        private String brandName;
        private String productCategoryName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public int getProductCategoryId() {
            return productCategoryId;
        }

        public void setProductCategoryId(int productCategoryId) {
            this.productCategoryId = productCategoryId;
        }

        public int getFeightTemplateId() {
            return feightTemplateId;
        }

        public void setFeightTemplateId(int feightTemplateId) {
            this.feightTemplateId = feightTemplateId;
        }

        public int getProductAttributeCategoryId() {
            return productAttributeCategoryId;
        }

        public void setProductAttributeCategoryId(int productAttributeCategoryId) {
            this.productAttributeCategoryId = productAttributeCategoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getProductSn() {
            return productSn;
        }

        public void setProductSn(String productSn) {
            this.productSn = productSn;
        }

        public int getDeleteStatus() {
            return deleteStatus;
        }

        public void setDeleteStatus(int deleteStatus) {
            this.deleteStatus = deleteStatus;
        }

        public int getPublishStatus() {
            return publishStatus;
        }

        public void setPublishStatus(int publishStatus) {
            this.publishStatus = publishStatus;
        }

        public int getNewStatus() {
            return newStatus;
        }

        public void setNewStatus(int newStatus) {
            this.newStatus = newStatus;
        }

        public int getRecommandStatus() {
            return recommandStatus;
        }

        public void setRecommandStatus(int recommandStatus) {
            this.recommandStatus = recommandStatus;
        }

        public int getVerifyStatus() {
            return verifyStatus;
        }

        public void setVerifyStatus(int verifyStatus) {
            this.verifyStatus = verifyStatus;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getGiftGrowth() {
            return giftGrowth;
        }

        public void setGiftGrowth(int giftGrowth) {
            this.giftGrowth = giftGrowth;
        }

        public int getGiftPoint() {
            return giftPoint;
        }

        public void setGiftPoint(int giftPoint) {
            this.giftPoint = giftPoint;
        }

        public int getUsePointLimit() {
            return usePointLimit;
        }

        public void setUsePointLimit(int usePointLimit) {
            this.usePointLimit = usePointLimit;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getLowStock() {
            return lowStock;
        }

        public void setLowStock(int lowStock) {
            this.lowStock = lowStock;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPreviewStatus() {
            return previewStatus;
        }

        public void setPreviewStatus(int previewStatus) {
            this.previewStatus = previewStatus;
        }

        public String getServiceIds() {
            return serviceIds;
        }

        public void setServiceIds(String serviceIds) {
            this.serviceIds = serviceIds;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getAlbumPics() {
            return albumPics;
        }

        public void setAlbumPics(String albumPics) {
            this.albumPics = albumPics;
        }

        public String getDetailTitle() {
            return detailTitle;
        }

        public void setDetailTitle(String detailTitle) {
            this.detailTitle = detailTitle;
        }

        public int getPromotionPerLimit() {
            return promotionPerLimit;
        }

        public void setPromotionPerLimit(int promotionPerLimit) {
            this.promotionPerLimit = promotionPerLimit;
        }

        public int getPromotionType() {
            return promotionType;
        }

        public void setPromotionType(int promotionType) {
            this.promotionType = promotionType;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getProductCategoryName() {
            return productCategoryName;
        }

        public void setProductCategoryName(String productCategoryName) {
            this.productCategoryName = productCategoryName;
        }
    }
}
