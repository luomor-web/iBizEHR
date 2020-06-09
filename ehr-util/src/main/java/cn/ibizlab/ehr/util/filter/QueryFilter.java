package cn.ibizlab.ehr.util.filter;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.Transient;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QueryFilter {

    public static QueryFilter createQuery()
    {
        QueryFilter queryFilter=new QueryFilter();
        return queryFilter;
    }

    public QueryFilter eq(String column,Object value) {
        return op(column,SegmentCond.eq(value));
    }
    public QueryFilter ne(String column,Object value) {
        return op(column,SegmentCond.ne(value));
    }
    public QueryFilter gt(String column,Object value) {
        return op(column,SegmentCond.gt(value));
    }
    public QueryFilter ge(String column,Object value) {
        return op(column,SegmentCond.ge(value));
    }
    public QueryFilter lt(String column,Object value) {
        return op(column,SegmentCond.lt(value));
    }
    public QueryFilter le(String column,Object value) {
        return op(column,SegmentCond.le(value));
    }
    public QueryFilter isnull(String column) {
        return op(column,SegmentCond.isnull());
    }
    public QueryFilter isnotnull(String column) {
        return op(column,SegmentCond.isnotnull());
    }
    public QueryFilter in(String column,Collection value) {
        return op(column,SegmentCond.in(value));
    }
    public QueryFilter notin(String column,Collection value) {
        return op(column,SegmentCond.notin(value));
    }
    public QueryFilter like(String column,String value) {
        return op(column,SegmentCond.like(value));
    }
    public QueryFilter startsWith(String column,String value) {
        return op(column,SegmentCond.startsWith(value));
    }
    public QueryFilter endsWith(String column,String value) {
        return op(column,SegmentCond.endsWith(value));
    }
    public QueryFilter between(String column,Object from,Object to) {
        return op(column,SegmentCond.between(from,to));
    }


    @JsonIgnore
    @Transient
    private Map<String,SegmentCond> map;

    private Map<String,SegmentCond> getMap()
    {
        if(map==null)
            map=new LinkedHashMap<>();
        return  map;
    }

    @JsonAnyGetter
    public Map<String , SegmentCond> any() {
        return getMap();
    }

    @JsonAnySetter
    public void set(String column, SegmentCond value) {
        getMap().put(column,value);
    }

    @JsonProperty(index = 999)
    private List<QueryFilter> $or;


    public List<QueryFilter> get$or() {
        return $or;
    }

    public void set$or(List<QueryFilter> $or) {
        this.$or = $or;
    }


    public QueryFilter or(QueryFilter... ors)
    {
        if ($or == null) {
            $or = new ArrayList();
        }
        Collections.addAll($or, ors);
        return this;

    }

    @JsonProperty(index = 999)
    private List<QueryFilter> $and;

    public List<QueryFilter> get$and() {
        return $and;
    }

    public void set$and(List<QueryFilter> $and) {
        this.$and = $and;
    }

    public QueryFilter and(QueryFilter... ands)
    {
        if ($and == null) {
            $and = new ArrayList();
        }

        Collections.addAll($and, ands);
        return this;

    }

    @Override
    public String toString() {
        return "QueryFilter{" +
                "map=" + map +
                ", $or=" + $or +
                '}';
    }

    private QueryFilter op(String column, SegmentCond segmentCond) {

        if(this.getMap().containsKey(column))
            ((SegmentCond)this.getMap().get(column)).getMap().putAll(segmentCond.getMap());
        else
            this.getMap().put(column,segmentCond);
        return this;
    }


    public static class SegmentCond  {
        @JsonIgnore
        @Transient
        private Map<String,Object> map;

        @Override
        public String toString() {
            return "SegmentCond{" +
                    "map=" + map +
                    '}';
        }

        private Map<String,Object> getMap()
        {
            if(map==null)
                map=new LinkedHashMap<>();
            return  map;
        }

        @JsonAnyGetter
        public Map<String , Object> any() {
            return getMap();
        }

        @JsonAnySetter
        public void set(String column, Object value) {
            getMap().put(column,value);
        }

        public static SegmentCond eq(Object value) {
            return op(Segment.EQ,value);
        }
        public static SegmentCond ne(Object value) {
            return op(Segment.NE,value);
        }
        public static SegmentCond gt(Object value) {
            return op(Segment.GT,value);
        }
        public static SegmentCond ge(Object value) {
            return op(Segment.GE,value);
        }
        public static SegmentCond lt(Object value) {
            return op(Segment.LT,value);
        }
        public static SegmentCond le(Object value) {
            return op(Segment.LE,value);
        }
        public static SegmentCond isnull() {
            return op(Segment.IS_NULL,true);
        }
        public static SegmentCond isnotnull() {
            return op(Segment.IS_NOT_NULL,true);
        }
        public static SegmentCond in(Collection value) {
            return op(Segment.IN,value);
        }
        public static SegmentCond notin(Collection value) {
            return op(Segment.NOTIN,value);
        }
        public static SegmentCond like(String value) {
            return op(Segment.LIKE,value);
        }
        public static SegmentCond startsWith(String value) {
            return op(Segment.LEFTLIKE,value);
        }
        public static SegmentCond endsWith(String value) {
            return op(Segment.RIGHTLIKE,value);
        }
        public static SegmentCond between(Object from,Object to) {
            return op(Segment.GE,from).op(Segment.LT,to);
        }
        private static SegmentCond op(Segment segment,Object value) {
            SegmentCond segmentCond=new SegmentCond();
            segmentCond.getMap().put(segment.keyword,value);
            return segmentCond;
        }
    }

    public enum Segment  {
        AND("$and"),
        OR("$or"),

        EQ("$eq"),
        NE("$ne"),
        GT("$gt"),
        GE("$gte"),
        LT("$lt"),
        LE("$lte"),
        IS_NULL("$null"),
        IS_NOT_NULL("$notNull"),
        IN("$in"),
        NOTIN("$notIn"),
        LIKE("$like"),
        LEFTLIKE("$startsWith"),
        RIGHTLIKE("$endsWith"),
        EXISTS("$exists"),
        NOTEXISTS("$notExists");

        private final String keyword;

        Segment(final String keyword) {
            this.keyword = keyword;
        }

    }

    /*
            SQL: (field1>1 and field2='3' and (field3 like "a" or (field4 is not null and field5 in ['11','12']) )
            JAVA: QueryFilter filter=QueryFilter.createQuery()
                    .gt("field1",1)
                    .eq("field2",'3')
                    .or(QueryFilter.createQuery().like("field3","a")
                            ,QueryFilter.createQuery().isnotnull("field4").in("field5",Arrays.asList("11","12")));
            JSON:  {
                        "$or":[
                            {
                                "field3":{"$like":"a"}
                            },
                            {
                                "field4":{ "$notNull":true},
                                "field5":{"$in":["11","12"]}
                            }],
                        "field1":{"$gt":1},
                        "field2":{"$eq":"3" }
                    }
     */
}
