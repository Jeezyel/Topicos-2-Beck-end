    INSERT INTO public.estado(
	sigla,  nome)
	VALUES ('sl',  'seila');

   INSERT INTO public.estado(
	sigla,  nome)
	VALUES ('bb',  'borabora');

	INSERT INTO public.estado(
    	sigla,  nome)
    	VALUES ('vv',  'vava');

    	INSERT INTO public.estado(
        	sigla,  nome)
        	VALUES ('ss',  'sacanagen sacanagen');


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.municipio(
	 id_estado, nome)
	VALUES ( 1, 'muito longe');

	INSERT INTO public.municipio(
    	 id_estado, nome)
    	VALUES ( 2, 'vaidar merda');

    INSERT INTO public.municipio(
    	 id_estado, nome)
    	VALUES ( 3, 'gameplay');

    	INSERT INTO public.municipio(
        	 id_estado, nome)
        	VALUES ( 4, 'bordao');



///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.endereco(
	 municipio_id, bairro, cep, complemento, logradouro)
	VALUES ( 1, 'logoali', '770202222', 'perto dacula', 'nao sei o que e');

	INSERT INTO public.endereco(
    	 municipio_id, bairro, cep, complemento, logradouro)
    	VALUES ( 2, 'acula', '770202222', 'perto dacula', 'nao sei o que e');

    INSERT INTO public.endereco(
    	 municipio_id, bairro, cep, complemento, logradouro)
    	VALUES ( 3 , 'bem ali', '770202222', 'perto do trem grande', 'nao sei o que e');

    INSERT INTO public.endereco(
    	 municipio_id, bairro, cep, complemento, logradouro)
    	VALUES ( 4 , 'apontando com a boca', '770202222', 'perto do trem grande logo ali', 'nao sei o que e');


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'tq@gmail.com', '23523623457');

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'ty@gmail.com', '4563242345');

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'tck@gmail.com', '2345266234');

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'qck@gmail.com', '23452347724');



///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.usuario(
	datanacimento, id_contato, id_enderecoprincipal, cpf, nome, login, senha, perfis)
	VALUES ('2001/10/01', 2, 2, '23567234','pp', 'pp', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', '{ADMIN}'),
	('2001/10/01', 1, 1, '2345624353','qq', 'qq', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', '{ADMIN}'),
	('2001/10/01', 3, 3, '43587345635','tt', 'tt', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', '{ADMIN}'),
	('2001/10/01', 4, 4, '7896789676','aa', 'aa', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', '{ADMIN}');


///////////////////////////////////////////////////////////////////////////////////////////////////////////////


INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'tq@gmail.com', '23523623457');

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'ty@gmail.com', '4563242345');

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'tck@gmail.com', '2345266234');

INSERT INTO public.contato(
       	  email, telefone)
       	VALUES (  'qck@gmail.com', '23452347724');



///////////////////////////////////////////////////////////////////////////////////////////////////////////////
INSERT INTO public.autor(
	 id_usuario, nomeartistico)
	VALUES ( 1, 'danona'),
			( 2, 'dolarama'),
			( 3, 'dorama'),
			( 3, 'dropando');

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.cor(
	 corrgb, descricao)
	VALUES ( '(255,255,255)', 'cor principal'),
			( '(255,0,255)', 'cor Secundária'),
			( '(0,255,255)', 'Cor terciária'),
			( '(255,255,0)', 'Cor quartenária'),
			( '(0,0,0)', 'Bleck');

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.editora(
	 id_endereco, cnpj, nome, telefone)
	VALUES ( 3, '36543465', 'dondoca investimento', '6312431241'),
			( 3, '345634532', 'roni coliman investimento', '6313451241'),
			( 3, '234562345', 'dondoca banks', '6312477741'),
			( 3, '345234663', 'roni coliman banks', '6312778841');

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.livro(
	anopublicacao, numpaginas, valor,  id_autor, id_editora, categorialivro, descricao, titulo)
	VALUES ( 2011, 99, 50.50, 1, 1, 'ROMANCE', 'apaixnado na lua', 'a luz da lua'),
			( 2021, 79, 5.50, 2, 2, 'FICCAO', 'a gameplay', 'a gameplay Assassina'),
			( 2017, 83, 45.50, 3, 3, 'TERROR', 'jovens em um acampamento', 'Json'),
			( 2022, 80, 2.50, 4, 4, 'AUTO_AJUDA', 'como mudar a sua vida', 'a maior mentira');

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.marca(
	 descricao, nome)
	VALUES ( 'fornecedor gringo', 'Light life'),
			( 'fornecedor nacional', 'll luminaria'),
			( 'fornecedor nacional', 'luz'),
			( 'fornecedor gringo', 'caloteiro');

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO public.luminaria(
 	valor,  id_cor, id_marca, descricao, estilo, tipodefontedeluz)
 	VALUES ( 167.00, 1, 1 , 'luminaria de teclado', 'Light bar', 'led'),
 			( 107.00, 3, 2 ,'luminaria da Pixel', 'luminaria', 'led'),
 			( 17.00, 4, 3 ,'luminaria de torre', 'torre', 'led'),
 			( 168.00, 5, 4 ,'luminaria de lava', 'torre', 'led');
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

