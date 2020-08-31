package es.weso.hermes;

import es.weso.hermes.slice.HermesSlice;

public interface HermesStorageGateway {

    boolean storePrefix(String prefix, String uri);

    boolean storeConstraint(HermesSlice slice);
}
