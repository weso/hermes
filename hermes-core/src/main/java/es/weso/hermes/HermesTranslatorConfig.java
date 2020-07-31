package es.weso.hermes;

import java.util.HashMap;
import java.util.Map;

public class HermesTranslatorConfig {

    private final Map<String, Object> options = new HashMap<>();

    private HermesTranslatorConfig() {}

    public static HermesTranslatorConfig empty() {
        return new HermesTranslatorConfig();
    }

    public Object getConfig(String configKey) {
        return options.get(configKey);
    }

    public HermesTranslatorConfig addConfigOption(String configKey, Object value) {
        this.options.put(configKey, value);
        return this;
    }
}
