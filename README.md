# Projeto Cartão – Máquina de Estados (Cliente × Instituição)

Trabalho I da disciplina **Inteligência Artificial e Ilusão de Inteligência em Jogos** (PUCPR – Prof.ª Marina de Lara).
Autores: Gabriel Furlan, Gabriel Dias e Arthur Polak.

Simulação, em dias, de um cartão de crédito com dois agentes que usam o **padrão State** (`enter` / `execute` / `leave`):

| Agente | Classe | Estados |
|---|---|---|
| **A – Instituição** | `instituicao/Instituicao.java` | Ocioso, Analisando, Respondendo |
| **B – Cliente** | `cliente/Cliente.java` | Passeando, Comprando |

**Comunicação entre agentes (bônus):** os agentes se comunicam pelo objeto compartilhado `Cartao` (compra pendente, fatura e limite) e por flags internas. A Instituição só entra em *Analisando* quando o Cliente, em *Comprando*, deixa uma compra pendente no cartão.

## Estrutura

```
src/
  Run/Run.java                  -> laço principal da simulação
  Objetos/                      -> State, AbstractState, Cartao, Limites, Produto, ControleDeTempo, _produtos.txt
  cliente/                      -> Cliente + states/ (Passeando, Comprando)
  instituicao/                  -> Instituicao + States/ (Ocioso, Analisando, Respondendo)
docs/
  Projeto-Cartao-Documentacao.pdf   -> documento da entrega
  diagrama_cliente.png/.svg, diagrama_instituicao.png/.svg
  log_exemplo.txt                   -> exemplo de log de uma execução
```

## Como compilar e executar

Para rodar a aplicação:

1. Acesse o arquivo **`Run.java`** localizado dentro do pacote/pasta **`Run`**.
2. Defina a quantidade de dias desejada alterando o valor do **contador** no código principal.
3. Execute o arquivo **`Run.java`** para iniciar a simulação.

Requisito: JDK 8 ou superior (apenas Java padrão, sem bibliotecas externas).

> **Importante:** execute a partir da pasta `src`, pois o programa lê o arquivo `Objetos/_produtos.txt` por caminho relativo.

**Linux / macOS**
```bash
cd src
javac -encoding UTF-8 -d ../out $(find . -name "*.java")
java -cp ../out Run.Run
```

**Windows (PowerShell)**
```powershell
cd src
javac -encoding UTF-8 -d ..\out (Get-ChildItem -Recurse -Filter *.java).FullName
java -cp ..\out Run.Run
```
(Se os acentos aparecerem errados no console do Windows, rode `chcp 65001` antes.)

Também é possível abrir a pasta `src` no VS Code/IntelliJ e executar `Run.java`.

## Regras principais

- **Cliente:** a cada dia entra em *Passeando*; se `nextInt(100) < 50` (50%) vai para *Comprando*, onde sorteia um produto de `_produtos.txt` e o deixa como compra pendente. No dia seguinte volta a *Passeando*.
- **Instituição:** *Ocioso* → *Analisando* quando há compra pendente; em *Analisando* a compra é **negada** se `limiteDisponível < valor` e **aprovada** caso contrário (debitando o limite, inicial R$ 10.000); no ciclo seguinte *Respondendo* informa o resultado e volta a *Analisando* (nova compra) ou *Ocioso*.
- No dia 5 de cada mês (`Cartao.FECHAMENTO_FATURA`) o cliente fecha a fatura: a lista de compras com a situação de cada uma é impressa e a fatura é esvaziada.

Detalhes completos (diagramas, tabelas de regras, variáveis e limitações) em [`docs/Projeto-Cartao-Documentacao.pdf`](docs/Projeto-Cartao-Documentacao.pdf).
