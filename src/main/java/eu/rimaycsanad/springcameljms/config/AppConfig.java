package eu.rimaycsanad.springcameljms.config;

import java.util.Properties;

import org.apache.camel.spring.spi.BridgePropertyPlaceholderConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class AppConfig extends BridgePropertyPlaceholderConfigurer {

	public static final String QCF_NAME = "qcf.name";
	public static final String FROM_QUEUE_NAME = "from.queue.name";
	public static final String TO_QUEUE_NAME = "to.queue.name";

	public static String getQcfName() {
		return getStringConfig(QCF_NAME, "qcf");
	}

	public static String getFromQueueName() {
		return getStringConfig(FROM_QUEUE_NAME, "from.q");
	}

	public static String getToQueueName() {
		return getStringConfig(TO_QUEUE_NAME, "to.q");
	}

	private static String getStringConfig(String key, String defaultValue) {
		String value = System.getProperty(key, defaultValue);
		return value != null ? value.replaceAll("\\p{Cntrl}", " ") : value;
	}

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		logger.debug("user properties to add: " + props);
		System.getProperties().putAll(props);
		super.processProperties(beanFactoryToProcess, props);
	}

}
