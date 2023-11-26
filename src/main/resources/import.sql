INSERT INTO tb_authors (name, birthday, nationality) values('Robert T. Kiyosaki', 'April 8, 1947', 'Japenese-American')
INSERT INTO tb_authors (name, birthday, nationality) values('George Samuel Clason','November 7, 1874 – April 5, 1957', 'American')
INSERT INTO tb_authors (name, birthday, nationality) values('Jacob Petry','Julho 26, 1971','Brazilian')
INSERT INTO tb_authors (name, birthday, nationality) values(' Brian Tracy ','January 5, 1944','Canadian')


INSERT INTO tb_category (genre) values('Romance')
INSERT INTO tb_category (genre) values('Auto-Ajuda e Desenvolvimento Pessoal')
INSERT INTO tb_category (genre) values('Auto-Ajuda')
INSERT INTO tb_category (genre) values('Desenvolvimento Pessoal')
INSERT INTO tb_category (genre) values('Literatura')
INSERT INTO tb_category (genre) values('Didático')
INSERT INTO tb_category (genre) values('Finanças Pessoais')


INSERT INTO tb_books (title, book_year, publisher, edition, img_url, short_summary, long_summary, category_id, author_id) values('O homem mais rico da Babiônia', '1926', 'Harper Collins', 1,'https://cdn.kobo.com/book-images/6e3abd67-b02f-47ef-a49c-427d82d0ca80/1200/1200/False/o-homem-mais-rico-da-babilonia.jpg','Foi por volta de 1926 que o autor George S. Clason se lembrou de escrever alguns panfletos informativos sobre como alcançar o sucesso financeiro...','Foi por volta de 1926 que o autor George S. Clason se lembrou de escrever alguns panfletos informativos sobre como alcançar o sucesso financeiro, inspirando-se em parábolas ambientadas na antiga Babilónia, império indubitavelmente poderoso. Assim, Clason conta a história de um homem que quis tornar-se rico e o conseguiu através de cinco leis de ouro, que se tornaram um conjunto de princípios pedagógicos com validade intemporal.',2,3)
INSERT INTO tb_books (title, book_year, publisher, edition, img_url, short_summary, long_summary, category_id, author_id) values('Pai rico, Pai pobre', '1997', 'Campus- Grupo Elsevier', 1,'https://img.bertrand.pt/images/pai-rico-pai-pobre-robert-t-kiyosaki/NDV8MTYwMzYzNzd8MTE1ODE0MzR8MTUwNDcxMTQyMzAwMA==/500x', 'O livro Pai rico, pai pobre narra a história de Robert Kiyosaki e de seu amigo Mike. Ao longo de sua trajetória...','O livro Pai rico, pai pobre narra a história de Robert Kiyosaki e de seu amigo Mike. Ao longo de sua trajetória, Robert recebe orientações financeiras de seu próprio pai – o pai pobre – e do pai de Mike – o pai rico. suas próprias carreiras, eles carregam visões muito distintas quando se fala em lidar com o dinheiro.',7,1)
INSERT INTO tb_books (title, book_year, publisher, edition, img_url, short_summary, long_summary, category_id, author_id) values('As 16 leis do sucesso', '2017','Faro Editorial', 2,'https://m.media-amazon.com/images/I/71ZB2soKVgL._AC_UF1000,1000_QL80_.jpg','AS 16 LEIS DO SUCESSO é um curso prático que reúne as 16 poderosas lições que são as bases de toda filosofia de Napoleon Hill...','AS 16 LEIS DO SUCESSO é um curso prático que reúne as 16 poderosas lições que são as bases de toda filosofia de Napoleon Hill, o maior gênio na área da realização pessoal e psicologia aplicada de todos os tempos.',2,2)
INSERT INTO tb_books (title, book_year, publisher, edition, img_url, short_summary, long_summary, category_id, author_id) values('Metas','2011', 'Best Seller', 1, 'https://m.media-amazon.com/images/I/51RCgVyCGpL._SY466_.jpg','Em 1900 havia cinco mil milionários apenas nos Estados Unidos. Com a chegada do novo milênio o número saltou para cinco milhões...','Em 1900 havia cinco mil milionários apenas nos Estados Unidos. Com a chegada do novo milênio o número saltou para cinco milhões. Até 2020 estima-se que 20 milhões de pessoas entrem no time dos rendimentos de sete dígitos. Em Metas, o especialista em treinamento empresarial Brian Tracy dá dicas e ferramentas para quem quer fazer parte desse seleto clube de privilegiados. Através do prático e comprovado processo de estabelecimento e realização de objetivos, é possível realizar muito em pouco tempo.',3,4)

INSERT INTO tb_belonging (book_id, category_id, position) values(1,7,0)
INSERT INTO tb_belonging (book_id, category_id,position) values(2,2,1)
INSERT INTO tb_belonging (book_id, category_id,position) values(3,2,2)
INSERT INTO tb_belonging (book_id, category_id,position) values(4,3,3)