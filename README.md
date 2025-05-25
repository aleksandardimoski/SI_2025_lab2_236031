# SI_2025_lab2_236031
## Александар Димоски 236031

---

## 2) Control Flow Graph (CFG)
![Screenshot](ControlFlowGraph.png "ControlFlowGraph")

---

## 3) Цикломатска Комплексност
Цикломатската комплексност на функцијата checkCart е 9.

Се добива преку формулата: бројот на ребра - број на јазли + 2
```
28 - 21 + 2 = 9
```

---

## 4) Тест случаи критериум

### Тест случај 1
```
allItems = null  
cardNumber = "1234567890123456"
```

### Тест случај 2
```
allItems = [ new Item(null, 1, 100, 0.0) ]
cardNumber = "1234567890123456"
```

### Тест случај 3
```
allItems = [ new Item("product", 2, 200, 0.5) ]
cardNumber = "1234567890123456"
```

### Тест случај 4
```
allItems = [ new Item("item", 1, 100, 0.0) ]
cardNumber = "1234abc901234567"
```

### Тест случај 4
```
allItems = [ new Item("item", 1, 100, 0.0) ]
cardNumber = "1234abc901234567"
```

### Тест случај 5
```
allItems = [ new Item("item", 1, 100, 0.0) ]
cardNumber = "1111222233334444"
```

Со овие 5 случаеви се покриени сите блокови

---

## 5) Multiple Condition – тест случаи

Условот е:
```
if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
```

| Тест | `price > 300` | `discount > 0` | `quantity > 10` | Очекуван резултат (се одзема 30?) |
| ---- | ------------- | -------------- | --------------- |-----------------------------------|
| 1    | false         | false          | false           | Не се одзема 30                   |
| 2    | true          | false          | false           | Се одзема 30                      |
| 3    | false         | true           | false           | Се одзема 30                      |
| 4    | false         | false          | true            | Се одзема 30                      |
| 5    | true          | true           | false           | Се одзема 30                      |
| 6    | true          | false          | true            | Се одзема 30                      |
| 7    | false         | true           | true            | Се одзема 30                      |
| 8    | true          | true           | true            | Се одзема 30                      |

Минимален број на тест случаи за покривање на сите можни комбинации е 8

---
