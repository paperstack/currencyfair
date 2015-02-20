create table TradeService_Trade (
	uuid_ VARCHAR(75) null,
	tradeId LONG not null primary key,
	userId LONG,
	currencyFrom VARCHAR(75) null,
	currencyTo VARCHAR(75) null,
	amountSell DOUBLE,
	amountBuy DOUBLE,
	rate DOUBLE,
	timePlaced DATE null,
	originatingCountry VARCHAR(75) null
);