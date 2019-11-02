# Projeto LigAção

Projeto para a disciplina de Domínios de Software - 2019/02 - do curso de Engenharia de Software ([INF/UFG](http://www.inf.ufg.br/)).

## Identificação dos componentes do grupo

Desenvolvido pelos alunos: [@alicefrancener](https://github.com/alicefrancener/), [@caiobas](https://github.com/caiobas), [@danielfreitasbs](https://github.com/danielfreitasbs) e [@ottoleggio](https://github.com/ottoleggio).

## Problema

Há várias instituições, ONGs e grupos de voluntários que promovem ações/eventos visando impactar positivamente a sociedade. Para que essas ações aconteçam são necessários voluntários, __encontrar voluntários adequados é uma dificuldade para as instituições__.

Há pessoas que têm vontade de participar de ações voluntárias porém enfrentam a __dificuldade de não ter conhecimento adequado de quais ações existem, de que tipo, quando acontecem e como participar__.

Há também pessoas que já têm conhecimento das ações e já são voluntários em instituições, porém para as quais a __instituição/ONGs têm uma dificuldade em saber e gerenciar quem irá participar da ação__.

## Objetivo

O sistema __LigAção__ será uma plataforma no qual instituições possam promover suas ações e na qual pessoas possam ter conhecimento dessas ações e possam se inscrever para participar delas.

## Identificação dos componentes do sistema

O sistema será uma plataforma web com portabilidade para ambientes mobile.

Utilizaremos a API de login do Facebook para facilitar o login na plataforma.

Legislação pertinente ao domínio:

- Lei sobre voluntariado (Lei nº 9.608, de 18/02/1998)
- Lei sobre OSCIP (Lei nº 9.790, de 23/03/1999).

## Identificação dos usuários finais

- Instituições, movimentos sociais, ONGs e grupos de voluntários que desejam divulgar suas ações sociais para atingir mais pessoas. Esses usuários são identificados no projeto como **Promotores de Ações**.
- Voluntários e pessoas interessadas em participar presencialmente de ações voluntárias. São identificados no projeto como **Voluntários**

| Necessidades gerais | Usuário
| - | -
| Cadastrar ações | Promotores de ações
| Gerenciar quem poderá participar das ações | Promotores de ações
| Ter conhecimento de quais ações existem em sua cidade |Voluntários
| Escolher ações de acordo com seu interesse | Voluntários
| Obter informações sobre a ação (data, hora, local, etc) | Voluntários
| Se inscrever em ações | Voluntários

## Fontes de requisitos

| Fonte | Técnica de coleta | Motivação
| - | - | -
Voluntários e promotores de ações | Questionário-online | O questionário nos permite atingir várias pessoas usando somente uma técnica
Voluntários e promotores de ações |  Entrevistas | Com entrevistas, podemos ter maior compreensão das reais necessidades de ações dos usuários, validar e refinar requisitos
Promotores de ações<sup>1</sup>| Observação direta de divulgação de ações na internet | Ao analisar como as ações são divulgadas atualmente poderemos compreender melhor de que forma nosso sistema pode ajudar, que lacuna poderia preencher
Sistemas existentes que conectam voluntários à instituições<sup>2</sup> | Análise de concorrência | A observação de sistemas que já existem dentro do domínio nos permite analisar principais funções existentes e se atendem necessidades dos usuários
Sistemas para divulgar eventos<sup>3</sup> | Análise de concorrência | Ações voluntárias têm características similares à eventos gerais (congressos, palestras, workshops). Dessa forma, observar sistemas que servem para divulgar eventos nos permite obter as funcionalidades gerais necessárias para promoção de eventos e inscrição de pessoas.

<sup>1</sup> Lista de promotores de ações: [Projeto Solidarie](https://www.instagram.com/projetosolidaire/), [Ensinando Abraçar](https://www.instagram.com/ensinandoabracar), [Goiânia Invisível](https://www.instagram.com/invisivelgo/), [Pão com Amor](https://www.instagram.com/paocomamor), [Grupo Miau AuAu](https://www.instagram.com/grupomiauauau/), [Nós + Árvores](https://www.instagram.com/nosmaisarvores/), [EcomAmor](https://www.instagram.com/ecomamor/), Banho do Bem, Vida Lata  
<sup>2</sup> Lista de sistemas que conectam voluntários à instituições: [Sistema Voluntário](https://sistemavoluntario.v2v.net/pt-BR/aggregators/2442604a-22ec-410a-84a1-7c9e9e8d6d65), [Ação Voluntária](https://www.acaovoluntaria.org.br/), [Voluntários](https://voluntarios.com.br/), [Parceiros Voluntários](http://www.parceirosvoluntarios.org.br/), [Volunteer Match](https://www.volunteermatch.org), [GiveGab](https://www.givegab.com/)  
<sup>3</sup> Lista de sistemas para divulgar eventos e nos quais as pessoas podem se inscrever: [Sympla](https://www.sympla.com.br/), [Eventuzz](https://www.eventuzz.com/events), [Eventbrite](https://www.eventbrite.com.br/), [Meetup](https://www.meetup.com/pt-BR/)

## Requisitos funcionais

__RF__ _<número único do requisito funcional>_: __como__ _<ator/(sub)sistema>_ , __desejo__ _<ação/objetivo/meta>_ , __para que__ _<razão/benefício>_.

__RF01__: __como__ Promotor de ações, __desejo__ cadastrar uma nova ação, __para que__ possa recrutar novos candidatos. São os dados que comporão o perfil da ação: nome do Promotor da ação, categoria da ação, nome da ação, local, data, horário início, horário fim, descrição e imagem descritiva da ação (opcional). As categorias de ações serão: Projeto Social, Ambiental, Animal, Educação, Esportes, Arte e Cultura.

__RF02__: __como__ Promotor de ações, __desejo__ alterar dados (categoria da ação, nome da ação, descrição e imagem descritiva da ação) de uma ação existente, __para que__ possa adequá-la a
algum imprevisto.

__RF03__: __como__ Promotor de ações, __desejo__ cancelar uma ação existente com opção de adicionar uma justificativa, __para que__ possa ajustá-la a algum imprevisto que a impossibilite de acontecer.

__RF04__: __como__ Promotor de ações, __desejo__ poder filtrar os candidatos de acordo com os atributos de seus perfis, __para que__ eu possa selecionar as pessoas que se encaixam ao trabalho. Alguns atributos dos candidatos que poderão ser filtrados serão: idade, cidade, profissão, categorias de interesse do candidato, ações realizadas e avaliação do voluntário.

__RF05__: __como__ Promotor de ações, __desejo__ poder convidar os candidatos para minhas ações de acordo com os atributos de seus perfis, __para que__ eu possa aumentar as chances de ter pessoas que mais se encaixam ao trabalho.

__RF06__: __como__ Promotor de ações, __desejo__ poder avaliar os voluntários através de uma pontuação de 0 a 5 em critérios (dedicação, pontualidade), para que no futuro aquele candidato possa ser selecionado de acordo com seu histórico.

__RF07__: __como__ Voluntário, __desejo__ filtrar ações disponíveis de acordo com seus atributos, __para que__
possa selecionar uma que mais me agrada. Alguns atributos das ações que poderão ser filtrados serão: cidade, categoria da ação, nome do promotor de ações.

__RF08__: __como__ Voluntário, __desejo__ poder me inscrever em ações, __para que__ possa participar como voluntário. Para se inscrever será necessário nome e e-mail do voluntário.

__RF09__: __como__ Voluntário, __desejo__ poder avaliar as organizações após a realização da ação, __para que__ no futuro aquela organização possa ser selecionada de acordo com seu histórico.

__RF10__: __como__ Promotor de ações, __desejo__ criar (_create_) meu perfil no sistema LigAção, __para que__ possa utilizar todas as funcionalidades do sistema. O promotor de ações poderá se cadastrado como pessoa física ou jurídica. Seguem os dados que comporão o perfil do promotor de ações: nome de pessoa física responsável, CPF do responsável, nome do promotor de ações, tipo de promotor (pessoa física ou jurídica), CNPJ do promotor (obrigatório somente se for pessoa jurídica), razão social (obrigatório somente se for pessoa jurídica), data da fundação, foto de perfil, links para redes sociais e site (opcionais), categorias das ações realizadas, descrição geral, telefone, endereço, nome de usuário, e-mail e senha.

__RF11__: __como__ Promotor de ações, __desejo__ ler (_read_) meu perfil no sistema LigAção, __para que__ possa listar meus dados e verificar se estão corretos. Os dados retornados serão os mesmos citados no RF10.

__RF12__: __como__ Promotor de ações, __desejo__ atualizar (_update_) meu perfil no sistema LigAção, __para que__ possa corrigir e manter atualizados meus dados. Os dados que poderão ser atualizados serão os mesmos citados no RF10.

__RF13__: __como__ Promotor de ações, __desejo__ excluir (_delete_) meu perfil no sistema LigAção, __para que__ possa sair do sistema e não deixar os meus dados pessoais disponíveis. Ao excluir o perfil, todas as ações relacionadas ao Promotor serão excluídas também.

__RF14__: __como__ Voluntário, __desejo__ criar (_create_) meu perfil no sistema LigAção, __para que__ possa utilizar todas as funcionalidades do sistema. Seguem os dados que comporão o perfil voluntário: nome, foto de perfil, links para redes sociais e site (opcionais), endereço (cidade e estado), profissão/área de atuação, categorias de ações de interesse, nome de usuário, e-mail e senha.

__RF15__: __como__ Voluntário, __desejo__ ler (_read_) meu perfil no sistema LigAção, __para que__ possa listar meus dados e verificar se estão corretos. Os dados retornados serão os mesmos citados no RF14.

__RF16__: __como__ Voluntário, __desejo__ atualizar (_update_) meu perfil no sistema LigAção, __para que__ possa corrigir e manter atualizados meus dados. Os dados que poderão ser atualizados serão os mesmos citados no RF14.

__RF17__: __como__ Voluntário, __desejo__ excluir (_delete_) meu perfil no sistema LigAção, __para que__ possa sair do sistema e não deixar os meus dados pessoais disponíveis.

## Diagrama de casos de uso

## Casos de uso detalhados

## Programação das entregas dos requisitos
