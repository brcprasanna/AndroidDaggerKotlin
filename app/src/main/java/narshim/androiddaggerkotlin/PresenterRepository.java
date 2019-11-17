package narshim.androiddaggerkotlin;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import narshim.androiddaggerkotlin.home.BasePresenter;
import narshim.androiddaggerkotlin.home.HomePresenter;

public class PresenterRepository {
    @Inject
    protected Provider<HomePresenter> homePresenterProvider;

    private Map<KClass<HomePresenter>, Provider<HomePresenter>> providerMap;

    public static <T> KClass<T> getKClass(Class<T> cls) {
        return JvmClassMappingKt.getKotlinClass(cls);
    }

    public <T extends BasePresenter> T get(KClass<T> classDef) {
        if (providerMap == null) {
            providerMap = createProviderMap();
        }

        Provider provider = providerMap.get(classDef);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid Provider");
        } else {
            return (T) provider.get();
        }
    }

    private Map<KClass<HomePresenter>, Provider<HomePresenter>> createProviderMap() {
        Map<KClass<HomePresenter>, Provider<HomePresenter>> classProviderMap = new HashMap<>();

        classProviderMap.put(getKClass(HomePresenter.class), homePresenterProvider);
        return classProviderMap;
    }

}
