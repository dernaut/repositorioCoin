CREATE TABLE IF NOT exists tb_coin(
	id_coin	serial PRIMARY key,
	name_coin varchar(50) not null,
	url_icon varchar(50) not null,
	price_coin  decimal(20,4) not null,
	day_variation decimal(2,2) not null,
	week_variation decimal(2,2) not null,
	market_cap decimal(20,4) not null,
	day_volume decimal(20,4) not null,
	circulating_supply decimal(20,4) not null
)