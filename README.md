# examplePlugin
That's just a simple Minecraft plugin make in Java that adds and opens inventories and items.

Only the code is available.

## How to use API ?

### 1. InventoryBuilder

To create an inventory, you need first to call the constructor :

```java
InventoryBuilder inventory = new InventoryBuilder("name_of_inventory", 6);
```
String ***name_of_inventory*** : name of this inventory (colors are accepted using '&')

int ***6*** : number of rows (here 6 rows)

