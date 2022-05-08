package de.hwglu.portfoliotracker;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfoliotrackerApplication {
	private static final Config cfg = Config.builder().key("GCMWJ0M5WIZRV30O").timeOut(10).build();

	public static void main(String[] args) {
		AlphaVantage.api().init(cfg);

		// TimeSeriesResponse response =
		// AlphaVantage.api().timeSeries().daily().forSymbol("TSLA").fetchSync();

		// TimeSeriesResponse daily =
		// AlphaVantage.api().timeSeries().intraday().interval(Interval.SIXTY_MIN).forSymbol("TSLA").fetchSync();

		// log.info(response.toString());

		SpringApplication.run(PortfoliotrackerApplication.class, args);
	}
}