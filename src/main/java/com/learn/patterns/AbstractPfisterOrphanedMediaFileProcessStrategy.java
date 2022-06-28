package com.learn.patterns;

import org.springframework.beans.factory.annotation.Required;


public abstract class AbstractPfisterOrphanedMediaFileProcessStrategy implements PfisterOrphanedMediaFileProcessStrategy {

	public static final String DEFAULT_STRATEGY_KEY = "DEFAULT_STRATEGY_KEY";
	public static final String CELUM_ASSETS_STRATEGY_KEY = "CELUM_ASSETS_STRATEGY_KEY";

	private ConfigurationService configurationService;
	private PfisterMediaDao pfisterMediaDao;
	private OrphanedMediaService orphanedMediaService;

	protected PfisterMediaDao getPfisterMediaDao() {
		return pfisterMediaDao;
	}

	@Required
	public void setPfisterMediaDao(final PfisterMediaDao pfisterMediaDao) {
		this.pfisterMediaDao = pfisterMediaDao;
	}

	protected OrphanedMediaService getOrphanedMediaService() {
		return orphanedMediaService;
	}

	@Required
	public void setOrphanedMediaService(final OrphanedMediaService orphanedMediaService) {
		this.orphanedMediaService = orphanedMediaService;
	}

	protected ConfigurationService getConfigurationService() {
		return configurationService;
	}

	@Required
	public void setConfigurationService(final ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}
}
