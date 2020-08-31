package by.epamtc.textprocessing.server.service;

import by.epamtc.textprocessing.server.service.impl.TextServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory INETANCE = new ServiceFactory();
	private final TextService textService = new TextServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return INETANCE;
	}

	public TextService getTextService() {
		return textService;
	}
}
