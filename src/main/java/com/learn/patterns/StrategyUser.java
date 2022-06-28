package com.learn.patterns;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.learn.patterns.AbstractPfisterOrphanedMediaFileProcessStrategy.CELUM_ASSETS_STRATEGY_KEY;
import static com.learn.patterns.AbstractPfisterOrphanedMediaFileProcessStrategy.DEFAULT_STRATEGY_KEY;

//@Component
//@Getter
//@Setter
public class StrategyUser {
	public Map<String, PfisterOrphanedMediaFileProcessStrategy> getProcessStrategies() {
		return processStrategies;
	}

	@Required
	public void setProcessStrategies(Map<String, PfisterOrphanedMediaFileProcessStrategy> processStrategies) {
		this.processStrategies = processStrategies;
	}


	private Map<String, PfisterOrphanedMediaFileProcessStrategy> processStrategies;

	public void processMediaFileInternally(final String file) {
		if (file.contains("CELUM")) {
			getProcessStrategies().get("CELUM_ASSETS_STRATEGY_KEY").process(file);
		}
		else {
			getProcessStrategies().get("DEFAULT_STRATEGY_KEY").process(file);
		}
	}
}
