package com.hk.xia.mybatisplus.generator.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class HkEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HkEmployeeExample() {
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

        public Criteria andHkidIsNull() {
            addCriterion("hkId is null");
            return (Criteria) this;
        }

        public Criteria andHkidIsNotNull() {
            addCriterion("hkId is not null");
            return (Criteria) this;
        }

        public Criteria andHkidEqualTo(Integer value) {
            addCriterion("hkId =", value, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidNotEqualTo(Integer value) {
            addCriterion("hkId <>", value, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidGreaterThan(Integer value) {
            addCriterion("hkId >", value, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hkId >=", value, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidLessThan(Integer value) {
            addCriterion("hkId <", value, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidLessThanOrEqualTo(Integer value) {
            addCriterion("hkId <=", value, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidIn(List<Integer> values) {
            addCriterion("hkId in", values, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidNotIn(List<Integer> values) {
            addCriterion("hkId not in", values, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidBetween(Integer value1, Integer value2) {
            addCriterion("hkId between", value1, value2, "hkid");
            return (Criteria) this;
        }

        public Criteria andHkidNotBetween(Integer value1, Integer value2) {
            addCriterion("hkId not between", value1, value2, "hkid");
            return (Criteria) this;
        }

        public Criteria andHknameIsNull() {
            addCriterion("hkName is null");
            return (Criteria) this;
        }

        public Criteria andHknameIsNotNull() {
            addCriterion("hkName is not null");
            return (Criteria) this;
        }

        public Criteria andHknameEqualTo(String value) {
            addCriterion("hkName =", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameNotEqualTo(String value) {
            addCriterion("hkName <>", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameGreaterThan(String value) {
            addCriterion("hkName >", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameGreaterThanOrEqualTo(String value) {
            addCriterion("hkName >=", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameLessThan(String value) {
            addCriterion("hkName <", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameLessThanOrEqualTo(String value) {
            addCriterion("hkName <=", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameLike(String value) {
            addCriterion("hkName like", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameNotLike(String value) {
            addCriterion("hkName not like", value, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameIn(List<String> values) {
            addCriterion("hkName in", values, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameNotIn(List<String> values) {
            addCriterion("hkName not in", values, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameBetween(String value1, String value2) {
            addCriterion("hkName between", value1, value2, "hkname");
            return (Criteria) this;
        }

        public Criteria andHknameNotBetween(String value1, String value2) {
            addCriterion("hkName not between", value1, value2, "hkname");
            return (Criteria) this;
        }

        public Criteria andHkstagenameIsNull() {
            addCriterion("hkStageName is null");
            return (Criteria) this;
        }

        public Criteria andHkstagenameIsNotNull() {
            addCriterion("hkStageName is not null");
            return (Criteria) this;
        }

        public Criteria andHkstagenameEqualTo(String value) {
            addCriterion("hkStageName =", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameNotEqualTo(String value) {
            addCriterion("hkStageName <>", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameGreaterThan(String value) {
            addCriterion("hkStageName >", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameGreaterThanOrEqualTo(String value) {
            addCriterion("hkStageName >=", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameLessThan(String value) {
            addCriterion("hkStageName <", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameLessThanOrEqualTo(String value) {
            addCriterion("hkStageName <=", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameLike(String value) {
            addCriterion("hkStageName like", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameNotLike(String value) {
            addCriterion("hkStageName not like", value, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameIn(List<String> values) {
            addCriterion("hkStageName in", values, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameNotIn(List<String> values) {
            addCriterion("hkStageName not in", values, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameBetween(String value1, String value2) {
            addCriterion("hkStageName between", value1, value2, "hkstagename");
            return (Criteria) this;
        }

        public Criteria andHkstagenameNotBetween(String value1, String value2) {
            addCriterion("hkStageName not between", value1, value2, "hkstagename");
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