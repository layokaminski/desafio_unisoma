# Desafio Unisoma

Projeto criado para o desafio da mobiauto

## ⚙️ Executando os testes

```
mvn test
```


### Rotas

# Criar funcionário

- `/api/employee`
- exemplo de json a ser enviado:

```json
{
 "name": "Test da Silva",
 "cpf": "42115812321",
 "birthday": "10/01/1990",
 "address": "Rua Test, 300",
 "phone": "11 99999-9999",
 "salary": 3000.00
}
```

- `/api/adjustment/42115812321` CPF utilizando no exemplo acima, rota atualiza o salario do funcionario
- `/api/tax/42115812321` CPF utilizando no exemplo acima, rota faz calculo do imposto
