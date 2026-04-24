package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new edu.monash.fit5046.healthyrecipehub.DataBinderMapperImpl());
  }
}
