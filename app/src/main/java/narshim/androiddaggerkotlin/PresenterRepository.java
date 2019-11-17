package narshim.androiddaggerkotlin;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import narshim.androiddaggerkotlin.home.BasePresenter;
import narshim.androiddaggerkotlin.home.HomePresenter;

public class PresenterRepository {
    @Inject
    protected Provider<HomePresenter> homePresenterProvider;

    private Map<Class<? extends BasePresenter>, Provider> providerMap;

    public <T extends BasePresenter> T get(Class<T> classDef) {
        if (providerMap == null) {
            providerMap = createProverMap();
        }

        Provider provider = providerMap.get(classDef);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid Provider");
        } else {
            return (T) provider.get();
        }
    }

    private Map<Class<? extends BasePresenter>, Provider> createProverMap() {
        Map<Class<? extends BasePresenter>, Provider> classProviderMap = new HashMap<>();

        classProviderMap.put(HomePresenter.class, homePresenterProvider);
        return classProviderMap;
    }

}
