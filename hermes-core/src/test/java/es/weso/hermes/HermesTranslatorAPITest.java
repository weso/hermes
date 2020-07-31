package es.weso.hermes;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HermesTranslatorAPITest {

    @Test
    public void test() {
        HermesTranslator ht = HermesTranslator.fromDefaultConfig();
        List<String> prefixesFiles = new ArrayList<>();
        List<String> shapesFiles = new ArrayList<>();

        prefixesFiles.add("C:\\Users\\Willy\\Documents\\github\\weso\\hermes\\hermes-core\\src\\test\\assets\\possitive\\uniovi\\prefixes.csv");
        shapesFiles.add("C:\\Users\\Willy\\Documents\\github\\weso\\hermes\\hermes-core\\src\\test\\assets\\possitive\\uniovi\\uniovi_subject.csv");

        try {
            System.out.println(ht.translate(prefixesFiles, shapesFiles));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
