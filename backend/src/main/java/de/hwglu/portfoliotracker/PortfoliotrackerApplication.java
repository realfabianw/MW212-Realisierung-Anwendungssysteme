package de.hwglu.portfoliotracker;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.timeseries.TimeSeries;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfoliotrackerApplication{
	private static final Logger log = LoggerFactory.getLogger(PortfoliotrackerApplication.class);
	private static final Config cfg = Config.builder().key("GCMWJ0M5WIZRV30O").timeOut(10).build();

	public static void main(String[] args) {
		AlphaVantage.api().init(cfg);

		TimeSeriesResponse response = AlphaVantage.api().timeSeries().daily().forSymbol("IBM").fetchSync();

		log.info(response.toString());

		//SpringApplication.run(PortfoliotrackerApplication.class, args);
	}

}
