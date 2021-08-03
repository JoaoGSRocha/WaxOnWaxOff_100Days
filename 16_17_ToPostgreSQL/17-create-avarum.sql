-- -----------------------------------------------------
-- Schema avarum_shop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS avarum_shop CASCADE;
DROP TABLE IF EXISTS avarum_shop.skin CASCADE;
DROP TABLE IF EXISTS avarum_shop.expansion CASCADE;


CREATE SCHEMA avarum_shop;
SHOW search_path;
SET search_path TO avarum_shop;

-- -----------------------------------------------------
-- Table avarum_shop.skin
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS avarum_shop.expansion (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  expansionCode VARCHAR(255) NULL DEFAULT NULL);

-- -----------------------------------------------------
-- Table avarum_shop.expansion
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS avarum_shop.skin (
  id BIGSERIAl PRIMARY KEY NOT NULL,
  sku VARCHAR(255) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  rarity VARCHAR(255) DEFAULT NULL,
  condition VARCHAR(255) DEFAULT NULL,
  price DECIMAL(13,2) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL,
  active BIT,
  units_in_stock INT DEFAULT NULL,
  releaseDate TIMESTAMP(6) DEFAULT NULL,
  date_created TIMESTAMP(6) DEFAULT NULL,
  last_updated TIMESTAMP(6) DEFAULT NULL,
  expansion_id BIGINT NOT NULL,
  CONSTRAINT fk_category FOREIGN KEY (expansion_id) REFERENCES expansion (id)
);

-- -----------------------------------------------------
-- Eventually ad the Trader ID in skin Entity and create
-- Trader Entity as well to Trade Entity
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO expansion(expansionCode) VALUES ('Classic');

INSERT INTO skin (sku, name, description, rarity, condition, image_url, active, units_in_stock,
price, expansion_id, date_created)
VALUES ('AV-CL-1000', 'Avarum Coins', 'Produced by the Metal Benders. The only currency in Avarum.',
'Rare', 'Factory New', 'assets/images/products/placeholder.png'
,(CAST(1 AS bit)),100,19.99,1, NOW());

INSERT INTO skin (sku, name, description, rarity, condition, image_url, active, units_in_stock,
price, expansion_id, date_created)
VALUES ('AV-CL-1001', 'Vylus', 'The Ex-Servant of the West Kingdom',
'Common', 'Battle Scarred', 'assets/images/products/placeholder.png'
,(CAST(1 AS bit)),100,29.99,1, NOW());

INSERT INTO skin (sku, name, description, rarity, condition, image_url, active, units_in_stock,
price, expansion_id, date_created)
VALUES ('AV-CL-1002', 'Hood', 'Hooodies Goodies',
'Uncommon', 'Field-Tested', 'assets/images/products/placeholder.png'
,(CAST(1 AS bit)),100,24.99,1, NOW());

INSERT INTO skin (sku, name, description, rarity, condition, image_url, active, units_in_stock,
price, expansion_id, date_created)
VALUES ('AV-CL-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT',
'Mythical', 'Minimal Wear', 'assets/images/products/placeholder.png'
,(CAST(1 AS bit)),100,29.99,1, NOW());

INSERT INTO skin (sku, name, description, rarity, condition, image_url, active, units_in_stock,
price, expansion_id, date_created)
VALUES ('AV-CL-1004', 'The Go Programming Language: A to Z', 'Learn Go',
'Ancient', 'Battle Scarred', 'assets/images/products/placeholder.png'
,(CAST(1 AS bit)),100,24.99,1, NOW());
