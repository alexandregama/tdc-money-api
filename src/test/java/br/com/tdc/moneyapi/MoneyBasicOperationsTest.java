package br.com.tdc.moneyapi;

import static org.junit.Assert.*;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class MoneyBasicOperationsTest {

	@Test
	public void shouldPlusMoneyWithAnotherMoney() throws Exception {
		CurrencyUnit real = MonetaryCurrencies.getCurrency("BRL");
		
		MonetaryAmount money120Reais = Money.of(120, real);
		MonetaryAmount money80Reais = Money.of(80, real);
		
		MonetaryAmount newMoney = money120Reais.add(money80Reais);
		
		assertEquals(200, newMoney.getNumber().intValue());
	}
	
	@Test
	public void shouldShowsThat120IsGreaterThan80() throws Exception {
		CurrencyUnit real = MonetaryCurrencies.getCurrency("BRL");
		
		MonetaryAmount money120Reais = Money.of(120, real);
		MonetaryAmount money80Reais = Money.of(80, real);
		
		assertTrue(money120Reais.isGreaterThan(money80Reais));
	}
	
	@Test
	public void shouldCheckIfMoneyIsZero() throws Exception {
		CurrencyUnit real = MonetaryCurrencies.getCurrency("BRL");
		
		MonetaryAmount money120Reais = Money.of(120, real);
		MonetaryAmount money80Reais = Money.of(80, real);
		
		assertFalse(money120Reais.isZero());
		assertFalse(money80Reais.isZero());
	}
	
}
