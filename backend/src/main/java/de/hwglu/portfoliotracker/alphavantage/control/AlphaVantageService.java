package de.hwglu.portfoliotracker.alphavantage.control;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hwglu.portfoliotracker.stocks.control.StockRepository;
import de.hwglu.portfoliotracker.stocks.entity.Stock;
import de.hwglu.portfoliotracker.ticks.control.TickRepository;
import de.hwglu.portfoliotracker.ticks.entity.Interval;
import de.hwglu.portfoliotracker.ticks.entity.Tick;

@Service
public class AlphaVantageService {
    private static final Logger log = LoggerFactory.getLogger(AlphaVantageService.class);

    @Autowired
    private TickRepository tickRepository;

    @Autowired
    private StockRepository stockRepository;

    public void fetchDailyTicksIfNotExists(String stockId) {

        LocalDateTime fiveDaysAgo = getLastOpenDay();

        log.info("checking the database for entries...");

        int tickCount = tickRepository.countByStockIdAndTimestampGreaterThanEqual(stockId, fiveDaysAgo);

        log.info("entries found: {}", tickCount);

        if (tickCount == 0) {
            Stock stock = stockRepository.findById(stockId).get();

            log.info("fetching tick data...");

            TimeSeriesResponse response = AlphaVantage.api().timeSeries().daily().forSymbol(stock.getSymbol())
                    .fetchSync();

            log.info(response.toString());

            // Time Series Response -> Tick

            DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            List<Tick> ticks = new ArrayList<>();
            for (StockUnit stockUnit : response.getStockUnits()) {
                LocalDate timestampDate = LocalDate.parse(stockUnit.getDate(), DATEFORMATTER);
                LocalDateTime timestamp = timestampDate.atTime(LocalTime.MAX);

                ticks.add(new Tick(stockId, Interval.DAILY, timestamp, "Unknown",
                        BigDecimal.valueOf(stockUnit.getOpen()),
                        BigDecimal.valueOf(stockUnit.getHigh()),
                        BigDecimal.valueOf(stockUnit.getLow()),
                        BigDecimal.valueOf(stockUnit.getClose()),
                        "$"));
            }

            log.info("persisting tick data in the database...");

            tickRepository.saveAll(ticks);

            log.info("successfully persisted tick data in the database");
        }
    }

    /**
     * TODO Diese Methode sollte den letzten Tag zurückgeben, an dem die Börse offen
     * war. Falls FR -> DO; Falls MO -> FR
     * 
     * @return LocalDateTime
     */
    private LocalDateTime getLastOpenDay() {
        return LocalDate.now().atStartOfDay().minusDays(5);
    }
}
