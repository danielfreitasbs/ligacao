
# Comandos maven (testes, análise estática e documentação)

Baseado na documentação do repositório [kyriosdata/exemplo](https://github.com/kyriosdata/exemplo)

## Pré-requisitos

- `mvn --version`<br>
você deverá ver a indicação da versão do Maven instalada e
a versão do JDK, dentre outras. Observe que o JDK é obrigatório, assim como
a definição das variáveis de ambiente **JAVA_HOME** e **M2_HOME**.

## Limpar e compilar

- `mvn clean`<br>
remove diretório _target_

- `mvn compile`<br>
compila o projeto, deposita resultados no diretório _target_

## Testes de unidade e cobertura

- `mvn test`<br>
executa todos os testes do projeto. Para executar apenas parte dos testes, por exemplo,
aqueles contidos em uma dada classe execute `mvn -Dtest=NomeDaClasseTest test`. Observe
que o sufixo do nome da classe de teste é `Test` (padrão recomendado). Para executar um
único teste `mvn -Dtest=NomeDaClasseTest#nomeDoMetodo test`.

- `mvn verify -P cobertura`<br>
executa testes de unidade e produz relatório de
cobertura em _target/site/jacoco/index.html_ além de verificar se limite mínimo
de cobertura, conforme configurado, é satisfeito.

## Documentação

- `mvn javadoc:javadoc`<br>
produz documentação do projeto depositada em
_target/site/apidocs/index.html_. Este comando está configurado para
o JDK 9.

## Análise estática

Trata-se da análise do código sem que seja executado. Esta análise produz
uma "noção de quão bom" está o código sob alguns aspecto e, em consequência, 
permite orientar eventuais ações de melhoria. Fique atento, "sair 
bem" na análise estática não significa que "agrada usuários". A análise 
estática observa o código. 

Todas estas análises devem ser realizadas em todos os projetos? Não!
Aquelas relevantes para um dado projeto deverão ser
configuradas em conformidade com o contexto em questão.

- **Checkstyle**
  - `mvn checkstyle:checkstyle`<br>
  gera análise de estilo em _target/site/checkstyle.html_. 
  Observe que o uso do plugin
  **jxr** é necessário para geração de relatório do código fonte referenciável
  pelo relatório gerado pelo Checkstyle. Contudo, o uso do **jxr** não é 
  obrigatório.

  - `mvn checkstyle:check`<br>
  faz com que o _build_ falhe se pelo menos
um estilo é violado

- **Dependency Check (vulnerabilidades)**
  - `mvn verify -P owasp`<br>
  análise de vulnerabilidades depositadas em
  _target/dependency-check-report.html_. A primeira execução é relativamente
  "longa", esteja preparado para esperar...

- **Spotbugs**
  - `mvn spotbugs:spotbugs`<br>
  detecção de bugs
   - `mvn spotbugs:check`<br>
   apenas verifica se há erros
  - `mvn spotbugs:gui`<br>
  abre GUI para exibir bugs após _mvn spotbugs:spotbugs_

- **Spotbugs** (security)
  - `mvn spotbugs:spotbugs -P security`<br>
  detecção de bugs
   - `mvn spotbugs:check -P security`<br>
   apenas verifica se há erros
  - `mvn spotbugs:gui -P security`<br>
  abre GUI para exibir bugs após _mvn spotbugs:spotbugs -P security_