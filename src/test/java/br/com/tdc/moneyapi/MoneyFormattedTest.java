package br.com.tdc.moneyapi;

import static org.junit.Assert.*;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;
import org.junit.Test;

public class MoneyFormattedTest {

	@Test
	public void shouldFormatRealCurrencyUnit() throws Exception {
		CurrencyUnit dollar = MonetaryCurrencies.getCurrency(Locale.US);
		
		MonetaryAmount money = Money.of(1230.02, dollar);
		
		MonetaryAmountFormat formatter = MonetaryFormats.getAmountFormat(Locale.US);
		
		String formattedMoney = formatter.format(money);
		
		assertEquals("USD1,230.02", formattedMoney);
	}
	
	@Test
	public void shouldFormatDollarCurrencyWithoutUSD() throws Exception {
		CurrencyUnit dollar = MonetaryCurrencies.getCurrency(Locale.US);
		
		MonetaryAmount money = Money.of(1230.02, dollar);
		
		MonetaryAmountFormat customFormatter = MonetaryFormats.getAmountFormat(
				AmountFormatQueryBuilder.of(Locale.US).set(CurrencyStyle.SYMBOL).build());
				
		String customFormattedMoney = customFormatter.format(money);
	
		assertEquals("$1,230.02", customFormattedMoney);				
	}
}
