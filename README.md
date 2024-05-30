# Система Управления Поставками Фруктов

Этот проект представляет собой простую систему управления поставками фруктов, созданную с использованием Spring Boot для бэкенда. Система управляет поставщиками, продуктами, поставками и генерирует отчеты на основе поставок за указанный период.

## Структура Проекта

### Бэкенд

- **Фреймворк:** Spring Boot
- **ORM:** Hibernate
- **База данных:** PostgreSQL
- **Зависимости:** Spring Data JPA, Spring Web, Hibernate, PostgreSQL Driver

## Функциональные Возможности

- **Управление Поставщиками:** Добавление, обновление и получение информации о поставщиках.
- **Управление Продуктами:** Добавление, обновление и получение информации о продуктах.
- **Управление Поставками:** Создание и получение поставок.
- **Генерация Отчетов:** Генерация отчетов, показывающих виды и количества продуктов, полученных от поставщиков за указанный период.

## API Эндпоинты

### Поставщики

- **GET /suppliers:** Получить всех поставщиков.
- **POST /suppliers:** Добавить нового поставщика.
- **PUT /suppliers/{id}:** Обновить существующего поставщика.

### Продукты

- **GET /products:** Получить все продукты.
- **POST /products:** Добавить новый продукт.
- **PUT /products/{id}:** Обновить существующий продукт.

### Поставки

- **GET /deliveries:** Получить все поставки.
- **POST /deliveries:** Создать новую поставку.

### Отчеты

- **GET /reports:** Генерация отчета для поставок за указанный период.

## Сериализация Объектов

В этом проекте для обмена данными между клиентом и сервером используется JSON. Для этого мы используем Jackson для сериализации и десериализации Java объектов в и из JSON.

### Работа с Ленивой Загрузкой

В большинстве случаев данные запрашиваются через тело запроса (`@RequestBody`), а не через параметры запроса (`@RequestParam`). Это было сделано для упрощения структуры запросов и ответа, так как не было строгих требований к формату запросов.

## Примеры Запросов с Использованием Postman

### 1. Получить всех поставщиков

**Метод:** GET  
**URL:** `http://localhost:8080/suppliers`

### 2. Добавить нового поставщика

**Метод:** POST  
**URL:** `http://localhost:8080/suppliers`  
**Тело запроса (JSON):**

```json
{
  "name": "Supplier A",
  "contactInfo": "Contact Info A"
}
```

### 3. Обновить существующего поставщика

**Метод:** PUT  
**URL:** `http://localhost:8080/suppliers/{id}`  
**Тело запроса (JSON):**

```json
{
  "name": "Updated Supplier",
  "contactInfo": "Updated Contact Info"
}
```

### 4. Создать новую поставку

**Метод:** POST  
**URL:** `http://localhost:8080/deliveries`  
**Тело запроса (JSON):**

```json
{
  "supplier": {
    "id": 1
  },
  "date": "2024-05-29",
  "deliveryDetails": [
    {
      "product": {
        "id": 1
      },
      "quantity": 100
    },
    {
      "product": {
        "id": 2
      },
      "quantity": 50
    }
  ]
}
```

### 5. Генерация отчета для поставок за указанный период

**Метод:** GET  
**URL:** `http://localhost:8080/reports?startDate=2024-01-01&endDate=2024-12-31`