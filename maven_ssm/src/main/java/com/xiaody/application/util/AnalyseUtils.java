package com.xiaody.application.util;

import java.util.ArrayList;
import java.util.List;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnalyseUtils {
	 private static final Logger LOGGER = LoggerFactory.getLogger(AnalyseUtils.class);

	    /**
	     * content : ���Ǹ߼�java����ʦ
	     *
	     * result : [�߼�, java, ����ʦ]
	     */
	    public static List<String> splitExceptStopWords(String content) {
	        List<String> words = new ArrayList<>();
	        try {
	            for (Word word : WordSegmenter.seg(content.trim())) {
	                words.add(word.getText());
	            }
	        } catch (Exception e) {
	            words.add(content);

	            LOGGER.error("Error occurred during split[" + content + "]" + e.getMessage(), e);
	        }
	        return words;
	    }

	    /**
	     * content : ���Ǹ߼�java����ʦ
	     *
	     * result : [��, ��, �߼�, java, ����ʦ]
	     */
	    public static List<String> splitWithStopWords(String content) {
	        List<String> words = new ArrayList<>();
	        try {
	            for (Word word : WordSegmenter.segWithStopWords(content.trim())) {
	                words.add(word.getText());
	            }
	        } catch (Exception e) {
	            words.add(content);

	            LOGGER.error("Error occurred during split[" + content + "]" + e.getMessage(), e);
	        }
	        return words;
	    }
}
