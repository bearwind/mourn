alter table admin ADD salt varchar(10) Null;
UPDATE `admin` SET `id`='1', `name`='熊风', `password`='BD509AFEB1C41D854BB85240F24B85B2', `salt`='6fad4xbc' WHERE (`id`='1');
UPDATE `admin` SET `id`='2', `name`='xf', `password`='1E3791B10114749008EF6F7B81643E2C', `salt`='eqgwkwg8' WHERE (`id`='2');
UPDATE `admin` SET `id`='3', `name`='admin', `password`='CD477F5F78AEEF93DF45213366879ACA', `salt`='bkve3poc' WHERE (`id`='3');