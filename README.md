# Trabalho de Faculdade - Simulador de Fila de Banco

Esse é um trabalho da faculdade que simula filas de atendimento de banco, feito em Java.

## Quem Fez
- Gabriel Antunes de Lavor

## O Que o Programa Faz
- Adiciona clientes na fila (normal ou prioritária)
- Chama o próximo cliente (prioritário vai primeiro)
- Pode desfazer se chamou o cliente errado
- Mostra um relatório com quantas pessoas foram atendidas

## Como Fizemos Tudo na Mão (Modelos de Design)

### Estruturas que Criamos do Zero:
- **FilaEncadeada.java** - Fila que fiz usando nós encadeados
- **PilhaEncadeada.java** - Pilha que fiz usando nós encadeados

### Como Funciona Nossa Fila:
- Cada cliente na fila sabe quem é o próximo (como uma corrente)
- Temos controle do primeiro e último da fila
- Quem chega primeiro é atendido primeiro (FIFO)
- Funciona igual fila de banco de verdade

### Como Funciona Nossa Pilha:  
- Só mexe no topo (último elemento)
- Último que entra é primeiro que sai (LIFO)
- Funciona igual pilha de pratos
- Perfeito para o histórico de atendimentos

### Decisões Importantes:
1. **Clientes Prioritários Primeiro** - Idosos e gestantes vão na frente
2. **Histórico com Pilha** - Último atendimento é o primeiro a desfazer
3. **Tudo na Mão** - Não usei filas prontas do Java

## Como Organizamos o Programa
- `model/` - Fica a classe Cliente (a pessoa na fila)
- `structures/` - Nossas filas e pilhas que criamos na mão
- `service/` - O sistema que controla tudo

## Como Abrir e Rodar o Programa
1. Abre o IntelliJ IDEA
2. Clica em "Open" ou "Open Project"
3. Escolhe a pasta "projeto_banco"
4. Espera ele carregar tudo
5. Vai na pasta `src` e abre o arquivo `Main.java`
6. Clica com botão direito em cima do arquivo `Main.java`
7. Escolhe "Run 'Main.main()'"
8. Pronto! O programa vai funcionar

## Para Testar se Está Funcionando
1. Abre o programa
2. Escolhe opção 1 e adiciona: "Maria" como "Prioritario"
3. Escolhe opção 1 e adiciona: "João" como "Comum"  
4. Escolhe opção 2 - tem que chamar a Maria primeiro (ela é prioritária)
5. Escolhe opção 4 - mostra o relatório
6. Escolhe opção 3 - desfaz o último atendimento
7. Escolhe opção 4 de novo - mostra que voltou uma pessoa para a fila

## Coisas que Aprendemos
- Como funciona fila encadeada (cada elemento ligado no próximo)
- Como funciona pilha encadeada (só mexe no topo)  
- Como organizar código em Java
- Como fazer um programa que realmente funciona
- Como criar estruturas de dados do zero sem usar as prontas

---

**Desenvolvido no VS Code e testado no IntelliJ - funciona perfeitamente em ambos!**