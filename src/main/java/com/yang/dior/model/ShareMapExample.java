package com.yang.dior.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareMapExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShareUidIsNull() {
            addCriterion("share_uid is null");
            return (Criteria) this;
        }

        public Criteria andShareUidIsNotNull() {
            addCriterion("share_uid is not null");
            return (Criteria) this;
        }

        public Criteria andShareUidEqualTo(Integer value) {
            addCriterion("share_uid =", value, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidNotEqualTo(Integer value) {
            addCriterion("share_uid <>", value, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidGreaterThan(Integer value) {
            addCriterion("share_uid >", value, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_uid >=", value, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidLessThan(Integer value) {
            addCriterion("share_uid <", value, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidLessThanOrEqualTo(Integer value) {
            addCriterion("share_uid <=", value, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidIn(List<Integer> values) {
            addCriterion("share_uid in", values, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidNotIn(List<Integer> values) {
            addCriterion("share_uid not in", values, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidBetween(Integer value1, Integer value2) {
            addCriterion("share_uid between", value1, value2, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareUidNotBetween(Integer value1, Integer value2) {
            addCriterion("share_uid not between", value1, value2, "shareUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidIsNull() {
            addCriterion("share_from_uid is null");
            return (Criteria) this;
        }

        public Criteria andShareFromUidIsNotNull() {
            addCriterion("share_from_uid is not null");
            return (Criteria) this;
        }

        public Criteria andShareFromUidEqualTo(Integer value) {
            addCriterion("share_from_uid =", value, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidNotEqualTo(Integer value) {
            addCriterion("share_from_uid <>", value, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidGreaterThan(Integer value) {
            addCriterion("share_from_uid >", value, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_from_uid >=", value, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidLessThan(Integer value) {
            addCriterion("share_from_uid <", value, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidLessThanOrEqualTo(Integer value) {
            addCriterion("share_from_uid <=", value, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidIn(List<Integer> values) {
            addCriterion("share_from_uid in", values, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidNotIn(List<Integer> values) {
            addCriterion("share_from_uid not in", values, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidBetween(Integer value1, Integer value2) {
            addCriterion("share_from_uid between", value1, value2, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareFromUidNotBetween(Integer value1, Integer value2) {
            addCriterion("share_from_uid not between", value1, value2, "shareFromUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidIsNull() {
            addCriterion("share_to_uid is null");
            return (Criteria) this;
        }

        public Criteria andShareToUidIsNotNull() {
            addCriterion("share_to_uid is not null");
            return (Criteria) this;
        }

        public Criteria andShareToUidEqualTo(Integer value) {
            addCriterion("share_to_uid =", value, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidNotEqualTo(Integer value) {
            addCriterion("share_to_uid <>", value, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidGreaterThan(Integer value) {
            addCriterion("share_to_uid >", value, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_to_uid >=", value, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidLessThan(Integer value) {
            addCriterion("share_to_uid <", value, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidLessThanOrEqualTo(Integer value) {
            addCriterion("share_to_uid <=", value, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidIn(List<Integer> values) {
            addCriterion("share_to_uid in", values, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidNotIn(List<Integer> values) {
            addCriterion("share_to_uid not in", values, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidBetween(Integer value1, Integer value2) {
            addCriterion("share_to_uid between", value1, value2, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andShareToUidNotBetween(Integer value1, Integer value2) {
            addCriterion("share_to_uid not between", value1, value2, "shareToUid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}