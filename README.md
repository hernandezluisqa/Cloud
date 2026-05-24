# Tests

### By Tag
mvn test -Dcucumber.filter.tags="@Smoke"

### All
mvn test

### Clean test files
mvn clean test

### Exclude Manual and WIP tests
mvn test -Dcucumber.filter.tags="not @Manual and not @WIP"

### Abrir reporte Allure
allure serve allure-results