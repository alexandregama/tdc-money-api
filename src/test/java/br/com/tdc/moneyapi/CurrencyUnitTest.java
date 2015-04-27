package br.com.tdc.moneyapi;

import static org.junit.Assert.*;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.junit.Test;

public class CurrencyUnitTest {

	@Test
	public void shouldReturnBrazilianCurrency() throws Exception {
		CurrencyUnit real = MonetaryCurrencies.getCurrency("BRL");
		
		assertEquals("BRL", real.getCurrencyCode());
	}
	
	@Test
	public void shouldReturnAmericanCurrency() throws Exception {
		CurrencyUnit dollar = MonetaryCurrencies.getCurrency("USD");
		
		assertEquals("USD", dollar.getCurrencyCode());
	}

	@Test
	public void shouldCreateABrazilianMoney() throws Exception {
		CurrencyUnit real = MonetaryCurrencies.getCurrency("BRL");
		
		MonetaryAmount money = Money.of(200, real);
		
		assertEquals("BRL", money.getCurrency().getCurrencyCode());
		assertEquals(120, money.getNumber().intValue());
	}
	
	@Test
	public void shouldCreateABrazilianFastMoney() throws Exception {
		CurrencyUnit real = MonetaryCurrencies.getCurrency("BRL");
		
		MonetaryAmount money = FastMoney.of(50, real);

		assertEquals("BRL", money.getCurrency().getCurrencyCode());
		assertEquals(80, money.getNumber().intValue());
	}
	
}
