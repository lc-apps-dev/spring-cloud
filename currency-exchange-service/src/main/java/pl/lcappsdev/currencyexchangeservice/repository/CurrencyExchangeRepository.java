package pl.lcappsdev.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lcappsdev.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);
}
