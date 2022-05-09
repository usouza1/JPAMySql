INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (1, 0, 'Cabo Adaptador Conversor Displayport X Hdmi Macho', 102, 49.95);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (2, 0, 'Moto E20 Dual SIM 32 GB azul 2 GB RAM', 124, 744.90);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (3, 0, 'Smart TV Philco PTV32G70RCH LED HD 32 220V', 148, 1279.00);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (4, 0, 'Fire Tv Stick 4k Controle Remoto Por Voz Com Alexa - Amazon', 172, 1334.95);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (5, 0, 'Capacete para moto integral Pro Tork Evolution G4 Las Vegas', 133, 170.90);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (6, 0, 'Camiseta Masculina Básica Logo Reissue Preto Calvin Klein', 184, 79.87);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (7, 0, 'Infinity Cube Cubo Mágico Infinito Fidget Toys', 170, 21.68);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (8, 0, 'Multilaser E Lite Dual SIM 32 GB preto 512 MB RAM', 136, 314.90);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (9, 0, 'Tênis Nikecourt Vapor Lite Masculino', 189, 599.99);
INSERT INTO Prd (ID, VERSION, NmPrd, QtEstq, VlUnit) VALUES (10, 0, 'Smart TV Samsung UN55AU8000GXZD LED 4K 55240V', 144, 3599.99);


INSERT INTO Cli (ID, VERSION, NrCpf, TxEmail, NmCli) VALUES (1, 0, '42571900', 'twhite@acore.org', 'Thomas White');
INSERT INTO Cli (ID, VERSION, NrCpf, TxEmail, NmCli) VALUES (2, 0, '55443000', 'philipc@acore.org', 'Philip Campbell');
INSERT INTO Cli (ID, VERSION, NrCpf, TxEmail, NmCli) VALUES (3, 0, '19155100', 'lindac@acore.org', 'Linda Carter');
INSERT INTO Cli (ID, VERSION, NrCpf, TxEmail, NmCli) VALUES (4, 0, '41689100', 'sophieca@acore.org', 'Sophie C. Allen');
INSERT INTO Cli (ID, VERSION, NrCpf, TxEmail, NmCli) VALUES (5, 0, '52957700', 'patriciajs@acore.org', 'Patricia J. Smith');


INSERT INTO End (ID, VERSION, TxBai, NrCep, TxCid, TxCmpl, TxLog, TxUf, CLI_ID) VALUES (1, 0, 'Asa Norte', 70714900, 'Brasilia', 'Centro Empresarial Varig', 'SCN Quadra 4 Bloco B', 'DF', 1);
INSERT INTO End (ID, VERSION, TxBai, NrCep, TxCid, TxCmpl, TxLog, TxUf, CLI_ID) VALUES (2, 0, 'Vila Almeida', 4795100, 'São Paulo', 'Centro Empresarial Naçẽes Unidas (CENU)', 'Avenida das Nações Unidas', 'SP', 2);
INSERT INTO End (ID, VERSION, TxBai, NrCep, TxCid, TxCmpl, TxLog, TxUf, CLI_ID) VALUES (3, 0, 'Centro', 20031170, 'Rio de Janeiro', '', 'Av. República do Chile, 330', 'RJ', 3);
INSERT INTO End (ID, VERSION, TxBai, NrCep, TxCid, TxCmpl, TxLog, TxUf, CLI_ID) VALUES (4, 0, 'Botafogo', 22290240, 'Rio de Janeiro', '', 'Av. Pasteur, 146', 'RJ', 4);
INSERT INTO End (ID, VERSION, TxBai, NrCep, TxCid, TxCmpl, TxLog, TxUf, CLI_ID) VALUES (5, 0, 'Vila Mariana', 4007900, 'São Paulo', '', 'Rua Tutóia 1157', 'SP', 5);


INSERT INTO Car (ID, VERSION, NrQtd, CLI_ID, PRD_ID) VALUES (1, 0, 2, 1, 1);
INSERT INTO Car (ID, VERSION, NrQtd, CLI_ID, PRD_ID) VALUES (2, 0, 1, 1, 3);


INSERT INTO Ped (ID, VERSION, DtEntr, DtPed, VlPed, CLI_ID, END_ID) VALUES (1, 0, '2022-04-01', '2022-04-03', '2613.95', 1, 1);
INSERT INTO Ped (ID, VERSION, DtEntr, DtPed, VlPed, CLI_ID, END_ID) VALUES (2, 0, '2022-04-18', '2022-04-21', '2999.70', 1, 1);


INSERT INTO Item (ID, VERSION, NrQtd, VlUnit, PED_ID, PRD_ID) VALUES (1, 0, 1, '1334.95', 1, 4);
INSERT INTO Item (ID, VERSION, NrQtd, VlUnit, PED_ID, PRD_ID) VALUES (2, 0, 1, '1279.00', 1, 3);
INSERT INTO Item (ID, VERSION, NrQtd, VlUnit, PED_ID, PRD_ID) VALUES (3, 0, 2, '341.80', 2, 5);
INSERT INTO Item (ID, VERSION, NrQtd, VlUnit, PED_ID, PRD_ID) VALUES (4, 0, 2, '99.90', 2, 1);
INSERT INTO Item (ID, VERSION, NrQtd, VlUnit, PED_ID, PRD_ID) VALUES (5, 0, 2, '2558.00', 2, 3);
