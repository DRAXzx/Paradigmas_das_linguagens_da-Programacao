class Item:
    def __init__(self, codigo, descricao, valor):
        self.codigo = codigo
        self.descricao = descricao
        self.valor = valor
        self.acrescimo = 0
        self.desconto = 0
        self.total = valor

def inserir_item(carrinho):
    codigo = input("Código do item: ")
    descricao = input("Descrição do item: ")
    valor = float(input("Valor do item: "))
    item = Item(codigo, descricao, valor)
    carrinho.append(item)

def localizar_item(codigo, carrinho):
    for item in carrinho:
        if item.codigo == codigo:
            return item
    return None

def aplicar_acrescimo_item(item, acrescimo):
    item.acrescimo += acrescimo
    calcular_total_item(item)

def aplicar_desconto_item(item, desconto):
    item.desconto += desconto
    calcular_total_item(item)

def calcular_total_item(item):
    item.total = item.valor + item.acrescimo - item.desconto

def distribuir_acrescimo(carrinho, acrescimo_total):
    if len(carrinho) == 0:
        return
    acrescimo_por_item = acrescimo_total / len(carrinho)
    for item in carrinho:
        aplicar_acrescimo_item(item, acrescimo_por_item)

def distribuir_desconto(carrinho, desconto_total):
    if len(carrinho) == 0:
        return
    desconto_por_item = desconto_total / len(carrinho)
    for item in carrinho:
        aplicar_desconto_item(item, desconto_por_item)

def finalizar_venda(carrinho):
    total_acrescimo = sum(item.acrescimo for item in carrinho)
    total_desconto = sum(item.desconto for item in carrinho)
    valor_final = sum(item.total for item in carrinho)
    
    exibir_itens(carrinho)
    print(f"\nTotal de acréscimo: R${total_acrescimo:.2f}")
    print(f"Total de desconto: R${total_desconto:.2f}")
    print(f"Valor final: R${valor_final:.2f}")

def exibir_itens(carrinho):
    print("\nItens no carrinho:")
    for item in carrinho:
        print(f"Código: {item.codigo}, Descrição: {item.descricao}, Valor: R${item.valor:.2f}, "
              f"Acréscimo: R${item.acrescimo:.2f}, Desconto: R${item.desconto:.2f}, Total: R${item.total:.2f}")

def exibir_menu():
    print("\nMenu:")
    print("1 - Inserir item ao carrinho")
    print("2 - Acréscimo de item")
    print("3 - Desconto de item")
    print("4 - Acréscimo total")
    print("5 - Desconto total")
    print("6 - Finalizar venda")

def adicionar_acrescimo_item(carrinho):
    codigo = input("Informe o código do item para acréscimo: ")
    item = localizar_item(codigo, carrinho)
    if item:
        acrescimo = float(input("Valor do acréscimo: "))
        aplicar_acrescimo_item(item, acrescimo)
    else:
        print("Item não encontrado.")

def adicionar_desconto_item(carrinho):
    codigo = input("Informe o código do item para desconto: ")
    item = localizar_item(codigo, carrinho)
    if item:
        desconto = float(input("Valor do desconto: "))
        aplicar_desconto_item(item, desconto)
    else:
        print("Item não encontrado.")

def adicionar_acrescimo_total(carrinho):
    acrescimo_total = float(input("Informe o valor total do acréscimo: "))
    distribuir_acrescimo(carrinho, acrescimo_total)

def adicionar_desconto_total(carrinho):
    desconto_total = float(input("Informe o valor total do desconto: "))
    distribuir_desconto(carrinho, desconto_total)

def finalizar_venda_e_sair(carrinho):
    finalizar_venda(carrinho)
    exit()

def menu():
    carrinho = []
    while True:
        exibir_menu()
        opcao = input("Escolha uma opção: ")
        
        if opcao == '1':
            inserir_item(carrinho)
        elif opcao == '2':
            adicionar_acrescimo_item(carrinho)
        elif opcao == '3':
            adicionar_desconto_item(carrinho)
        elif opcao == '4':
            adicionar_acrescimo_total(carrinho)
        elif opcao == '5':
            adicionar_desconto_total(carrinho)
        elif opcao == '6':
            finalizar_venda_e_sair(carrinho)
        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    menu()